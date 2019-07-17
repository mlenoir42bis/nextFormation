package com.apps.dao;

import java.util.List;

import com.apps.entity.Menu;

public interface IDAOMenu {
	
	void save(Menu menu);
	Menu find(Long menuID);
	Menu find(String referenceMenu);
	void update(Menu menu);
	void remove(Menu menu);
	
	List<Menu> getAllMenu();
	List<Menu> getAllMenuLazy();
}
