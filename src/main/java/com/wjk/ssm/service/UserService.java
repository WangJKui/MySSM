package com.wjk.ssm.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wjk.comm.util.IdGeneratorUser;
import com.wjk.comm.util.MD5Util;
import com.wjk.ssm.mapper.UserMapper;
import com.wjk.ssm.vo.User;


@Service
public class UserService {

	@Autowired
	UserMapper userMapper;

	/**
	 * 注册
	 * @param username
	 * @param password
	 */
	public void register(String username, String password) {
		String account = IdGeneratorUser.nextId().toString();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = df.format(new Date());
		
		User u = new User();
		u.setAccount(account);
		u.setCreateTime(format);
		u.setUpdateTime(format);
		
		u.setPassword(MD5Util.MD5Encode(password, "UTF-8"));
		
		userMapper.insert(u);
	}

	/**
	 * 登录
	 * @param account
	 * @param password
	 */
	public void login(String account, String password) {
		
		User user = userMapper.selectByAccount(account);
		if(user!=null && user.getPassword()!=null && user.getPassword().equals(MD5Util.MD5Encode(account, "UTF-8"))) {
			 //shiro管理的session
			Subject currentUser = SecurityUtils.getSubject();  
			Session session = currentUser.getSession();
	       
			//shiro加入身份验证
		    UsernamePasswordToken token = new UsernamePasswordToken(account, password); 
		    token.setRememberMe(true);
		    currentUser.login(token);
		    
			session.setAttribute("currentUser", currentUser);

		    
		    if(currentUser.isAuthenticated()){  
		    	System.out.println("登录成功===================");
	       }else{  
	           token.clear();  
	       } 
		}
		
	}
	

}
