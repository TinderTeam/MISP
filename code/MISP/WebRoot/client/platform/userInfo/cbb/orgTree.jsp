<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>

<ul>
	
		<c:forEach var="org" items="${orgItem}">
		<li>	
			<c:set var="icon" value="icon-minus-sign" scope="request"/>
			<c:if test="${!org.subOrgExist}">
				<c:set var="icon" value="icon-th-large" scope="request"/>
			</c:if>
			<span><i class="${icon}"></i></span> <a href="#" onClick="treeSelect(this.innerHTML)")>${org.orgName}</a>
			<c:if test="${org.subOrgExist}"> 
						<!------>
						<c:set var="orgItem" value="${org.subOrgList}" scope="request"/>
						<jsp:include page="orgTree.jsp"/>
						<!----  --->
			</c:if>
			
		</li>	
		</c:forEach>		
						
</ul>
