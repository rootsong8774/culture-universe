package com.sejong.cultureuniverse.repository.admin;

import static com.sejong.cultureuniverse.entity.admin.QAdmin.admin;
import static com.sejong.cultureuniverse.entity.admin.QNoticeBoard.noticeBoard;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryFactory;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sejong.cultureuniverse.dto.paging.PageRequestDTO;
import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.admin.NoticeBoard;
import com.sejong.cultureuniverse.entity.admin.QAdmin;
import com.sejong.cultureuniverse.entity.admin.QNoticeBoard;
import com.sejong.cultureuniverse.repository.NoticeBoardRepository;
import com.sejong.cultureuniverse.service.admin.NoticeBoardService;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootTest
public class NoticeBoardRepositoryTest {
    @Autowired
    private NoticeBoardRepository noticeBoardRepository;
    
    @Autowired
    private NoticeBoardService noticeBoardService;

    JPAQueryFactory queryFactory;
    @Autowired
    EntityManager em;

    @Test
        public void insertDummies(){
            IntStream.rangeClosed(1,100).forEach(i -> {
                NoticeBoard noticeBoard = NoticeBoard.builder()
                    .noticeContent("test content" + i)
                    .noticeTitle("test title" + i)
                    .readCount(100L)
                    .adminId(new Admin("admin"+i, "1234"))
                    .build();
                System.out.println(noticeBoardRepository.save(noticeBoard));
            });
        }

    @Test
    public void findByNoticeFindAllTest() {
        List<NoticeBoard> findAll = noticeBoardRepository.findAll();
        for (NoticeBoard noticeBoard : findAll) {
            System.out.println("noticeBoard = " + noticeBoard);
        }
    }

   /* @Test
    public void findAllWithAdminId() {
        PageRequestDTO pageRequestDTO = new PageRequestDTO();
        Pageable pageable = pageRequestDTO.getPageable(Sort.by("noticeIdx").descending());
        Page<Object[]> result = noticeBoardRepository.findAllWithAdminId(pageable);
        for (Object[] objects : result) {
            for (Object object : objects) {
                System.out.println("object = " + object);
            }
        }
    }*/

    @Test
    public void querydslTest() {
        queryFactory = new JPAQueryFactory(em);
        PageRequestDTO pageRequestDTO = new PageRequestDTO();
        pageRequestDTO.setType("t");
        pageRequestDTO.setKeyword("1");
        Pageable pageable = pageRequestDTO.getPageable(Sort.by("noticeIdx").descending());
        BooleanBuilder builder = noticeBoardService.getSearch(pageRequestDTO);
        List<Tuple> result = queryFactory
            .select(noticeBoard, admin)
            .from(noticeBoard)
            .leftJoin(noticeBoard.adminId, admin)
            .where(builder)
            .offset(1)
            .limit(12)
            .fetch();

        for (Tuple tuple : result) {
            System.out.println("tuple.toString = " + tuple.toString());
        }

    }
    
    @Test public void testQuery1(){ Pageable pageable = PageRequest.of(0,10, Sort.by("gno").descending());
        // 동적 처리를 위한 Q도메인 클래스 얻어오기
        // Q도메인 클래스 이용 시 엔티티 클래스에 선언된 title, content 같은 필드들을 변수로 활용 가능
        QNoticeBoard qNoticeBoard = noticeBoard;
        String keyword = "1";
         //BooleanBuilder는 where문에 들어가는 조건들을 넣어주는 컨테이너
         BooleanBuilder builder = new BooleanBuilder();
        // 2
        // 원하는 조건은 필드 값과 같이 결합해서 생성
        // BooleanBuilder 안에 들어가는 값은 com.querydsl.core.types.Predicate 타입
         BooleanExpression expression = qNoticeBoard.noticeTitle.contains(keyword);
        // 3
        // 만들어진 조건은 where 문에 and나 or같은 키워드와 결합
         builder.and(expression);
        // 4
         //BooleanBuilder는 GuestbookRepository에 추가된
        // QuerydslPredicateExcutor 인터페이스의 findAll() 사용 가능
         Page<NoticeBoard> result = noticeBoardRepository.findAll(builder,pageable);
        // 5
        result.stream().forEach(noticeBoard -> { System.out.println(noticeBoard); }); }

    /*
    @Test
    private void updateTest(){
        Optional<NoticeBoard> result = Optional.ofNullable(
            noticeBoardRepository.findByNoticeIdx(50L));
        if(result.isPresent()){
            NoticeBoard noticeBoard = result.get();

            noticeBoard.changeTitle("change title");
            noticeBoard.changeContent("change content");

            noticeBoardRepository.save(noticeBoard);
        }

    }*/

}
