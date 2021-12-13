package co.MovingCenter.ViewDongSan.ej.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.MovingCenter.ViewDongSan.ej.service.ViewReservationpasMapper;
import co.MovingCenter.ViewDongSan.ej.service.ViewReservationpasService;
import co.MovingCenter.ViewDongSan.ej.service.ViewReservationpasVO;

@Repository("reservationDao")
public class ViewReservationpasServiceImpl implements ViewReservationpasService {
	
	@Autowired
	ViewReservationpasMapper map;
	
	@Override
	public List<ViewReservationpasVO> selectRoomList(ViewReservationpasVO vo) { //여행지미입력
		return map.selectRoomList(vo);
	}
	

}
