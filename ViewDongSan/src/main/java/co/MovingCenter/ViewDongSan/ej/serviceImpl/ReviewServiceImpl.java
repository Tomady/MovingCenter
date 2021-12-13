package co.MovingCenter.ViewDongSan.ej.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.MovingCenter.ViewDongSan.ej.service.ReviewMapper;
import co.MovingCenter.ViewDongSan.ej.service.ReviewService;
import co.MovingCenter.ViewDongSan.ej.service.ReviewVO;

@Repository("reviewDao")
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	public ReviewMapper map;
	
	@Override
	public List<ReviewVO> selectRoomReview(ReviewVO vo) {
		return map.selectRoomReview(vo);
	}

}
