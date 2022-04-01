package com.sejong.cultureuniverse.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString (exclude = {"member","eventBoard"})
public class EventComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentIdx;
    private String eventComment;
    private Date regDate;
    private Date modDate;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "user_idx")
    private Member member;

//    이벤트 게시판과 관계
//    @ManyToOne(fetch = FetchType.LAZY )
//    @JoinColumn(name ="event_idx")
//    private EventBoard eventBoard;


}
