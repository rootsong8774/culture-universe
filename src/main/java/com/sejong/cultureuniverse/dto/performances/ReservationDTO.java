package com.sejong.cultureuniverse.dto.performances;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {
    
    String username;
    Long[] seatNos;
}
