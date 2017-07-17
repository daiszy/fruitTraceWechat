$(function(){
	//alert(HOST);
	//从服务端获取苹果星级和品种
	getName();
	
	$("#swipeA").on('tap', function() {  
       window.location.href = "fruitPosition.html";
     });  
});

function getName()
{
	var url = HOST+"/getNameServlet";
	$.ajax({
		type:"get",
		url:url,
		async:true,
		datatype:"JSON",
		error:function()
		{
			alert("获取苹果信息Request error!");
		},
		success:function(data)
		{
			//alert("获取苹果信息Request success!");
			$.each(JSON.parse(data), function(i,n) {
				$("#fruitName").text(n.name);
				$("#fruitGrade").text(n.grade);
			});
		}
	});
}
