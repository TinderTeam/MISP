<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
 
		<div class="container-fluid">		
			<div class="row-fluid">
					
		 <table class="table table-striped table-bordered table-hover table-condensed">
       
             <thead>
                <tr>
                    <th>功能名称</th>
                    <th>功能描述</th>
 					<th style="width:60px">操作</th>
                </tr>
            </thead>
            <tbody>
               <c:forEach var="function" items="${functionList}"> 						 
				  <tr>
                    <td  style="text-align:center" >${function.functionName}</td>
                    <td  style="text-align:center" >${function.functionDesp}</td>
          
                    <td  style="text-align:center">
  						<span class="icon" ><a class="tip-bottom" href="groupManage!deleteFunction.action?selectedID=${userGroup.groupID}&operateType=delete" title="删除"><i class="icon-remove"></i></a></span>
                    </td>		
                  </tr>   
						 
				</c:forEach>
         
            </tbody>
        </table>
        	<a class="btn btn-primary offset10"  href="groupManage!show.action?selectedID=${userGroup.groupID}&operateType=create">新增</a>	
									</div>
									
							</div>		
			 
				
