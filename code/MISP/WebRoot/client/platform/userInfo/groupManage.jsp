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
								<h5>选中的权限组：</h5>
								<p class="text-info">选中的权限组</p>
								<h5>权限组列表</h5>
								<select multiple="multiple" style="height:320px">
								  <option>管理员</option>
								  <option>业务部</option>
								  <option>市场部</option>
								  <option>|4</option>
								  <option>5</option>
								</select>
								
								<HR>
								<div >
								  <button type="submit" class="btn btn-primary">查询</button>
								  <button type="btn tip-top" class="btn btn-primary tip-top" data-original-title="删除组织机构后会保留涉及用户的其他权限信息">删除</button> 
								  <a href="#myAlert" data-toggle="modal" class="btn btn-primary">新增</a>
								  
								  
								  
									<div id="myAlert" class="modal hide">
										<div class="modal-header">
											<button data-dismiss="modal" class="close" type="button">×</button>
											<h3>新增权限组</h3>
										</div>
										<div class="modal-body">
											
												
														<div class="control-group">
															<h5>新权限组名称</h5>
															<input type="text" name="newAssetsName" class="span12"/>
														</div>
														<p>新建完成后请通过查询权限组功能进行权限修改</p>										
															
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
									
									<h5>权限组详细信息</h5>
										<HR>
											<h6>权限组名称</h6>									
												<div class="control-group">
													<div class="controls">
														
														<input type="text" name="newAssetsName" class="span12"  placeholder="权限组名称"/>									
													</div>									
												</div>
										<HR>
										
								
											<h6>权限组成员</h6>		
											<p>共6个成员</p>
											<div class="control-group">
													<div class="controls">
														
													<select multiple="multiple" style="height:120px">
													  <option>管理员</option>
													  <option>业务部</option>
													  <option>市场部</option>
													  <option>|4</option>
													  <option>5</option>
													</select>	
												</div>									
												</div>
											<button type="submit" class="btn btn-primary" name ="submit" value="addNew">删除成员</button>
											<a href="#modifyAlert" data-toggle="modal" class="btn btn-primary">新增成员</a>
								  
								  
								  
									<div id="modifyAlert" class="modal hide">
											<div class="modal-header">
												<button data-dismiss="modal" class="close" type="button">×</button>
												<h3>新增权限组成员</h3>
											</div>
											<div class="modal-body">

												<div class="control-group">
													<h6>查询新增权限组成员</h6>	
														<input type="text" name="newAssetsName" class="span12"  placeholder="这里改成Bootstrap的Search的组件"/>			
														<div class="control-group">
															<h5>筛选结果</h5>
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
