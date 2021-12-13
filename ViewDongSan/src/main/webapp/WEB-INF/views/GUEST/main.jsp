<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#imglist{
		width: 700px;
		height: 500px;
	}
	#contents{
		margin-top : 30px;
	}
	
</style>
<script type="text/javascript">
	
	//체크인날짜 오늘날짜로 지정
	window.onload = function() {
		today = new Date();
		console.log("today.toISOString() >>>" + today.toISOString());
		today = today.toISOString().slice(0, 10);
		console.log("today >>>> " + today);
		checkindate = document.getElementById("checkindate");
		checkindate.value = today;
	}
	
	function schedule(){
		let checkindate = $("#checkindate").val();
		let checkoutdate = $("#checkoutdate").val();
		let area = $("#place").val();
		if(checkindate==''||checkoutdate==''){ //날짜를 입력하지 않았을때
			alert("여행날짜를 입력해 주세요.");
		}else{
			today = new Date();
			today = today.toISOString().slice(0, 10);
			if(checkindate<today){ //체크인날짜가 현재날짜이전인경우
				alert("체크인 날짜를 확인해주세요.");
				$("#checkindate").focus();
				$("#checkindate").val(today);
				
			}else if(checkindate>=checkoutdate){ //체크아웃날짜가 체크인날짜와 같거나 이를 경우
				alert("체크아웃 날짜를 확인해주세요.");
				$("#checkoutdate").focus();
				$("#checkoutdate").val("");
			}
		}
		
		if(area != ""){ //여행지 입력시
			console.log("여행지입력");
			$.ajax({
				url:"selectAreaRoomList.do",
				data:{
					area:area,
					checkindate:checkindate,
					checkoutdate:checkoutdate
				},
				type:"POST",
				dataType : "json",
				success:showList,
				error:function(){
					alert("리스트를 불러오는데 실패했습니다. 관리자에게 문의하세요.");
				}
			})
		}else{ //여행지 미입력시
			console.log("여행지미입력");
			$.ajax({
				url:"selectRoomList.do",
				data:{
					checkindate:checkindate,
					checkoutdate:checkoutdate
				},
				type:"POST",
				dataType : "json",
				success:showList,
				error:function(){
					alert("리스트를 불러오는데 실패했습니다. 관리자에게 문의하세요.");
				}
			})
		}
		
	}
	
	function showList(datas){
		if($(".row align-items-center")){
			$("#showshowshow>#contents").remove();
		}
		for(let data of datas){
			let contents = $("<div>").attr({"id":"contents",
				"class":"row align-items-center","roomid":data.roomid});				
			
			let col = $("<div>").attr({"class":"col-lg-6"});
			let aboutimg = $("<div>").attr({"class":"about_img"});
			let imglist = $("<img>").attr({"id":"imglist","src":data.roomImg});
			
			aboutimg.append(imglist);
			col.append(aboutimg);
			contents.append(col)

			let collg = $("<div>").attr({"class":"col-lg-6"});
			let abouttext = $("<div>").attr({"class":"about_text"});
			let roomid = $("<h2>").attr({"id":"roomId"}).text(data.roomName);
			let roomsub = $("<h3>").text(data.roomSubject);
			let div = $("<div>");
			let division = $("<h1>").text("-");
			let table = $("<table>");
			let tbody = $("<tbody>");
			let trF = $("<tr>");
			let tdF = $("<td>");
			let rate = $("<h3>").text("★"+data.roomRate);
			let trS = $("<tr>");
			let tdS = $("<td>");
			let address =  $("<h3>").text(data.roomAddress);
			let trT = $("<tr>");
			let tdT = $("<td>");
			let price = $("<h3>").text(data.roomPrice+"/박");
			
			div.append(division)
			tbody.append(trF).append(tdF).append(rate);
			tbody.append(trS).append(tdS).append(address);
			tbody.append(trT).append(tdT).append(price);
			table.append(tbody);
			abouttext.append(roomid);
			abouttext.append(roomsub);
			abouttext.append(div);
			abouttext.append(table);
			collg.append(abouttext);

			contents.append(collg);

			$("#showshowshow").append(contents);
		}

		$(document).on("click","#showshowshow>#contents",function(){
			let checkindate = $("#checkindate").val();
			let checkoutdate = $("#checkoutdate").val();
			let roomid = event.target.closest("#contents").getAttribute("roomid");
			console.log(event.target.closest("#contents").getAttribute("roomid"));
			location.href="roomDetails.do?roomid="+roomid+"&checkin="+checkindate+"&checkout="+checkoutdate;
		})
	}
	
</script>
</head>
<body>
	<!-- banner part start-->
    <section class="banner_part">
        <div class="container">
            <div class="row align-items-center justify-content-center">
                <div class="col-lg-10">
                    <div class="banner_text text-center">
                        <div class="banner_text_iner">
                            <span id="siteTitle">ViewDongSan</span>
                            <p>Let’s start your journey with us, your dream will come true</p>
                            <a href="#" class="btn_1">여행추천글?</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- banner part start-->

    <!-- booking part start-->
    <section class="booking_part">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="booking_menu">
                        <ul class="nav nav-tabs" id="myTab" role="tablist">
                            <li class="nav-item">
                            <a class="nav-link active" id="hotel-tab" data-toggle="tab" href="#" role="tab" aria-controls="hotel" aria-selected="true">Search for your schedule</a>
                            </li>                     
                        </ul>
                    </div>
                </div>
                <div class="col-lg-12">
                    <div class="booking_content">
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="hotel" role="tabpanel" aria-labelledby="hotel-tab">
                                <div class="booking_form">
                                    <form action="#">
                                        <div class="form-row">                                           
                                            <div class="form_colum">
                                                <input id="place" placeholder="여행지를 입력하세요." type="text">
                                            </div>
                                            <div class="form_colum">
                                                <input id="checkindate" type="date">
                                            </div>                                            
                                            <div class="form_colum">
                                                <input id="checkoutdate" type="date">
                                            </div>                                                                       
                                            <div class="form_btn">
                                                <a href="#" class="btn_1" onclick="schedule()">search</a>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>                                                       
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Header part end-->
    
	<section class="about_us section_padding" id="room">
		<div class="container" id="showshowshow">
		</div>
	</section>


</body>
</html>