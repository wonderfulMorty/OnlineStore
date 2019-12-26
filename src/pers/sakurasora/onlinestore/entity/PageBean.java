package pers.sakurasora.onlinestore.entity;

import java.util.List;

/**
 * 
 * 
 * @Description
 *				分页
 */
public class PageBean<T> {
	
	/**
	 * 当前页的数据<br>
	 * 查询  limit (pageNumber-1)*pageSize,pageSize
	 */
	private List<T> data;
	
	/**
	 * 当前页<br>
	 * 页面传递过来
	 */
	private int pageNumber;
	
	/**
	 * 总条数<br>
	 * 查询  count(*)
	 */
	private int totalRecord;
	
	/**
	 * 每页显示的数量<br>
	 * 固定值
	 */
	private int pageSize;
	
	/**
	 * 总页数<br>
	 * 计算出来 (int)Math.ceil(totalRecord*1.0/pageSize);
	 */
	private int totalPage;
	
	/**
	 * 有参构造
	 * @param pageNumber 当前页
	 * @param pageSize 每页显示的数量
	 */
	public PageBean(int pageNumber, int pageSize) {
		super();
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}
	
	public List<T> getData() {
		return data;
	}
	
	public void setData(List<T> data) {
		this.data = data;
	}
	
	public int getPageNumber() {
		return pageNumber;
	}
	
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	public int getTotalRecord() {
		return totalRecord;
	}
	
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	/**
	 * @return 总页数
	 */
	public int getTotalPage() {
		totalPage = (int)Math.ceil(totalRecord*1.0/pageSize);
		return totalPage;
	}
	
	/**
	 * @return 开始索引
	 */
	public int getStartIndex(){
		return (pageNumber-1)*pageSize;
	}
}
