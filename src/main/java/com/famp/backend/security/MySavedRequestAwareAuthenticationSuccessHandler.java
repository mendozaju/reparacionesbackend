package com.famp.backend.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletResponseWrapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;

public class MySavedRequestAwareAuthenticationSuccessHandler extends
		SimpleUrlAuthenticationSuccessHandler {
	private RequestCache requestCache = new HttpSessionRequestCache();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws ServletException, IOException {
		SavedRequest savedRequest = requestCache.getRequest(request, response);
		if (savedRequest == null) {
			clearAuthenticationAttributes(request);
			System.out.println("Se autentico correctamente 1");
			PrintWriter out = response.getWriter();
			out.print("ok con headers");
			out.flush();
			response.addHeader("Access-Control-Allow-Origin", "*");          
            response.addHeader("Access-Control-Allow-Methods","GET, POST, PUT");
            response.addHeader("Access-Control-Allow-Headers","accept, content-type");
            response.addHeader("Access-Control-Allow-Credentials","true");
			
			
			
			return;
		}
		String targetUrlParam = getTargetUrlParameter();
		if (isAlwaysUseDefaultTargetUrl()
				|| (targetUrlParam != null && StringUtils.hasText(request
						.getParameter(targetUrlParam)))) {
			System.out.println("Se autentico correctamente 2");
			requestCache.removeRequest(request, response);
			clearAuthenticationAttributes(request);
			response.addHeader("Access-Control-Allow-Origin", "*");          
            response.addHeader("Access-Control-Allow-Methods","GET, POST, PUT");
            response.addHeader("Access-Control-Allow-Headers","accept, content-type");
            response.addHeader("Access-Control-Allow-Credentials","true");
			
			return;
		}
		
		clearAuthenticationAttributes(request);
		System.out.println("Se autentico correctamente 3");
		response.addHeader("Access-Control-Allow-Origin", "*");          
        response.addHeader("Access-Control-Allow-Methods","GET, POST, PUT");
        response.addHeader("Access-Control-Allow-Headers","accept, content-type");
        response.addHeader("Access-Control-Allow-Credentials","true");
	}

	public void setRequestCache(RequestCache requestCache) {
		this.requestCache = requestCache;
	}
}