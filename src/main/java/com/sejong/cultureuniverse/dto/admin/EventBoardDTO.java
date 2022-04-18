package com.sejong.cultureuniverse.dto.admin;

import com.sejong.cultureuniverse.entity.admin.Admin;
import java.time.LocalDateTime;

import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class EventBoardDTO {
    private Long eventIdx;

    private Admin admin;

    private String eventTitle;
    private String eventContent;

   /* private Long commentIdx;
    private String eventComment;*/

    private Long readCount;
    private LocalDateTime regDate, modDate;

   
}