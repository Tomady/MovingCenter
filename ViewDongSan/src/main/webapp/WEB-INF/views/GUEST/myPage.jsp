<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#sidemenu {
	border: 2px solid grey;
	border-radius: 10px;
	height: 500px;
}

.row, #profile, #pictureUpload {
	margin-top: 20px;
}

#menu {
	margin-bottom: 15px;
	font-weight: bold;
	font-size: 17px;
}

#mypagecontent {
	font-size: 30px;
}
.single-input{
	font-size: 20px;
}
#label{
	color:rgb(248, 144, 25);
	font-weight: bold;
}
#menu:hover{
	color:rgb(248, 144, 25);
	font-weight: bold;
	cursor:pointer;
}
#drop{
	color:red;
}
#drop:hover{
	font-weight: bold;
	cursor:pointer;
}
#saveBtn{
	float:right;
}
</style>
</head>
<body>
	<!-- sidebar : 예약내역,위시리스트,내가작성한후기 -->
	<div class="whole-wrap">
		<div class="container box_1170">
			<div class="section-top-border">
				<div class="row">
					<div class="col-lg-3 col-md-4 mt-sm-30">
						<div class="single-element-widget">
							<h1>My Page</h1><br>
							<img src="img/elements/d.jpg" alt="" class="img-fluid"><br><br>
							<h1>&nbsp;-</h1>
							<span id="menu">&nbsp;&nbsp;&nbsp;프로필 이미지 변경</span><br>
							<span id="menu">&nbsp;&nbsp;&nbsp;예약내역</span><br>
							<span id="menu">&nbsp;&nbsp;&nbsp;위시리스트</span><br>
							<span id="menu">&nbsp;&nbsp;&nbsp;내가 작성한 후기</span><br>
							<span>(시간남으면 만들기)</span>
							<h1>&nbsp;-</h1>
							<span id="drop">&nbsp;&nbsp;&nbsp;회원탈퇴</span><br>
							<span>세션값지워주고->로그아웃,상태값변경</span>
						</div>
					</div>
					<div class="col-lg-8 col-md-8">
						<br><br><br><br>
						<h3 class="mb-30">MY INFO</h3>
						<form action="#">
							<div class="mt-10">
								<span id="label">ID</span>
								<input type="text" name="first_name" class="single-input" 
									   value="GUEST ID (수정 불가, Read Only)" readonly>								
							</div>
							<div class="mt-10">
								<span id="label">PW</span>
								<input type="password" name="last_name" class="single-input" 
									   value="GUEST PASSWORD" placeholder="비밀번호">
							</div>
							<div class="mt-10">
								<span id="label">NAME</span>
								<input type="text" name="last_name" class="single-input" 
									   value="GUEST NAME" placeholder="이름">
							</div>
							<div class="mt-10">
								<span id="label">TEL</span>
								<input type="email" name="EMAIL" class="single-input"
									   value="GUEST TEL" placeholder="전화번호">
							</div>
							<div class="mt-10">
								<span id="label">ADDRESS</span>
								<input type="email" name="EMAIL" class="single-input"
									   value="GUEST ADDRESS" placeholder="주소">
							</div>
						</form>
						<br>
						<button class="genric-btn primary-border circle" id="saveBtn">SAVE</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>