package co.MovingCenter.ViewDongSan.man.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping(value = "/adminMain.do")
	public String test() {
		return "ADMIN/main";
	}
}
