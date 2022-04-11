package com.sejong.cultureuniverse.entity.reservation;

import static javax.persistence.FetchType.LAZY;

import com.sejong.cultureuniverse.entity.performance.PerformanceSchedule;
import com.sejong.cultureuniverse.exception.AlreadyBookException;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "seats_seq", sequenceName = "seats_seq", allocationSize = 1,initialValue = 1)
public class Seats {

    @Id
    @GeneratedValue(generator = "seats_seq")
    private Long seatNo;
    
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "schedule_code")
    private PerformanceSchedule schedule;

    private Integer rowNo;
    private Integer colNo;

    private Boolean isBooked;
    private Integer price;
    
    public void reserveSeats() {
        if (this.isBooked) {
            throw new AlreadyBookException("이미 예약되어있는 좌석입니다.");
        }
        this.isBooked=true;
    }
    
    public void cancelSeats() {
        this.isBooked=false;
    }

}
