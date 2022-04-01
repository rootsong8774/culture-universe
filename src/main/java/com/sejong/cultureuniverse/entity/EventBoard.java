package com.sejong.cultureuniverse.entity;

import static javax.persistence.FetchType.LAZY;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "event_seq", sequenceName = "event_seq", initialValue = 1, allocationSize = 1)
public class EventBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_seq")
    private Long eventIdx;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="admin_id")
    private Admin adminId;

    private String eventTitle;
    private String eventContent;
    private Long readCount;
    private Date regDate;
    private Date modDate;
}
