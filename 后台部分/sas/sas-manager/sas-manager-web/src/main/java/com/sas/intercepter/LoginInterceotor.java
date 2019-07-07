/**   
 * @Title: LoginInterceotor.java 
 * @Package com.appointment.intercepter 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author xieweipeng 
 * @date 2018年4月13日 下午9:14:04 
 * @version V1.0   
 */
package com.sas.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: LoginInterceotor
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author xieweipeng
 * @date 2018年4月13日 下午9:14:04
 * @version V1.0
 */
public class LoginInterceotor implements HandlerInterceptor {

	/*
	 * (非 Javadoc) <p>Title: afterCompletion</p> <p>Description:
	 * 执行controlle方法后执行r</p>
	 * 
	 * @param arg0
	 * 
	 * @param arg1
	 * 
	 * @param arg2
	 * 
	 * @param arg3
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax
	 * .servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/*
	 * (非 Javadoc) <p>Title: postHandle</p> <p>Description:返回modleAndView前执行
	 * </p>
	 * 
	 * @param arg0
	 * 
	 * @param arg1
	 * 
	 * @param arg2
	 * 
	 * @param arg3
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet
	 * .http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub

	}

	/*
	 * (非 Javadoc) <p>Title: preHandle</p> <p>Description:
	 * 执行congtroller方法前执行</p>
	 * 
	 * @param arg0
	 * 
	 * @param arg1
	 * 
	 * @param arg2
	 * 
	 * @return true:不看接此请求 false:拦截
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet
	 * .http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object arg2) throws Exception {
		HttpSession session = request.getSession();
		String uri = request.getRequestURI();
		if (uri.contains("login") || uri.contains("index")|| uri.contains("setDeparment")||uri.contains("map")||uri.contains("Proscenium")) {
			return true;
		}
		if (session.getAttribute("user") != null) {
			return true;
		} else {
			 request.getRequestDispatcher("/WEB-INF/jsp/login_main/login.jsp").forward(request,response); //服务器端跳转
			return false;
		}
	}

}
