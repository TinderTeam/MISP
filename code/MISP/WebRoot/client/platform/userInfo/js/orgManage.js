	
	function addSubModal(id)
	{
		//添加子组织机构
	
		
		$('#addSubGroup').modal('show');
		document.getElementById("addSubOrgSubmit").value=id;
	}
	
	function showMemModal(id)
	{
		//查询用户列表
		
			$.ajax({  
					url: "orgManage!searchUserByID.action", 
					dataType:"html",
					data:{
						orgID:id,
					},
					success: function (str) { 
						var obj = eval ("(" + str + ")");
						var userSelectOption="";
						var users=obj;
						for(var i=0;i<users.length;i++)
						{
							userSelectOption=userSelectOption+"<option>"+users[i].userID+"</option>";									
						}
						document.getElementById("userList").innerHTML=userSelectOption;
						$('#showMemModal').modal('show');
					}, 
					error: function (XMLHttpRequest, textStatus, errorThrown) {
						alert("error in ajax recieve");
						alert(errorThrown); 
					} 
			});
		
	
	}

	
	function modifySubModal(id)
	{
		//修改该组织机构
		
		
		$.ajax({  
					url: "orgManage!searchOrgInfoByID.action", 
					dataType:"html",
					data:{
						orgID:id,
					},
					success: function (str) { 
						var obj = eval ("(" + str + ")");
						document.getElementById("modifyInput").value=obj.orgName;
						document.getElementById("modifyDespInput").value=obj.orgDesp;
						$('#modifySubGroup').modal('show');
						document.getElementById("modifySubOrgSubmit").value=id;
						
					}, 
					error: function (XMLHttpRequest, textStatus, errorThrown) {
						alert("error in ajax recieve");
						alert(errorThrown); 
					} 
			});
	}
	
	function deleteSubModal(id)
	{
		//删除
		$('#warningModal').modal('show');
		document.getElementById("deleteOrgbtn").value=id; 
	}
	
	function addOrgSubmit(id)
	{
		//提交新增组织机构
		var url="";
		var newName=document.getElementById("addInput").value;
		
		if(newName==""){
			alert("新增组织机构名称不可为空");
		}else{
			$.ajax({  
				url: "orgManage!orgNameVerification.action", 
				dataType:"html",
				data:{
					newOrgName:newName,
				},
				success: function (str) { 
					
					if(str=="repeat"){
						alert("用户名不可重复");
					}
					else if(str=="noRepeat"){
						var fatherID=document.getElementById("addSubOrgSubmit").value;
						url="orgManage!addSubOrg.action?newOrgName="+newName+"&fatherID="+fatherID;
						 window.location.href=url; 
					}else{
						alert("error in ajax recieve:orgNameVerification= "+str);
						return true;
					}
				}, 
				error: function (XMLHttpRequest, textStatus, errorThrown) {
					alert("error in ajax recieve");
					alert(errorThrown); 
				} 
			});
		}
	}
		
		
	function deletOrgSubmit()
	{
		//删除组织机构	
			var deleteOrg = document.getElementById("deleteOrgbtn").value; 
			$.ajax({  
				url: "orgManage!deleteSubOrg.action", 
				dataType:"html",
				data:{
					deleteOrg:deleteOrg,
				},
				success: function (str) { 
					window.location.href="orgManage.action";
				}, 
				error: function (XMLHttpRequest, textStatus, errorThrown) {
					alert("error in ajax recieve");
					alert(errorThrown); 
				} 
			});
		
		
	}
	
	function modityOrgSubmit(){
	//修改组织机构	
			var orgID = document.getElementById("modifySubOrgSubmit").value; 
			var newName = document.getElementById("modifyInput").value;
			var dept=document.getElementById("modifyDespInput").value;
			$.ajax({  
				url: "orgManage!modifyOrg.action", 
				dataType:"html",
				data:{
					orgID:orgID,
					newName:newName,
					dept:dept,
				},
				success: function (str) { 
					window.location.href="orgManage.action";
				}, 
				error: function (XMLHttpRequest, textStatus, errorThrown) {
					alert("error in ajax recieve");
					alert(errorThrown); 
				} 
			});
	}