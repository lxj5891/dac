package com.antony.service.sm.db;

import java.util.List;
import java.util.Map;

public interface SM3001DBMapper {
	List<Map> getSendmailList(Map param);

	Integer queryTotCount(Map param);

	Integer queryAdminWaitAppCount();

	int queryWaitAppCount(Map param);
}
