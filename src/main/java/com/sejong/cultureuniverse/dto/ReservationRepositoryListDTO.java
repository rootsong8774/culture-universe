package com.sejong.cultureuniverse.dto;

import com.querydsl.core.annotations.QueryProjection;
import com.sejong.cultureuniverse.entity.reservation.ReservationStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class ReservationRepositoryListDTO {
    private Long userIdx; //회원id
    private Long reservationId; //예약번호
    private LocalDate reservationDate; //예매일
    private Long seatNo; //예매번호 = 좌석번호
    private ReservationStatus reservationStatus; // 상태 booked,cancled

    @QueryProjection
    public ReservationRepositoryListDTO (Long userIdx, Long reservationId, LocalDate reservationDate,
         Long seatNo, ReservationStatus reservationStatus){
        this.userIdx = userIdx;
        this.reservationId= reservationId;
        this.reservationDate = reservationDate;
        this.seatNo = seatNo;
        this.reservationStatus = reservationStatus;
    }
}
