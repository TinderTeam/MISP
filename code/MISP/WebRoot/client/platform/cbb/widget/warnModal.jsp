<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<script src="<%=request.getContextPath()%>/client/platform/cbb/widget/warnModal.js"></script>
<div id="WarningModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true"><i class="icon-remove"></i></button>
			<h3 id="ModalTitle"></h3>
		</div>
		
		<div class="modal-body">
			<p id="WarningText"></p>
		</div>
		
		<div class="modal-footer">				  	
			
			<a id="ConformBtn" class="btn btn-danger" href="">确认</a>
			<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
		</div>
	</div>