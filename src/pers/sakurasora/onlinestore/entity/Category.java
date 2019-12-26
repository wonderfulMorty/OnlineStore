package pers.sakurasora.onlinestore.entity;

import java.io.Serializable;

/**
 * 
 * 
 * @DateTime 	2019年5月14日
 * @Description
 *				类别实体类		t_category
 */
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 类别编号<br>
	 * 自增长
	 */
	private Integer id;
	
	/**
	 * 类别名
	 */
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
	
}
