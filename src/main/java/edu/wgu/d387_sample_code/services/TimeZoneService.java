package edu.wgu.d387_sample_code.services;

import org.springframework.stereotype.Service;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class TimeZoneService {

    public Map<String, String> getZoneTimes() {

        ZonedDateTime easternTime = ZonedDateTime.of(
                LocalDate.now(),
                LocalTime.of(12, 30),
                ZoneId.of("America/New_York")
        );

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("hh:mm a");

        Map<String, String> times = new LinkedHashMap<>();
        times.put("ET", fmt.format(easternTime));
        times.put("MT", fmt.format(easternTime.withZoneSameInstant(ZoneId.of("America/Denver"))));
        times.put("UTC", fmt.format(easternTime.withZoneSameInstant(ZoneId.of("UTC"))));
        return times;
    }

    public String getPresentationMessage() {
        Map<String, String> times = getZoneTimes();
        return "Join us for an online live presentation held at the Landon Hotel at: \n" +
                times.get("ET") + " ET | " +
                times.get("MT") + " MT | " +
                times.get("UTC") + " UTC ";

    }
}
