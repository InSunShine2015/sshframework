package com.jesus.sshframework.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User extends BaseEntity {
	
	/**
	 * 用户名(默认为手机号码)
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 绑定的渠道
	 */
	private String channel;
	/**
	 * 用户类型
	 */
	private String userType;
	
	public User() {
		super();
	}
	
	/**
	 * 简单admin对象
	 * @param username 账号
	 * @param password 密码
	 * @param isAccountEnabled 是否启用
	 */
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	@Column(name="CHANNEL")
	public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    @Column(name="USER_NAME",updatable = true)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name="PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="USER_TYPE")
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
	
	
}
