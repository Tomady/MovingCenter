package co.MovingCenter.ViewDongSan.man.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.MovingCenter.ViewDongSan.man.service.AdminMapper;
import co.MovingCenter.ViewDongSan.man.service.AdminService;
import co.MovingCenter.ViewDongSan.man.service.AdminVO;

@Repository("adminDao")
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminMapper map;

	@Override
	public AdminVO selectAdmin(AdminVO vo) {
		// TODO Auto-generated method stub
		return map.selectAdmin(vo);
	}

}
