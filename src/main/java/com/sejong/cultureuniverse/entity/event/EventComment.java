package com.sejong.cultureuniverse.entity.event;

import com.sejong.cultureuniverse.entity.BaseEntity;
import com.sejong.cultureuniverse.entity.Member;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import lombok.ToString.Exclude;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class EventComment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentIdx;
    private String eventComment;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "user_idx")
    @Exclude
    private Member member;



    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name ="event_idx")
    @Exclude
    private EventBoard eventBoard;


}
