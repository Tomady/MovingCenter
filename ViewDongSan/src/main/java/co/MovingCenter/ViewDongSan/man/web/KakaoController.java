package co.MovingCenter.ViewDongSan.man.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.MovingCenter.ViewDongSan.man.service.GuestService;
import co.MovingCenter.ViewDongSan.man.service.GuestVO;

@Controller
public class KakaoController {
	
	@Autowired
	private GuestService guestDao;
	
	@RequestMapping("/kakaologin.do")
	@ResponseBody
	
	public String userController(HttpServletRequest request, HttpSession session, Model model) {
		System.out.println("카카오로그인");
		System.out.println(request.getParameter("kakaoemail"));
		System.out.println(request.getParameter("kakaoname"));
		System.out.println(request.getParameter("kakaobirth"));

		// kakaoemail을 kakaoid에 저장
		String kakaoid = request.getParameter("kakaoemail");

		GuestVO userTo = new GuestVO();
//
		// kakaoid를 to의 id로 세팅
		userTo.setGuestid(kakaoid);
		userTo = guestDao.selectGuestId(userTo);
		
		
		
		// 카카오계정으로 로그인한 적이 있는지 없는지 
		String ViewPage = null;
		if (userTo == null) { // 회원이 아닌경우 (카카오 계정으로 처음 방문한 경우) 카카오 회원정보 설정 창으로 이동
		    System.out.println("카카오 회원 정보 설정");

		    model.addAttribute("kakaoid", request.getParameter("kakaoemail"));
		    model.addAttribute("kakaoname", request.getParameter("kakaoname"));
		    model.addAttribute("kakaobirth", request.getParameter("kakaobirth"));
		    model.addAttribute("kakaoemail", request.getParameter("kakaoemail"));
		    
		    
		    
		    
		    
//		    request.setAttribute("kakaoid", request.getParameter("kakaoemail"));
//		    request.setAttribute("kakaoname",request.getParameter("kakaoname"));
//		    request.setAttribute("kakaobirth",request.getParameter("kakaobirth"));
//		    request.setAttribute("kakaoemail",request.getParameter("kakaoemail"));

		    // 회원가입창으로 이동
		    ViewPage = "join";

		} else { // 이미 카카오로 로그인한 적이 있을 때 (최초 1회 로그인때 회원가입된 상태)
		    // id, nick, profile을 가져와서
		    userTo = guestDao.selectGuestId(userTo);
		    // id를 세션에 저장
		    session.setAttribute("kakaoid", userTo.getGuestid());
		    // nick을 세션에 저장
		    session.setAttribute("nick", userTo.getGname());
		    // 프로필 사진 (profile)을 세션에 저장
		    session.setAttribute("profile", userTo.getGimg());


		    System.out.println("kakaoid : " + userTo.getGuestid());
		    System.out.println("nick : " + userTo.getGname());
		    System.out.println("profile : " + userTo.getGimg());
		    
		    ViewPage = "GUEST/main";
		}
		return ViewPage;
	}
	

}
