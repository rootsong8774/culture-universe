package com.sejong.cultureuniverse.entity.performance;

import static javax.persistence.FetchType.LAZY;

import com.sejong.cultureuniverse.entity.Reservation;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Seats {

    @Id
    private Long seatNo;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "reservation_id")
    private Reservation reservationId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "schedule_code")
    private PerformanceSchedule scheduleCode;

    private Integer rowNo;
    private Integer colNo;

    private Boolean isBooked;
    private Integer price;

}
