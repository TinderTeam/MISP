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
		  <div id="content-header">
			<h1>${page_pageName}</h1>
		  </div>
		  <!---面包屑导航---->
		  
<div class="row-fluid">
  <div class="span12">
    <div class="widget-box">
      <div class="widget-title">
        <ul class="nav nav-tabs">
          <li class="active"><a data-toggle="tab" href="#tab1">基本资料</a></li>
          <li><a data-toggle="tab" href="#tab2">密码修改</a></li>
          <li><a data-toggle="tab" href="#tab3">其他信息</a></li>
        </ul>
      </div>
      <div class="widget-content tab-content ">
        <!---Tab1--->
        <div id="tab1" class="tab-pane active row-fluid">
        
        <s:form action="user/userManage" method="POST">	
        
          <div class="widget-content nopadding">
 				 
				 <s:text name="USER_ID"/>
                 <div class="controls">
                    <c:if test="${'create' == operateType}">
                      <s:textfield name="userManage.user.userID"/>
                    </c:if>
                    <c:if test="${'modify' == operateType}">
                      <s:textfield name="userManage.user.userID" readonly="true"/>
                    </c:if>  
                 
				 </div>
 				 <s:iterator value="userManage.extAttrNameList" status="status">
				 
 				 
				   <s:label name="userManage.extAttrNameList.get(#status.index)"></s:label>
				   <s:hidden name="userManage.user.attrList[%{#status.index}].attrName"  value="%{userManage.user.attrList[#status.index].attrName}"/>
				 
                   <div class="controls">
                           <s:textfield name="userManage.user.attrList[%{#status.index}].attrValue" value="%{userManage.user.attrList[#status.index].attrValue}"/>
 				   </div>
                 </s:iterator>
                 
				  <c:if test="${'create' == operateType}">
				        <s:submit name="create" value="新增" align="left" method="create"/>
                  </c:if>
                  <c:if test="${'modify' == operateType}">
                        <s:submit name="modify" value="修改" align="left" method="modify" /> 
                   </c:if> 
                        <s:submit name="cancel" value="取消" align="left" /> 
                  

 				  
			</div>	  
		</s:form>
				</div>
			   </div>
			  </div>
            </div>
        </div>
      </div>
      <!---Tab1--->
      <div id="tab2" class="tab-pane"> This is a Tab Two Content </div>
      <!----Tab3--->
      <div id="tab3" class="tab-pane"> </div>


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


