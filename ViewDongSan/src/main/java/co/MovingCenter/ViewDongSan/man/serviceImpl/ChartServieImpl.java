package co.MovingCenter.ViewDongSan.man.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.MovingCenter.ViewDongSan.man.service.ChartMapper;
import co.MovingCenter.ViewDongSan.man.service.ChartService;
import co.MovingCenter.ViewDongSan.man.service.ChartVO;
@Repository("chartDao")
public class ChartServieImpl implements ChartService {
@Autowired
ChartMapper map;
	@Override
	public List<ChartVO> selectListChart() {
		// TODO Auto-generated method stub
		return map.selectListChart();
	}
	@Override
	public List<ChartVO> selectChart(ChartVO vo) {
		return map.selectChart(vo);
	}
	@Override
	public List<String> selectHostID() {
		return map.selectHostID();
	}
	@Override
	public List<ChartVO> selectListChartByID(ChartVO vo) {
		return map.selectListChartByID(vo);
	}

}
