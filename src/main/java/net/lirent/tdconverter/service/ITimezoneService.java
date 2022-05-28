package net.lirent.tdconverter.service;

import org.springframework.http.ResponseEntity;

/**
 * Interface for timezone service.
 *
 * @author l.pone
 */
public interface ITimezoneService {

    /**
     * Get timezones from Area/ Location/ Region
     * @return timezone data
     */
    ResponseEntity<Object> getTimezone(String... input);
}
