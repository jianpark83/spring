package org.zerock.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.ReviewVO;
import org.zerock.domain.Criterial;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReviewMapperTests {

    @Autowired
    private ReviewMapper mapper;

    // 공통 ReviewVO 생성기
    private ReviewVO buildSampleReview(String title, String writer, String region) {
        return ReviewVO.builder()
                .review_title(title)
                .restaurant_name("테스트 식당")
                .review_content("내용입니다")
                .writer_name(writer)
                .rating(5)
                .count(0)
                .region(region)
                .build();
    }

    // 공통 Criterial 생성기
    private Criterial createCriterial(int page, int amount, String type, String keyword) {
        Criterial cri = new Criterial(page, amount);
        cri.setType(type);
        cri.setKeyword(keyword);
        return cri;
    }

    @Test
    public void testInsertSelectKey() {
        ReviewVO vo = buildSampleReview("키 등록 제목", "김철수", "부산");
        mapper.insertSelectKey(vo);
        log.info("Inserted with Key: " + vo.getReview_id());
    }

    @Test
    public void testRead() {
        Long review_id = 1L; // 존재해야 함
        ReviewVO vo = mapper.read(review_id);
        log.info("Read Review: " + vo);
    }

    @Test
    public void testGetList() {
        List<ReviewVO> list = mapper.getList();
        list.forEach(vo -> log.info(vo));
    }

    @Test
    public void testUpdate() {
        ReviewVO vo = ReviewVO.builder()
                .review_id(1L)
                .review_title("수정된 제목")
                .restaurant_name("수정된 식당")
                .review_content("수정된 내용")
                .writer_name("수정자")
                .rating(3)
                .count(5)
                .region("대구")
                .build();

        int result = mapper.update(vo);
        log.info("Update Result: " + result);
    }

    @Test
    public void testDelete() {
        Long review_id = 1L;
        int result = mapper.delete(review_id);
        log.info("Delete Result: " + result);
    }

    @Test
    public void testPaging() {
        Criterial cri = createCriterial(1, 5, null, null);
        List<ReviewVO> list = mapper.getListWithPaging(cri);
        list.forEach(vo -> log.info(vo));
    }

    @Test
    public void testTotalCount() {
        // 예: 제목(T), 작성자(W), 지역명(R), 내용(C)
        Criterial cri = createCriterial(1, 10, "TWRC", "대구");  // 여러 타입 가능
        String[] temp = cri.getTypeArr();  // typeArr 강제 호출 (MyBatis에서 참조되도록)
        int count = mapper.getTotalCount(cri);
        log.info("Total Count: " + count);
    }
 }
