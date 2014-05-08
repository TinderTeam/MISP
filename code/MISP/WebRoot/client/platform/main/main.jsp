<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
	    <jsp:include page="../framework/cbb/head.jsp"/>		
        <jsp:include page="../framework/cbb/js.jsp"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
	<body>
		<!-----标题栏----->
		<jsp:include page="../framework/cbb/title.jsp"/>
		<!----站内搜索栏---- 暂时不用，拓展用
		<jsp:include page="../framework/cbb/search.jsp"/>
		--->		
		<!---快捷信息操作栏---->
		<jsp:include page="../framework/cbb/info.jsp"/>
        <!---快捷操作栏----> 
		 <!----菜单栏--->
		<jsp:include page="../framework/cbb/menu.jsp"/>
		<!----菜单栏--->	
		<!----内容栏--->
		<div id="content">
			<div id="content-header">		
				<h1>MISP</h1>			
			</div>
			
			<!---面包屑导航---->
			<jsp:include page="../framework/cbb/bread.jsp"/>
			<!---End 面包屑导航---->
			
			
			<div class="container-fluid">
			
				<!----内容页---->

				<!----内容页完---->
				
				
				<!----尾部声明---->
				<jsp:include page="../framework/cbb/footer.jsp"/>				  

			</div>
		</div>
	</body>
</html>
