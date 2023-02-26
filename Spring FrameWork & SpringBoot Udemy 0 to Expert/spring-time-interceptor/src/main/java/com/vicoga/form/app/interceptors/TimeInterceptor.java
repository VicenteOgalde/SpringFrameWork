package com.vicoga.form.app.interceptors;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TimeInterceptor implements HandlerInterceptor {
	
	@Value("${config.time.start}")
	private Integer start;
	@Value("${config.time.close}")
	private Integer close;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Calendar calendar= Calendar.getInstance();
		Integer hour = calendar.get(Calendar.HOUR_OF_DAY);
		
		
		if(hour >= start && hour<= close) {
			StringBuilder message= new StringBuilder("office hours are from ");
			message.append(start).append("pm to ").append(close).append("pm.")
			.append(" Thanks for your visit.");
			request.setAttribute("officeHours", message.toString());
			
			return true;
		}
		
		response.sendRedirect(request.getContextPath().concat("/close"));
		
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		String officeHours= (String) request.getAttribute("officeHours");
		
		modelAndView.addObject("officeHours", officeHours);
		
		
	}
	
	

}
