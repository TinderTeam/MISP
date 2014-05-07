<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<h2 class="contentTitle">个人设置</h2>

<div class="pageContent">
	<div class="tabs" currentIndex="1" eventType="click">
		<div class="tabsHeader">
			<div class="tabsHeaderContent">
				<ul>
					<li><a href="javascript:;"><span>个人信息</span></a></li>
					<li><a href="javascript:;"><span>密码修改</span></a></li>
				
				</ul>
			</div>
		</div>
		<div class="tabsContent" >
			<div>
				
				<div class="pageForm required-validate">
					<div class="pageFormContent nowrap">
						<dl>
							<dt>必填：</dt>
							<dd>
								<input type="text" name="name" maxlength="20" class="required" />
							
							</dd>
						</dl>
						<dl>
							<dt>必填+邮箱：</dt>
							<dd>
								<input type="text" name="email" class="required email" alt="请输入您的电子邮件"/>
								
							</dd>
						</dl>
						<dl>
							<dt>电话：</dt>
							<dd>
								<input type="text" name="phone" class="phone" alt="请输入您的电话"/>
								
							</dd>
						</dl>
					
					<dl>
							<dt>必填：</dt>
							<dd>
								<input type="text" name="name" maxlength="20" class="required" />
							
							</dd>
						</dl>
						<dl>
							<dt>必填+邮箱：</dt>
							<dd>
								<input type="text" name="email" class="required email" alt="请输入您的电子邮件"/>
								
							</dd>
						</dl>
						<dl>
							<dt>电话：</dt>
							<dd>
								<input type="text" name="phone" class="phone" alt="请输入您的电话"/>
								
							</dd>
						</dl>
						<dl>
							<dt>必填：</dt>
							<dd>
								<input type="text" name="name" maxlength="20" class="required" />
							
							</dd>
						</dl>
						<dl>
							<dt>必填+邮箱：</dt>
							<dd>
								<input type="text" name="email" class="required email" alt="请输入您的电子邮件"/>
								
							</dd>
						</dl>
						<dl>
							<dt>电话：</dt>
							<dd>
								<input type="text" name="phone" class="phone" alt="请输入您的电话"/>
								
							</dd>
						</dl>
						<div class="divider"></div>
				
					</div>
					<div class="formBar">
						<ul>
							<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
							<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
						</ul>
					</div>
				</div>
	
			</div>
			<div>
				<div class="pageForm required-validate">
					<div class="pageFormContent nowrap">
						<dl>
							<dt>旧密码</dt>
							<dd>
								<input type="text" name="lastPswd" maxlength="20" class="required"  alt="请输入您的原密码"/>							
							</dd>
						</dl>
						<dl>
							<dt>新密码</dt>
							<dd>
								<input type="text" name="newPswd" class="required " alt="请输入您的新密码"/>
								
							</dd>
						</dl>
						<dl>
							<dt>再次输入新密码</dt>
							<dd>
								<input type="text" name="confirmPswd" class="required" alt="请再次输入您的新密码"/>
								
							</dd>
						</dl>
						<!---分割线，
							<div class="divider"></div>
						暂不需要-->
					</div>
					<div class="formBar">
						<ul>
							<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
							<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="tabsFooter">
			<div class="tabsFooterContent"></div>
		</div>
	</div>
	
	<p>&nbsp;</p>
	
</div>

<script type="text/javascript">
function customvalidXxx(element){
	if ($(element).val() == "xxx") return false;
	return true;
}
</script>