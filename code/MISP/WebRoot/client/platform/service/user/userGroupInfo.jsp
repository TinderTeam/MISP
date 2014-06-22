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
					
 					<div class="container-fluid">		
						<div class="row-fluid">
										
							 <table class="table table-striped table-bordered table-hover table-condensed">
					       
					             <thead>
					                <tr>
					                    <th>功能名称</th>
					                    <th>功能描述</th>
					 					<th style="width:60px">操作</th>
					                </tr>
					            </thead>
					            <tbody>
					               <c:forEach var="function" items="${groupManage.userGroup.functionList}"> 						 
									  <tr>
					                    <td  style="text-align:center" >${function.functionName}</td>
					                    <td  style="text-align:center" >${function.functionDesp}</td>
					          
					                    <td  style="text-align:center">
					  						<span class="icon" ><a class="tip-bottom" href="groupManage!deleteFunction.action?selectedID=${userGroup.groupID}&operateType=delete" title="删除"><i class="icon-remove"></i></a></span>
					                    </td>		
					                  </tr>   
											 
									</c:forEach>
					         
					            </tbody>
					        </table>
        	         <a class="btn btn-primary offset10"  href="groupManage!show.action?selectedID=${userGroup.groupID}&operateType=create">新增</a>	
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


