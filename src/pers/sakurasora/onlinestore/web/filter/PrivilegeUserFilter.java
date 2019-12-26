package pers.sakurasora.onlinestore.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.sakurasora.onlinestore.entity.User;

/**
 * 
 * 
 * @Description
 *				用户权限过滤
 */
public class PrivilegeUserFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	/**
	 * 执行过滤
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// 1. 强转
		HttpServletRequest request =(HttpServletRequest) req;
		HttpServletResponse response =(HttpServletResponse) resp;
		
		/* 2. 逻辑：
		 * 			从session中获取用户
		 * 			若为null，提示登录
		 */
		User user = (User) request.getSession().getAttribute("user");
		
		if(user == null){
			request.setAttribute("sMessage", "请先登录");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
		
		// 3. 放行
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
