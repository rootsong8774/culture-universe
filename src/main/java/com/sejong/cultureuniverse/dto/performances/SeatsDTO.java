package com.sejong.cultureuniverse.dto.performances;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatsDTO implements Serializable {
    
    private Long seatNo;
    private Long scheduleCode;
    private LocalDate scheduleDate;
    private LocalTime scheduleTime;
    private Integer rowNo;
    private Integer colNo;
    private Boolean isBooked;
    private Integer price;
}
