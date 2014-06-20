<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<jsp:include page="../cbb/head.jsp"/>
		<jsp:include page="../cbb/js.jsp"/>
		
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
		<div id="content-header">
			<h1>${page_pageName}</h1>
		</div>
		  <!---面包屑导航---->
		<jsp:include page="../cbb/bread.jsp"/>
		  <!---End 面包屑导航---->
		  <!----内容页---->
		<div class="container-fluid">		
			<div class="row-fluid">
					
						<table class="table table-striped table-bordered table-hover table-condensed">
       
        <!-- table class="table table-bordered table-striped">  -->
            <thead>
                <tr>
                    <th>用户组名称</th>
                    <th>用户组描述</th>
					<th>用户列表</th>
					<th style="width:60px">操作</th>
                </tr>
            </thead>
            <tbody>
               <c:forEach var="userGroup" items="${groupManage.groupList}"> 						 
				  <tr>
                    <td  style="text-align:center" >${userGroup.groupName}</td>
                    <td  style="text-align:center" >${userGroup.groupDesp}</td>
                    <td  style="text-align:center" >
                    <c:forEach var="user" items="${userGroup.userList}"> 
                      ${user.userID},
                    </c:forEach>
                    </td  >
                    
                    <td  style="text-align:center">
                    	<span class="icon" ><a class="tip-bottom" href="" " title="权限查询"><i class="icon-search"></i></a></span>					
						<span class="icon" ><a class="tip-bottom" href="groupManage!show.action?selectedID=${userGroup.groupID}&operateType=modify" title="编辑" ><i class="icon-pencil"></i></a></span>
						<span class="icon" ><a class="tip-bottom" href="groupManage!delete.action?selectedID=${userGroup.groupID}&operateType=delete" title="删除"><i class="icon-remove"></i></a></span>
                    </td>		
                  </tr>   
						 
				</c:forEach>
         
            </tbody>
        </table>
        	<a class="btn btn-primary offset10"  href="groupManage!show.action?selectedID=${userGroup.groupID}&operateType=create">新增</a>	
									</div>
									
							</div>		
						</div>	
				
					<!----内容页完---->
					<!----尾部声明---->
				<jsp:include page="../cbb/footer.jsp"/>
 
</body>
 </html>
