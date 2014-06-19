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
	
	<div id="WarningModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			<h3 id="ModalTitle"></h3>
		</div>
		
		<div class="modal-body">
			<p id="WarningText"></p>
		</div>
		
		<div class="modal-footer">				  	
			
			<a id="ConformBtn" class="btn btn-danger" href="">确认</a>
			<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
		</div>
	</div>	