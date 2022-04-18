package com.sejong.cultureuniverse.service.admin;


import com.sejong.cultureuniverse.dto.admin.EventBoardDTO;
import com.sejong.cultureuniverse.dto.admin.NoticeBoardDTO;
import com.sejong.cultureuniverse.dto.paging.PageRequestDTO;
import com.sejong.cultureuniverse.dto.paging.PageResultDTO;
import com.sejong.cultureuniverse.dto.performances.PerformanceDetailsDTO;
import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.event.EventBoard;
import com.sejong.cultureuniverse.entity.event.EventComment;
import javax.servlet.http.HttpServletRequest;


public interface EventBoardService {
    
    Long register(EventBoardDTO dto, HttpServletRequest request);
    
    PageResultDTO<EventBoardDTO, EventBoard> getList(PageRequestDTO requestDTO);

    EventBoardDTO read(Long eventIdx);

    void modify(EventBoardDTO dto);

    void remove(Long eventIdx);

    default EventBoardDTO entityToDto(EventBoard entity) {

        return EventBoardDTO.builder()
            .eventIdx(entity.getEventIdx())
            .eventTitle(entity.getEventTitle())
            .eventContent(entity.getEventContent())
            .readCount(entity.getReadCount())
            .regDate(entity.getRegDate())
            .modDate(entity.getModDate())
            .admin(entity.getAdmin())
            .build();
    }

//    default EventBoard dtoToEntity(EventBoardDTO dto) {
//        return EventBoard.builder()
//                .eventIdx(dto.getEventIdx())
//                .adminId(new Admin(dto.getAdminId(), dto.getAdminPw()))
//                .eventTitle(dto.getEventTitle())
//                .eventContent(dto.getEventContent())
//                .readCount(dto.getReadCount())
//                .build();
//    }
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

