package pers.sakurasora.onlinestore.web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import pers.sakurasora.onlinestore.constant.Constant;
import pers.sakurasora.onlinestore.entity.Category;
import pers.sakurasora.onlinestore.entity.Product;
import pers.sakurasora.onlinestore.service.ProductService;
import pers.sakurasora.onlinestore.service.impl.ProductServiceImpl;
import pers.sakurasora.onlinestore.utils.UploadUtil;

/**
 * 
 * 
 * @Description
 *				Servlet--添加商品模块
 */
@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductService productService = new ProductServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			/*
			 * 1. 使用fileuload 保存图片和将商品的信息放入map中
			 */
			Map<String,Object> map = new HashMap<>(); // 创建map 存放商品的信息
			DiskFileItemFactory factory = new DiskFileItemFactory(); // 创建磁盘文件项工厂 (设置临时文件的大小和位置)
			ServletFileUpload upload = new ServletFileUpload(factory); // 创建核心上传对象
			
			List<FileItem> list = upload.parseRequest(request); // 解析request
			
			for (FileItem fi : list) { // 遍历list 获取每一个文件项
				String key = fi.getFieldName(); // 获取每一项中name属性的值
			
				if (fi.isFormField()){ // 判断是否是普通的上传组件（如<input type="text"/>、<label>等）
					map.put(key, fi.getString("utf-8"));
				} else { // 文件上传组件：<input type="file"/>
					String sName = fi.getName(); // 获取文件的名称（如  1.jpg)
					String sRealName = UploadUtil.getRealName(sName); // 获取文件真实名称（肯带路径）
					String sRandomName = UploadUtil.getUUIDName(sRealName); //c.获取文件的随机名称 
					String sRandomDir = UploadUtil.getDir(); // 获取随机目录
					
					InputStream inputStream = fi.getInputStream(); // 获取文件内容(输入流)
					
					String sProductPath = getServletContext().getRealPath("/products"); // 获取products目录的真实路径
					
					File dirFile = new File(sProductPath,sRandomDir); // 创建随机目录
					if(!dirFile.exists()){
						dirFile.mkdirs();
					}
					
					FileOutputStream fileOutputStream = new FileOutputStream(new File(dirFile,sRandomName)); // 创建输出流
					
					IOUtils.copy(inputStream, fileOutputStream); // 对拷流
								
					/*
					 * 释放资源
					 */
					fileOutputStream.close(); 
					inputStream.close();
					
					fi.delete(); // 删除临时文件
					
					map.put(key, "products"+sRandomDir+"/"+sRandomName); //j.将商品的路径放入map中
					//System.out.println("map:key:"+map.get(key));
				}
			}
			
			/*
			 * 封装product对象
			 */
			Product product = new Product();
//			map.put("pdate", new Date()); // 设置 shelf_time
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			product.setShelf_time(Timestamp.valueOf(formatter.format(new Date()))); // 设置 shelf_time
			map.put("is_down", Constant.PRODUCT_IS_NOT_DOWN); //设置 is_down  上架
			
			BeanUtils.populate(product, map); // 使用org.apache.commons.beanutils.BeanUtils将map封装为product对象
			
			Category category = new Category(); 
			category.setId(Integer.parseInt((String) map.get("category_id")));
			product.setCategory(category); // 设置 category
			
			/*
			 * 2. 调用service 完成添加
			 */
			productService.save(product);
			
			/*
			 * 3. 重定向
			 */
			response.sendRedirect(request.getContextPath()+"/jsp/admin/product/list.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("添加商品失败");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
