<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<jsp:include page="../../cbb/head.jsp"/>
		<jsp:include page="../../cbb/js.jsp"/>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body>
<!-----标题栏----->
<jsp:include page="../../cbb/title.jsp"/>

<!---快捷信息操作栏---->
<jsp:include page="../../cbb/info.jsp"/>
<!---快捷操作栏---->
<!----菜单栏--->
<jsp:include page="../../cbb/menu.jsp"/>
<!----菜单栏--->
<!----内容栏--->
	<div id="content">
		  
		  <!---面包屑导航---->
		  <jsp:include page="../../cbb/bread.jsp"/>
		  <!---End 面包屑导航---->
	<div class="row-fluid">
		<div class="span12">
	    	<div class="widget-box">
				<div class="widget-title">
					<span class="icon">
						<i class="icon-th"></i>
					</span>
		       		<h5>用户信息</h5>
		   		</div>

             <s:form action="user/groupManage" method="POST" theme="simple">	
 
   					<div class="widget-content nopadding">	
	       					<div class="form-horizontal">
	       						<div class="control-group">
	       						    <s:hidden name="groupManage.userGroup.groupID"  value="%{groupManage.userGroup.groupID}"/>
	       						    
	       							<div class="control-label">
	        							<s:text name="用户组名称"/>
	        						</div>
					                 <div class="controls">
					                    <s:textfield name="groupManage.userGroup.groupName"/>					                       
									 </div>
								</div>
								<div class="control-group">
	       							<div class="control-label">
	        							<s:text name="用户组描述"/>
	        						</div>
					                 <div class="controls">
					                    <s:textfield name="groupManage.userGroup.groupDesp"/>					                       
									 </div>
								</div>
		 				 		 
	                 		
		                   	 </div>

					</div>
					
 					<div class="container-fluid">		
						<div class="row-fluid">
										
							 <div class="widget-content nopadding">
								<table class="table table-bordered table-striped">
									<thead>
										<tr>
											<th style="width:150px">
											  <label class="checkbox">
													<input type="checkbox" name="selectedIDList" > 模块
										      </label>  
										 
											</th>
											<th class="span12">功能</th>						
										</tr>
									</thead>
									<tbody>	
		                                <c:forEach var="parentMenu"   items="${groupManage.userGroup.menuTreeList}"> 						 
										<tr>
											<td>
												<label class="checkbox">
												    <c:if test="${parentMenu.menu.selected}">
												     <input type="checkbox"  checked="checked"  name="selectedIDList"  value="${parentMenu.menu.functionID}"/>${parentMenu.menu.value}
 												    </c:if>
												    <c:if test="${!parentMenu.menu.selected}">
												     <input type="checkbox"   name="selectedIDList"  value="${parentMenu.menu.functionID}"/>${parentMenu.menu.value}
 												    </c:if>
												</label>
											</td>
											<td>
												<div class="form-inline">
													<c:forEach var="menu"   items="${parentMenu.childMenuList}"> 						 
													  <label class="checkbox">
													   	  <c:if test="${menu.menu.selected}">													   
													       <input type="checkbox" checked="checked" name="selectedIDList"  value="${menu.menu.functionID}"/>${menu.menu.value}
													      </c:if> 
													      <c:if test="${!menu.menu.selected}">													   
													       <input type="checkbox" name="selectedIDList"  value="${menu.menu.functionID}"/>${menu.menu.value}
													      </c:if> 
 												 	  </label>
												    </c:forEach>
												</div>													
											</td>								
										</tr>	
									   </c:forEach>
										 
								 	
									</tbody>
								</table>  
							</div>
	                         <div class="form-actions">
		                 			<div class="offset10">
			                 			    <c:if test="${'create' == operateType}">
									       		<s:submit cssClass="btn btn-primary" name="create" value="新增" method="create"/>
					                  		</c:if>
					                  		<c:if test="${'modify' == operateType}">
					                       		
					                       		<s:submit cssClass="btn btn-primary" name="modify" value="修改" align="left" method="modify" />
					                   		</c:if> 
					               
					                       	<input class="btn btn-primary" type="submit"  name="cancel"  class="btn btn-success" value="取消"/>
		                 			</div>
			                    </div>							
			                 </div>
					</div>
		       </s:form>
			</div>
		</div>
    </div>
     
      
		</div>	
					
		  <!---End 面包屑导航---->
		  <!----内容页---->
		  <div class="container-fluid">
				
					<!----内容页完---->
					<!----尾部声明---->
				<jsp:include page="../../cbb/footer.jsp"/>
		   </div>
	</div>
	
</body>
</html>


