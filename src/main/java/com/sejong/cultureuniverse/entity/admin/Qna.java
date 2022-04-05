package com.sejong.cultureuniverse.entity.admin;

import com.sejong.cultureuniverse.entity.Member;
import lombok.*;

import javax.persistence.*;
import lombok.ToString.Exclude;

import java.time.LocalDateTime;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Qna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionIdx;
    private String title;
    private String type;
    private String content;
    private LocalDateTime regDate;
    private LocalDateTime modDate;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx")
    @Exclude
    private Member member;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_idx")
    @Exclude
    private AdminComment adminComment;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    @Exclude
    private Admin admin;

    public void changeTitle(String title) {
        this.title =title ;
    }
    public void changeContent(String content) {
        this.content =content ;
    }

}
