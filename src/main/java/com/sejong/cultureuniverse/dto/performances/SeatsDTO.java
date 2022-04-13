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
    private Integer rowNo;
    private Integer colNo;
    private Boolean isBooked;
    private Integer price;
}
