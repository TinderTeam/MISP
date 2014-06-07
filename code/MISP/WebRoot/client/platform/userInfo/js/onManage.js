	//全局参数
	var modifyOrgName="";
	var modifyOrgBelone="";
	
	
	
	//通过Ajax 查询组织 
	function serachOrg()
	{
		<!------- Search ORG ---->
		
		var nameSelected =document.getElementById("selectedOrg").innerHTML;
		if(nameSelected=="未选择组织机构"){
			alert("请选择组织结构");
		}
		else{
			$.ajax({  
				url: "orgManage!ajaxSearchOrg.action", 
				dataType:"html",
				
				data:{
					orgName:nameSelected,
				},
				success: function (str) { 
								
					var obj = eval ("(" + str + ")");
					
					//配置页面相关信息
					document.getElementById("orgInfoName").value=nameSelected;
					document.getElementById("beloneInfo").innerHTML="["+nameSelected+"]隶属于";
					document.getElementById("beloneInfoContent").innerHTML=obj.orgBeloneInfo;
					document.getElementById("staticInfo").innerHTML=obj.staticInfo;
					//配置全局变量
					modifyOrgName=nameSelected;
					
					
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
		//正在修改（已经查询的组织名称）
		var nameSelected =document.getElementById("orgInfoName").value;
		//选中的上级组织名称
		var selectedName=document.getElementById("selectUpOrg").value;
		
		if(nameSelected==""){
			alert("请选择组织结构并点击左下角查询按钮，查询详细信息");
		}
		else if(selectedName==""){
			alert("请选择需要变更的组织的上级组织");
		}
		else if(selectedName==nameSelected){
			alert("不能将自身设定为上级组织");
		}
		else{
			//将全局变量更改为选中变量
			modifyOrgBelone=selectedName;
			document.getElementById("beloneInfoContent").innerHTML=modifyOrgBelone+"-"+modifyOrgName;
			$('#modifyAlert').modal('hide')
		}
	}	


	//确认调整修改
	function ensureModify()
	{

	}	

	//取消修改
	function cancelModify()
	{
		//清除全局变量
		modifyOrgName="";
		modifyOrgBelone="";
		//清除页面查询的数据
		
		document.getElementById("orgInfoName").value="";
		document.getElementById("beloneInfo").innerHTML="";
		document.getElementById("beloneInfoContent").innerHTML="";
		document.getElementById("staticInfo").innerHTML="";
	}	
