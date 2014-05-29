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
		
		<script type="text/javascript">
			  
			function loadInfo() {
		
				 $.ajax(
					  {
						  url:"ajaxDownloadDebug.action",
						  dataType:"html",
						  data:{},
						  success:function(strValue)
						  {
							 alert("收到数据："+strValue);						
							 test();				
						  }
					  }
			  	)
			}

		</script>
		<script type="text/javascript">
			function test() {
				var div = document.getElementById('btn_download'); 
				div.disabled=false;
			}
		</script>
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
				<div class="widget-content">
					<div class="control-group">
						<button  id ="btn_createdata" type="submit" class="btn btn-success" onclick="loadInfo()">生成数据</button>
						<button  id="btn_download" type="submit" class="btn btn-success" name="submit" value = "download" disabled="true">下载</button>																		
					</div>
				</div>		
					<!----内容页完---->
					<!----尾部声明---->
				<jsp:include page="../cbb/footer.jsp"/>
		   </div>
	</div>
	

</body>
</html>
