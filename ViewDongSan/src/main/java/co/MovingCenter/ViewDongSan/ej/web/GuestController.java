package co.MovingCenter.ViewDongSan.ej.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GuestController {

	@RequestMapping(value = "/guestMain.do")
	public String test() {
		return "GUEST/main";
	}
}
