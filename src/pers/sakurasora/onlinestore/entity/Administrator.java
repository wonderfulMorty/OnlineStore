package pers.sakurasora.onlinestore.entity;

import java.io.Serializable;

/**
 * 
 * 
 * @Description
 *				管理员信息实体类	t_administrator
 */
public class Administrator implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 管理员编号<br>
	 * 自增长
	 */
	private Integer id;
	
	/**
	 * 管理员账号
	 */
	private String account;
	
	/**
	 * 管理员密码
	 */
	private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Administrator [id=" + id + ", account=" + account + ", password=" + password + "]";
	}

}
