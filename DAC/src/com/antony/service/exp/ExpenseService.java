package com.antony.service.exp;

import javax.servlet.http.HttpServletRequest;

import org.antonyframework.service.common.BaseService;
import org.antonyframework.web.common.AppResult;
import org.springframework.beans.factory.annotation.Autowired;

public class ExpenseService extends BaseService {

	@Autowired
	private ExpenseMapper mapper;

	public AppResult createStep1(HttpServletRequest request) {
		AppResult result = new AppResult();
		return result;
	}
}
