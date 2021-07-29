package com.altimetrik.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class PreFilter extends ZuulFilter {
	private static Logger log = LoggerFactory.getLogger(PreFilter.class);
	
	private String originAllowed = "ALTIMETRIK";
	
	  @Override
	  public String filterType() {
	    return "pre";
	  }

	  @Override
	  public int filterOrder() {
	    return 1;
	  }

	  @Override
	  public boolean shouldFilter() {
	    return true;
	  }

	  @Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		String origin = request.getHeader(HttpHeaders.ORIGIN);
		log.info(origin);
		log.info("PreFilter: "
				+ String.format("%s request to %s and path", request.getMethod(), request.getRequestURL().toString()));
		
		//2.3 - if origin is not ALTIMETRIK throw Forbidden error
		if (!originAllowed.equalsIgnoreCase(origin)) {
			ctx.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
			if (ctx.getResponseBody() == null) {
				ctx.setSendZuulResponse(false);
			}
		}

		return null;
	}
}