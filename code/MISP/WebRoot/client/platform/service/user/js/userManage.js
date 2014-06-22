

function warn(id,title,msg,url){	
		document.getElementById("WarningText").innerHTML=msg;
		document.getElementById("ConformBtn").href=url;
		$('#WarningModal').modal('show');
}