	//全局参数
	var modifyOrgName="";
	var modifyOrgBelone="";
	var searchOrgValue="";
	
	
	
	//通过Ajax 查询组织 
	function serachOrg()
	{
		<!------- Search ORG ---->
		
		searchOrgValue =document.getElementById("selectedOrg").innerHTML;
		if(searchOrgValue=="未选择组织机构"){
			alert("请选择组织结构");
		}
		else{
			$.ajax({  
				url: "orgManage!ajaxSearchOrg.action", 
				dataType:"html",
				
				data:{
					orgName:searchOrgValue,
				},
				success: function (str) { 
								
					var obj = eval ("(" + str + ")");
					
					//配置页面相关信息
					document.getElementById("orgInfoName").value=searchOrgValue;
					document.getElementById("beloneInfo").innerHTML="["+searchOrgValue+"]隶属于";
					document.getElementById("beloneInfoContent").innerHTML=obj.orgBeloneInfo;
					document.getElementById("staticInfo").innerHTML=obj.staticInfo;
					//配置全局变量
					modifyOrgName=searchOrgValue;
					//禁用修改确认按钮
					document.getElementById("ensureModifyBtn").disabled=true;
					
				}, 
				error: function (XMLHttpRequest, textStatus, errorThrown) { 
					alert(errorThrown); 
				} 
			});			
		}
	}

	//组织机构树节点单击选择
	function treeSelect(str)
	{

		document.getElementById("selectedOrg").innerHTML=str;
		document.getElementById("modal_orgName1").innerHTML=str;
		document.getElementById("modal_orgName2").innerHTML=str;

		
	}	
	
	//调整组织机构归属
	function changeOrgBelone()
	{

		//选中的上级组织名称
		var selectedName=document.getElementById("selectUpOrg").value;
		
		if(searchOrgValue==""){
			alert("请选择组织结构并点击左下角查询按钮，查询详细信息");
		}
		else if(selectedName==""){
			alert("请选择需要变更的组织的上级组织");
		}
		else if(selectedName==searchOrgValue){		
			alert("不能将自身设定为上级组织");
		}
		else{
			//将全局变量更改为选中变量
			modifyOrgBelone=selectedName;
			document.getElementById("ensureModifyBtn").disabled=false;
			document.getElementById("beloneInfoContent").innerHTML=modifyOrgBelone+"-"+modifyOrgName;
			$('#modifyAlert').modal('hide')
			
		}
	}	


	//确认调整修改
	function ensureModify()
	{
		var disabled=document.getElementById("ensureModifyBtn").value;
		if(disabled==false){
			//可用状态
			
			
			var oldOrgName=searchOrgValue;
			var newOrgName=document.getElementById("orgInfoName").value;
			var newOrgBelone=modifyOrgBelone;
			
			alert("旧名称："+oldOrgName+";新名称="+newOrgName+";新归属="+newBelone);
			
			$.ajax({  
				url: "orgManage!ajaxOrgModify.action", 
				dataType:"html",
				
				data:{
					oldOrgName:oldOrgName,
					newOrgName:newOrgName,
					newOrgBelone:newOrgBelone
				},
				success: function () { 
				}, 
				error: function (XMLHttpRequest, textStatus, errorThrown) { 
					alert(errorThrown); 
				} 
			});			
			
		}
		else{
			return;
		}
		
	}	

	//取消修改
	function cancelModify()
	{
		//清除全局变量
		modifyOrgName="";
		modifyOrgBelone="";
		searchOrgValue="";
		//清除页面查询的数据
		
		document.getElementById("orgInfoName").value="";
		document.getElementById("beloneInfo").innerHTML="";	
		document.getElementById("beloneInfoContent").innerHTML="";
		document.getElementById("staticInfo").innerHTML="";
		document.getElementById("ensureModifyBtn").disabled=true;
	}	
	
	function editOrg(){
		document.getElementById("ensureModifyBtn").disabled=false;
	}
