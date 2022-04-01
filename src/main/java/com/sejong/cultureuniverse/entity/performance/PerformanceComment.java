package com.sejong.cultureuniverse.entity.performance;

import com.sejong.cultureuniverse.entity.BaseEntity;
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
@SequenceGenerator(name = "performance_comment_seq", sequenceName = "performance_comment_seq", initialValue = 1, allocationSize = 1)
public class PerformanceComment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "performance_comment_seq")
    private Long commentIdx;

    @ManyToOne
    @JoinColumn(name = "perform_id")
    private PerformanceDetails performId;

    private String performanceComment;

    private Integer rating;
}
