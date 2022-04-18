package com.sejong.cultureuniverse.entity.event;

import com.sejong.cultureuniverse.entity.BaseEntity;
import com.sejong.cultureuniverse.entity.Member;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import lombok.ToString.Exclude;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class EventComment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentIdx;
    
    @Lob
    private String eventComment;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "user_idx")
    @Exclude
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY ,cascade = CascadeType.REMOVE)
    @JoinColumn(name ="event_idx")
    @Exclude
    private EventBoard eventBoard;


}
