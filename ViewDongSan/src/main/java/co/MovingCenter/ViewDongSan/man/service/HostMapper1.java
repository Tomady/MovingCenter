package co.MovingCenter.ViewDongSan.man.service;

import java.util.List;

public interface HostMapper1 {
	public List<HostVO1> selectListHost();

	HostVO1 selectHost(HostVO1 vo);

	int hostDelete(String hostid);
	
	int hostUpdate(HostVO1 vo);
}
