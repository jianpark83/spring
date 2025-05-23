package org.zerock.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.ReviewVO;
import org.zerock.domain.Criterial;

public interface ReviewMapper {
    
    void insertSelectKey(ReviewVO review);

    ReviewVO read(Long review_id);

    int update(ReviewVO review);

    int delete(Long review_id);

    List<ReviewVO> getList();  // 전체 목록 (페이징 없는 간단용)

    List<ReviewVO> getListWithPaging(Criterial cri);  // 페이징 목록

    int getTotalCount(Criterial cri);  // 총 개수

	List<ReviewVO> searchTest(Map<String, Map<String, String>> outerMap);

	void insert(ReviewVO vo);

	void increaseViewCount(Long review_id);
}
