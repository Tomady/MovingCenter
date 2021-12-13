package co.MovingCenter.ViewDongSan.aram.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HostController {

	@RequestMapping(value = "/hostMain.do")
	public String test() {
		System.out.println("hostMain");
		
		return "HOST/main";
	}
}
