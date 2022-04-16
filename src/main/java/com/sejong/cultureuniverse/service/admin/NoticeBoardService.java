package com.sejong.cultureuniverse.service.admin;

import com.querydsl.core.BooleanBuilder;
import com.sejong.cultureuniverse.dto.admin.NoticeBoardAndAdminDTO;
import com.sejong.cultureuniverse.dto.paging.PageRequestDTO;
import com.sejong.cultureuniverse.dto.paging.PageResultDTO;
import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.admin.NoticeBoard;


public interface NoticeBoardService {

    Long register(NoticeBoardAndAdminDTO dto);

    PageResultDTO<NoticeBoardAndAdminDTO, Object[]> getList(PageRequestDTO requestDTO);

    NoticeBoardAndAdminDTO read(Long noticeIdx);

    void modify(NoticeBoardAndAdminDTO dto);

    void remove(Long noticeIdx);
    BooleanBuilder getSearch(PageRequestDTO requestDTO);
//db->화면
    default NoticeBoardAndAdminDTO entityToDto(NoticeBoard entity, Admin admin) {

        return NoticeBoardAndAdminDTO.builder()
            .noticeIdx(entity.getNoticeIdx())
            .noticeTitle(entity.getNoticeTitle())
            .noticeContent(entity.getNoticeContent())
            .readCount(entity.getReadCount())
            .regDate(entity.getRegDate())
            .modDate(entity.getModDate())
            .adminId(admin.getAdminId())
            .build();

    }
//화면->db
    default NoticeBoard noticeAndAdminToEntity(NoticeBoardAndAdminDTO dto) {
        return NoticeBoard.builder()
            .noticeIdx(dto.getNoticeIdx())
            .adminId(new Admin(dto.getAdminId(), dto.getAdminPw()))
            .noticeTitle(dto.getNoticeTitle())
            .noticeContent(dto.getNoticeContent())
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

