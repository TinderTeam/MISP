	<script type="text/javascript">
			
		
			function serachOrg()
			{
				<!------- Change DetailInfo Name ---->
				
				var nameSelected =document.getElementById("selectedOrg").innerHTML;
				if(nameSelected=="δѡ����֯����"){
					alert("��ѡ����֯�ṹ");
				}
				else{
					document.getElementById("orgInfoName").value=nameSelected;
					document.getElementById("beloneInfo").innerHTML="["+nameSelected+"]������";
		
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