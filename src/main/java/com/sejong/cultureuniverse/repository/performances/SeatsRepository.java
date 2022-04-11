package com.sejong.cultureuniverse.repository.performances;

import com.sejong.cultureuniverse.entity.reservation.Seats;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatsRepository extends JpaRepository<Seats, Long> {


}
