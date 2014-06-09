
	//全局参数
	var modifyOrgName="";
	var modifyOrgBelone="";
	var searchGroupValue="";
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

	//组织机构树节点单击选择
	function selectGroup(str)
	{

		document.getElementById("selectedGroup").innerHTML=str;

		
	}	
	
	//显示详细信息
	function showDetail()
	{
		
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
	function ensureDeleteMember()
	{
		
	}
	
	//增加组成员
	function ensureAddMember()
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
	
	