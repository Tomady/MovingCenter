package co.MovingCenter.ViewDongSan.man.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.MovingCenter.ViewDongSan.man.service.GuestMapper;
import co.MovingCenter.ViewDongSan.man.service.GuestService;
import co.MovingCenter.ViewDongSan.man.service.GuestVO;

@Repository("guestDao")
public class GuestServiceImpl implements GuestService {
	@Autowired
	GuestMapper map;

	@Override
	public List<GuestVO> selectListGuest() {
		// TODO Auto-generated method stub
		return map.selectListGuest();
	}

	@Override
	public GuestVO selectGuest(GuestVO vo) {
		// TODO Auto-generated method stub
		return map.selectGuest(vo);
	}

	@Override
	public int guestDelete(String guestid) {
		// TODO Auto-generated method stub
		return map.guestDelete(guestid);
	}

}
