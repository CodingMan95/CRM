package com.test.crm.controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.crm.entity.User;
import com.test.crm.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	/*
	 * 用户登录
	 */
	@RequestMapping("login.do")
	@ResponseBody
	public User login(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String userName = request.getParameter("userName");
		String pass = request.getParameter("password");
		String type = request.getParameter("roleName");

		// String userName = "张三";
		// String pass = "123456";
		User user = userService.selectUserByName(userName);
		String password = user.getPassword();
		String roleName = user.getRoleName();

		if (password.equals(pass) && roleName.equals(type)) {
			response.sendRedirect("main.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}
		request.getSession().setAttribute("currentUser", user);// session
		return user;
	}

	/*
	 * 修改密码
	 */
	@RequestMapping("modifyPassword.do")
	@ResponseBody
	public int modifyPassword(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String name = request.getParameter("userName");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");

		User user = new User();

		user.setNewPassword(newPassword);
		user.setPassword(oldPassword);
		user.setUserName(name);

		int result = userService.modifyPassword(user);
		return result;
	}

	@RequestMapping("logout.do")
	@ResponseBody
	public void logout(HttpSession session, HttpServletResponse response) throws Exception {

		// 通过session.invalidata()方法来注销当前的session
		session.invalidate();
		response.sendRedirect("login.jsp");

	}

	@RequestMapping("comboList.do")
	@ResponseBody
	public List<User> comboList() {
		List<User> user = userService.selectLimit();
		return user;
	}

	@RequestMapping("user/list.do")
	@ResponseBody
	public List<User> findAllUser() {

		List<User> user = userService.findAllUser();

		return user;
	}

	@RequestMapping("user/save.do")
	@ResponseBody
	public int addUser(HttpServletRequest request) {

		User user = new User();

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String trueName = request.getParameter("trueName");
		String roleName = request.getParameter("roleName");

		user.setUserName(userName);
		user.setPassword(password);
		user.setEmail(email);
		user.setPhone(phone);
		user.setRoleName(roleName);
		user.setTrueName(trueName);

		int result = userService.addUser(user);

		return result;
	}

	@RequestMapping("user/update.do")
	@ResponseBody
	public int updateUser(HttpServletRequest request) {

		User user = new User();

		Integer id = Integer.valueOf(request.getParameter("id"));
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String trueName = request.getParameter("trueName");
		String roleName = request.getParameter("roleName");

		user.setId(id);
		user.setUserName(userName);
		user.setPassword(password);
		user.setEmail(email);
		user.setPhone(phone);
		user.setRoleName(roleName);
		user.setTrueName(trueName);

		int result = userService.updateUser(user);

		return result;
	}

	@RequestMapping("user/delete.do")
	@ResponseBody
	public int deleteUser(ServletRequest request) {

		Integer id = Integer.valueOf(request.getParameter("ids"));

		int result = userService.deleteUser(id);

		return result;
	}
}
