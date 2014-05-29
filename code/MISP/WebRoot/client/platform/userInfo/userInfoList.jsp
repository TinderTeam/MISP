<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
                     <th>用户名</th>  
                    <c:forEach var="attrName" varStatus="iterStatus" items="${userManage.extAttrNameList}"> 						 
					   <th>${attrName}</th>   
					</c:forEach>
                </tr>
            </thead>
            <tbody>
               <c:forEach var="userInfo" items="${userManage.userList.currentPageData}"> 						 
				  <tr>
                    <td>${userInfo.userID}</td>
                    <c:forEach var="attr" items="${userInfo.attrList}"> 
                      <td>${attr.attrValue}</td>
                    </c:forEach>
                  </tr>   
						 
				</c:forEach>
         
            </tbody>
        </table>
    </div>
</div>
	</div>
</div>
