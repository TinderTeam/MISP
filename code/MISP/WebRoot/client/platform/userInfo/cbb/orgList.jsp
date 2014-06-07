

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>


		<c:forEach var="org" items="${orgAllItem}">
			<option>${org.orgName}</option>
			<c:if test="${org.subOrgExist}"> 
						<!------>
						<c:set var="orgAllItem" value="${org.subOrgList}" scope="request"/>
						<jsp:include page="orgList.jsp"/>
						<!----  --->
			</c:if>
			
		</li>	
		</c:forEach>		


	