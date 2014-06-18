<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="row-fluid">
    <div class="span12"> 
<div class="widget-box">
    <div class="widget-content nopadding">
               <s:form action="user/userManage" method="POST">	
        
          <div class="widget-content nopadding">
 				 
                 <div class="controls">
                 	  <s:text name="USER_ID"/>
                      <s:textfield name="userManage.filter.userID"/>
                 
				 </div>
 				 <s:iterator value="userManage.filter.filterAttrNameList" status="status">
 	 

                   <div class="controls">
                           <s:label name="userManage.filter.filterAttrNameList.get(#status.index)"></s:label>
                           <s:textfield name="userManage.filter.attrList[%{#status.index}].attrValue" value="%{userManage.filter.attrList[#status.index].attrValue}"/>
                           
				           <s:hidden name="userManage.filter.attrList[%{#status.index}].attrName"  value="%{userManage.filter.attrList[#status.index].attrName}"/>
				 
 				   </div>
                 </s:iterator>
                 
				 
 				  <button type="submit" class="btn btn-primary">查询</button>
			</div>	  
		</s:form>
    </div>
</div>
	</div>
</div>
