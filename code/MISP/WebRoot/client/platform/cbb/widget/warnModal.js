

function warnModal(title,msg,url){	
		document.getElementById("WarningText").innerHTML=msg;
		document.getElementById("ConformBtn").href=url;
		document.getElementById("ModalTitle").innerHTML=title;
		$('#WarningModal').modal('show');
}