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
					<s:form action="orgManage/orgManage" method="POST">			
						<div class="span3"> 
							<div class="well">
								<h5>选中的组织：</h5>
								<p class="text-info">选中的组织机构</p>
								<h5>组织机构树：</h5>
								<select multiple="multiple" style="height:320px">
								  <option>+深圳市孚思科技有限公司</option>
								  <option>|-业务部</option>
								  <option>+ 市场部</option>
								  <option>  |4</option>
								  <option>5</option>
								</select>
								
								<HR>
								<div >
								  <button type="submit" class="btn btn-primary">查询</button>
								  <button type="btn tip-top" class="btn btn-primary tip-top" data-original-title="删除组织机构后会删除组织机构下属所有机构及用户归属信息">删除</button> 
								  <a href="#myAlert" data-toggle="modal" class="btn btn-primary">新增</a>
								  
								  
								  
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
															<input type="text" name="newAssetsName" class="span12"/>
														</div>
															<h6>组织机构描述</h6>		
							
															<div class="well">	
																	<label class="control-label">某某组织机构是.....</label>											
															</div>												
															
															</div>	
													<div id="tab2" class="tab-pane">
														<h6>选择需要加入到XXXX的用户</h6>		
														<div class="control-group">
															<h5>选择未分配组织机构的用户：</h5>
															<select multiple="multiple" style="height:100px"  class="span12">
																<option>用户2</option>
																<option>用户1</option>
															</select>
														</div>
													</div>	
														
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
						 
						 <div class="span9"> 
								<div class="well">	
									
									<h5>组织机构详细信息</h5>
										<HR>
											<h6>组织机构名称	</h6>									
												<div class="control-group">
													<div class="controls">
														<s:textfield type="text" class="login_input" name="user.userID" placeholder="组织机构名称"/>												
													</div>									
												</div>
										<HR>
							
											<h6>隶属关系</h6>		
																		
												<div class="control-group">
													<ul class="breadcrumb">
													  <li>选中的组织机构 <strong>隶属于</strong></span></li>
													  <li>深圳孚思科技有限公司<span class="divider">-</span></li>
													  <li>市场开发部<span class="divider">-</span></li>
													  <li>营销组</li>
													 
													</ul>
												</div>
												
												
												
												  <a href="#modifyAlert" data-toggle="modal" class="btn btn-primary">修改</a>
								  
								  
								  
									<div id="modifyAlert" class="modal hide">
											<div class="modal-header">
												<button data-dismiss="modal" class="close" type="button">×</button>
												<h3>调整组织机构隶属关系</h3>
											</div>
											<div class="modal-body">
												<div class="control-group">
													<h6>调整XXXX部门的隶属关系</h6>	
														<div class="well">	
															<label class="control-label">隶属关系调整后，部门内子机构的隶属关系一并调整。调整后某某部门将属于某某部门.....</label>											
														</div>			
														<div class="control-group">
															<h5>选择某某部门的上属部门</h5>
															<select multiple="multiple" style="height:100px"  class="span12">
																<option>部门2</option>
																<option>部门1</option>
															</select>
														</div>
													
												</div>
	
											</div>
											<div class="modal-footer">
													
												<button type="submit" class="btn btn-primary" name ="submit" value="addNew">调整</button>
												<a data-dismiss="modal" class="btn" href="#">返回</a>
											</div>
										</div>
								  
								  
												
												
																		
										<HR>
							
							
								<h6>统计信息</h6>		
							
										<div class="well">	
												<label class="control-label">子机构2个，成员用户2个</label>											
										</div>
											
							
							
							
								  <button type="submit" class="btn btn-primary">确认修改</button>
								  <button type="button" class="btn btn-primary">取消修改</button>
								
									</div>	
							</div>		
						</div>	
					</s:form> 	 
					<!----内容页完---->
					<!----尾部声明---->
				<jsp:include page="../cbb/footer.jsp"/>
		   </div>
	</div>

</body>
</html>
