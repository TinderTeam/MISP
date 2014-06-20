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
		<script src="<%=request.getContextPath()%>/client/platform/userInfo/js/orgManage.js"></script>
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
			<div class="row-fluid">
					
						<div class="span12"> 
						
	
								<h5>组织机构树：</h5>
								
								
									<div class="tree well">
										<c:set var="orgList" value="${orgManageModel.orgList}" scope="request"/>
										<jsp:include page="cbb/orgTree.jsp"/>
									</div>
				
								
						 </div>	 
						
						</div>				
					<!----内容页完---->
					<!----尾部声明---->
				<jsp:include page="../cbb/footer.jsp"/>
				
		   </div>
	</div>
<!-- Button to trigger modal -->
		<!-- add Modal -->
					<div id="addSubGroup" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					  <div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h3 id="myModalLabel">新增组织结构</h3>
					  </div>
					  <div class="modal-body">
							<div class="control-group">
								<label class="control-label">新组织机构名称</label>
								<div class="controls">
									<input  id="addInput" value ="" type="password" />							
								</div>									
							</div>
					  </div>
					  <div class="modal-footer">
						<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
						<button class="btn btn-primary" onclick="addOrgSubmit()" id="addSubOrgSubmit" value="" name="addSubOrg_FatherID">提交</a>
					  </div>
					</div>			
				<!-- Warning Modal -->
					<div id="warningModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					  <div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h3 id="myModalLabel">删除组织机构</h3>
					  </div>
					  <div class="modal-body">
						<p>删除组织机构会删除该组织内所有用户的组织机构信息。确认继续删除吗？</p>
					  </div>
					  <div class="modal-footer">
						
						<button id="deleteOrgbtn" value=" " class="btn btn-danger" onClick="deletOrgSubmit()">删除</button>
						<button class="btn" data-dismiss="modal" aria-hidden="true" >关闭</button>
					  </div>
					</div> 
					
					<div id="modifySubGroup" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					  <div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h3 id="myModalLabel">修改组织结构信息</h3>
					  </div>
					  <div class="modal-body">
							<div class="control-group">
								<label class="control-label">组织机构名称</label>
								<div class="controls">		
									<input style="width:520px" id="modifyInput" type="text" placeholder="组织机构名称" value ="" >					
								</div>									
							</div>
							<div class="control-group">
								<label class="control-label">组织机构描述</label>
								<div class="controls">
									<textarea style="width:520px" class="span12" id="modifyDespInput" rows="3"></textarea>					
								</div>									
							</div>
					  </div>
					  <div class="modal-footer">
					  		<button class="btn btn-primary" onclick="modityOrgSubmit()" id="modifySubOrgSubmit" value="">提交</button>
							<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
						
					  </div>
					</div>		
					
					
					<div id="showMemModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					  <div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h3 id="myModalLabel">查看组织成员</h3>
					  </div>
					  <div class="modal-body">
							<select multiple="multiple" style="width:520px"
							id="userList">
							  <option>1</option>
							  <option>2</option>
							  <option>3</option>
							  <option>4</option>
							  <option>5</option>
							</select>
							
					  </div>
					  <div class="modal-footer">				  	
							<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
						
					  </div>
					</div>	
				</body>
</html>
