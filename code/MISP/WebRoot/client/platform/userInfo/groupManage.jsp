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
		<script src="<%=request.getContextPath()%>/client/platform/userInfo/js/onManage.js"></script>
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
					
						<div class="span5"> 
							<div class="well">
								<h5>选中的权限：</h5>
								<div class="well">
									<p  class="text-success"><strong id="selectedOrg">未选择权限组</strong></p>
								</div>
						        <form class="form-search">
  									<input type="text" class="input-medium search-query">
  									<button type="submit" class="btn">Search</button>
								</form>	
								<h5>权限树：</h5>
								<select multiple="multiple">
  									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
									<option>5</option>
								</select>

								
								<HR>
								<div >
							
								  <input type="button" class="btn btn-primary tip-top" 
								  onClick="serachOrg()" value="显示详细信息" data-original-title="点击查询在右侧显示组织详细信息"/>
								  <button type="btn tip-top" class="btn btn-primary tip-top" data-original-title="删除组织机构后会删除组织机构下属所有机构及用户归属信息">删除</button> 
								  <a href="#addGroupModal" data-toggle="modal" class="btn btn-primary">新增</a>
								  
								  
								  
									<div id="addGroupModal" class="modal hide">
										<div class="modal-header">
											<button data-dismiss="modal" class="close" type="button">×</button>
											<h3>增加权限组</h3>
										</div>
										<div class="modal-body">
											<h6>新权限组名称:</h6>									
											<input type="text" name="新权限组名称" class="span12"/>
											<h6>新建完成后请通过查询该权限组进行修改</h6>
	
										</div>
										<div class="modal-footer">
													
												<button type="submit" class="btn btn-primary" name ="submit" value="addNew">增加</button>
												<a data-dismiss="modal" class="btn" href="#">取消</a>
										</div>
									</div>
								  
								  
								  
								</div>	
							</div>		
						 </div>	 
						 
						 <div class="span7"> 
								<div class="well">	
									
									<h5>权限组详细信息</h5>
										<HR>
											<h6>权限组名称	</h6>									
												<div class="control-group">
													<div class="controls">
														<s:textfield id="orgInfoName" type="text" class="login_input" name="" placeholder="权限组名称"/>												
													</div>									
												</div>
											<h6>权限组成员	</h6>									
												<select multiple="multiple">
													<option>1</option>
													<option>2</option>
													<option>3</option>
													<option>4</option>
													<option>5</option>
												</select>
												
											
								  			<input type="button" class="btn btn-primary" value="删除"></input> 
								  			<a href="#addMumberModal" data-toggle="modal" class="btn btn-primary">新增</a>
												<div id="addMumberModal" class="modal hide">
													<div class="modal-header">
														<button data-dismiss="modal" class="close" type="button">×</button>
														<h3>增加权限组成员</h3>
													</div>
												    <HR>
													<div class="modal-body">
													<select multiple="multiple" class="span12">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
													</select>
													</div>
													<HR>
													<div class="modal-footer">
																	
														<button type="submit" class="btn btn-primary" name ="submit" value="addNew">增加</button>
														<a data-dismiss="modal" class="btn" href="#">取消</a>
													</div>
												</div>
												
												
												
								  			<h6>权限选择	</h6>
								  				<label class="checkbox">
  												<input type="checkbox" value="">
  													系统配置
												</label>	
												<label class="checkbox inline">
												  <input type="checkbox" id="inlineCheckbox1" value="option1"> 用户管理
												</label>
												<label class="checkbox inline">
												  <input type="checkbox" id="inlineCheckbox2" value="option2"> 组织机构管理
												</label>
												<label class="checkbox inline">
												  <input type="checkbox" id="inlineCheckbox3" value="option3"> 权限组管理
												</label>
												<HR>
												<label class="checkbox">
  												<input type="checkbox" value="">
  													个人设置
												</label>	
												<label class="checkbox inline">
												  <input type="checkbox" id="inlineCheckbox1" value="option1"> 密码修改
												</label>
												
												<HR>
												<label class="checkbox">
  												<input type="checkbox" value="">
  													功能模块
												</label>	
												<label class="checkbox inline">
												  <input type="checkbox" id="inlineCheckbox1" value="option1"> 权限控制点1
												</label>
												</label>	
												<label class="checkbox inline">
												  <input type="checkbox" id="inlineCheckbox1" value="option1"> 权限控制点2
												</label>
												<HR>
											<div class="control-group">
													<div class="controls">
													<input type="button" class="btn btn-primary" onClick="ensureModify()" value="确认修改" />
													<input type="button" class="btn btn-primary" onClick="cancelModify()" value="取消修改" />		
													</div>									
												</div>	
											
													
											</div>
							
									
									</div>	
							</div>		
						</div>	
				
					<!----内容页完---->
					<!----尾部声明---->
				<jsp:include page="../cbb/footer.jsp"/>
		   </div>
	</div>

</body>
</html>
