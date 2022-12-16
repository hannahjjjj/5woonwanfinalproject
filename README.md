# 오늘 운동 완료 🏃‍♂️5WoonWan🏃‍♀️
![캡처](https://user-images.githubusercontent.com/111735494/207983666-a9d1bd8f-6f94-40de-908f-dee89a99f500.PNG)
## SpringBoot Project 5WoonWan
스프링부트을 이용한 운동시설 검색 및 회원권 구매 <br> 트레이너와 1:1 스케줄링이 가능한 웹 사이트
### 👨🏻‍🏫프로젝트 내용👩🏻‍🏫
웹 사이트 시연영상 <br> custwebpage ✔[click](https://www.youtube.com/watch?v=371BYG-tJDY)  <br> adminwebpage ✔[click](https://www.youtube.com/watch?v=ps1rfaj25qM)
### 프로젝트기능구현
1. 자신의 동네주변 헬스장검색
2. 자신이 선택한 강사와 스케줄링 기능
3. OCR을 이용한 자신의 인바디 변화 체크
4. 결제 API기능
5. 리뷰 기능
6. 로그인(카카오API사용) 및 회원가입 기능
### 👩🏻‍💻팀원역할👨🏻‍💻
+ 윤진호
<br> 카카오로그인,결제api,스케줄관리,인바디OCR등록,OCR등록 후 그래프구현,admin페이지(강사/시설관리자/시설/강사스케쥴/로그인/회원가입),페이징처리
+ 전민우
<br>결제페이지,메인화면,admin(로그인/회원가입),결제api
+ 조한나
<br>시설페이지,시설디테일페이지,강사디테일페이지,리뷰구현,페이징처리,search기능
+ 유승리
<br>회원가입
### 시스템구성도
![시스템구성도](https://user-images.githubusercontent.com/111735494/207923738-b459a007-6587-4cef-ab3a-43f0e20c11ee.jpg)
### 수행도구
![image](https://user-images.githubusercontent.com/111735494/207928775-deba99ca-0dfa-4db3-a7bc-2ec041cd5356.png)
### UI설계
![image](https://user-images.githubusercontent.com/111735494/207990263-0e5f14ce-ea33-4364-b6be-8b1f4dd38008.png)
### 데이터베이스 설계
![파이널 프로젝트 ERD](https://user-images.githubusercontent.com/111735494/207484883-17c8ee47-b078-4cc3-a529-9a28c4e77a38.png)
### ⚡TROUBLE SHOOTING⚡

|이름|발생한 문제|해결 방법|
|:---:|:---:|:---:|
|윤진호|결제 API를 이용해 결제를 진행할 때 주문 번호가 중복이 되어 이미 결제가 된 상품 문구 발생|주문이 저장되는 DB 테이블에 마지막 PK 번호를 받아와 그 다음 번호로 주문번호를 작성|
|전민우|||
|조한나|||

## 프로젝트 결과
### custwebpage
![image](https://user-images.githubusercontent.com/111735494/207851195-3e288c1f-37df-4c46-b8b0-c6cb0060a93e.png)
### adminwebpage
![image](https://user-images.githubusercontent.com/111735494/207851298-83278f44-5e78-4713-a6a5-1bbdb32f573f.png)
## 회원전용 웹페이지
### 1.회원가입
+ Ajax 이용하여 아이디 중복 및 비밀번호2차확인
+ 모든 칸을 채우지 않으면 "입력사항을 모두 입력해주세요."모달창 띄우기
+ 카카오 API를 사용하여 주소찾기 기능
+ 모든 조건 충족시 회원가입
![회원가입](https://user-images.githubusercontent.com/48542532/207912445-7d2ff275-79d0-4b6c-a25b-fa5622b66fd2.gif)
### 2.로그인
+ 카카오 API를 이용한 로그인
+ 로그인 실패시 모달창을 띄워 아이디 혹은 비밀번호 확인요청
![로그인](https://user-images.githubusercontent.com/48542532/207912533-b6bf012e-2498-42bc-81d3-c498e97fd09e.gif)
#### 로그인 성공 화면
### 3.마이페이지
+ 로그인한 아이디값 정보 불러옴
+ 마이페이지 수정 및 회원탈퇴 가능
+ 자신이 구매한 회원권과 예약 현황확인
+ 인바디 등록하면 자신의 수치 변화를 그래프를 통해 확인
![마이페이지 2](https://user-images.githubusercontent.com/48542532/207913129-10f03429-36ab-4350-8b09-c6cfc7c23fa4.gif)
![오씨알](https://user-images.githubusercontent.com/48542532/207913150-32d8774a-36e0-4082-90fe-f4c0a7ee2fc5.gif)


### 4.스케줄 관리

+ 자신이 원하는 날짜와 시간을 선택해 강사에게 수업요청 가능
+ 불가능 시간에는 따로 표시
+ 오늘 이후 날짜만 선택가능
![스케줄](https://user-images.githubusercontent.com/48542532/207913501-3d985f2a-8eb2-4557-9190-9b25b7b6c2bd.gif)
### 5.시설 리스트
+ 운동 카테고리별로 정리
+ 페이징처리 구현
![시설 디테일](https://user-images.githubusercontent.com/48542532/207915548-06a62066-d5e9-4a0b-86d2-d24457b594eb.gif)
### 6.시설 상세 페이지
+ 시설의 기본정보
+ 좌측 카테고리별로 클릭하면 이동
+ 강사 리스트 표시(강사사진 클릭하면 강사상세페이지로 이동)
![시설리스트](https://user-images.githubusercontent.com/48542532/207914045-78241cc6-21cb-4b7a-a04e-908ee2b3dd47.gif)
### 6-1. 리뷰구현
+ 별점과 리뷰 표시(날짜, 아이디, 리뷰내용, 별점)
+ 로그인시에만 작성란이 생겨남
+ 회원권 구매시에만 작성 (회원권 구매 안했을 시 회원권구매 후 별점이용가능 메세지)
![시설리스트](https://user-images.githubusercontent.com/48542532/207914045-78241cc6-21cb-4b7a-a04e-908ee2b3dd47.gif)
### 6-2. 카카오맵 연동
+ 카카오맵 연동하여 시설 상세위치 표시
### 6-3. 이용권 구매
+ 결제 API를 통해 구매 가능
### 7. 강사 상세 페이지
+ 강사기본정보
+ 드롭다운형식으로 이력/수상/PT가격을 볼 수 있음
### 7-1.PT 신청 기능
+ PT가격에서 자신이 원하는 회원권 구매
+ 결제 API를 통해 결제
![강사 디테일 회원권 구매](https://user-images.githubusercontent.com/48542532/207913605-d19c17f9-128a-4459-8fc7-d31ae3785bdb.gif)

### 8. 검색기능
+ 메인페이지에서 자신이 사는 동네를 검색
+ 시설페이지에서 좌측에 있는 검색창 이용 가능
![검색](https://user-images.githubusercontent.com/48542532/207913644-8fb584a8-6abe-4350-99a0-0bb2dbcae45d.gif)

## 관리자전용 PAGE
### 1.회원가입
+ 시설 관리자와 트레이너를 구분해서 가입 진행
+ 트레이너의 경우 DataBase에 저장 되어있는 시설 검색 후 가입 진행 
+ Ajax 이용하여 아이디 중복 및 비밀번호2차확인
+ 가입에 필요한 필수 정보를 입력하지 않으면 "입력사항을 모두 입력해주세요."모달창 띄우기
+ 카카오 API를 사용하여 주소찾기 기능
+ 모든 조건 충족시 회원가입
![어드민 회원가입](https://user-images.githubusercontent.com/48542532/207925434-f5f100b9-a580-4df2-bf2f-24cf0a94aa85.gif)
### 2.로그인
+ 로그인 실패시 모달창을 띄워 아이디 혹은 비밀번호 확인요청
![어드민 회원가입](https://user-images.githubusercontent.com/48542532/207925461-043888fa-fb7e-4337-9595-cf0cc2d7489e.gif)
#### 로그인 성공 화면
### 3.시설 수정
+ 내 시설 정보 수정 가능
### 4.강사 수정(트레이너)
+ 등록된 내 정보 수정
### 5.강사 관리(관리자)
+ 내 시설에 등록된 강사들 리스트 표시
![어드민 회원가입](https://user-images.githubusercontent.com/48542532/207925509-3ef9cc6a-c2ed-4c57-b8e6-945bfd208ee5.gif)
### 6.스케줄 관리
+ 트레이너는 자신에게 예약된 회원권 스케줄 조정
+ 시설 관리자는 나의 시설에 예약된 회원권 스케줄 조정
+ 날짜별로 예약 확인, 취소 가능
+ 오늘 이후 날짜만 선택가능
![어드민 스케줄](https://user-images.githubusercontent.com/48542532/207925548-47eacbbd-6990-41f0-8933-7e73deb7475f.gif)

### 7. 메인페이지
+ 신규 고객 , 매출 , 연령대 별 성비 차트 표시
+ 다가오는 스케줄(시간 , 강사명, 회원명) 표시
![어드민 메인](https://user-images.githubusercontent.com/48542532/207925578-aab89ca3-69e1-4d0e-a9d0-70cff7375f05.gif)
