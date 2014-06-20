<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<jsp:include page="../cbb/head.jsp"/>
		<jsp:include page="../cbb/js.jsp"/>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
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
	<div class="row-fluid">
		<div class="span12">
	    	<div class="widget-box">
				<div class="widget-title">
					<span class="icon">
						<i class="icon-th"></i>
					</span>
		       		<h5>用户信息</h5>
		   		</div>

 
   					<div class="widget-content nopadding">	
       					<s:form action="user/userManage" method="POST" theme="simple">	
	       					<div class="form-horizontal">
	       						<div class="control-group">
	       							<div class="control-label">
	        							<s:text name="USER_ID"/>
	        						</div>
					                 <div class="controls">
					                    <c:if test="${'create' == operateType}">
					                      <s:textfield name="userManage.user.userID"/>
					                    </c:if>
					                    <c:if test="${'modify' == operateType}">
					                      <s:textfield name="userManage.user.userID" readonly="true"/>
					                    </c:if>  
									 </div>
								</div>
		 				 		<s:iterator value="userManage.extAttrNameList" status="status">
			 				 		<div class="control-group">
			 				 			<div class="control-label">
							 				<s:label name="userManage.extAttrNameList.get(#status.index)"></s:label>
							 			</div>
							   			<s:hidden name="userManage.user.attrList[%{#status.index}].attrName"  value="%{userManage.user.attrList[#status.index].attrName}"/>
						                <div class="controls">
			                           		<s:textfield name="userManage.user.attrList[%{#status.index}].attrValue" value="%{userManage.user.attrList[#status.index].attrValue}"/>
			 				   			</div>
			 				   		</div>
		                		</s:iterator>
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
				<jsp:include page="../cbb/footer.jsp"/>
		   </div>
	</div>
	
</body>
</html>


