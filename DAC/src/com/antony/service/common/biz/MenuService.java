package com.antony.service.common.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antonyframework.service.common.BaseService;
import org.antonyframework.web.common.menu.MenuManager;
import org.springframework.beans.factory.annotation.Autowired;

import com.antony.service.common.db.MenuMapper;
import com.antony.service.main.db.Cm0001Mapper;
import com.antony.service.main.vo.Cm0001;
import com.antony.service.main.vo.Cm0001Example;

public class MenuService extends BaseService {
	@Autowired
	private Cm0001Mapper cm0001Mapper;
	@Autowired
	private MenuMapper menuManager;
	public List getTopMenu(Integer UID) {
		Cm0001Example example = new Cm0001Example();
		example.createCriteria().andTypeEqualTo("TOP");
		List<Cm0001> topMenuDB = cm0001Mapper.selectByExample(example);
		HashMap param = new HashMap();
		param.put("ID", UID);
		
		List<Map> queryTopMenu = menuManager.queryTopMenu(param);
		return queryTopMenu;
	}

	public List getLeftMenu(String topIndex) {
		Cm0001Example example = new Cm0001Example();
		example.createCriteria().andTypeEqualTo("LEFT")
				.andParentEqualTo(topIndex);
		return cm0001Mapper.selectByExample(example);
	}
}
