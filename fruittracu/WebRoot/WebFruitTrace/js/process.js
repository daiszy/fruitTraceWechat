$(function(){
	
	getStaffInfo();
	
	getProcessInfo();
});

function getStaffInfo()
{
	var url = HOST+"/producelinestuffsServlet";
	$.ajax({
		type:"get",
		url:url,
		async:true,
		datatype:"JSON",
		error:function()
		{
			alert("获取加工员工信息Request error!");
		},
		success:function(data)
		{
			//alert("获取加工员工信息Request success!");
			$.each(JSON.parse(data), function(i,n) {
				$("#staffNum").html(n.stuff) ;
				$("#staffName").html(n.name) ;
				$("#staffHealth").html(n.health) ;
				$("#processTime").html(n.time) ;
			});		
		}
	});
}

function getProcessInfo()
{
	var url = HOST+"/packmaterialsServlet";
	$.ajax({
		type:"get",
		url:url,
		async:true,
		datatype:"JSON",
		error:function()
		{
			alert("获取包装信息Request error!");
		},
		success:function(data)
		{
			//alert("获取包装信息Request success!");
			$.each(JSON.parse(data), function(i,n) {
				$("#pmCategory").html(n.cat);
				$("#pmName").html(n.name);
				$("#pmMaterial").html(n.mat);
				$("#pmState").html(n.status);
				$("#pmTime").html(n.time);
			});		
		}
	});
}
