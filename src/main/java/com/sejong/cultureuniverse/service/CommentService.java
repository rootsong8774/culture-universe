package com.sejong.cultureuniverse.service;

import com.sejong.cultureuniverse.dto.CommentRequestDto;
import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.entity.event.EventBoard;
import com.sejong.cultureuniverse.entity.event.EventComment;
import com.sejong.cultureuniverse.repository.CommentRepository;
import com.sejong.cultureuniverse.repository.EventBoardRepository;
import com.sejong.cultureuniverse.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final EventBoardRepository eventBoardRepository;

    //create
    @Transactional
    public Long commentSave(String username, Long eventIdx, CommentRequestDto dto){
        Member member = memberRepository.findByNickname(username);
        EventBoard eventBoard = eventBoardRepository.findById(eventIdx).orElseThrow(() ->
            new IllegalArgumentException("댓글 쓰기 실패: 해당글이 존재하지 않습니다."+eventIdx));
        dto.setMember(member);
        dto.setEventBoard(eventBoard);

        EventComment comment = dto.toEntity();
        commentRepository.save(comment);

        return dto.getId();
    }

}
