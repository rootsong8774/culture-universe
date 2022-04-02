package com.sejong.cultureuniverse.entity;

import com.sejong.cultureuniverse.entity.performance.PerformanceDetails;
import lombok.*;

import javax.persistence.*;
import lombok.ToString.Exclude;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long favoriteId;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "user_idx")
    @Exclude
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "perform_id")
    @Exclude
    private PerformanceDetails performId;



}
