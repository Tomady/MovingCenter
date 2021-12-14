package co.MovingCenter.ViewDongSan.man.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.MovingCenter.ViewDongSan.man.service.HostMapper1;
import co.MovingCenter.ViewDongSan.man.service.HostService1;
import co.MovingCenter.ViewDongSan.man.service.HostVO1;


@Repository("hostDao1")
public class HostServiceImpl implements HostService1 {
	
@Autowired
HostMapper1 map;

	@Override
	public List<HostVO1> selectListHost() {
		// TODO Auto-generated method stub
		return map.selectListHost();
	}


//	@Override
//	public int hostDelete(HostVO1 vo) {
//		// TODO Auto-generated method stub
//		return map.hostDelete(vo);
//	}


	@Override
	public HostVO1 selectHost(HostVO1 vo) {
		// TODO Auto-generated method stub
		return map.selectHost(vo);
	}


	@Override
	public int hostDelete(String hostid) {
		// TODO Auto-generated method stub
		return map.hostDelete(hostid);
	}


	@Override
	public int hostUpdate(HostVO1 vo) {
		// TODO Auto-generated method stub
		return map.hostUpdate(vo);
	}
	
	

}
