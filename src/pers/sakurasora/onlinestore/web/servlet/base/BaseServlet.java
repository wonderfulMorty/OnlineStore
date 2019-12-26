package pers.sakurasora.onlinestore.web.servlet.base;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.LogFactory;

import com.sun.istack.internal.logging.Logger;

/**
 * 
 * 
 * @Description
 *				通用的servlet
 */
@WebServlet("/base")
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 1.  获取方法名称<br>
		 * 1.1  判断参数（method）值是否为空。若为空，执行默认方法。<br>
		 * 2.  获取方法对象<br>
		 * 3.  让方法执行，接收返回值<br>
		 * 4.  判断返回值是否为空：若不为空统一处理请求转发
		 */
		try {
			String sMethodName = request.getParameter("method");
			
			if (sMethodName == null || sMethodName.trim().length() == 0) {
				sMethodName = "index";
			}
			
			Method method = this.getClass().getMethod(sMethodName, HttpServletRequest.class,HttpServletResponse.class);
			String path = (String) method.invoke(this,request, response);
			
			if (path != null) {
				request.getRequestDispatcher(path).forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(); // 运行时异常；500错误；统一错误页面
		}
	}

	public String index(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); // 设置编码
		response.getWriter().println("URL无效。你好，请不要捣乱，谢谢。");
		return null;
	}
}
