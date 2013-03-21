package com.antony.web.action.sm;

//import javax.inject.Inject;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.antonyframework.core.Constants;
import org.antonyframework.util.StringEncryptUtil;
import org.antonyframework.util.TimeUtil;
import org.antonyframework.web.common.PagingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.antony.dao.Cu0001Mapper;
import com.antony.vo.Cu0001;
import com.antony.web.action.BaseController;

@Controller
@RequestMapping("/admin/sm/sm3001")
public class SM3001Controller extends BaseController {

	// @Inject
	// private User user;
	@Autowired
	private Cu0001Mapper cu0001Mapper;

	@RequestMapping("")
	public String index(HttpServletRequest request, Model model) {
		PagingList list = getServMgr().getSm3001Service().queryForPagingList(
				request);
		int totCount = getServMgr().getSm3001Service().getAdminTotCount();
		int appCount = getServMgr().getSm3001Service().getAdminAppCount();
		model.addAttribute("list", list);
		model.addAttribute("totCount", totCount);
		model.addAttribute("appCount", appCount);
		model.addAttribute("today", TimeUtil.DateFormat(new Date()));
		return "/admin/sm/sm3001/sm3001_admin_list";
	}

	@RequestMapping(value = "/{Id}", method = RequestMethod.GET)
	public String object(@PathVariable("Id") int Id) {
		return "/admin/user/show";
	}

	@RequestMapping("mail")
	public String mail(HttpServletRequest request, Model model) {
		List list = getServMgr().getSm3001Service().getSendMailList(request);
		model.addAttribute("list", list);
		return "/admin/sm/sm3001/sm3001_mail";
	}

	@RequestMapping("list")
	public String list(HttpServletRequest request, Model model) {
		Cu0001 user = getUserMgr().getUser();
		PagingList list = getServMgr().getSm3001Service()
				.queryForMySm3001PagingList(request, user);
		String dateFormat = TimeUtil.DateFormat(new Date());
		Map param = new HashMap();
		param.put("ID", user.getId());
		int totCount = getServMgr().getSm3001Service().getTotCount(param);
		int appCount = getServMgr().getSm3001Service().getAppCount(param);
		model.addAttribute("totCount", totCount);
		model.addAttribute("appCount", appCount);
		model.addAttribute("list", list);
		model.addAttribute("today", dateFormat);
		return "/admin/sm/sm3001/sm3001_list";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addView(HttpServletRequest request,
			HttpServletResponse response) {
		Cu0001 user = getUserMgr().getUser();
		try {
			String emailflag = StringEncryptUtil.encrypt("201");
			request.setAttribute("emailflag", emailflag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute(Constants.LOGIN_USER, user);
		request.setAttribute("seq", "邮箱验证成功后自动生成");
		return "/admin/sm/sm3001/sm3001_add_view";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response) {
		String emailflag = request.getParameter("emailflag");
		String idStr = request.getParameter("id");
		try {
			String value = StringEncryptUtil.decrypt(emailflag);
			idStr = StringEncryptUtil.decrypt(idStr);
			if (!value.equals("200")) {
				return ajaxDoneError("请验证邮箱");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			int add = getServMgr().getSm3001Service().add(request, idStr);
			if (add > 0)
				return ajaxDoneSuccess("添加成功");
			else if (add == -1) {
				return ajaxDoneError("用户不存在，请<a href='/combo/register.do' target='_blank' style='color:#0F0'>注册</a>此用户");
			} else {
				return ajaxDoneError("添加失败,请与管理员联系");
			}

		} catch (Exception e) {
			return ajaxDoneError("添加失败,请与管理员联系");
		}

	}

	@RequestMapping(value = "edit/{Id}", method = RequestMethod.GET)
	public String editView(@PathVariable("Id") int Id,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println(Id);
		String id = request.getParameter("id");
		System.out.println(id);
		return "/admin/user/editView";
	}

	@RequestMapping(value = "edit/{Id}", method = RequestMethod.POST)
	public ModelAndView edit(@PathVariable("Id") int Id,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			String id = request.getParameter("request id" + Id);
			System.out.println(id);
			cu0001Mapper.selectByPrimaryKey(1);
			return ajaxDoneSuccess("修改成功");
		} catch (Exception e) {
			return ajaxDoneError("修改失败");
		}
	}

	@RequestMapping(value = "delete/{Id}", method = RequestMethod.POST)
	public ModelAndView del(@PathVariable("Id") String Id,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			int delete = getServMgr().getSm3001Service().delete(Id);
			if (delete == -1 || delete == -2)
				return ajaxDoneError("删除失败");
			if (delete > 0)
				return ajaxDoneSuccess("删除成功");
			else
				return ajaxDoneError("删除失败");
		} catch (Exception e) {
			return ajaxDoneError("删除失败");
		}
	}

	@RequestMapping(value = "append", method = RequestMethod.POST)
	public ModelAndView append(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String Id = request.getParameter("Id");
			int count = getServMgr().getSm3001Service().setAppend(Id);
			if (count > 0)
				return ajaxDoneSuccess("审核成功");
			else
				return ajaxDoneError("审核失败");
		} catch (Exception e) {
			return ajaxDoneError("审核失败，请与管理员联系");
		}
	}

	@RequestMapping(value = "checkemail", method = RequestMethod.POST)
	public void checkemail(HttpServletRequest request,
			HttpServletResponse response) {
		String email = request.getParameter("email");
		System.out.println("$#$#$#$$#$#$\n\n" + email);
		// 验证是否存在 于 sm3001
		int has = getServMgr().getSm3001Service().getSM3001ByEmail(email);
		if (email == null || email.isEmpty()) {
			Map json = new HashMap();
			String emailflag;
			try {
				emailflag = StringEncryptUtil.encrypt("300");
				json.put("emailflag", emailflag);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				json.put("emailflag", "300");
			}
			json.put("status", 300);
			json.put("statusCode", 300);
			json.put("message", "请输入邮箱");
			sendJson(response, json);
			return;
		}
		if (has > 0) {
			Map json = new HashMap();
			String emailflag;
			try {
				emailflag = StringEncryptUtil.encrypt("300");
				json.put("emailflag", emailflag);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				json.put("emailflag", "300");
			}
			json.put("status", 300);
			json.put("statusCode", 300);
			json.put("message", "邀请人已经存在于数据库中，不要重复录入");
			sendJson(response, json);
			return;
		}

		Map user = getServMgr().getSm3001Service().getComboUserInfo(email);
		String seq = "SM3001";
		String date = TimeUtil.dateToDatetimeDay(new Date());
		String netkey = getServMgr().getSm3001Service().getNextKey();
		String id = StringEncryptUtil.eencrypt(netkey);
		NumberFormat df = new DecimalFormat("###0");
		String format = df.format(Integer.valueOf(netkey));
		seq = seq + date + format;

		if (user != null) {
			Integer check = (Integer) user.get("status");
			if (check == 300) {
				user.put("status", 300);
				user.put("statusCode", 300);
				user.put("message", "请验证用户信息的完整性， （ps。 选择学校）");
				sendJson(response, user);
				return;
			}
			
			if (check == 301) {
				user.put("status", 300);
				user.put("statusCode", 300);
				user.put(
						"message",
						"用户不存在，请<a href='/combo/register.do' target='_blank' style='color:#0F0'>注册</a>此用户");
				sendJson(response, user);
				return;
			}
			
			String emailflag;
			try {
				emailflag = StringEncryptUtil.encrypt("200");
				user.put("emailflag", emailflag);
				user.put("eid", id);
				user.put("seq", seq);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				user.put("emailflag", "200");
			}

			user.put("status", 200);
			user.put("statusCode", 200);
			user.put("message", "信息读取成功");
			System.out.println(user);
			sendJson(response, user);
		} else {
			user = new HashMap();
			String emailflag;
			try {
				emailflag = StringEncryptUtil.encrypt("300");
				user.put("emailflag", emailflag);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				user.put("emailflag", "300");
			}
			user.put("status", 300);
			user.put("statusCode", 300);
			user.put(
					"message",
					"用户不存在，请<a href='/combo/register.do' target='_blank' style='color:#0F0'>注册</a>此用户");
			sendJson(response, user);
		}

	}

	@RequestMapping(value = "sendMail/{Id}", method = RequestMethod.POST)
	public ModelAndView sendMail(@PathVariable("Id") String Id,
			HttpServletRequest request, HttpServletResponse response) {
		int inventMail = 0;
		System.out.println(Id);
		String[] sid = Id.split(",");
		inventMail = getServMgr().getMailService().inventMail(sid);
		if (inventMail > 0) {
			return ajaxDoneSuccess("邮件发送成功","sm/sm3001/mail");
		} else {
			return ajaxDoneError("请验证邮箱");
		}

	}

}