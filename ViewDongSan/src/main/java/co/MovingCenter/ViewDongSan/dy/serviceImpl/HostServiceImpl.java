package co.MovingCenter.ViewDongSan.dy.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.MovingCenter.ViewDongSan.dy.service.HostMapper;
import co.MovingCenter.ViewDongSan.dy.service.HostService;
import co.MovingCenter.ViewDongSan.dy.service.HostVO;

@Repository("hostDao")
public class HostServiceImpl implements HostService {
	@Autowired
	HostMapper map;
	
	@Override
	public List<HostVO> selectListHost() {
		System.out.println("impl selectListHost()");
		return map.selectListHost();
	}
}
