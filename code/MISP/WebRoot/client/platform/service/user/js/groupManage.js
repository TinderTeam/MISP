
	//全局参数
	var modifyOrgName="";
	var modifyOrgBelone="";
	var searchGroupValue="";
	var deleteUserNumber=0;  //删除的用户的个数
	var deleteUserList = new Array();
    var allGroupName= allGroupNameInit();
	
	function allGroupNameInit()
	{
		var allOption=document.getElementById("selectedGroupList").innerHTML;
		var strs= new Array(); //定义一数组
		strs=allOption.split("</option>");
		var array= new Array(); //定义一数组
		for(var i=0;i<strs.length-1;i++){
			array[i]=strs[i].replace("<option>"," ");
		}
		return array;
	}
    
	//确认查找权限组
	function ensureSearchGroup()
	{
		document.getElementById("ensureSearchGroupBtn").disabled=false;
	}
	
	//模糊匹配函数
	function searchFit(strKey,strValue){
	//key是匹配关键字
	//value是被匹配的字符串
		var re=new RegExp(strKey);
		return re.test(strValue);
	}
	
	
	
	//查询结果显示
	function searchGroupResult()
	{
		var str = document.getElementById("keyword").value;
		var selectOption="";
		for(var i=0;i<allGroupName.length;i++){
			if(searchFit(str,allGroupName[i])){
				selectOption=selectOption+"<option>"+allGroupName[i]+"</option>";
			}else{
				
			}
		}
		document.getElementById("selectedGroupList").innerHTML=selectOption;
	}

	//权限组单击选择
	function selectGroup(str)
	{

		document.getElementById("selectedGroup").innerHTML=str;

		
	}	
	
	//显示选中的权限组详细信息
	function showDetail()
	{
		searchGroupValue =document.getElementById("selectedGroup").innerHTML;

		if(searchGroupValue=="未选择权限组")
		{
			alert("请选择权限组");
		}
		else
		{
			document.getElementById("groupInfoName").value=searchGroupValue;
			$.ajax({  
				url: "groupManage!ajaxSearchGroup.action", 
				dataType:"html",
				
				data:{
					groupName:searchGroupValue,
				},
				success: function (str) { 
								
					var obj = eval ("(" + str + ")");
					var userSelectOption="";
					selectGroupUserList = obj.userIDList;
					for(var i=0;i<obj.userIDList.length;i++)
					{
						//将每一个用户ID配置成其本身，方便后续做删除处理
						userSelectOption=userSelectOption+"<option id=\""+selectGroupUserList[i]+"\">"+selectGroupUserList[i]+"</option>";
								
					}
					
					document.getElementById("selectedUserList").innerHTML=userSelectOption;
				}, 
				error: function (XMLHttpRequest, textStatus, errorThrown) { 
					alert(errorThrown); 
				} 
			});			
		}
		
		
	}

	//删除权限组
	function deleteGroup()
	{
		
	}
	
	//增加权限组
	function addGroup()
	{
		
	}
	
	//删除组成员
	function deleteUser()
	{
		
		var parent=document.getElementById("selectedUserList");
		var child=document.getElementById(document.getElementById("selectedUserList").value);
		if(child==null)
		{
			alert("请选择需要删除的用户");
		}
		else
		{
			
			//deleteUserList 存放已经被删除的用户列表
			deleteUserList[deleteUserNumber]=document.getElementById("selectedUserList").value;
			deleteUserNumber++;	
			
			//删除选中的用户
			parent.removeChild(child);
			
			//使能确认修改按钮
			ensureEditGroup();
		}
		
		
	}
	
	//增加组成员
	function addUser()
	{
		document.getElementById("ensureAddMemberBtn").disabled=false;
	}

	//确认编辑权限组
	function ensureEditGroup()
	{
		document.getElementById("ensureEditGroupBtn").disabled=false;
	}
	
	//确认更新权限组
	function ensureModifyGroup()
	{
		
	}
	
	//取消更新权限组
	function cancelModifyGroup()
	{
		
	}
	
	