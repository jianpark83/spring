create sequence re_board;

create table review_board(
    review_id number,
    review_title varchar2(200) not null,
    restaurant_name varchar2(200) not null,
    review_content varchar2(2000) not null,
    writer_name varchar2(50) not null,
    register_date date default sysdate,    --작성일
    rating number,
    count number,
    region varchar2(50)  
);
commit;

INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '여기 또 올래요', '별로식당', '이 가격에 이 정도면 대만족!', '수지', 5, '서울');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '여기 또 올래요', '만원의행복', '매콤한 양념과 육수의 맛있는 열무냉면', '블랑', 3, '부산');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '삼겹살 끝판왕', '고기천국', '전체적으로 만족스러웠어요', '서준', 1, '광주');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '정말 별로였어요', '재방문식당', '음식 하나하나가 정성스러워요', '지안', 5, '경기');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '여기 또 올래요', '송월냉면', '음식 하나하나가 정성스러워요', '수지', 4, '인천');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '강추하는 맛집', '별로식당', '이 가격에 이 정도면 대만족!', '지안', 3, '대구');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '혼밥하기 좋은 곳', '재방문식당', '혼자 먹기 딱 좋아요', '나연', 4, '세종');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '가성비 최고 식당', '맛있는상상', '재료가 신선하지 않았어요', '철수', 5, '세종');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '천호동 냉면 맛집!!', '송월냉면', '전체적으로 만족스러웠어요', '우진', 1, '인천');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '천호동 냉면 맛집!!', '만원의행복', '매콤한 양념과 육수의 맛있는 열무냉면', '나연', 5, '세종');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '강추하는 맛집', '만원의행복', '커피 맛있고 분위기 최고에요', '수지', 4, '울산');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '삼겹살 끝판왕', '송월냉면', '재료가 신선하지 않았어요', '나연', 4, '강원');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '혼밥하기 좋은 곳', '후기좋은집', '재료가 신선하지 않았어요', '서준', 4, '강원');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '삼겹살 끝판왕', '송월냉면', '혼자 먹기 딱 좋아요', '서준', 5, '서울');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '강추하는 맛집', '고기천국', '고기가 부드럽고 양도 많아요', '지안', 4, '대전');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '분위기 좋은 카페', '별로식당', '혼자 먹기 딱 좋아요', '영희', 2, '세종');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '여기 또 올래요', '후기좋은집', '커피 맛있고 분위기 최고에요', '나연', 1, '서울');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '혼밥하기 좋은 곳', '카페드림', '분위기와 서비스 모두 만족', '민수', 3, '울산');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '재방문의사 있음', '고기천국', '혼자 먹기 딱 좋아요', '나연', 4, '경기');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '친절한 직원들', '혼밥정식', '매콤한 양념과 육수의 맛있는 열무냉면', '민지', 4, '강원');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '친절한 직원들', '만원의행복', '매콤한 양념과 육수의 맛있는 열무냉면', '우진', 3, '울산');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '삼겹살 끝판왕', '혼밥정식', '전체적으로 만족스러웠어요', '영희', 2, '부산');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '재방문의사 있음', '송월냉면', '혼자 먹기 딱 좋아요', '지안', 4, '서울');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '혼밥하기 좋은 곳', '후기좋은집', '음식 하나하나가 정성스러워요', '민지', 1, '부산');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '천호동 냉면 맛집!!', '카페드림', '분위기와 서비스 모두 만족', '수지', 3, '인천');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '정말 별로였어요', '맛있는상상', '음식 하나하나가 정성스러워요', '우진', 1, '강원');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '가성비 최고 식당', '혼밥정식', '분위기와 서비스 모두 만족', '수지', 2, '경기');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '강추하는 맛집', '카페드림', '이 가격에 이 정도면 대만족!', '민수', 2, '강원');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '혼밥하기 좋은 곳', '만원의행복', '재료가 신선하지 않았어요', '나연', 4, '대구');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '분위기 좋은 카페', '혼밥정식', '음식 하나하나가 정성스러워요', '나연', 3, '세종');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '혼밥하기 좋은 곳', '만원의행복', '커피 맛있고 분위기 최고에요', '나연', 1, '경기');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '삼겹살 끝판왕', '후기좋은집', '매콤한 양념과 육수의 맛있는 열무냉면', '철수', 5, '부산');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '친절한 직원들', '고기천국', '고기가 부드럽고 양도 많아요', '영희', 5, '인천');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '삼겹살 끝판왕', '별로식당', '혼자 먹기 딱 좋아요', '수지', 1, '울산');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '재방문의사 있음', '혼밥정식', '이 가격에 이 정도면 대만족!', '블랑', 2, '세종');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '가성비 최고 식당', '후기좋은집', '이 가격에 이 정도면 대만족!', '영희', 2, '대구');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '천호동 냉면 맛집!!', '고기천국', '분위기와 서비스 모두 만족', '지안', 2, '광주');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '가성비 최고 식당', '만원의행복', '고기가 부드럽고 양도 많아요', '영희', 3, '서울');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '분위기 좋은 카페', '별로식당', '매콤한 양념과 육수의 맛있는 열무냉면', '민수', 5, '세종');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '혼밥하기 좋은 곳', '혼밥정식', '분위기와 서비스 모두 만족', '나연', 4, '인천');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '강추하는 맛집', '후기좋은집', '이 가격에 이 정도면 대만족!', '철수', 2, '광주');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '삼겹살 끝판왕', '만원의행복', '전체적으로 만족스러웠어요', '철수', 4, '인천');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '정말 별로였어요', '송월냉면', '커피 맛있고 분위기 최고에요', '민수', 4, '광주');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '여기 또 올래요', '고기천국', '이 가격에 이 정도면 대만족!', '철수', 5, '세종');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '혼밥하기 좋은 곳', '카페드림', '전체적으로 만족스러웠어요', '수지', 3, '경기');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '천호동 냉면 맛집!!', '별로식당', '고기가 부드럽고 양도 많아요', '나연', 4, '광주');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '재방문의사 있음', '별로식당', '분위기와 서비스 모두 만족', '수지', 2, '인천');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '가성비 최고 식당', '카페드림', '고기가 부드럽고 양도 많아요', '우진', 2, '강원');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '여기 또 올래요', '카페드림', '음식 하나하나가 정성스러워요', '철수', 4, '대구');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '친절한 직원들', '만원의행복', '이 가격에 이 정도면 대만족!', '영희', 5, '울산');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '재방문의사 있음', '별로식당', '음식 하나하나가 정성스러워요', '블랑', 2, '서울');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '정말 별로였어요', '고기천국', '커피 맛있고 분위기 최고에요', '서준', 4, '대구');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '재방문의사 있음', '만원의행복', '고기가 부드럽고 양도 많아요', '블랑', 1, '울산');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '삼겹살 끝판왕', '고기천국', '직원들이 친절해서 기분 좋았어요', '민지', 5, '인천');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '천호동 냉면 맛집!!', '맛있는상상', '직원들이 친절해서 기분 좋았어요', '나연', 3, '서울');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '재방문의사 있음', '별로식당', '음식 하나하나가 정성스러워요', '민수', 2, '인천');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '가성비 최고 식당', '혼밥정식', '재료가 신선하지 않았어요', '민수', 3, '대전');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '정말 별로였어요', '송월냉면', '이 가격에 이 정도면 대만족!', '민수', 1, '인천');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '가성비 최고 식당', '송월냉면', '직원들이 친절해서 기분 좋았어요', '지안', 3, '인천');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '여기 또 올래요', '별로식당', '혼자 먹기 딱 좋아요', '민수', 1, '대구');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '여기 또 올래요', '별로식당', '전체적으로 만족스러웠어요', '민지', 3, '대전');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '삼겹살 끝판왕', '재방문식당', '음식 하나하나가 정성스러워요', '블랑', 2, '서울');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '재방문의사 있음', '재방문식당', '음식 하나하나가 정성스러워요', '철수', 5, '경기');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '여기 또 올래요', '친절분식', '매콤한 양념과 육수의 맛있는 열무냉면', '지안', 5, '강원');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '혼밥하기 좋은 곳', '카페드림', '직원들이 친절해서 기분 좋았어요', '서준', 4, '대전');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '삼겹살 끝판왕', '재방문식당', '매콤한 양념과 육수의 맛있는 열무냉면', '민지', 4, '인천');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '재방문의사 있음', '맛있는상상', '재료가 신선하지 않았어요', '나연', 5, '강원');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '친절한 직원들', '송월냉면', '전체적으로 만족스러웠어요', '철수', 3, '서울');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '천호동 냉면 맛집!!', '맛있는상상', '이 가격에 이 정도면 대만족!', '영희', 1, '인천');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '삼겹살 끝판왕', '고기천국', '이 가격에 이 정도면 대만족!', '수지', 2, '대구');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '분위기 좋은 카페', '후기좋은집', '매콤한 양념과 육수의 맛있는 열무냉면', '우진', 1, '부산');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '분위기 좋은 카페', '후기좋은집', '전체적으로 만족스러웠어요', '우진', 1, '부산');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '재방문의사 있음', '후기좋은집', '음식 하나하나가 정성스러워요', '민지', 2, '울산');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '정말 별로였어요', '송월냉면', '전체적으로 만족스러웠어요', '수지', 3, '세종');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '분위기 좋은 카페', '재방문식당', '이 가격에 이 정도면 대만족!', '나연', 3, '대구');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '천호동 냉면 맛집!!', '혼밥정식', '이 가격에 이 정도면 대만족!', '민수', 2, '대구');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '가성비 최고 식당', '맛있는상상', '이 가격에 이 정도면 대만족!', '나연', 4, '광주');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '혼밥하기 좋은 곳', '만원의행복', '전체적으로 만족스러웠어요', '민수', 3, '부산');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '천호동 냉면 맛집!!', '혼밥정식', '전체적으로 만족스러웠어요', '수지', 5, '대전');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '친절한 직원들', '별로식당', '분위기와 서비스 모두 만족', '블랑', 3, '울산');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '삼겹살 끝판왕', '별로식당', '직원들이 친절해서 기분 좋았어요', '수지', 3, '서울');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '천호동 냉면 맛집!!', '별로식당', '분위기와 서비스 모두 만족', '지안', 3, '서울');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '친절한 직원들', '송월냉면', '전체적으로 만족스러웠어요', '철수', 5, '세종');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '정말 별로였어요', '재방문식당', '음식 하나하나가 정성스러워요', '서준', 5, '대구');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '분위기 좋은 카페', '후기좋은집', '직원들이 친절해서 기분 좋았어요', '민수', 5, '대전');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '삼겹살 끝판왕', '카페드림', '음식 하나하나가 정성스러워요', '서준', 5, '인천');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '정말 별로였어요', '후기좋은집', '분위기와 서비스 모두 만족', '수지', 2, '강원');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '재방문의사 있음', '맛있는상상', '분위기와 서비스 모두 만족', '우진', 3, '대전');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '분위기 좋은 카페', '재방문식당', '고기가 부드럽고 양도 많아요', '수지', 5, '인천');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '정말 별로였어요', '별로식당', '직원들이 친절해서 기분 좋았어요', '철수', 5, '인천');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '친절한 직원들', '카페드림', '재료가 신선하지 않았어요', '서준', 5, '울산');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '친절한 직원들', '혼밥정식', '직원들이 친절해서 기분 좋았어요', '블랑', 4, '광주');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '가성비 최고 식당', '재방문식당', '음식 하나하나가 정성스러워요', '나연', 2, '대전');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '가성비 최고 식당', '친절분식', '매콤한 양념과 육수의 맛있는 열무냉면', '서준', 3, '광주');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '가성비 최고 식당', '후기좋은집', '고기가 부드럽고 양도 많아요', '나연', 4, '서울');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '천호동 냉면 맛집!!', '후기좋은집', '혼자 먹기 딱 좋아요', '우진', 5, '광주');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '정말 별로였어요', '맛있는상상', '재료가 신선하지 않았어요', '나연', 1, '서울');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '천호동 냉면 맛집!!', '맛있는상상', '재료가 신선하지 않았어요', '서준', 3, '인천');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '삼겹살 끝판왕', '친절분식', '이 가격에 이 정도면 대만족!', '서준', 2, '대전');
INSERT INTO review_board (review_id, review_title, restaurant_name, review_content, writer_name, rating, reigon)
VALUES (re_board.nextval, '친절한 직원들', '친절분식', '분위기와 서비스 모두 만족', '민지', 1, '경기');