package com.transcendinsights.hodor.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import com.netflix.zuul.context.RequestContext;

import org.slf4j.Logger;

/**
 * This is zuul incoming request tap filter to log the incoming request principle. It is a pre filter.
 *
 * @author jaimodha
 * @since 10/24/18.
 */
@Component
public class IncomingRequestTapFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(IncomingRequestTapFilter.class);

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
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info(String.format("%s request to %s by %s", request.getMethod(), request.getRequestURL().toString(), SecurityContextHolder.getContext().getAuthentication().getPrincipal()));

        return null;
    }

}
