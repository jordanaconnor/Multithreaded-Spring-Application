package edu.wgu.d387_sample_code.services;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/time")
public class TimeZoneController {

    private final TimeZoneService timeZoneService;

    public TimeZoneController(TimeZoneService timeZoneService) {
        this.timeZoneService = timeZoneService;
    }

    @GetMapping(value = "/zones", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> getZoneTimes() {
        return ResponseEntity.ok(timeZoneService.getZoneTimes());
    }

    @GetMapping(value = "/presentation", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getPresentationMessage() {
        return ResponseEntity.ok(timeZoneService.getPresentationMessage());
    }
}
