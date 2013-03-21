package org.antonyframework.core;


/**
 * 系统常量配置
 * 
 * @author Nanlei
 * 
 */
public interface Constants {
	public final static String ENCODING = "UTF-8";
	public final static String DATEFORMAT = "yyyy-MM-dd hh:mm";

	/* 通用操作结果页面返回值 */
	public static final String EXECUTE_RESULT = "executeResult";
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";

	public static final String COMMAND = "command";

	public static final String LOGIN_USER = "loginUser";
	public static final String LOGIN_USER_ID = "userId";
	public static final String USER_ROLE_ID = "roleId";
	
	
	public static final String DEFAULT = "default";

	/************************* 全局跳转开始 *****************************/
	public static final String SYSTEM_ERROR = "systemerror";
	/************************* 全局跳转结束 *****************************/

	/************************* 信息常量开始 *****************************/
	public static final String UNDEFINE_ERROR = "ERRS000";

	public static final String ERROR_PREFIX = "ERR";

	public static final String PROCEDURES_MESSAGE_PREFIX = "MSG";
	/************************* 信息常量结束 *****************************/

	/* 默认分页尺寸及分页标记 */
	public static final int DEFAULT_PAGE_SIZE = 10;
	public static final int MAX_PAGE_SIZE = 1000;
	public static final String NORMAL_MARK = "?";
	public static final String START_MARK = ":_START_INDEX_";
	public static final String END_MARK = ":_END_INDEX_";

	public static final String DEFAULT_SESSIONID_FALG = "sid";

	/**
	 * 操作状态标识 status
	 */
	public static final String STATUS_FLAG = "status";

	/**
	 * 成功状态标识
	 */
	public static final String STATUS_SUCCESS = "success";

	/**
	 * 失败状态标识
	 */
	public static final String STATUS_FAILURE = "failure";
	
	/*
	 * 杨昌钊增加,页面大小
	 */
	public static final int PAGESIZE = 12;
	/**
	 * 隐私保护标识
	 */
	public static final String LIMIT_CANNOT="该用户已设置隐私保护";
	/**
	 * 地图上某点无用户
	 */
	public static final String NO_USER ="该区域还没有用户";
}
