<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div>
			<button onclick="aRam()">아람 페이지로 이동</button>
		</div>
		<div>
			<button onclick="geongman()">경만 페이지로 이동</button>
		</div>
		<div>
			<button onclick="eunji()">은지 페이지로 이동</button>
		</div>
		<div>
			<button onclick="location.href='join.do'">DB테스트</button>
		</div>
	</div>

	<script type="text/javascript">
		function aRam() {
			location.href = 'hostMain.do';
		}

		function geongman() {
			location.href = 'Login.do';
		}

		function eunji() {
			location.href = 'guestMain.do';
		}
	</script>
</body>
</html>