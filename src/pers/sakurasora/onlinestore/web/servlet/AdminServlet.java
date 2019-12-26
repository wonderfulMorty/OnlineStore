package pers.sakurasora.onlinestore.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.sakurasora.onlinestore.constant.Constant;
import pers.sakurasora.onlinestore.entity.Administrator;
import pers.sakurasora.onlinestore.service.AdminService;
import pers.sakurasora.onlinestore.service.impl.AdminServiceImpl;
import pers.sakurasora.onlinestore.web.servlet.base.BaseServlet;

/**
 * 
 * 
 * @Description
 *				Servlet--管理员模块
 */
@WebServlet("/admin")
public class AdminServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private AdminService adminService = new AdminServiceImpl();

	/**
	 * 管理员登录
	 * @param 	request
	 * @param 	response
	 * @return
	 * @throws 	ServletException
	 * @throws 	IOException
	 */
	public String login(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		/**
		 * 1. 获取账号和密码<br>
		 * 2. 调用service完成登录 返回值:Administrator<br>
		 * 3. 判断Administrator 根据结果生成提示:<br>
		 * 		Administrator为null:  用户名或密码不正确<br>
		 * 		Administrator不为null: 重定向/jsp/admin/home.jsp）
		 */
		try {
			String sAccount = request.getParameter("account");
			String sPassword = request.getParameter("password");
			Administrator admin = adminService.login(sAccount,sPassword);
			
			if(admin == null){
				request.setAttribute("error", "用户名或密码不正确");;
				return "/jsp/admin/index.jsp";
			}
			
			request.getSession().setAttribute("admin", admin); // 保存管理员登录状态
			
			response.sendRedirect(request.getContextPath() + "/jsp/admin/home.jsp"); //重定向到 管理中心/jsp/admin/home.jsp
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("查找管理员失败");
		}
		
		return null;
	}
	
	/**
	 * 退出
	 */
	public String logout(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
//		request.getSession().invalidate(); // 清除session中的所有信息
		
		request.getSession().removeAttribute("admin"); // 将admin从session中移除
		
		PrintWriter pw = response.getWriter();
		pw.write("<script>window.parent.location.href='" + request.getContextPath() + "/jsp/admin/index.jsp';</script>");
		pw.flush();
		
		return null;
	}

}
