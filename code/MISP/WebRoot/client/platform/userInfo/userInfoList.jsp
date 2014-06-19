<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="span12">
	<br/>
</div>

<div class="row-fluid">

		       	<table class="table table-striped table-bordered table-hover table-condensed">
		        <!-- table class="table table-bordered table-striped">  -->
		            <thead>
		                <tr>
		                    <th><s:text name="USER_ID"></s:text></th>  
		                    <c:forEach var="attrName"   items="${userManage.extAttrNameList}"> 						 
							   <th>${attrName}</th>   
							</c:forEach>
						
							<th style="width:60px">操作</th>
		                </tr>
		            </thead>
		            <tbody>
		               <c:forEach var="user" items="${userManage.userList.currentPageData}"> 						 
						  <tr>
		                    <td style="text-align:center">${user.userID}</td>
		                    <c:forEach var="attr" items="${user.attrList}"> 
		                      <td style="text-align:center">${attr.attrValue}</td>
		                    </c:forEach>
		                    
		                    <td style="text-align:center" >
								<span class="icon" ><a class="tip-bottom" href="" " title="权限查询"><i class="icon-search"></i></a></span>
								<span class="icon" ><a class="tip-bottom" href="" " title="重置密码"><i class=" icon-refresh"></i></a></span>							
								<span class="icon" ><a class="tip-bottom" href="userManage!showUser.action?selectedID=${user.userID}&operateType=modify" title="编辑" ><i class="icon-pencil"></i></a></span>
								<span class="icon" ><a class="tip-bottom" href="userManage!delete.action?selectedID=${user.userID}&operateType=delete" title="删除"><i class="icon-remove"></i></a></span>
		                 	</td>
		                 
		                  </tr>   
								 
						</c:forEach>
		         
		            </tbody>
		        </table>
		     
		<a class="btn btn-primary offset10" href="userManage!showUser.action?operateType=create">新增</a>
</div>	
