package co.MovingCenter.ViewDongSan.man.service;

import java.util.List;

public interface GuestMapper {

	public List<GuestVO> selectListGuest();

	GuestVO selectGuest(GuestVO vo);

	int guestDelete(String guestid);


}
