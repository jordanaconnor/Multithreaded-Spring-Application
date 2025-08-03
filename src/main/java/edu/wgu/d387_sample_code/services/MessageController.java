package edu.wgu.d387_sample_code.services;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MessageController {
    static ExecutorService messageExecutor = newFixedThreadPool(5);

    @GetMapping("/messages")
    public ResponseEntity<List<String>> sendMessages() {
        List<String> messages = new ArrayList<>();
        Properties properties = new Properties();

        messageExecutor.execute(() -> {
            try {
                InputStream stream = new ClassPathResource("translation_fr_CA.properties").getInputStream();
                properties.load(stream);
                messages.add(properties.getProperty("welcomeMessage"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        messageExecutor.execute(() -> {
            try {
                InputStream stream = new ClassPathResource("translation_en_CA.properties").getInputStream();
                properties.load(stream);
                messages.add(properties.getProperty("welcomeMessage"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        try {
            Thread.sleep(100);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(messages, HttpStatus.OK);
    }
}