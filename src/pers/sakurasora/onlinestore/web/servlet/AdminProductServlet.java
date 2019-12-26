package pers.sakurasora.onlinestore.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

import com.alibaba.fastjson.JSON;

import pers.sakurasora.onlinestore.entity.Category;
import pers.sakurasora.onlinestore.entity.Product;
import pers.sakurasora.onlinestore.service.CategoryService;
import pers.sakurasora.onlinestore.service.ProductService;
import pers.sakurasora.onlinestore.service.impl.CategoryServiceImpl;
import pers.sakurasora.onlinestore.service.impl.ProductServiceImpl;
import pers.sakurasora.onlinestore.web.servlet.base.BaseServlet;

/**
 * @author SakuraSora
 * 
 * @Description Servlet--商品管理模块
 */
@WebServlet("/adminProduct")
public class AdminProductServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private ProductService productService = new ProductServiceImpl();
	private CategoryService categoryService = new CategoryServiceImpl();

	/**
	 * 展示已上架商品列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1. 调用service 查询以上架商品<br>
		 * 2. 将返回值放入request中,请求转发
		 */
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			Map map = new HashedMap();
			int page = 0;
			
			if (request.getParameter("page") == null) {
				page = 1;
			} else {
				page = Integer.parseInt(request.getParameter("page").toString());
			}
			List<Product> productLis = productService.findAll();
			int pageIndex = page;// 当前页
			int pageSize = 5;// 设置每页要展示的数据数量(根据项目需求灵活设置)
			int rowCount = 0;
			try {
				rowCount = productLis.size();// 总条数
				// 通过计算，得到分页应该需要分几页，其中不满一页的数据按一页计算
				if (rowCount % pageSize != 0) {
					rowCount = rowCount / pageSize + 1;
				} else {
					rowCount = rowCount / pageSize;
				}
			} catch (Exception e) {
			}
			System.out.println("pageindex:"+pageIndex);
			List<Product> pr =productService.findByPages(pageIndex,pageSize);
			map.put("data", pr);
			map.put("total", pr.size() + "");
			map.put("pages", rowCount + "");
			map.put("currentPage", pageIndex + "");
			// request.setAttribute("productLis", map);
			System.out.println(JSON.toJSON(map));
			response.getWriter().print(JSON.toJSON(map));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("查询所有商品失败");
		}

		// return "/jsp/admin/product/list.jsp";
	}

	public String getProductList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "/jsp/admin/product/list.jsp";
	}

	/**
	 * 商品下架
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String shelfDown(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 1. 获取商品编号 productId<br>
		 * 2. 调用service 执行下架<br>
		 * 3. 重定向
		 */
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			String sProductId = request.getParameter("productId");
			productService.down(Integer.parseInt(sProductId));
			System.out.println("shelfDown:"+sProductId);
			response.sendRedirect(request.getContextPath() + "/jsp/admin/product/list.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("更新商品下架标志失败");
		}
		//response.getWriter().print("商铺下架成功！！");
		return null;
	}

	/**
	 * 跳转到添加商品页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String addUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1. 调用categoryservice 查询所有分类<br>
		 * 2. 放入request 跳转/jsp/admin/product/add.jsp
		 */
		try {
			List<Category> categoryLis = categoryService.findCategoryList();
			request.setAttribute("categoryLis", categoryLis);
		} catch (Exception e) {
		}
		return "/jsp/admin/product/add.jsp";
	}
}
