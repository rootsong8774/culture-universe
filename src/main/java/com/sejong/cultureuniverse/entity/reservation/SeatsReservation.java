package com.sejong.cultureuniverse.entity.reservation;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@SequenceGenerator(name = "seats_reservation_seq", sequenceName = "seats_reservation_seq", allocationSize = 1, initialValue = 1)
public class SeatsReservation {
    
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "seats_reservation_seq")
    private Long sr_no;
    
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;
    
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "seat_no")
    private Seats seats;
    
    private Integer totalPrice;
}
