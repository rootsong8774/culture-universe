package com.sejong.cultureuniverse.entity;

import static javax.persistence.FetchType.*;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "notice_seq", sequenceName = "notice_seq", initialValue = 1, allocationSize = 1)
public class NoticeBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notice_seq")
    private Long notice_idx;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "admin_id")
    private Admin admin_id;
    private String n_title;
    private String n_content;
    private Long read_count;
    private Date reg_date;
    private Date mod_date;

}
