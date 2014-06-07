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
								<h5>选中的组织：</h5>
								<div class="well">
									<p  class="text-success"><strong id="selectedOrg">未选择组织机构</strong></p>
								</div>
							
								<h5>组织机构树：</h5>
								
								
									<div class="tree well">
										<c:set var="orgItem" value="${orgManageModel.orgList}" scope="request"/>
										<jsp:include page="cbb/orgTree.jsp"/>
									</div>
								
								<HR>
								<div >
							
								  <input type="button" class="btn btn-primary tip-top" 
								  onClick="serachOrg()" value="查询" data-original-title="点击查询在右侧显示组织详细信息"/>
								  <button type="btn tip-top" class="btn btn-primary tip-top" data-original-title="删除组织机构后会删除组织机构下属所有机构及用户归属信息">删除</button> 
								  <a href="#myAlert" data-toggle="modal" class="btn btn-primary">新增机构/用户</a>
								  
								  
								  
									<div id="myAlert" class="modal hide">
										<div class="modal-header">
											<button data-dismiss="modal" class="close" type="button">×</button>
											<h3>新增组织机构或用户</h3>
										</div>
										<div class="modal-body">
											<div class="widget-box">
												<div class="widget-title">
													<ul class="nav nav-tabs">
														<li class="active"><a data-toggle="tab" href="#tab1">组织机构</a></li>
														<li><a data-toggle="tab" href="#tab2">用户</a></li>											
													</ul>
												</div>
												<div class="widget-content tab-content">
													<div id="tab1" class="tab-pane active">
														<div class="control-group">
															<h5>新组织机构名</h5>
															<input type="text" name="newAssetsName" class="span12"/>														</div>
															<h6>组织机构描述</h6>		
							
														

															<input type="text" name="newAssetsName" class="span12"/>																																			
															
															</div>	

													<div id="tab2" class="tab-pane">
														<h6>选择需要加入的用户</h6>		
														<div class="control-group">
															<h5>选择未分配组织机构的用户：</h5>
															<select multiple="multiple" style="height:100px"  class="span12">
																<c:forEach var="userModel" items="${orgManageModel.noOrgUserList}">	
																<option>${userModel.userID}</option>													
																</c:forEach>
															</select>
														</div>													</div>	
														
													</div>                            
												</div>

	
											</div>
											<div class="modal-footer">
													
												<button type="submit" class="btn btn-primary" name ="submit" value="addNew">添加</button>
												<a data-dismiss="modal" class="btn" href="#">返回</a>
											</div>
										</div>
								  
								  
								  
								</div>	
							</div>		
						 </div>	 
						 
						 <div class="span7"> 
								<div class="well">	
									
									<h5>组织机构详细信息</h5>
										<HR>
											<h6>组织机构名称	</h6>									
												<div class="control-group">
													<div class="controls">
														<s:textfield id="orgInfoName" type="text" class="login_input" name="" placeholder="组织机构名称"/>												
													</div>									
												</div>
										<HR>
							
											<h6>隶属关系</h6>		
												<strong id = "beloneInfo"></strong>					
												<p id = "beloneInfoContent"></p>
												
												
												
												  <a id="modifyOrgBelone" href="#modifyAlert" data-toggle="modal" class="btn btn-primary">修改</a>
								  
								  
								  
									<div id="modifyAlert" class="modal hide">
											<div class="modal-header">
												<button data-dismiss="modal" class="close" type="button">×</button>
												<h3>调整组织机构隶属关系</h3>
											</div>
											<div class="modal-body">
												<div class="control-group">
													<h6>调整"<strong id="modal_orgName1"></strong>"隶属关系</h6>	
														<div class="well">	
															<label class="control-label">隶属关系调整后，部门内子机构的隶属关系一并调整。</label>											
														</div>			
														<div class="control-group">
															<h5>选择"<strong id="modal_orgName2"></strong>"部门的上属部门</h5>
															<select id="selectUpOrg" multiple="multiple" style="height:100px"  class="span12">
																<c:set var="orgAllItem" value="${orgManageModel.orgList}" scope="request"/>
																<jsp:include page="cbb/orgList.jsp"/>
															</select>
														</div>
													
												</div>
	
											</div>
											<div class="modal-footer">
													
												 <input type="button" class="btn btn-primary" onClick="changeOrgBelone()" value="调整" />
												<a data-dismiss="modal" class="btn" href="#">返回</a>
											</div>
										</div>
								  
								  
												
												
																		
										<HR>
							
							
								<h6>统计信息</h6>		
							
										<div class="well">	
												<label class="control-label" id="staticInfo"></label>											
										</div>
											
							
							
							
									<input type="button" class="btn btn-primary" onClick="ensureModify()" value="确认修改" />
									<input type="button" class="btn btn-primary" onClick="cancelModify()" value="取消修改" />
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
