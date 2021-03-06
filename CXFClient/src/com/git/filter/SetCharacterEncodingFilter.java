package com.git.filter;

import java.io.IOException;

import javax.servlet.*;


public class SetCharacterEncodingFilter implements Filter
{
	protected String encoding = null;
	 protected FilterConfig filterConfig = null;
	 protected boolean ignore = true;
	public SetCharacterEncodingFilter()
	{
		// TODO 自动生成的构造函数存根
	}

	@Override
	public void destroy()
	{
		 this.encoding = null;
		    this.filterConfig = null;

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException
	{
		if (ignore || (request.getCharacterEncoding() == null))
	    {
	     String encoding = selectEncoding(request);
	     if (encoding != null)
	      request.setCharacterEncoding(encoding);
	    }
	    chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException
	{
		//this.filterConfig = filterConfig;
	    // 获取初始化参数
	    this.encoding = filterConfig.getInitParameter("encoding");
	    String value = filterConfig.getInitParameter("ignore");
	    if (value == null)
	    {
	     this.ignore = true;
	    } else if (value.equalsIgnoreCase("true"))
	    {
	     this.ignore = true;
	    } else if (value.equalsIgnoreCase("yes"))
	    {
	     this.ignore = true;
	    } else
	     this.ignore = false;

	}
	protected String selectEncoding(ServletRequest request)
	 {
	    return (this.encoding);
	 }

}
