package com.sejong.cultureuniverse.entity.event;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.*;

import com.sejong.cultureuniverse.entity.BaseEntity;
import javax.persistence.*;

import com.sejong.cultureuniverse.entity.admin.Admin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "winner_seq", sequenceName = "winner_seq", initialValue = 1, allocationSize = 1)
public class EventWinner extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "winner_seq")
    private Long winnerIdx;
    private String winTitle;
    private String winContent;
    private Long readCount;

    @ManyToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name="admin_idx")
    private Admin adminId;

}
