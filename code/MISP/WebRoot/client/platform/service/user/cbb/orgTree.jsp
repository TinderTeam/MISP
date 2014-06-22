<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>

<ul>
	
		<c:forEach var="org" items="${orgList}">
		<li>	
			<c:set var="icon" value="icon-minus-sign" scope="request"/>
			<c:if test="${null != org.subOrgList}">
				<c:set var="icon" value="icon-th-large" scope="request"/>
			</c:if>
			<span><i class="${icon}"></i>${org.orgName}</span>
					<a id="${org.orgID}" class="tip-bottom" href="javascript:void(0);" title="创建组织机构" onclick="addSubModal(this.id)"><i class="icon-plus"></i></a>
					<a id="test" class="tip-bottom" href="javascript:void(0);" title="查询成员" onclick="showMemModal(this.id)"><i class="icon-user"></i></a>
					<a id="${org.orgID}" class="tip-bottom" href="javascript:void(0);" title="编辑" onclick="modifySubModal(this.id)"><i class="icon-pencil"></i></a>
					<a id="${org.orgID}" class="tip-bottom" href="javascript:void(0);" title="删除" onclick="deleteSubModal(this.id)"><i class="icon-remove"></i></a>
			<c:if test="${null != org.subOrgList}"> 
						<!------>
						<c:set var="orgList" value="${org.subOrgList}" scope="request"/>
						<jsp:include page="orgTree.jsp"/>
						<!----  --->
			</c:if>
			
		</li>	
		</c:forEach>		
						
</ul>
