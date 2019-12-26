package pers.sakurasora.onlinestore.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import pers.sakurasora.onlinestore.constant.Constant;
import pers.sakurasora.onlinestore.entity.User;
import pers.sakurasora.onlinestore.service.UserService;
import pers.sakurasora.onlinestore.service.impl.UserServiceImpl;
import pers.sakurasora.onlinestore.utils.UUIDUtil;
import pers.sakurasora.onlinestore.web.servlet.base.BaseServlet;

/**
 * @author SakuraSora
 * 
 * @Description
 *				Servlet--用户模块
 */
@WebServlet("/user")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService = new UserServiceImpl();

	/**
	 * 请求跳转到注册页面
	 * @param 	request
	 * @param 	response
	 * @return 	注册页面相对路径字符串
	 * @throws 	ServletException
	 * @throws 	IOException
	 */
	public String registUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "/jsp/register.jsp";
	}
	
	/**
	 * 验证用户名是否已存在
	 * @param 	request
	 * @param 	response
	 * @return
	 * @throws 	ServletException
	 * @throws 	IOException
	 */
	public String verifyAccount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 1. 获取 用户名account<br>
		 * 2. 调用service获取用户 返回值：user<br>
		 * 3. 判断user,打印数据null/not null：response.getWriter().write();
		 */
		try {
			User user = new User();
			String sAccount = request.getParameter("account");
			user = userService.verifyAccount(sAccount);
			if (user == null) {
				response.getWriter().write("null");
			} else {
				response.getWriter().write("not null");
			}
		} catch (Exception e) {
		}
		return null;
	}
	
	/**
	 * 验证邮箱是否已存在
	 * @param 	request
	 * @param 	response
	 * @return
	 * @throws 	ServletException
	 * @throws 	IOException
	 */
	public String verifyEmail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 1. 获取 邮箱email<br>
		 * 2. 调用service获取用户 返回值：user<br>
		 * 3. 判断user,打印数据null/not null：response.getWriter().write();
		 */
		try {
			User user = new User();
			String sEmail = request.getParameter("email");
			user = userService.verifyEmail(sEmail);
			if (user == null) {
				response.getWriter().write("null");
			} else {
				response.getWriter().write("not null");
			}
		} catch (Exception e) {
		}
		return null;
	}
	
	/**
	 * 用户注册
	 * @param 	request
	 * @param 	response
	 * @return	请求转发相对路径字符串/null
	 * @throws 	ServletException
	 * @throws 	IOException
	 */
	public String regist(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		/**
		 * 1. 封装对象<br>
		 * 		request.getParameterMap()：获取页面（form表单）内容并转为Map;<br>
		 * 		BeanUtils.populate(Object bean,Map properties)，这个方法会遍历map<key,value>中的key，如果bean中有这个属性，就把这个key对应的value值赋给bean的属性。<br>
		 * 2. 调用service完成注册<br>
		 * 3. 页面转发 提示信息
		 */
		try {
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			
			
			
			if("".equals(user.getName())) {
				user.setName(null);
			}
//			if("".equals(user.getTelephone())) {
//				user.setTelephone(null);
//			}
			if("".equals(user.getBirthday())) {
				user.setBirthday(null);
			}
			
			userService.regist(user);
			request.setAttribute("sMessage", "恭喜你，注册成功！");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("sMessage", "注册失败"); 
		}
		return "/jsp/message.jsp"; // 转发到信息提示页面
	}
	
	
	
	/**
	 * 请求跳转到登录页面
	 * @param 	request
	 * @param 	response
	 * @return
	 * @throws 	ServletException
	 * @throws 	IOException
	 */
	public String loginUI(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		return "/jsp/login.jsp";
	}
	
	/**
	 * 用户登录
	 * @param 	request
	 * @param 	response
	 * @return
	 * @throws 	ServletException
	 * @throws 	IOException
	 */
	public String login(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		/**
		 * 1. 获取用户名和密码<br>
		 * 2. 调用service完成登录 返回值:User<br>
		 * 3. 判断User 根据结果生成提示:<br>
		 * 		User为null:  用户名或密码不正确<br>
		 * 		User不为null: 未激活/已激活（登录成功保存用户登录状态，跳转index.jsp）
		 */
		try {
			String sAccount = request.getParameter("account");
			String sPassword = request.getParameter("password");
			User user = userService.login(sAccount,sPassword);
			
			if(user == null){
				request.setAttribute("error", "用户名或密码不正确");;
				return "/jsp/login.jsp";
			}
			
		
			
			request.getSession().setAttribute("user", user); // 保存用户登录状态
			
			/*----------------------记住用户名begin----------------------*/
			if(Constant.SAVE_NAME.equals(request.getParameter("savename"))){ // 如果勾选了记住用户名
				Cookie cookie = new Cookie("saveName", URLEncoder.encode(sAccount, "utf-8")); // 如果用户名为中文，需要使用utf-8编码
				
//				cookie.setMaxAge(0); // 不记录cookie
//				cookie.setMaxAge(-1); // 会话级cookie，关闭浏览器失效
				cookie.setMaxAge(Integer.MAX_VALUE); // 想设置多长时间设置多长时间
				cookie.setPath(request.getContextPath()+"/");
				
				response.addCookie(cookie); // 将用户名保存到cookie中
			}else{ 
				Cookie cookie = new Cookie("saveName", URLEncoder.encode(sAccount, "utf-8")); // 如果用户名为中文，需要使用utf-8编码
				
				cookie.setMaxAge(0); // 不记录cookie(删除此cookie)
				cookie.setPath(request.getContextPath()+"/");
				
				response.addCookie(cookie); // 将用户名保存到cookie中
			}
			/*----------------------记住用户名end----------------------*/
			
			response.sendRedirect(request.getContextPath()); //重定向到 首页index.jsp
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("sMessage", "用户登录失败");
			return "/jsp/message.jsp";
		}
		
		return null;
	}
	
	/**
	 * 退出
	 */
	public String logout(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
//		request.getSession().invalidate(); // 清除session中的所有信息
		
		request.getSession().removeAttribute("user");
		response.sendRedirect(request.getContextPath()); // 重定向到 首页index.jsp
		return null;
	}
}
