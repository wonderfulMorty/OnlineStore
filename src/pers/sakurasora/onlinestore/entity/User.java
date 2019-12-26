package pers.sakurasora.onlinestore.entity;

import java.io.Serializable;

/**
 * 
 * 
 * @Description
 *				用户信息表实体类	t_user
 */
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * 用户编号<br>
	 * 自增长
	 */
	private Integer id;
	
	/**
	 * 用户名（账号）
	 */
	private String account;
	
	/**
	 * 用户密码
	 */
	private String password;
	
	/**
	 * 用户姓名
	 */
	private String name;
	
	/**
	 * 用户性别
	 */
	private String sex;
	
	/**
	 * 用户邮箱
	 */
	private String email;
	
	/**
	 * 用户手机号
	 */
	private String telephone;
	
	/**
	 * 用户生日
	 */
	private String birthday;
	
	/**
	 * 激活状态<br>
	 * null-未设置激活状态<br>
	 * 0-未激活<br>
	 * 1-已激活
	 */
	private Integer state;
	
	/**
	 * 激活码
	 */
	private String code;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", account=" + account + ", password=" + password + ", name=" + name + ", sex=" + sex
				+ ", email=" + email + ", telephone=" + telephone + ", birthday=" + birthday + ", state=" + state
				+ ", code=" + code + "]";
	}	
	
}
