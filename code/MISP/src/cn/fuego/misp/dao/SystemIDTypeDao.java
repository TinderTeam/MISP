package cn.fuego.misp.dao;

import cn.fuego.misp.domain.po.SystemIDType;

public interface SystemIDTypeDao {
	public void create(SystemIDType id);

	public void saveOrUpdate(SystemIDType id);

	public void delete(SystemIDType id);
	
	public SystemIDType getIDTypeByName(String name);
	
	
	
}
