package com.sejong.cultureuniverse.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = {"member","performanceDetails"})
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long favoriteId;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "user_idx")
    private Member member;

//      공연정보와 관계
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "perform_id")
//    private performance_details performanceDetails;


}
