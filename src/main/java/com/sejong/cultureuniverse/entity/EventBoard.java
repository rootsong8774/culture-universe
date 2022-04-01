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
    private Long event_idx;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="admin_id")
    private Admin admin_id;

    private String e_title;
    private String e_content;
    private Long read_count;
    private Date reg_date;
    private Date mod_date;
}
