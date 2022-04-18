package com.sejong.cultureuniverse.entity.admin;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.*;

import com.sejong.cultureuniverse.entity.BaseEntity;
import java.time.LocalDateTime;
import javax.persistence.*;

import lombok.*;
import lombok.ToString.Exclude;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;

@SuperBuilder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "notice_seq", sequenceName = "notice_seq", initialValue = 1, allocationSize = 1)
@ToString
public class NoticeBoard extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notice_seq")
    private Long noticeIdx;
    private String noticeTitle;
    
    @Lob
    private String noticeContent;
    private Long readCount;

    @ManyToOne(fetch = LAZY) //객체로 받는게 맞음
    @JoinColumn(name = "admin_idx")
    @Exclude
    private Admin admin;
    
    public void changeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }
    
    public void changeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }
    
}
