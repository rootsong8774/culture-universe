package com.sejong.cultureuniverse.entity.event;

import static javax.persistence.FetchType.LAZY;

import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.BaseEntity;
import javax.persistence.Entity;
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

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "winner_seq", sequenceName = "winner_seq", initialValue = 1, allocationSize = 1)
public class EventWinner extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "winner_seq")
    private Long winnerIdx;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="admin_id")
    private Admin admin;

    private String winTitle;
    private String winContent;
    private Long readCount;

}
