$(function(){
	
	getOrchardInfo();

	/*初始化swiper标签*/
	var mySwiper = new Swiper(".swiper-container",{
		 direction: 'horizontal',
         loop: false,
         // 如果需要分页器
   		 pagination: '.swiper-pagination',
    
    	// 如果需要前进后退按钮
   		nextButton: '.swiper-button-next',
   		prevButton: '.swiper-button-prev',
	})

	$(".swipeIllumi").css("display","none");
	$(".swipeSeason").css("display","none");
	
	var colum = 1;
	
	//向左滑动
	$(".swipe").on("swipeleft",function(){
		colum++;
		if(colum == 1){
			$(".swipeNum").css("display","block");
			$(".swipeIllumi").css("display","none");
			$(".swipeSeason").css("display","none");
		}
		if(colum == 2){
			$(".swipeNum").css("display","none");
			$(".swipeIllumi").css("display","block");
			$(".swipeSeason").css("display","none");
		}
		if(colum == 3){
			$(".swipeNum").css("display","none");
			$(".swipeIllumi").css("display","none");
			$(".swipeSeason").css("display","block");
		}
	});
	//向右滑动
	$(".swipe").on("swiperight",function(){
		colum--;
		if(colum == 1){
			$(".swipeNum").css("display","block");
			$(".swipeIllumi").css("display","none");
			$(".swipeSeason").css("display","none");
		}
		if(colum == 2){
			$(".swipeNum").css("display","none");
			$(".swipeIllumi").css("display","block");
			$(".swipeSeason").css("display","none");
		}
		if(colum == 3){
			$(".swipeNum").css("display","none");
			$(".swipeIllumi").css("display","none");
			$(".swipeSeason").css("display","block");
		}
	});	
});

function getOrchardInfo()
{
	var url = HOST+"/baseServlet";
	$.ajax({
		type:"get",
		url:url,
		async:true,
		datatype:"JSON",
		error:function()
		{
			alert("获取气候信息Request error!");
		},
		success:function(data)
		{
			//alert("获取气候信息Request success!");
			$.each(JSON.parse(data), function(i,n) {
				$("#fruitNum").text(n.tree);
				$("#fruitArea").text(n.area);
				$("#fruitIllumHour").text(n.ill);
				$("#fruitHeight").text(n.ele);
				$("#spring").attr('src',n.image);
			});
		}
	});
}
