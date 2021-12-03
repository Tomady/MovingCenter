package co.MovingCenter.ViewDongSan.dy.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.MovingCenter.ViewDongSan.dy.service.HostService;

@Controller
public class AhController {
	@Autowired
	HostService hostDao;
	
	@RequestMapping(value = "/join.do")
	public String join(Model model) {
		// dbTest
		model.addAttribute("Hosts", hostDao.selectListHost());
		
		return "dbTest";
	}
	
}
