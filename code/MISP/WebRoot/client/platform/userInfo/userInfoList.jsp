<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="row-fluid">
    <div class="span12"> 
<div class="widget-box">
    <div class="widget-title">
		<span class="icon">
			<i class="icon-th"></i>
		</span>
        <h5>Static table</h5>
    </div>
    <div class="widget-content nopadding">
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th><s:text name="USER_ID"></s:text></th>  
                    <c:forEach var="attrName"   items="${userInfo.extAttrNameList}"> 						 
					   <th>${attrName}</th>   
					</c:forEach>
					<th>修改</th>
					<th>删除</th>
                </tr>
            </thead>
            <tbody>
               <c:forEach var="user" items="${userInfo.userList.currentPageData}"> 						 
				  <tr>
                    <td>${user.userID}</td>
                    <c:forEach var="attr" items="${user.attrList}"> 
                      <td>${attr.attrValue}</td>
                    </c:forEach>
                    <td><a href="<%=request.getContextPath()%>/QueryTransOperInfo.do?userID=${user.userID}">修改</a></td>
					<td><a href="<%=request.getContextPath()%>/Index.do?userID=${user.userID}">删除</a></td>
                  </tr>   
						 
				</c:forEach>
         
            </tbody>
        </table>
    </div>
</div>
	</div>
</div>
