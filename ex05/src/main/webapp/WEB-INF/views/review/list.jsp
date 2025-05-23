<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>리뷰 목록</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/list_css.css">
    <script src="${pageContext.request.contextPath}/resources/script/jquery-1.12.3.js"></script>
    <script src="${pageContext.request.contextPath}/resources/script/script.js"></script>
</head>
<body>
<div id="main">
    <!-- 헤더 -->
    <header>
        <div id="logo">
            <a href="${pageContext.request.contextPath}/review/list">
                <img src="${pageContext.request.contextPath}/resources/img/오늘 뭐먹조.png" alt="로고">
            </a>
        </div>
        <div id="menu">
            <ul>
                <li><a href="#">한식</a></li>
                <li><a href="#">중식</a></li>
                <li><a href="#">일식</a></li>
                <li><a href="#">양식</a></li>
                <li><a href="#">디저트</a></li>
            </ul>
        </div>
        <div id="spot">
            <ul>
                <li><a href="#">마이페이지</a></li>
                <li><a href="#">회원가입</a></li>
                <li><a href="#">로그인</a></li>
            </ul>
        </div>
    </header>

    <!-- 사이드 메뉴 -->
    <nav>
        <div class="menu">
            <li class="none"><a href="#">메뉴</a></li>
            <li><a href="#">서울</a>
                <ul class="sub">
                    <li><a href="#">강남</a></li>
                    <li><a href="#">잠실</a></li>
                    <li><a href="#">종로</a></li>
                    <li><a href="#">홍대</a></li>
                </ul>
            </li>
            <li><a href="#">경기도</a>
                <ul class="sub">
                    <li><a href="#">고양</a></li>
                    <li><a href="#">성남</a></li>
                    <li><a href="#">수원</a></li>
                    <li><a href="#">포천</a></li>
                </ul>
            </li>
            <li><a href="#">경상도</a>
                <ul class="sub">
                    <li><a href="#">대구</a></li>
                    <li><a href="#">부산</a></li>
                    <li><a href="#">울산</a></li>
                    <li><a href="#">포항</a></li>
                </ul>
            </li>
            <li><a href="#">전라도</a>
                <ul class="sub">
                    <li><a href="#">광주</a></li>
                    <li><a href="#">목포</a></li>
                    <li><a href="#">여수</a></li>
                    <li><a href="#">전주</a></li>
                </ul>
            </li>
            <li><a href="#">충청도</a>
                <ul class="sub">
                    <li><a href="#">공주</a></li>
                    <li><a href="#">대전</a></li>
                    <li><a href="#">천안</a></li>
                    <li><a href="#">청주</a></li>
                </ul>
            </li>
            <li><a href="#">제주도</a>
                <ul class="sub">
                    <li><a href="#">서귀포시</a></li>
                    <li><a href="#">제주시</a></li>
                </ul>
            </li>
        </div>
    </nav>

    <!-- 본문 -->
    <div id="body">
        <h1 class="main-title">맛ZON</h1>
        <div id="list">

            <!-- 등록 버튼 + 검색 -->
            <div class="controls">
                <form action="${pageContext.request.contextPath}/review/register" method="get">
                    <button type="submit" class="pagination-button">등록</button>
                </form>

            <form action="${pageContext.request.contextPath}/review/list" method="get" class="search">
    <input type="hidden" name="pageNum" value="1" />
    <input type="hidden" name="amount" value="${empty cri.amount ? 10 : cri.amount}" />
    
    <select name="type">
        <option value="T" ${cri.type == 'T' ? 'selected' : ''}>제목</option>
        <option value="W" ${cri.type == 'W' ? 'selected' : ''}>작성자</option>
        <option value="C" ${cri.type == 'C' ? 'selected' : ''}>내용</option>
        <option value="R" ${cri.type == 'R' ? 'selected' : ''}>지역</option>
    </select>
    
    <input type="text" name="keyword" value="${cri.keyword}" placeholder="리뷰 검색..." />
    <button type="submit">검색</button>
</form>
            </div>

            <!-- 테이블 -->
            <table>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>지역</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>등록일</th>
                        <th>조회수</th>
                    </tr>
                </thead>
                <tbody>
                    <c:choose>
                        <c:when test="${not empty list}">
                            <c:forEach var="review" items="${list}">
                                <tr class="review-row">
                                    <td>${review.review_id}</td>
                                    <td>${review.region}</td>
                                    <td>
                                        <c:url var="detailLink" value="/review/get">
    <c:param name="review_id" value="${review.review_id}" />
    <c:param name="pageNum" value="${not empty cri.pageNum ? cri.pageNum : 1}" />
    <c:param name="amount" value="${not empty cri.amount ? cri.amount : 10}" />
    <c:param name="type" value="${not empty cri.type ? cri.type : ''}" />
    <c:param name="keyword" value="${not empty cri.keyword ? cri.keyword : ''}" />
</c:url>
<a href="${detailLink}">
    ${review.review_title}
</a>
                                    </td>
                                    <td>${review.writer_name}</td>
                                    <td><fmt:formatDate value="${review.register_date}" pattern="yyyy-MM-dd"/></td>
                                    <td>${review.count}</td>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <tr><td colspan="6">등록된 리뷰가 없습니다.</td></tr>
                        </c:otherwise>
                    </c:choose>
                </tbody>
            </table>

  <!-- 기본값 설정 -->
    <c:choose>
        <c:when test="${empty cri.amount}">
            <c:set var="criAmount" value="10" />
        </c:when>
        <c:otherwise>
            <c:set var="criAmount" value="${cri.amount}" />
        </c:otherwise>
    </c:choose>
    <c:choose>
        <c:when test="${empty cri.type}">
            <c:set var="criType" value="" />
        </c:when>
        <c:otherwise>
            <c:set var="criType" value="${cri.type}" />
        </c:otherwise>
    </c:choose>
    <c:choose>
        <c:when test="${empty cri.keyword}">
            <c:set var="criKeyword" value="" />
        </c:when>
        <c:otherwise>
            <c:set var="criKeyword" value="${cri.keyword}" />
        </c:otherwise>
    </c:choose>










<!-- 페이지네이션 -->
<div class="pagination">

    <!-- 이전 버튼 -->
    <c:if test="${pageMaker.prev}">
        <c:url var="prevLink" value="/review/list">
            <c:param name="pageNum" value="${pageMaker.startPage - 1}" />
            <c:param name="amount" value="${empty cri.amount ? 10 : cri.amount}" />
            <c:if test="${not empty cri.type}">
                <c:param name="type" value="${cri.type}" />
            </c:if>
            <c:if test="${not empty cri.keyword}">
                <c:param name="keyword" value="${cri.keyword}" />
            </c:if>
        </c:url>
        <a class="pagination-button" href="${prevLink}">이전</a>
    </c:if>

    <!-- 페이지 번호 반복 -->
    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="pageNum">
        <c:url var="pageLink" value="/review/list">
            <c:param name="pageNum" value="${pageNum}" />
            <c:param name="amount" value="${empty cri.amount ? 10 : cri.amount}" />
            <c:if test="${not empty cri.type}">
                <c:param name="type" value="${cri.type}" />
            </c:if>
            <c:if test="${not empty cri.keyword}">
                <c:param name="keyword" value="${cri.keyword}" />
            </c:if>
        </c:url>
        <a class="pagination-button ${pageNum == cri.pageNum ? 'active' : ''}" href="${pageLink}">
            ${pageNum}
        </a>
    </c:forEach>

    <!-- 다음 버튼 -->
    <c:if test="${pageMaker.next}">
        <c:url var="nextLink" value="/review/list">
            <c:param name="pageNum" value="${pageMaker.endPage + 1}" />
            <c:param name="amount" value="${empty cri.amount ? 10 : cri.amount}" />
            <c:if test="${not empty cri.type}">
                <c:param name="type" value="${cri.type}" />
            </c:if>
            <c:if test="${not empty cri.keyword}">
                <c:param name="keyword" value="${cri.keyword}" />
            </c:if>
        </c:url>
        <a class="pagination-button" href="${nextLink}">다음</a>
    </c:if>

</div>





        </div>
    </div>
</div>
</body>
</html>
