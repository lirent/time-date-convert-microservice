package net.lirent.tdconverter.controller;

import net.lirent.tdconverter.service.TimezoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.util.Set;
/**
 * Controller for Timezone API endpoints
 *
 * @author l.pone
 */
@RestController
@RequestMapping("/api/timezone")
public class TimezoneController {

    @Autowired
    private TimezoneService timezoneService;

    /**
     *  Handles the incoming POST API "/api/timezone/{area}"
     * @param area zone
     * @return response data
     */
    @GetMapping("/{area}")
    public ResponseEntity<?> timeByArea(@PathVariable String area){
        return timezoneService.getTimezone(area);
    }

    /**
     *  Handles the incoming POST API "/api/timezone/{area}/{location}"
     * @param area
     * @param location
     * @return
     */
    @GetMapping("/{area}/{location}")
    public ResponseEntity<?> timeByZone(@PathVariable String area, @PathVariable String location){
        return timezoneService.getTimezone(area, location);
    }

    /**
     *  Handles the incoming POST API "/api/timezone/{area}/{location}/{region}"
     * @param area
     * @param location
     * @param region
     * @return
     */
    @GetMapping("{area}/{location}/{region}")
    public ResponseEntity<?> timeByRegion(@PathVariable String area, @PathVariable String location, @PathVariable String region){
        return timezoneService.getTimezone(area, location, region);
    }

    /**
     * Return all the timezones
     * @return timezones list
     */
    @GetMapping
    public Set<String> getAllTimeZones(){
        return ZoneId.getAvailableZoneIds();
    }


}
