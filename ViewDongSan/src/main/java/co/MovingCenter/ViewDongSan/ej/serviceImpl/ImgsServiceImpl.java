package co.MovingCenter.ViewDongSan.ej.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.MovingCenter.ViewDongSan.ej.service.ImgsMapper;
import co.MovingCenter.ViewDongSan.ej.service.ImgsService;
import co.MovingCenter.ViewDongSan.ej.service.ImgsVO;

@Repository("imgsDao")
public class ImgsServiceImpl implements ImgsService {
	
	@Autowired
	public ImgsMapper map;
	
	@Override
	public ImgsVO selectRoomImgs(ImgsVO vo) {
		return map.selectRoomImgs(vo);
	}

}
