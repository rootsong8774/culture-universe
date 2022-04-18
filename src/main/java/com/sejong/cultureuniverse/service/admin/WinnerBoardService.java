package com.sejong.cultureuniverse.service.admin;


import com.sejong.cultureuniverse.dto.admin.WinnerBoardDTO;
import com.sejong.cultureuniverse.dto.paging.PageRequestDTO;
import com.sejong.cultureuniverse.dto.paging.PageResultDTO;
import com.sejong.cultureuniverse.entity.event.EventWinner;
import javax.servlet.http.HttpServletRequest;


public interface WinnerBoardService {

    Long register(WinnerBoardDTO dto, HttpServletRequest request);

    PageResultDTO<WinnerBoardDTO, EventWinner> getList(PageRequestDTO requestDTO);

    WinnerBoardDTO read(Long winnerIdx);

    void modify(WinnerBoardDTO dto);

    void remove(Long winnerIdx);


    default WinnerBoardDTO entityToDto(EventWinner entity) {
        return WinnerBoardDTO.builder()
            .winnerIdx(entity.getWinnerIdx())
            .winTitle(entity.getWinTitle())
            .winContent(entity.getWinContent())
            .readCount(entity.getReadCount())
            .regDate(entity.getRegDate())
            .modDate(entity.getModDate())
            .admin(entity.getAdmin())
            .build();
    }

//    default EventWinner dtoToEntity(WinnerBoardDTO dto) {
//        return EventWinner.builder()
//            .winnerIdx(dto.getWinnerIdx())
//            .adminId(new Admin(dto.getAdminId(), dto.getAdminPw()))
//            .winTitle(dto.getWinTitle())
//            .winContent(dto.getWinContent())
//            .readCount(dto.getReadCount())
//            .build();
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

