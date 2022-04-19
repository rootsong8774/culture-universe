package com.sejong.cultureuniverse.dto;

import com.querydsl.core.annotations.QueryProjection;
import com.sejong.cultureuniverse.entity.reservation.ReservationStatus;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class ReservationRepositoryListDTO {
//    private String performCode; //공연명
    private Long reservationId; //예약번호
    private LocalDate reservationDate; //예매일
    private Long sr_no; //예매번호 = 좌석번호
//    private Long[] seatNos; //매수
    private ReservationStatus reservationStatus; // 상태 booked,cancled

    @QueryProjection
    public ReservationRepositoryListDTO (Long reservationId, LocalDate reservationDate,
         Long sr_no, ReservationStatus reservationStatus){
        this.reservationId= reservationId;
        this.reservationDate = reservationDate;
        this.sr_no = sr_no;
        this.reservationStatus = reservationStatus;
    }
}
