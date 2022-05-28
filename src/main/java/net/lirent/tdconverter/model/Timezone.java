package net.lirent.tdconverter.model;

import lombok.*;

import java.time.LocalDateTime;

/**
 * Class for timezone information.
 *
 * @author l.pone
 */

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Timezone {

    private LocalDateTime dateTime;
    private String timeZone;
    private String dayOfWeek;
    private int dayOfYear;
    private int dayOfMonth;
    private int dstOffset;
    private long unixTime;
    private String offset;

}
