package co.MovingCenter.ViewDongSan.man.service;

import java.util.List;

public interface GuestService {
	public List<GuestVO> selectListGuest();

	int guestDelete(String guestid);

	GuestVO selectGuest(GuestVO vo);
	
	

}
