<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#place,#checkindate,#checkoutdate{
	width:250px;
	height: 50px;
}
#siteTitle{
	font-size:150px;
	color: white;
	font-family:Times;
}
</style>
</head>
<body>
	 <!--::header part start::-->
   <header class="main_menu">
        <div class="main_menu_iner">
            <div class="container">
                <div class="row align-items-center ">
                    <div class="col-lg-12">
                        <nav class="navbar navbar-expand-lg navbar-light justify-content-between">
                            <a class="navbar-brand"> <img src="img/logo2.jpg" alt="logo" onclick="location.href='guestMain.do'"></a>
                            <button class="navbar-toggler" type="button" data-toggle="collapse"
                                data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                                aria-expanded="false" aria-label="Toggle navigation">
                                <span class="navbar-toggler-icon"></span>
                            </button>                                               

                            <div class="collapse navbar-collapse main-menu-item justify-content-center"
                                id="navbarSupportedContent">
                                <ul class="navbar-nav">
                                    <li class="nav-item">
                                        <a class="nav-link" href="guestMain.do">Home</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">Reservation</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">History</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="myPage.do">MyPage</a>
                                    </li>
                                </ul>
                            </div>
                            <a href="#" class="btn_1 d-none d-lg-block">LOGIN</a>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <!-- Header part end-->

   
</body>
</html>