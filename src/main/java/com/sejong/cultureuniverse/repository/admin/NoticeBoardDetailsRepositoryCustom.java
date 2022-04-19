package com.sejong.cultureuniverse.repository.admin;

import com.sejong.cultureuniverse.dto.NoticeBoardDetailSearchCondition;
import com.sejong.cultureuniverse.entity.admin.NoticeBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoticeBoardDetailsRepositoryCustom {
    Page<NoticeBoard> search(NoticeBoardDetailSearchCondition condition, Pageable pageable);

}
