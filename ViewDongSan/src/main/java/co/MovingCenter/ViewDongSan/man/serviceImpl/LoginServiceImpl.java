package co.MovingCenter.ViewDongSan.man.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.MovingCenter.ViewDongSan.man.service.LoginMapper;
import co.MovingCenter.ViewDongSan.man.service.LoginService;
import co.MovingCenter.ViewDongSan.man.service.LoginVO;

@Repository("loginDao")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	LoginMapper map;

	@Override
	public List<LoginVO> allLoginMember() {
		// TODO Auto-generated method stub
		return map.allLoginMember();
	}


}
