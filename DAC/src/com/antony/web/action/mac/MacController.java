package com.antony.web.action.mac;

//import javax.inject.Inject;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
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
@RequestMapping("/mac/api")
public class MacController extends BaseController {

	@RequestMapping("IF00067")
	public void IF00067(HttpServletRequest request, HttpServletResponse response) {
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");
		//发送邮件
		getServMgr().getMailService().IF00067Mail(mail, pass);
		Map json = new HashMap();
		json.put("status", 300);
		json.put("statusCode", 300);
		json.put("message", "请输入邮箱" + mail);
		sendJson(response, json);
	}

	@RequestMapping("")
	public void index(HttpServletRequest request, HttpServletResponse response) {
		Map json = new HashMap();
		json.put("status", 300);
		json.put("statusCode", 300);
		json.put("message", "请输入邮箱");
		sendJson(response, json);
	}

	@RequestMapping(value = "test/{Id}", method = RequestMethod.POST)
	public void test(@PathVariable("Id") String Id, HttpServletRequest request,
			HttpServletResponse response) {
		Map json = new HashMap();

		System.out.println(Id);
		json.put("status", 300);
		json.put("statusCode", 300);
		json.put("message", "你的Id是" + Id);
		sendJson(response, json);
	}

	@RequestMapping(value = "key", method = RequestMethod.POST)
	public void key(HttpServletRequest request, HttpServletResponse response) {
		Map json = new HashMap();
		System.out.println("dfdfdfs");
		String status = request.getParameter("status");
		System.out.println(status);
		String message = request.getParameter("message");
		System.out.println(message);
		json.put("status", 300);
		json.put("statusCode", 300);
		json.put("message", "你的Id是");
		sendJson(response, json);
	}

	@RequestMapping(value = "root")
	public void root(HttpServletRequest request, HttpServletResponse response) {

		Map json = new HashMap();
		json.put("indexnum", "121286");
		json.put("total", "300");
		List names = new ArrayList();
		List creaters = new ArrayList();

		Map des1 = new HashMap();
		Map des2 = new HashMap();

		Map creater1 = new HashMap();
		Map creater2 = new HashMap();
		des1.put("name", "”告别星空2012”K歌联盟");
		des1.put("type", "1111");
		// create1
		creater1.put("cname", "David");
		creater1.put("cimage_url", "http://www……");
		// create2
		creater2.put("cname", "Jone");
		creater2.put("cimage_url", "http://www……");

		creaters.add(creater1);
		creaters.add(creater2);

		des1.put("addr", "西城区西直门交大东路46号(佰金KTV对面胡同里)");
		des1.put("ptime", "2013年2月15号  12：30");

		names.add(des1);
		names.add(des2);
		json.put("names", names);
		sendJson(response, json);
	}

}