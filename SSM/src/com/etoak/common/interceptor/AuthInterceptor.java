package com.etoak.common.interceptor;



import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import com.etoak.modules.user.bean.User;

/**
 *	认证拦截器 判断用户是否登录 解决session报空指针
 */
public class AuthInterceptor implements HandlerInterceptor{
	
	//不需要拦截器的方法路径
	private List<String> list;
	
	public void setList(List<String> list) {
		this.list = list;
	}

	/**
	 * 3.视图跳转之后触发afterCompletion方法
	 * */
	@Override
	public void afterCompletion(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object object, 
			Exception ex)
			throws Exception {
		
	}

	/**
	 * 2.视图跳转之前触发postHandle方法
	 * */
	@Override
	public void postHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object object, 
			ModelAndView mv)
			throws Exception {
		
	}

	/**
	 * 1.发送请求时如果有拦截器，首先进入拦截器preHandle方法，
	 * 返回值为fasle表示当前请求被拦截，
	 * 返回值为true表示当前请求通过拦截器，进入后台请求方法，处理业务逻辑
	 * */
	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler) throws Exception {
		
		//ResourceHttpRequestHandler资源文件请求 js、css、img
		if(handler instanceof ResourceHttpRequestHandler){
			return true;
		}else if(handler instanceof HandlerMethod){
			/**
			 * 发送后台请求 例如 /login/login.do找到login1方法 ,
			 * 当前handler就表示是login1方法
			 */
			HandlerMethod mh = (HandlerMethod)handler;
			Method method = mh.getMethod();
			if(list.contains(method.getName())){
				return true;
			}
		}
		
		
		//如果session等于空表示还有登录，没有登录就跳转登录页面
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user == null){
			//跳转登录页面
			response.sendRedirect(request.getContextPath() + "/");
			return false;
		}
		
		return true;
	}

}
