<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


    <head>
  
        <jsp:include page="../framework/cbb/head.jsp"/>		
        <jsp:include page="../framework/cbb/js.jsp"/>


<script type="text/javascript">
//�ж�������Ƿ�֧�� placeholder����
function isPlaceholder(){
	var input = document.createElement('input');
	return 'placeholder' in input;
}

if (!isPlaceholder()) {//��֧��placeholder ��jquery�����
	$(document).ready(function() {
	    if(!isPlaceholder()){
	        $("input").not("input[type='password']").each(//��input���¼� �ų�password��
	            function(){
	                if($(this).val()=="" && $(this).attr("placeholder")!=""){
	                    $(this).val($(this).attr("placeholder"));
	                    $(this).focus(function(){
	                        if($(this).val()==$(this).attr("placeholder")) $(this).val("");
	                    });
	                    $(this).blur(function(){
	                        if($(this).val()=="") $(this).val($(this).attr("placeholder"));
	                    });
	                }
	        });
	       
	        var pwdField	= $("input[type=password]");
	        var pwdVal		= pwdField.attr('placeholder');
	        pwdField.after('<input id="pwdPlaceholder" type="text" value='+pwdVal+' autocomplete="off" />');
	        var pwdPlaceholder = $('#pwdPlaceholder');
	        pwdPlaceholder.show();
	        pwdField.hide();
	        
	        pwdPlaceholder.focus(function(){
	        	pwdPlaceholder.hide();
	        	pwdField.show();
	        	pwdField.focus();
	        });
	        
	        pwdField.blur(function(){
	        	if(pwdField.val() == '') {
	        		pwdPlaceholder.show();
	        		pwdField.hide();
	        	}
	        });
	        
	    }
	});
	
}
</script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>

    <body>
		<div class="container background="<%=request.getContextPath()%>/client/framework/img/logo.png">
			<div id="logo">
				<img src="<%=request.getContextPath()%>/client/framework/img/logo.png"/>
			</div>
			<div id="loginbox">            
				<s:form action="login/login" method="POST">	
			
					<p style="color:red" >${message} 请登录</p>
					<div class="control-group">
						<div class="controls">
							<div class="input-prepend">
								<span class="add-on"><i class="icon-user"></i></span>
								<s:textfield type="text" class="login_input" name="user.userID" placeholder="请输入您的用户名"/> 
							</div>
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<div class="input-prepend">
								<span class="add-on"><i class="icon-lock"></i></span>
							  <s:password  type="password" class="login_input" name="user.password" placeholder="请输入您的密码" />
							</div>
						</div>
					</div>
					
					<div class="form-actions">
					   <!-- <span class="pull-left"><a href="#" class="flip-link"  onClick="javascript:alert('1');">忘记密码？</a></span>
						 -->  
						<span class="pull-right"><input type="submit" name="submit" class="btn btn-success" value="登陆" /></span>
					</div>
	
				
				</s:form>
			</div>
        </div>

    </body>
</html>
