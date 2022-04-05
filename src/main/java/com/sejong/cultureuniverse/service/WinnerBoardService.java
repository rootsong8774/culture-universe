package com.sejong.cultureuniverse.service;


import com.sejong.cultureuniverse.dto.PageRequestDTO;
import com.sejong.cultureuniverse.dto.PageResultDTO;
import com.sejong.cultureuniverse.dto.WinnerBoardDto;
import com.sejong.cultureuniverse.entity.event.EventWinner;
import org.springframework.stereotype.Service;



public interface WinnerBoardService {
    Long register(WinnerBoardDto dto);

    PageResultDTO<WinnerBoardDto, EventWinner> getList(PageRequestDTO requestDTO);

    WinnerBoardDto read(Long winnerIdx);

    void modify(WinnerBoardDto dto);

    void remove(Long winnerIdx);

    default EventWinner dtoToEntity(WinnerBoardDto dto) {
        return EventWinner.builder()
                .winnerIdx(dto.getWinnerIdx())
                .adminId(dto.getAdminId())
                .winTitle(dto.getWinTitle())
                .winContent(dto.getWinContent())
                .readCount(dto.getReadCount())
                .build();
    }

    default WinnerBoardDto entityToDto(EventWinner entity) {

        return WinnerBoardDto.builder()
                .winnerIdx(entity.getWinnerIdx())
                .winTitle(entity.getWinTitle())
                .winContent(entity.getWinContent())
                .readCount(entity.getReadCount())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
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

