package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Criterial {

    private int pageNum = 1;    // 현재 페이지 번호
    private int amount = 10;    // 한 페이지당 게시물 수

    private String type;        // 검색 조건 (T, W, C, R 등)
    private String keyword;     // 검색어

    public Criterial() {
        this(1, 10);
    }

    public Criterial(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }

    // ✅ 검색 타입 배열 (MyBatis foreach용)
    public String[] getTypeArr() {
        return type == null ? new String[] {} : type.split("");
    }

    // ✅ null 방지용 getter 추가
    public String getType() {
        return (this.type == null) ? "" : this.type;
    }

    public String getKeyword() {
        return (this.keyword == null) ? "" : this.keyword;
    }

    public int getStartRow() {
        return (this.pageNum - 1) * this.amount + 1;
    }

    public int getEndRow() {
        return this.pageNum * this.amount;
    }
}
