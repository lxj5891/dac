package org.antonyframework.service.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.antonyframework.core.Constants;
import org.antonyframework.web.common.AppResult;
import org.antonyframework.web.common.PagingList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Service 基类 设置log及基本的数据库访问<BR>
 * 基于Spring
 * 
 * @author Nanlei
 */
public class CommonBaseService {

	public int update(HttpServletRequest request) throws RuntimeException {
		return -1;
	}

	public int add(HttpServletRequest request) throws RuntimeException {
		return -1;
	}

	public List list(HttpServletRequest request) throws RuntimeException {
		return null;
	}
	public List list() throws RuntimeException {
		return null;
	}

	public Object getObjectById(String id, Class clazz) throws RuntimeException {
		return null;
	}
	public int delete(HttpServletRequest request) throws RuntimeException {
		return -1;
	}
	public int delete(String id) throws RuntimeException {
		return -1;
	}
	public int delete(Integer id) throws RuntimeException {
		// TODO Auto-generated method stub
		return 0;
	}

	public Boolean CheckImageType(String contentType) {
		if (!contentType.equals("image/jpg")
				&& !contentType.equals("image/png")
				&& !contentType.equals("image/jpeg")
				&& !contentType.equals("image/gif")
				&& !contentType.equals("image/jpeg")) {
			return false;
		}
		return true;
	}

	protected final Log log = LogFactory.getLog(getClass());

	protected AppResult rs = new AppResult();
	/* JdbcTemplate */
	protected JdbcTemplate jt;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jt = jdbcTemplate;
	}

	public JdbcTemplate getJdbc() {
		return this.jt;
	}

	/* NamedParameterJdbcTemplate */
	protected NamedParameterJdbcTemplate npjt;

	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.npjt = namedParameterJdbcTemplate;
	}

	public PagingList getPagingList(String srcSql, HttpServletRequest request) {
		int pageNum = 1;
		int pageSize = 10;

		if (request.getParameter("pageNum") != null) {
			System.out.println("@");
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}

		if (request.getAttribute("pageSize") != null) {
			pageSize = Integer.parseInt(String.valueOf(request
					.getAttribute("pageSize")));
		} else {
			if (request.getParameter("pageSize") != null) {
				pageSize = Integer.parseInt(request.getParameter("pageSize"));
			} else {
				pageSize = 10;
			}
		}
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageSize", pageSize);
		return new PagingList(srcSql, pageNum, pageSize, jt);
	}

	public PagingList getPagingList(String srcSql, HttpServletRequest request,
			Object... parameterObject) {
		int pageNum = 1;
		int pageSize = 10;
		if (request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		if (request.getAttribute("pageSize") != null) {
			pageSize = Integer.parseInt(String.valueOf(request
					.getAttribute("pageSize")));
		} else {
			if (request.getParameter("pageSize") != null) {
				pageSize = Integer.parseInt(request.getParameter("pageSize"));
			} else {
				pageSize = 10;
			}
		}
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageSize", pageSize);
		return new PagingList(srcSql, pageNum, pageSize, jt, parameterObject);
	}

	public static String getCountSql(String srcSql) {
		return "SELECT COUNT(*) FROM ( " + srcSql + " ) CTBL_";
	}

	public Integer getMax(String columnName, String tableName) {
		try {
			return jt.queryForInt("SELECT MAX(" + columnName + ") FROM "
					+ tableName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	public String getCookieKey(HttpServletRequest req, String key) {
		Cookie[] cookies = req.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName() == key || cookies[i].getName().equals(key)) {
				return cookies[i].getValue();
			}
		}
		return "";
	}

	protected static final String SELECT_ROUND_NAME = "select ROUNDNAME from c_round where ROUNDID=?";
	protected static final String SELECT_USER_NAME = "select USERTRUENAME from c_user where UID=?";

	private static final String INSERT_SYS_MSG = "insert into c_system_msg(TYPE,UID,TOUID,DATELINE,IGNORED,READED,EVENTID,EVENT) values(?,?,?,?,?,?,?,?)";

	public int insertSysMsg(int type, String UID, String TOUID, String eventId,
			String key) {
		System.out.println("推送类型" + type);
		System.out.println("发起方:" + UID);
		System.out.println("接收方：" + TOUID);
		System.out.println("事件ID：" + eventId);
		System.out.println("事件：" + key);
		return jt.update(INSERT_SYS_MSG, type, UID, TOUID, new Date(), false,
				false, eventId, key);
	}

	private static final String IGNORE_SYS_MSG = "update c_system_msg set IGNORED=? where SYSID=?";

	public int ignored(String sysId) {
		return jt.update(IGNORE_SYS_MSG, true, sysId);
	}

	public static <T> T convert(HttpServletRequest request, Class<T> c)
			throws Exception {
		// TODO Auto-generated method stub
		Class r = Class.forName(c.getName());
		Object obj = r.newInstance();
		Field[] fields = c.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			try {
				String MethodStr = "set"
						+ fields[i].getName().replaceFirst(
								fields[i].getName().substring(0, 1),
								fields[i].getName().substring(0, 1)
										.toUpperCase());
				String fileStr = fields[i].getType().toString().split(" ")[1];
				String parameter = request.getParameter(fields[i].getName());
				Method method = c.getMethod(MethodStr, Class.forName(fileStr));
				if (fields[i].getName().equalsIgnoreCase("userId")) {
					Object userId = request.getSession().getAttribute(
							Constants.LOGIN_USER_ID);
					System.out.println("方法" + method.getName() + ":" + userId);
					method.invoke(obj, (Integer) userId);
				} else if (fields[i].getName().equalsIgnoreCase("updatetime")) {
					System.out.println("方法" + method.getName() + ":"
							+ new Date());
					method.invoke(obj, new Date());
				} else if (fields[i].getName().equalsIgnoreCase("isDel")) {
					System.out.println("方法" + method.getName() + ":" + 0);
					method.invoke(obj, 0);
				} else if (fileStr.equalsIgnoreCase("java.lang.Integer")) {
					System.out.println("方法" + method.getName() + ":"
							+ parameter);
					method.invoke(obj, Integer.valueOf(parameter));
				} else if (fileStr.equalsIgnoreCase("java.lang.String")) {
					System.out.println("方法" + method.getName() + ":"
							+ parameter);
					method.invoke(obj, parameter);
				} else if (fileStr.equalsIgnoreCase("java.util.Date")) {
					System.out.println("方法" + method.getName() + ":"
							+ parameter);
					DateFormat format = new SimpleDateFormat(
							Constants.DATEFORMAT);
					method.invoke(obj, format.parse(parameter));
				}
			} catch (Exception e) {
				System.out.println(fields[i].getType() + "   "
						+ fields[i].getName());
			}
		}
		return (T) obj;
	}

	

}