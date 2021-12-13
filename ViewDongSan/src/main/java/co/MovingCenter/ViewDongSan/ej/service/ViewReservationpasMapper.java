package co.MovingCenter.ViewDongSan.ej.service;

import java.util.List;

public interface ViewReservationpasMapper {
	List<ViewReservationpasVO> selectRoomList(ViewReservationpasVO vo);
	List<ViewReservationpasVO> selectRoomAreaList(ViewReservationpasVO vo);
}

