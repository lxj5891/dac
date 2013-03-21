package com.antony.service.common.biz;

import java.sql.SQLException;
import java.util.List;

import org.antonyframework.service.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import com.antony.dao.Cu0001Mapper;
import com.antony.vo.Cu0001;
import com.antony.vo.Cu0001Example;

public class UserService extends BaseService {
	@Autowired
	private Cu0001Mapper cu0001Mapper;
	public Cu0001 getSuperUserInfo() {
		Cu0001Example example =new Cu0001Example();
		example.createCriteria().andRoleIdEqualTo(1);
		example.setOrderByClause(" id desc limit 0, 1  ");
		List<Cu0001> userList = cu0001Mapper.selectByExample(example);
		Cu0001 cu0001 = userList.get(0);
		return cu0001;
	}
	public Cu0001 getLoginUserBean(String userName) throws Exception {
		// TODO Auto-generated method stub
		try {
			Cu0001Example example = new Cu0001Example();
			example.createCriteria().andUsernameEqualTo(userName);
			example.setOrderByClause(" id desc limit 0, 1  ");
			List<Cu0001> UserDB = cu0001Mapper.selectByExample(example );
			return UserDB.get(0);
		} catch (Exception e) {
			// TODO: handle exception
			throw new SQLException();
		}
	}

}
