package com.sejong.cultureuniverse.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString (exclude = {"member","admin"})
public class Qna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionIdx;
    private String title;
    private String type;
    private String content;
    private String adminComment;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx")
    private Member member;
//    관리자와 1:1
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "admin_id")
//    private Admin admin;


}
