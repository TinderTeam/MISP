	<script type="text/javascript">
			
		
			function serachOrg()
			{
				<!------- Change DetailInfo Name ---->
				
				var nameSelected =document.getElementById("selectedOrg").innerHTML;
				if(nameSelected=="未选择组织机构"){
					alert("请选择组织结构");
				}
				else{
					document.getElementById("orgInfoName").value=nameSelected;
					document.getElementById("beloneInfo").innerHTML="["+nameSelected+"]隶属于";
		
				}
			}
		
		</script>
		<script type="text/javascript">
		<!-----Tree Select--->
			function treeSelect(str)
			{
				document.getElementById("selectedOrg").innerHTML=str;
			}
		</script>