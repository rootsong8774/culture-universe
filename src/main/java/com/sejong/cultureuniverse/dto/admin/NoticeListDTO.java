package com.sejong.cultureuniverse.dto.admin;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NoticeListDTO implements Serializable {
    private Long noticeIdx;
    private String noticeTitle;
    private String noticeContent;

}
