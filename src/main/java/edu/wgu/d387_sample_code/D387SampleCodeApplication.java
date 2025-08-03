package edu.wgu.d387_sample_code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

@SpringBootApplication
public class D387SampleCodeApplication {
	static ExecutorService messageExecutor = newFixedThreadPool(5);

	public static void main(String[] args) {
		SpringApplication.run(D387SampleCodeApplication.class, args);
	}
}
