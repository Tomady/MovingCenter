package co.MovingCenter.ViewDongSan.man.service;

import java.util.List;

public interface ChartMapper {
	List<ChartVO> selectListChart();
	List<ChartVO> selectChart(ChartVO vo);
	List<String> selectHostID();
	List<ChartVO> selectListChartByID(ChartVO vo);

}
