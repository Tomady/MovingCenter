package co.MovingCenter.ViewDongSan.man.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.MovingCenter.ViewDongSan.man.service.AdminService;
import co.MovingCenter.ViewDongSan.man.service.AdminVO;
import co.MovingCenter.ViewDongSan.man.service.ChartService;
import co.MovingCenter.ViewDongSan.man.service.ChartVO;
import co.MovingCenter.ViewDongSan.man.service.GuestService;
import co.MovingCenter.ViewDongSan.man.service.GuestVO;
import co.MovingCenter.ViewDongSan.man.service.HostService1;
import co.MovingCenter.ViewDongSan.man.service.HostVO1;

@Controller
public class AdminController {
	@Autowired
	private HostService1 hostDao1;
	@Autowired
	private GuestService guestDao;
	@Autowired
	private AdminService adminDao;
	@Autowired
	private ChartService chartDao;

	@RequestMapping(value = "/adminMain.do")
	public String test() {
		return "ADMIN/main";
	}

	@RequestMapping(value = "/Login.do")
	public String loginpage() {
		System.out.println("login1");
		return "Login";
	}
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "Login";
	}

	@RequestMapping("/alllist.do")
	public String alllist(Model model) {
//		List<LoginVO> list = loginDao.allLoginMember();
//		model.addAttribute("main", list);

		List<HostVO1> hostlist = hostDao1.selectListHost();
		List<GuestVO> guestlist = guestDao.selectListGuest();
		model.addAttribute("hosts", hostlist);
		model.addAttribute("guests", guestlist);

		return "ADMIN/main";
	}

	@RequestMapping("/main.do")
	public String login(HttpServletResponse response, @RequestParam("id") String id, @RequestParam("pw") String password, Model model) throws IOException {
		System.out.println("login2");
		String path = "";

		AdminVO avo = new AdminVO();
		avo.setAdminid(id);
		avo.setAdminpassword(password);
		avo = adminDao.selectAdmin(avo);

		if (avo == null) {
			HostVO1 hvo = new HostVO1();
			hvo.setHostid(id);
			hvo.setHpassword(password);
			hvo = hostDao1.selectHost(hvo);

			if (hvo == null) {
				GuestVO gvo = new GuestVO();
				gvo.setGuestid(id);
				gvo.setGpassword(password);
				gvo = guestDao.selectGuest(gvo);
				if (gvo != null) {
					path = "GUEST/main";
					// guest
				}
			} else {
				
				path = "HOST/main";
			}
		} else {
			List<HostVO1> hostlist = hostDao1.selectListHost();
			List<GuestVO> guestlist = guestDao.selectListGuest();
			model.addAttribute("hosts", hostlist);
			model.addAttribute("guests", guestlist);
			System.out.println("관리자");

			path = "ADMIN/main";
		}
		if(path == "") {
//			response.setContentType("text/html; charset=UTF-8");
//			PrintWriter out = response.getWriter();
//			out.print("<script>alert('로그인 정보를 확인해주세요.');</script>");
//			out.flush();
			return "redirect:Login.do";
		}else {
			
			return path;
		}

//		if (ret == 1) {
//			path = "ADMIN/main";
//			List<HostVO1> list = hostDao1.selectListHost();
//			model.addAttribute("main", list);
//		} 
//		else {
//			path = "Login";
//		}

//		return path;
	}

	@RequestMapping("/guestlist.do")
	public String guestList(Model model) {

		List<GuestVO> list = guestDao.selectListGuest();
		model.addAttribute("guestlist", list);

		return "ADMIN/guestlist";
	}

	@RequestMapping("/hostlist.do")
	public String hostList(Model model) {

		List<HostVO1> list = hostDao1.selectListHost();
		model.addAttribute("hostlist", list);

		return "ADMIN/hostlist";
	}

	@RequestMapping("/hostapprove.do")
	public String hostapprove(Model model) {
		List<HostVO1> list = hostDao1.selectListHost();
		model.addAttribute("hostapprove", list);
		return "ADMIN/hostapprove";

	}

	@ResponseBody
	@RequestMapping("/deletehost.do")
	public String deleteHost(HttpServletRequest request, Model model) {
		String hostid = request.getParameter("checkboxarr");
		System.out.println("deletehost.do");
		System.out.println(hostid);

		int result = hostDao1.hostDelete(hostid);
		if (result != 0) {
		} else {
			System.out.println("false");
		}
//		String[] arrayParam  = request.getParameterValues("hostid[]");
//		
//		for (int i = 0; i < arrayParam.length; i++) {
//			System.out.println(arrayParam[i]);
//		}
		return Integer.toString(result);
	}

	@ResponseBody
	@RequestMapping("/deleteguest.do")
	public String deleteGuest(HttpServletRequest request, Model model) {
		String guestid = request.getParameter("checkboxarr");
		System.out.println(guestid);

		guestDao.guestDelete(guestid);
		int result = guestDao.guestDelete(guestid);
//		

		return Integer.toString(result);
	}

	@ResponseBody
	@RequestMapping("/updatehost.do")
	public String updateHost(HttpServletRequest request, Model model) {
		System.out.println("들어오나");
		String author = request.getParameter("authorArr");
		String hostid = request.getParameter("hostid");

		HostVO1 vo = new HostVO1();
		vo.setHostid(hostid);
		vo.setAuthor(author);

		hostDao1.hostUpdate(vo);
		int result = hostDao1.hostUpdate(vo);
		System.out.println("수정완료");

		return Integer.toString(result);
	}

	@RequestMapping(value = "/allchart.do")
	public String chartpage(Model model) {
		System.out.println("chart");
		List<String> names = chartDao.selectHostID();
		for (int i = 0; i < names.size(); i++) {
			System.out.print(names.get(i));
		}
		model.addAttribute("names", names);
		model.addAttribute("info", chartDao.selectListChart());

		return "ADMIN/allchart";
	}

	@RequestMapping(value = "/yearchart.do")
	@ResponseBody
	public List<ChartVO> ajaxpage(Model model) {
		List<ChartVO> list = chartDao.selectListChart();
//		for(int i = 0 ; i < list.size(); i++) {
//			System.out.println(list.get(i).toString());
//		}
		return chartDao.selectListChart();
	}

	@RequestMapping("/hostChart.do")
	public String hostchart(ChartVO vo, Model model) {
		List<ChartVO> list = chartDao.selectChart(vo);
		model.addAttribute("selectchart", list);

		return "";
	}

	@RequestMapping("/getHostChartData.do")
	@ResponseBody
	public List<ChartVO> getChartDataById(ChartVO vo) {
		return chartDao.selectChart(vo);
	}

}
