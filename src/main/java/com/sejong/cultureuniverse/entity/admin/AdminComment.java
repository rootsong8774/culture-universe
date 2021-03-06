package com.sejong.cultureuniverse.entity.admin;

import com.sejong.cultureuniverse.entity.BaseEntity;
import com.sejong.cultureuniverse.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class AdminComment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentIdx; //댓글 번호
    
    @Lob
    private String commentContent; //댓글 내용

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx")
    @ToString.Exclude
    private Member member; //회원

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_idx")
//    @JsonIgnore
    @ToString.Exclude
    private Admin admin; //작성자

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_idx")
//    @JsonIgnore
    @ToString.Exclude
    private Qna qna;    //문의번호


    public void save(Qna qna, Member member) {
        this.qna = qna;
        this.member = member;
    }
}
