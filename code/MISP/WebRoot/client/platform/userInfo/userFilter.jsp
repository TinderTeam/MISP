<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="row-fluid">
	<s:form action="user/userManage" method="POST" theme="simple">	
	<div class="span12">
		<div class="widget-box">
		  <div class="widget-title">
				<span class="icon">
					<i class="icon-th"></i>
				</span>
		        <h5>筛选条件</h5>
		    </div>
			<div class="form-horizontal" >
				<div class="widget-content nopadding">
						<table class="table table-striped table-bordered table-hover table-condensed">
							<thead>
								<tr>
				                    <th><s:text  name="USER_ID"/></th>
						           <s:iterator value="userManage.filter.filterAttrNameList" status="status">
				                   		<th><s:text   name="userManage.filter.filterAttrNameList.get(#status.index)"></s:text ></th>
				                   	</s:iterator>
								</tr>	
						 	</thead>	
							<tbody>
			             		<tr>
			             			<td style="text-align:center"><s:textfield name="userManage.filter.userID"/></td>
			  
			             			<s:iterator value="userManage.filter.filterAttrNameList" status="status">
				                   		<td style="text-align:center">
					                   		<s:textfield name="userManage.filter.attrList[%{#status.index}].attrValue" value="%{userManage.filter.attrList[#status.index].attrValue}"/>
											<s:hidden name="userManage.filter.attrList[%{#status.index}].attrName"  value="%{userManage.filter.attrList[#status.index].attrName}"/>
				                   		</td>
				                   	</s:iterator>
							 	</tr>
							</tbody>
				
						</table>
						
								
					
					
				</div>
			</div>	  
			
	
		</div>
		
		<button type="submit" class="btn btn-primary offset10">查询</button>
	</div>
	</s:form>
</div>

