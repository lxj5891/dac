package com.antony.web.action.user;

//import javax.inject.Inject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.antony.dao.Cu0001Mapper;
import com.antony.web.action.BaseController;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	// @Inject
	// private User user;
	@Autowired
	private Cu0001Mapper cu0001Mapper;

	@RequestMapping("")
	public String index() {
		cu0001Mapper.selectByPrimaryKey(1);
		return "/admin/user/list";
	}

	@RequestMapping(value = "/{Id}", method = RequestMethod.GET)
	public String object(@PathVariable("Id") int Id) {
		System.out.println(Id);
		cu0001Mapper.selectByPrimaryKey(1);
		return "/admin/user/show";
	}

	@RequestMapping("list")
	public String list() {
		cu0001Mapper.selectByPrimaryKey(1);
		return "/admin/user/list";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addView(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		System.out.println(id);
		cu0001Mapper.selectByPrimaryKey(1);
		return "/admin/user/addView";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			cu0001Mapper.selectByPrimaryKey(1);
			return ajaxDoneSuccess("添加成功");
		} catch (Exception e) {
			return ajaxDoneError("添加失败");
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

}