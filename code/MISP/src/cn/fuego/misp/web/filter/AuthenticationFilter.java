package cn.fuego.misp.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.fuego.misp.util.validate.ValidatorUtil;
import cn.fuego.misp.web.constant.SessionAttrNameConst;
import cn.fuego.misp.web.model.user.UserModel;

 
/**
 * 
* @ClassName: AuthenticationFilter 
* @Description: TODO
* @author Tang Jun
* @date 2014-3-13 上午01:09:55 
*
 */
public class AuthenticationFilter implements Filter
{

	private static final String LOGIN_URL_FLAG = "login";
	private static final  String INDEX_PAGE = "index.jsp";

 

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		 HttpServletRequest httpRequest = (HttpServletRequest)request;
		 
		 HttpServletResponse httpResponse = (HttpServletResponse)response;
		 HttpSession  session = httpRequest.getSession();
		 String url = httpRequest.getRequestURL().toString();
		  
		 //the url does not contains login url, we should check login or not
		 if(url.toLowerCase().indexOf(LOGIN_URL_FLAG)<0)
		 {
		     UserModel loginUser = (UserModel) session.getAttribute(SessionAttrNameConst.LOGIN_USER);
			 if(null == loginUser || ValidatorUtil.isEmpty(loginUser.getUserID()))
			 {
				 httpResponse.sendRedirect(httpRequest.getContextPath()+"/"+INDEX_PAGE);
			 }
		 }
		 
 
		chain.doFilter(request, httpResponse);
	}


	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy()
	{
		// TODO Auto-generated method stub
		
	}


	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig arg0) throws ServletException
	{
 		
	}
 
}
