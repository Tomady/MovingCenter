package co.MovingCenter.ViewDongSan.ej.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.MovingCenter.ViewDongSan.ej.service.RoomsMapper;
import co.MovingCenter.ViewDongSan.ej.service.RoomsService;
import co.MovingCenter.ViewDongSan.ej.service.RoomsVO;

@Repository("roomsDao")
public class RoomsServiceImpl implements RoomsService {
	
	@Autowired
	public RoomsMapper map;
	
	@Override
	public RoomsVO selectRoomDetails(RoomsVO vo) {
		return map.selectRoomDetails(vo);
	}

}
