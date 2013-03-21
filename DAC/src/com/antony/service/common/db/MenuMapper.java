package com.antony.service.common.db;

import java.util.List;
import java.util.Map;

public interface MenuMapper {
	List<Map> queryTopMenu(Map param);
}