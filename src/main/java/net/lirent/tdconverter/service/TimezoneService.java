package net.lirent.tdconverter.service;

import net.lirent.tdconverter.model.Timezone;
import net.lirent.tdconverter.response.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.zone.ZoneRulesException;

@Service
public class TimezoneService implements ITimezoneService {

    private Timezone buildTimezone(String... input) {
        ZoneId zoneId;
        String zone = String.join("/", input);
        try {
            zoneId = ZoneId.of(zone);
        } catch (ZoneRulesException exception) {
            return null;
        }
        var zdt = ZonedDateTime.now(zoneId);

        return Timezone.builder()
                .dateTime(zdt.toLocalDateTime())
                .timeZone(zdt.getZone().toString())
                .dayOfWeek(zdt.getDayOfWeek().toString())
                .dayOfYear(zdt.getDayOfYear())
                .dayOfMonth(zdt.getDayOfMonth())
                .unixTime(zdt.toEpochSecond())
                .offset(zdt.getOffset().toString())
                .build();

    }

    @Override
    public ResponseEntity<Object> getTimezone(String... arg) {
        Timezone result = buildTimezone(arg);
        if (result == null)
            return ResponseHandler.generateResponse("Not Found", HttpStatus.NOT_FOUND, null);
        else
            return ResponseHandler.generateResponse("Successful", HttpStatus.OK, result);
    }
}
