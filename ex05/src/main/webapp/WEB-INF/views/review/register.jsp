<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>리뷰 등록</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/register_css.css">
    <script src="${pageContext.request.contextPath}/resources/script/jquery-1.12.3.js"></script>
    <script src="${pageContext.request.contextPath}/resources/script/script.js"></script>
        <script src="${pageContext.request.contextPath}/resources/script/register_script.js"></script>
</head>
<body>

<div id="main">

    <!-- HEADER -->
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
                <li><a href="#">로그인</a></li>
                <li><a href="#">회원가입</a></li>
                <li><a href="#">마이페이지</a></li>
            </ul>
        </div>
    </header>

    <!-- NAVIGATION -->
    <nav>
        <ul class="menu">
            <li class="none"><a href="#">메뉴</a></li>
            <li><a href="#">서울</a>
                <ul class="sub">
                    <li><a href="#">강남</a></li>
                    <li><a href="#">잠실</a></li>
                    <li><a href="#">종로</a></li>
                    <li><a href="#">홍대</a></li>
                </ul>
            </li>
            <li><a href="#">경기</a>
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
        </ul>
    </nav>

    <!-- CONTENT -->
    <div id="body">
        <div id="list">
            <main class="content">
                <form class="main-card" action="${pageContext.request.contextPath}/review/register"
      				method="post"
      				enctype="multipart/form-data">
                    <label for="title"><strong>제목:</strong></label>
                    <input type="text" id="title" name="review_title" required />

                    <label for="writer"><strong>작성자:</strong></label>
                    <input type="text" id="writer" name="writer_name" required />

                    <label for="region"><strong>지역명:</strong></label>
                    <input type="text" id="region" name="region" required />

                    <label for="restaurant"><strong>맛집 이름:</strong></label>
                    <input type="text" id="restaurant" name="restaurant_name" required />

                    <label for="score"><strong>평점:</strong></label>
                    <select id="score" name="rating">
                        <c:forEach var="i" begin="1" end="10">
                            <option value="${i}">${i}</option>
                        </c:forEach>
                    </select>

                    <label for="content"><strong>리뷰:</strong></label>
                    <textarea id="content" name="review_content" rows="5" required></textarea>

                    <label for="img"><strong>리뷰 사진:</strong></label>
                    <input type="file" id="img" name="upload" accept="image/*" />

                    <div class="edit-actions">
                        <button type="submit" class="btn-writer">등록</button>
                    </div>
                </form>
            </main>
        </div>
    </div>

</div>
</body>
</html>
