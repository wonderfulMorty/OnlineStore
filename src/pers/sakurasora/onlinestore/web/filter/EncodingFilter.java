package pers.sakurasora.onlinestore.web.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * 统一编码过滤器
 */
public class EncodingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) req; // 1.强转
		HttpServletResponse response=(HttpServletResponse) resp;
	    /*
	     * 传递给目标servlet或jsp的实际上是包装器对象的引用，而不是原始的HttpServletRequest对象
	     */
		chain.doFilter(new MyRequest(request), response); 	 // 2.放行
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}

/**
 * 自定义请求包装器包装请求，将字符编码转换的工作添加到getparameter()方法中。
 *
 */
class MyRequest extends HttpServletRequestWrapper{
	/** 
	 * 公共接口类HttpServletRequest继承自ServletRequest。<br>
	 * 客户端浏览器发出的请求被封装成为一个HttpServletRequest对象。<br>
	 * 对象包含了客户端请求信息--请求的地址，请求的参数，提交的数据
	 */
	private HttpServletRequest request;
	
	private boolean flag = true;
	
	public MyRequest(HttpServletRequest request) {
		super(request);
		this.request = request; // 获得被装饰对象的引用
	}
	
	@Override
	/**
	 * 调用被包装的请求对象的getParameter方法获得参数，然后再进行编码转换 
	 */
	public String getParameter(String name) {  
		if(name == null || name.trim().length() == 0){
			return null;
		}
		String[] values = getParameterValues(name);
		if(values == null || values.length == 0){
			return null;
		}
		
		return values[0];
	}
	
	@Override
	/**
	 * hobby=[eat,drink]
	 */
	public String[] getParameterValues(String name) {
		if(name == null || name.trim().length()==0){
			return null;
		}
		Map<String, String[]> map = getParameterMap();
		if(map == null || map.size() == 0){
			return null;
		}
		
		return map.get(name);
	}
	
	@Override
	/**
	 * map{ username=[tom],password=[123],hobby=[eat,drink]}
	 */
	public Map<String,String[]> getParameterMap() {  
		
		/**
		 * 首先判断请求方式
		 * 若为post  request.setchar...(utf-8)
		 * 若为get   将map中的值遍历编码就可以了
		 */
		String method = request.getMethod();
		if("post".equalsIgnoreCase(method)){
			try {
				request.setCharacterEncoding("utf-8");
				return request.getParameterMap();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}else if("get".equalsIgnoreCase(method)){
			Map<String,String[]> map = request.getParameterMap();
			if(flag){
				/*
				 * 需要遍历map,修改value的每一个数据的编码
				 */
				for (String key : map.keySet()) {
					String[] arr = map.get(key);
					for(int i = 0;i<arr.length;i++){ //继续遍历数组
						try {
							arr[i] = new String(arr[i].getBytes("iso8859-1"),"utf-8"); //编码
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
					}
				}
				flag=false;
			}
			
			return map;
		}
		
		return super.getParameterMap();
	}
	
}