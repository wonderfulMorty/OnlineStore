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

import pers.sakurasora.onlinestore.entity.Administrator;

/**
 * 
 * 
 * @Description
 *				管理员权限过滤
 */
public class PrivilegeAdminFilter implements Filter {

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
		 * 			从session中获取管理员
		 * 			若为null，提示登录
		 */
		Administrator admin = (Administrator) request.getSession().getAttribute("admin");
		
		if(admin == null){
			response.sendRedirect(request.getContextPath() + "/jsp/admin/index.jsp");
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
