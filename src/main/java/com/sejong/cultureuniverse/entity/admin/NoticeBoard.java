package com.sejong.cultureuniverse.entity.admin;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.*;

import com.sejong.cultureuniverse.entity.BaseEntity;
import java.time.LocalDateTime;
import javax.persistence.*;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

@Builder
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

    @OneToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "admin_id")
    private Admin adminId;
    private String noticeTitle;
    private String noticeContent;
    private Long readCount;


    public void changeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }
    public void changeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }
}
