package com.antony.service.sm.biz;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.antonyframework.core.Constants;
import org.antonyframework.service.common.BaseService;
import org.antonyframework.web.common.PagingList;
import org.springframework.beans.factory.annotation.Autowired;

import com.antony.dao.Sm3001Mapper;
import com.antony.dao.Sm3002Mapper;
import com.antony.service.sm.db.SM3001DBMapper;
import com.antony.service.sm.inf.SM3001Link;
import com.antony.vo.Cu0001;
import com.antony.vo.Sm3001;
import com.antony.vo.Sm3001Example;
import com.antony.vo.Sm3002;

public class SM3001Service extends BaseService {

	@Autowired
	private Sm3001Mapper sm3001Mapper;
	@Autowired
	private Sm3002Mapper sm3002Mapper;
	
	@Autowired
	private SM3001DBMapper sm3001dbMapper;
	private static Integer nextKey;

	public void init() {
		nextKey = sm3001Mapper.getNextId();
	}

	@Override
	public List list() throws RuntimeException {
		Sm3001Example example = new Sm3001Example();
		example.createCriteria();
		List<Sm3001> sm3001List = sm3001Mapper.selectByExample(example);
		return sm3001List;
	}

	public int add(HttpServletRequest request, String idStr)
			throws RuntimeException {
		// TODO Auto-generated method stub
		try {
			String UID = request.getParameter("UID");
			SM3001Link link = new SM3001Link(getConnection());
			int nextId = 0;
			try {
				nextId = Integer.valueOf(idStr);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				nextId = sm3001Mapper.getNextId();
			}

			Sm3001 bean = convert(request, Sm3001.class);
			bean.setId(nextId);
			Sm3002 sm3002Bean = new Sm3002();
			sm3002Bean.setId(nextId);

			sm3002Bean.setLogin("0");

			String uidFromCOMBO = link.getUidFromCOMBO(bean.getEmail());
			if (uidFromCOMBO != null && !uidFromCOMBO.equals("00000"))
				sm3002Bean.setUid(uidFromCOMBO);
			else
				return -1;

			
			sm3002Mapper.insert(sm3002Bean);
			return sm3001Mapper.insertSelective(bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	private static final String ALL_SM3001_PAGE = "select sm3001.*,cu0001.realname ,sm3002.login,sm3002.updatetime as logindate from sm3001 left join sm3002 on sm3001.id =sm3002.id left join cu0001 on cu0001.id = sm3001.userid ";

	public PagingList queryForPagingList(HttpServletRequest request) {
		request.setAttribute("pageSize", 20);
		return getPagingList(ALL_SM3001_PAGE, request);
	}

	@Override
	public int delete(String id) throws RuntimeException {
		// TODO Auto-generated method stub
		int d3002 = sm3002Mapper.deleteByPrimaryKey(Integer.valueOf(id));
		if(d3002 == 0)
			return -1;
	
		int d3001 = sm3001Mapper.deleteByPrimaryKey(Integer.valueOf(id));
		if(d3001 == 0)
			return -2;
		return 1; 
	}

	private static final String ALL_MY_SM3001_PAGE = "select sm3001.*,cu0001.realname ,sm3002.login from sm3001 left join sm3002 on sm3001.id =sm3002.id left join cu0001 on cu0001.id = sm3001.userid where sm3001.userid = ? ";

	public PagingList queryForMySm3001PagingList(HttpServletRequest request,
			Cu0001 user) {
		request.setAttribute("pageSize", 20);
		return getPagingList(ALL_MY_SM3001_PAGE, request, user.getId());
	}

	public Map getComboUserInfo(String email) {
		// TODO Auto-generated method stub

		try {
			SM3001Link link = new SM3001Link(getConnection());
			Map user = link.getUserInfoFromCOMBO(email);
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public String getNextKey() {
		// TODO Auto-generated method stub
		nextKey = nextKey + 1;
		int nextId = nextKey;
		return String.valueOf(nextId);
	}

	public int getSM3001ByEmail(String email) {
		Sm3001Example example = new Sm3001Example();
		example.createCriteria().andEmailEqualTo(email);
		int db = sm3001Mapper.countByExample(example);
		return db;
	}

	public int setAppend(String id) {
		int count = 0;
		String[] split = id.split(",");
		for (int i = 0;i<split.length;i++) {
			Sm3001 bean = new Sm3001();
			bean.setId(Integer.valueOf(split[i]));
			bean.setTypeid("1");
			count += sm3001Mapper.updateByPrimaryKeySelective(bean);
		}
		return count;
	}

	public List getSendMailList(HttpServletRequest request) {
		Map param = new HashMap();
		
		List<Map> db = sm3001dbMapper.getSendmailList(param);
		return db;
	}

	public int getAdminTotCount() {
		// TODO Auto-generated method stub
		int db= sm3001dbMapper.queryTotCount(null);
		return db;
	}

	public int getAdminAppCount() {
		// TODO Auto-generated method stub
		int db= sm3001dbMapper.queryAdminWaitAppCount();
		return db;
	}

	public int getTotCount(Map param) {
		// TODO Auto-generated method stub
		int db= sm3001dbMapper.queryTotCount(param);
		return db;
	}

	public int getAppCount(Map param) {
		// TODO Auto-generated method stub
		int db= sm3001dbMapper.queryWaitAppCount(param);
		return db;
	}

}
