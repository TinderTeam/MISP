<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<jsp:include page="../cbb/head.jsp"/>
		<jsp:include page="../cbb/js.jsp"/>
		<script src="<%=request.getContextPath()%>/client/platform/userInfo/js/userManage.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		
	</head>
<body>
<!-----标题栏----->
<jsp:include page="../cbb/title.jsp"/>

<!---快捷信息操作栏---->
<jsp:include page="../cbb/info.jsp"/>
<!---快捷操作栏---->
<!----菜单栏--->
<jsp:include page="../cbb/menu.jsp"/>

<!----菜单栏--->
<!----内容栏--->
	<div id="content">
		  
		  <!---面包屑导航---->
		  <jsp:include page="../cbb/bread.jsp"/>
		  <!---End 面包屑导航---->
		  <!----内容页---->
		  <div class="container-fluid">
		        <c:set var="userManage" value="${userManage}" scope="request"/>	  
		        <jsp:include page="./userFilter.jsp"/>		
		        
		        <c:set var="tableExtAttrNameList" value="${userManage.extAttrNameList}" scope="request"/>	  
		        <c:set var="userList" value="${userManage.userList.currentPageData}" scope="request"/>	  
				<jsp:include page="./userInfoList.jsp"/>		
					<!----内容页完---->
					<!----尾部声明---->
				<jsp:include page="../cbb/footer.jsp"/>
		   </div>
	</div>
	

</body>
</html>
