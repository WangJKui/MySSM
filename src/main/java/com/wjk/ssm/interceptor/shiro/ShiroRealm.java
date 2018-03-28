package com.wjk.ssm.interceptor.shiro;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.wjk.ssm.service.UserService;


public class ShiroRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	
	/** 
	 * 认证,登录时调用
	 * @see 经测试:本例中该方法的调用时机为LoginController.login()方法中执行Subject.login()时 
	 *  1、检查提交的进行认证的令牌信息
	 *  2、根据令牌信息从数据源(通常为数据库)中获取用户信息
	 *  3、对用户信息进行匹配验证。
	 *  4、验证通过将返回一个封装了用户信息的AuthenticationInfo实例。
	 *  5、验证失败则抛出AuthenticationException异常信息
	 */  
	/*
	 * 登录信息和用户验证信息验?(non-Javadoc)
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		String username = (String)token.getPrincipal();  				//得到用户? 
		String password = new String((char[])token.getCredentials()); 	//得到密码


		UsernamePasswordToken token11 = (UsernamePasswordToken)token;  

		System.out.println("=============="+token11.getUsername());

		System.out.println("==============AuthorizationInfo==========================11111111111111111111111");


		if(null != username && null != password){
			return new SimpleAuthenticationInfo(username, password, getName());
		}else{
			return null;
		}

	}



	/** 
	 * 授权查询, 进行鉴权但缓存中无用户的授权信息时调用
	 * @see 经测试:本例中该方法的调用时机为需授权资源被访问时 
	 * @see 经测试:并且每次访问需授权资源时都会执行该方法中的逻辑,这表明本例中默认并未启用AuthorizationCache
	 * @see 个人感觉若使用了Spring3.1开始提供的ConcurrentMapCache支持,则可灵活决定是否启用AuthorizationCache 
	 * @see 比如说这里从数据库获取权限信息时,先去访问Spring3.1提供的缓存,而不使用Shior提供的AuthorizationCache  
	 */

	/*
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调?,负责在应用程序中决定用户的访问控制的方法(non-Javadoc)
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {

//		List<String> r_l=userService.findAllRole();
//		List<String> p_l=userService.findAllPrivilege();
//		
		String currentUsername = (String)super.getAvailablePrincipal(pc);  

		SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo(); 

//		List<String> roles= new ArrayList<>();
//		roles.add("admin");
//		roles.add("wjk");
//
//		List<String> privilege= new ArrayList<>();
//		privilege.add("add");
//		privilege.add("del");

//		simpleAuthorInfo.addRoles(r_l);
//		simpleAuthorInfo.addStringPermissions(p_l);


		System.out.println("==============AuthorizationInfo=====22222==================="+currentUsername);

		return simpleAuthorInfo;
	}

}
