package com.wjk.ssm.vo;

import java.io.Serializable;

public class User implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -6639698129210454747L;

	private String id;

    private String account;

    private String password;

    private String username;

    private Integer age;

    private String address;

    private String createTime;

    private String updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", account=" + account + ", password=" + password + ", username=" + username
				+ ", age=" + age + ", address=" + address + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ "]";
	}
    
    
}