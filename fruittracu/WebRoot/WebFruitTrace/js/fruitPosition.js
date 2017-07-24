$(function(){
	var height = $(window).height();
//	$(".mainDiv").css("height",height+"px");
	getJInfo();
});

function getJInfo()
{
	var url = HOST+"/jidiServlet";
	$.ajax({
		type:"get",
		url:url,
		async:true,
		datatype:"JSON",
		error:function()
		{
			alert("获取基地信息Request error!");
		},
		success:function(data)
		{
			//alert("获取基地信息Request success!");
			$.each(JSON.parse(data), function(i,n) {
				$("#adminName").text(n.Jadmin);
				$("#fruitPosition").text(n.Jaddress);
				$("#jName").text(n.Jname);
			});
		}
	});
}
