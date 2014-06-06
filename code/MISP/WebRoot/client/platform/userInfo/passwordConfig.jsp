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
					<div class="span12"> 
						<div class="widget-box">
							<div class="widget-title">
								<span class="icon">
									<i class="icon-th"></i>
								</span>
								<h5>密码修改</h5>
							</div>
						<s:form action="userInfo/passwordConfig" method="POST">	
							<div class="widget-content nopadding">	
								<div class="form-horizontal">
									<div class="control-group">
										<label class="control-label">请输入原密码</label>
									
										<div class="controls">
												<s:password  type="password" name="oldPassword" placeholder="请输入原密码" />
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">请输入新密码</label>
										<div class="controls">
											<s:password  type="password" name="newPassword" placeholder="请输入新密码" />
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">请再次输入新密码</label>
										<div class="controls">
											<s:password  type="password" name="confirmPassword" placeholder="请再次输入新密码" />
										</div>
									</div>
									
									<div class="form-actions">
										<input type="submit" name="submit" class="btn btn-success" value="提交" />
										<input type="submit" name="submit" class="btn btn-success" value="取消" />
										<p  style="color:red" >${errorMsg}</p>
									</div>
								</div>
							</div>					
							</s:form>
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
