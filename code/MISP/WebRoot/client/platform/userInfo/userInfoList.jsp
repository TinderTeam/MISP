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
		                    <c:forEach var="attrName"   items="${tableExtAttrNameList}"> 						 
							   <th>${attrName}</th>   
							</c:forEach>
						
							<th style="width:60px">操作</th>
		                </tr>
		            </thead>
		            <tbody>
		               <c:forEach var="user" items="${userList}"> 						 
						  <tr>
		                    <td style="text-align:center">${user.userID}</td>
		                    <c:forEach var="attr" items="${user.attrList}"> 
		                      <td style="text-align:center">${attr.attrValue}</td>
		                    </c:forEach>
		                    
		                    <td style="text-align:center" >
								<span class="icon" ><a class="tip-bottom" href="" " title="权限查询"><i class="icon-search"></i></a></span>												
								<span class="icon" ><a class="tip-bottom" href="userManage!showUser.action?selectedID=${user.userID}&operateType=modify" title="编辑" ><i class="icon-pencil"></i></a></span>
								<a id="${user.userID}" class="tip-bottom" href="javascript:void(0);" title="重置密码" onclick="
								warnModal(
									'重置密码',
									'您确定要重置用户 ${user.userID}的密码吗？',
									'userManage!resetPassword.action?selectedID=${user.userID}'									
									)"><i class=" icon-refresh"></i></a>		                 	
								<a id="${user.userID}" class="tip-bottom" href="javascript:void(0);" title="删除" onclick="
								warnModal(
									'删除用户',
									'您确定要删除用户 ${user.userID}的吗？',
									'userManage!delete.action?selectedID=${user.userID}&operateType=delete'
									)
								"><i class="icon-remove"></i></a>
		                 	</td>
		                  
		                  </tr>   
								 
						</c:forEach>
		         
		            </tbody>
		        </table>     
		<a class="btn btn-primary offset10" href="userManage!showUser.action?operateType=create">新增</a>
</div>
<jsp:include page="../cbb/widget/warnModal.jsp"/>		
	
