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
	        							<s:text name="用户组名称" />
	        						</div>
					                 <div class="controls">
					                    <s:textfield name="groupManage.userGroup.groupName" readonly="true"/>					                       
									 </div>
								</div>
								<div class="control-group">
	       							<div class="control-label">
	        							<s:text name="用户组描述"/>
	        						</div>
					                 <div class="controls">
					                    <s:textfield name="groupManage.userGroup.groupDesp" readonly="true"/>					                       
									 </div>
								</div>
		 				 		 
	                 	 
		                   	 </div>

					</div>
 
 									</div>
				 
					<div class="container-fluid">			
                     
                     <c:set var="userList" value="${groupManage.userGroup.userList}" scope="request"/>
                     <c:set var="tableExtAttrNameList" value="${groupManage.userGroup.tableExtAttrNameList}" scope="request"/>
                     <c:set var="pageButtonControl" value="userGroupInfo" scope="request"/>	  
		        	 <jsp:include page="./userInfoList.jsp"/>	
		             <a href="#myAlert" data-toggle="modal" class="btn btn-primary" style="width:60px">新增</a>
		             <input class="btn btn-primary" type="submit"  name="cancel"  class="btn btn-success" value="取消"/>
		             
								<div id="myAlert"  class="modal hide" >
										<div class="modal-header">
											<button data-dismiss="modal" class="close" type="button">×</button>
											<h3>添加用户</h3>
										</div>
										<div class="modal-body">
										    <c:set var="userList" value="${groupManage.userList}" scope="request"/>
                                            <c:set var="tableExtAttrNameList" value="${groupManage.userGroup.tableExtAttrNameList}" scope="request"/>
                                            <c:set var="pageButtonControl" value="userGroupInfo" scope="request"/>	  
		        	                        <jsp:include page="./userInfoList.jsp"/>	
										</div>
										<div class="modal-footer">
											<s:submit cssClass="btn btn-primary" name="addMember" value="新增" method="addMember"/>	
 											<a data-dismiss="modal" class="btn" href="#">取消</a>
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


