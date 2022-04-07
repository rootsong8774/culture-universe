package com.sejong.cultureuniverse.entity.performance;

import static javax.persistence.FetchType.LAZY;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "schedule_seq", sequenceName = "schedule_seq", initialValue = 1, allocationSize = 1)
public class PerformanceSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "schedule_seq")
    private Long scheduleCode;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="perform_id")
    private PerformanceDetails performanceDetails;

    private LocalDate scheduleDate;
    private LocalTime scheduleTime;
}
