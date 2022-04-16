package com.sejong.cultureuniverse.entity.reservation;

import static com.sejong.cultureuniverse.entity.reservation.ReservationStatus.BOOKED;
import static com.sejong.cultureuniverse.entity.reservation.ReservationStatus.CANCEL;
import static javax.persistence.CascadeType.ALL;

import com.sejong.cultureuniverse.entity.Member;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;
    private LocalDate reservationDate;
    
    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;
    
    @OneToMany(mappedBy = "reservation", cascade = ALL)
    @Exclude
    private List<SeatsReservation> seatsReservations = new ArrayList<>();
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx")
    @Exclude
    private Member member;
    
    public void setMember(Member member) {
        this.member= member;
    }
    
    public void addSeatsReservation(SeatsReservation seatsReservation) {
        seatsReservations.add(seatsReservation);
        seatsReservation.setReservation(this);
    }
    
    public static Reservation createReservation(Member member,
        SeatsReservation... seatsReservations) {
        Reservation reservation = new Reservation();
        reservation.setMember(member);
        reservation.reservationStatus = BOOKED;
        reservation.reservationDate = LocalDate.now();
        for (SeatsReservation seatsReservation : seatsReservations) {
            reservation.addSeatsReservation(seatsReservation);
        }
        
        return reservation;
    }
    
    
    public void cancel() {
        this.setReservationStatus(CANCEL);
        for (SeatsReservation seatsReservation : seatsReservations) {
            seatsReservation.cancel();
        }
        
    }
    public int getTotalPrice() {
        return seatsReservations.stream().mapToInt(SeatsReservation::getPrice).sum();
    }
    
}
