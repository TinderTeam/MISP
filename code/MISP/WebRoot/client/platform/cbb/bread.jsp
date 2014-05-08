<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>

		
			<div id="breadcrumb">				
				<a href="<%=request.getContextPath()%>/client/platform/main/main.jsp" title="返回主页" class="tip-bottom"><i class="icon-home"></i>主页</a>
				<c:if test="${null!=page_breadList}"> 
					<c:forEach var="bread" items="${page_breadList}">	
						<a href="${bread.url}" class="current">${bread.value}</a>
					</c:forEach>
				</c:if>
			</div>