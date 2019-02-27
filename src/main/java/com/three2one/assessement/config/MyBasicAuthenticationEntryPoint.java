package com.three2one.assessement.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class MyBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

@Override
public void commence
  (HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx) 
  throws IOException, ServletException {
    response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName() + "");
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    PrintWriter writer = response.getWriter();
    writer.println("HTTP Status 401 - " + authEx.getMessage());
}

@Override
public void afterPropertiesSet() throws Exception {
	setRealmName("Spring");
    super.afterPropertiesSet();
}
}

