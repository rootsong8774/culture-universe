package com.sejong.cultureuniverse.service;


import com.sejong.cultureuniverse.dto.EventBoardDto;
import com.sejong.cultureuniverse.dto.PageRequestDTO;
import com.sejong.cultureuniverse.dto.PageResultDTO;
import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.event.EventBoard;
import org.springframework.stereotype.Service;



public interface EventBoardService {
    Long register(EventBoardDto dto);

    PageResultDTO<EventBoardDto, Object[]> getList(PageRequestDTO requestDTO);

    EventBoardDto read(Long eventIdx);

    void modify(EventBoardDto dto);

    void remove(Long eventIdx);

    default EventBoardDto entityToDto(EventBoard entity, Admin admin) {

        return EventBoardDto.builder()
            .eventIdx(entity.getEventIdx())
            .eventTitle(entity.getEventTitle())
            .eventContent(entity.getEventContent())
            .readCount(entity.getReadCount())
            .regDate(entity.getRegDate())
            .modDate(entity.getModDate())
            .adminId(admin.getAdminId())
            .build();
    }

    default EventBoard dtoToEntity(EventBoardDto dto) {
        return EventBoard.builder()
                .eventIdx(dto.getEventIdx())
                .adminId(new Admin(dto.getAdminId(), dto.getAdminPw()))
                .eventTitle(dto.getEventTitle())
                .eventContent(dto.getEventContent())
                .readCount(dto.getReadCount())
                .build();
    }


}


/*    @Autowired
    private NoticeBoardRepository noticeBoardRepository;


  public NoticeBoardService(NoticeBoardRepository noticeBoardRepository) {
        this.noticeBoardRepository = noticeBoardRepository;
    }

    @Transactional
    public Long savePost(NoticeBoardDto noticeBoardDto) {
        return noticeBoardRepository.save(noticeBoardDto.toEntity()).getNoticeIdx();
    }

    @Transactional
    public List<NoticeBoardDto> getBoardList() {
        List<NoticeBoard> boardList = noticeBoardRepository.findAll();
        List<NoticeBoardDto> boardDtoList = new ArrayList<>();

        for (NoticeBoard noticeBoard : boardList) {
            NoticeBoardDto boardDto = NoticeBoardDto.builder()
                .noticeIdx(noticeBoard.getNoticeIdx())
                .adminId(noticeBoard.getAdminId())
                .noticeTitle(noticeBoard.getNoticeTitle())
                .noticeContent(noticeBoard.getNoticeContent())
                .readCount(noticeBoard.getReadCount())
                .build();
            boardDtoList.add(boardDto);
        }
        return boardDtoList;

    }
}
*/

