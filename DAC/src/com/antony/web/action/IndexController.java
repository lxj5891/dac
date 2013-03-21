package com.antony.web.action;

//import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.antony.dao.Cu0001Mapper;

@Controller
public class IndexController extends BaseController {

	// @Inject
	// private User user;
	@Autowired
	private Cu0001Mapper cu0001Mapper;

	@RequestMapping("")
	public String index() {
		cu0001Mapper.selectByPrimaryKey(1);
		return "redirect:login";
	}

	@RequestMapping("login")
	public String login() {
		return "/admin/common/common_login";
	}

	@RequestMapping("chapter/{chapterId}")
	public String chapter(@PathVariable("chapterId") int chapterId, Model model) {
		System.out.println("dd");
		return "/chapter";
	}
}