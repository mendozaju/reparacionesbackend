package com.famp.backend.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.util.RequestMatcher;
import org.springframework.stereotype.Component;

@Component
public class MyBasicAuthenticationEntryPoint extends
		BasicAuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException authEx)
			throws IOException, ServletException {
		response.addHeader("WWW-Authenticate", "Basic realm=\""
				+ getRealmName() + "\"");
		
		if(isPreflight(request)){
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
			PrintWriter writer = response.getWriter();
    		writer.println("Entramos a la parteue de pre flight");
        } else {
        	response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    		PrintWriter writer = response.getWriter();
    		writer.println("Codigo de error 401 - " + authEx.getMessage());
    		response.setHeader("Access-Control-Allow-Origin", "*");
        }
		
		
	}
	
	private boolean isPreflight(HttpServletRequest request) {
        return "OPTIONS".equals(request.getMethod());
    }
	

	@Override
	public void afterPropertiesSet() throws Exception {
		setRealmName("My test aplication");
		super.afterPropertiesSet();
	}

}
