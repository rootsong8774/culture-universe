package com.sejong.cultureuniverse.entity.admin;

import com.sejong.cultureuniverse.entity.Member;
import lombok.*;

import javax.persistence.*;
import lombok.ToString.Exclude;

import java.io.Serializable;
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

}
