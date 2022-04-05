package com.sejong.cultureuniverse.entity.admin;

import static javax.persistence.FetchType.*;

import com.sejong.cultureuniverse.entity.BaseEntity;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

@Builder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "notice_seq", sequenceName = "notice_seq", initialValue = 1, allocationSize = 1)
public class NoticeBoard extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notice_seq")
    private Long noticeIdx;

    @OneToOne(fetch = LAZY)
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
