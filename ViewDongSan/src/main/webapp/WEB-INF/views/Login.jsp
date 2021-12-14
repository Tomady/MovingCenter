
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<script type="text/javascript">
	function login() {
		var id = document.querySelector('#id');
		var pw = document.querySelector('#pw');

		if (id.value == "" || pw.value == "") {
			alert("로그인 할 수 없습니다.");
			history.back();
		} 

	}
</script>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap"
	rel="stylesheet">
<script src="https://kit.fontawesome.com/53a8c415f1.js"
	crossorigin="anonymous"></script>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: "Noto Sans KR", sans-serif;
}

body {
	max-width: 100%;
	height: auto;
	background-image: url('resources/image/login.PNG');
	background-repeat: no-repeat;
	background-size: cover;
}

a {
	text-decoration: none;
	color: black;
}

li {
	list-style: none;
}

.wrap {
	top: 30px;
	width: 100%;
	height: 100vh;
	display: flex;
	align-items: center;
	justify-content: center;
	background: rgba(0, 0, 0, 0.1);
}

.login {
	position: absolute;
	width: 30%;
	height: 600px;
	background: rgba(204, 191, 191, 0.753);
	border-radius: 20px;
	display: flex;
	justify-content: center;
	align-items: center;
	flex-direction: column;
}

h2 {
	color: white;
	top: 20px;
	white-space: nowrap;
	font-size: 2em;
	width: 100%;
}

h4 {
	color: rgb(65, 64, 64);
	top: 20px;
	white-space: nowrap;
}

.login_id {
	margin-top: 20px;
	width: 80%;
}

.login_id input {
	width: 100%;
	height: 50px;
	border-radius: 30px;
	margin-top: 10px;
	padding: 0px 20px;
	border: 1px solid lightgray;
	outline: none;
}

.login_pw {
	margin-top: 20px;
	width: 80%;
}

.login_pw input {
	width: 100%;
	height: 50px;
	border-radius: 30px;
	margin-top: 10px;
	padding: 0px 20px;
	border: 1px solid lightgray;
	outline: none;
}

.submit {
	margin-top: 50px;
	width: 80%;
}

#loginfo {
	width: 40%;
	height: 40px;
	border: 0;
	outline: none;
	border-radius: 40px;
	background: linear-gradient(to left, rgba(96, 187, 247, 0.349),
		rgba(154, 252, 192, 0.404));
	color: white;
	font-size: 1.2em;
	letter-spacing: 2px;
}

#userinsert {
	width: 40%;
	height: 40px;
	border: 0;
	outline: none;
	border-radius: 40px;
	background: linear-gradient(to left, rgba(96, 187, 247, 0.349),
		rgba(154, 252, 192, 0.404));
	color: white;
	font-size: 1.2em;
	letter-spacing: 2px;
}

#kakao {
	border: 0;
	width: 100%;
	height: 0px;
	display: inline-block;
}

.kakao-img {
	width: 100%;
}

#naver {
	border: 0;
	width: 100%;
	height: 0px;
	display: inline-block;
}

.naver-img {
	width: 100%;
}
</style>
</head>

<body>
	<form action="main.do" method="post">
		<div class="wrap">
			<div class="login">
				<h2 align="center">LOGIN 또는 회원가입</h2>
				<div class="login_sns"></div>
				<div class="login_id">
					<h4>ID</h4>
					<input type="ID" name="id" id="id" placeholder="ID">
				</div>
				<div class="login_pw">
					<h4>Password</h4>
					<input type="password" name="pw" id="pw" placeholder="Password">
				</div>
				<div class="submit">
					<input type="submit" value="로그인" id="loginfo" onclick="login()" style="float: left;">
					<input type="button" value="회원가입" id="userinsert"
						onclick="location.href='#'" style="float: right;"> <br>
					<br> <br>
				</div>
				<div>
					 <button type="button" id="kakao"
						onclick="location.href='https://kauth.kakao.com/oauth/authorize?client_id=d058dc44b0e492fabf6be0c473ea8c4c&redirect_uri=http://localhost/ViewDongSan/alllist.do&response_type=code'">
						<img class="kakao-img" src="resources/image/kakao1.png">
					</button>
				</div>
				<br>
				<div>
					<button type="button" id="naver">
						<img class="naver-img" src="resources/image/naver1.png">
					</button>
				</div>
			</div>
		</div>
	</form>
</body>

</html>