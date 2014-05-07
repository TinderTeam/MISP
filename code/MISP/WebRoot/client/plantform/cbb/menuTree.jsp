<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>



   <c:forEach var="menuItem" items="${menuTreeItem}">
		<c:if test="${0==menuItem.menu.parentID}"> 
			<div class="accordionHeader">
				<h2><span>Folder</span>${menuItem.menu.value}</h2>
			</div>		
			<c:if test="${null!=menuItem.childMenuList}"> 
				<div class="accordionContent">	
					<ul class="tree treeFolder">
					<c:set var="menuTreeItem" value="${menuItem.childMenuList}" scope="request"/>
					<jsp:include page="menuTree.jsp"/>
					</ul>
				</div>
			</c:if>
			
		</c:if>
		<c:if test="${menuItem.menu.parentID>=1}"> 			
			<li><a href="<%=request.getContextPath()%>/client/${menuItem.menu.url}" target="navTab" rel="menu_${menuItem.menu.menuID}" external="${menuItem.menu.external}" fresh="${menuItem.menu.fresh}">${menuItem.menu.value}</a>
			<c:if test="${null!=menuItem.childMenuList}"> 
				<ul>
					<c:set var="menuTreeItem" value="${menuItem.childMenuList}" scope="request"/>
					<jsp:include page="menuTree.jsp"/>
				</ul>
			</c:if>	
			</li>
		</c:if>
   </c:forEach>


 
