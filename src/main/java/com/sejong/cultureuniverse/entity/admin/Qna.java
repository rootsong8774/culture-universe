package com.sejong.cultureuniverse.entity.admin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sejong.cultureuniverse.entity.BaseEntity;
import com.sejong.cultureuniverse.entity.Member;
import lombok.*;

import javax.persistence.*;
import lombok.ToString.Exclude;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Qna extends BaseEntity {

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

    @OrderBy("commentIdx desc")
    @JsonIgnoreProperties({"commentIdx"})
    @OneToMany (mappedBy = "commentIdx",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
//    @JoinColumn(name = "admin_id")
    @Exclude
    private List<AdminComment> adminCommentList;
}
