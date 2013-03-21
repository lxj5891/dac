package org.antonyframework.web;

/**
 * 后台消息信息配置
 * 
 * @author Tony Shen
 * 
 */
public interface Message {
	
	public static final String URL_USER = "user.do";
	public static final String URL_LOAN_UNDISPOSED = "loan.do?command=undisposed";
	public static final String URL_GOBACK = "@back";
	
	public static final String URL_ROOT = "/admin/root.do";
	
	public static final String GOBACK = "返回";

	public static final String FILE_NOT_IMAGE = "请上传图片格式的文件";
	public static final String FILE_ZERO_SIZE = "请不要上传零长度文件";
	public static final String FILE_NO_EXTENSION = "请确定文件的扩展名";


	public static final String LOGIN_NOT_EXISTS = "该用户不存在";
	public static final String LOGIN_WRONG_PASS = "密码错误";
	public static final String LOGIN_NO_RIGHT = "没有登录权限";
	public static final String LOGIN_TIME_OUT = "为了保证您的安全，在长时间内未使用系统，将被自动注销，请重新登录";
	public static final String LOGIN_CODE_ERR = "验证码错误";
	
	 

	public static final String LOGOUT = "您已经安全退出系统";
	
	public static final String USER_ADD_SUCCESS = "用户添加成功";
	public static final String USER_ADD_FAILURE = "用户添加失败";
	public static final String USER_EXISTS = "用户名已经存在，请重新选择";
	public static final String USER_UPDATE_SUCCESS = "用户修改成功";
	public static final String USER_UPDATE_FAILURE = "用户修改失败";
	
	public static final String NEWS_CATEGORY_UPDATE_SUCCESS = "新闻分类更新成功";
	public static final String NEWS_CATEGORY_UPDATE_FAILURE = "新闻分类更新失败";
	public static final String NEWS_CATEGORY_DELETE_SUCCESS = "新闻分类删除成功";
	public static final String NEWS_CATEGORY_DELETE_FAILURE = "新闻分类删除失败";
	public static final String NEWS_CATEGORY_ADD_SUCCESS = "新闻分类添加成功";
	public static final String NEWS_CATEGORY_ADD_FAILURE = "新闻分类添加失败";

	public static final String NEWS_UPDATE_SUCCESS = "新闻信息更新成功";
	public static final String NEWS_UPDATE_FAILURE = "新闻信息更新失败";
	public static final String NEWS_DELETE_SUCCESS = "新闻信息删除成功";
	public static final String NEWS_DELETE_FAILURE = "新闻求信息删除失败";

	public static final String LOAN_APPLY_APPROVE_SUCCESS = "贷款申请批准成功";
	public static final String LOAN_APPLY_APPROVE_FAILURE = "贷款申请批准失败";
	
	public static final String LOAN_APPLY_REJECT_SUCCESS = "贷款申请拒绝成功";
	public static final String LOAN_APPLY_REJECT_FAILURE = "贷款申请拒绝失败";
	
	public static final String LOAN_APPLY_DETELE_SUCCESS = "贷款申请移除成功";
	public static final String LOAN_APPLY_DETELE_FAILURE = "贷款申请移除失败";
	
	
	
	/**
	 * 前台消息信息配置
	 * 
	 * @author Tony Shen
	 * 
	 */
}
