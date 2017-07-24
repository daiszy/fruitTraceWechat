$(function(){
	
	$("#h1").animate({left:'0px'},1000);
	$("#h2").animate({left:'0px'},2000);
	$("#h3").animate({left:'0px'},3000);
	$("#h4").animate({left:'0px'},4000);
	$("#h5").animate({left:'0px'},5000);
	$("#h6").animate({left:'0px'},6000);
	$("#h7").animate({left:'0px'},7000);
	
	//获取套袋记录
	getBagInfo();
	
	//获取施肥记录
	getFertilInfo();
	
	//获取物理杀虫记录
	getInsecticideInfo();
	
	//获取物理防害记录
	getPhysicalPrejudicesInfo();
	
	//获取春耕记录
	getPlowings();
	
	//获取剪枝记录
	getPrunings();
	
	//获取喷药记录
	getSprayPesticides();
	
});

//套袋
function getBagInfo()
{
	var url = HOST+"/baggingServlet";
	$.ajax({
		type:"get",
		url:url,
		async:true,
		datatype:"JSON",
		error:function()
		{
			alert("获取套袋记录Request error!");
		},
		success:function(data)
		{
			//alert("获取套袋记录Request success!");
			$.each(JSON.parse(data), function(i,n) {
				var bagTable = document.getElementById("bagging");		
				
				var bagTr = document.createElement("tr");
				bagTable.appendChild(bagTr);
				
				var bagTdTime = document.createElement("td");
				bagTdTime.innerHTML = n.time;
				var bagTdInstruct = document.createElement("td");
				bagTdInstruct.innerHTML = n.instruct;
				
				bagTr.appendChild(bagTdTime);
				bagTr.appendChild(bagTdInstruct);
			});
		}
	});
}

//施肥
function getFertilInfo()
{
	var url = HOST+"/fertiServlet";
	$.ajax({
		type:"get",
		url:url,
		async:true,
		datatype:"JSON",
		error:function()
		{
			alert("获取施肥记录Request error!");
		},
		success:function(data)
		{
			//alert("获取施肥记录Request success!");
			$.each(JSON.parse(data), function(i,n) {
				var fertilTable = document.getElementById("fertil");		
				
				var fertilTr = document.createElement("tr");
				fertilTable.appendChild(fertilTr);
				
				var fertilTdTime = document.createElement("td");
				fertilTdTime.innerHTML = n.time;
				var fertilTdInstruct = document.createElement("td");
				fertilTdInstruct.innerHTML = n.rmark;
				
				fertilTr.appendChild(fertilTdTime);
				fertilTr.appendChild(fertilTdInstruct);
			});
		}
	});
}

//杀虫
function getInsecticideInfo()
{
	var url = HOST+"/physicalInsecticidalsServlet";
	$.ajax({
		type:"get",
		url:url,
		async:true,
		datatype:"JSON",
		error:function()
		{
			alert("获取物理杀虫Request error!");
		},
		success:function(data)
		{
			//alert("获取物理杀虫记录Request success!");
			$.each(JSON.parse(data), function(i,n) {
				var tableInsecticide = document.getElementById("insecticide");
				
				var trInsecticide = document.createElement("tr");				
				tableInsecticide.appendChild(trInsecticide);
				
				var tdInsecticideTime = document.createElement("td");
				tdInsecticideTime.innerHTML = n.time;
				
				var tdInsecticideInstruct = document.createElement("td");
				tdInsecticideInstruct.innerHTML = n.instruct;
				
				trInsecticide.appendChild(tdInsecticideTime);
				trInsecticide.appendChild(tdInsecticideInstruct);
			});
		}
	});
}

//防害
function getPhysicalPrejudicesInfo()
{
	var url = HOST+"/physicalprejudicesServlet";
	$.ajax({
		type:"get",
		url:url,
		async:true,
		datatype:"JSON",
		error:function()
		{
			alert("获取物理防害Request error!");
		},
		success:function(data)
		{
			//alert("获取物理防害记录Request success!");
			$.each(JSON.parse(data), function(i,n) {
				var tablePhysicalPrejudices = document.getElementById("physicalPrejudices");
				
				var trPhysicalPrejudices = document.createElement("tr");				
				tablePhysicalPrejudices.appendChild(trPhysicalPrejudices);
				
				var tdPhysicalPrejudicesTime = document.createElement("td");
				tdPhysicalPrejudicesTime.innerHTML = n.time;
				
				var tdPhysicalPrejudicesInstruct = document.createElement("td");
				tdPhysicalPrejudicesInstruct.innerHTML = n.rmark;
				
				trPhysicalPrejudices.appendChild(tdPhysicalPrejudicesTime);
				trPhysicalPrejudices.appendChild(tdPhysicalPrejudicesInstruct);
			});
		}
	});
}

//春耕
function getPlowings()
{
	var url = HOST+"/plowingsServlet";
	$.ajax({
		type:"get",
		url:url,
		async:true,
		datatype:"JSON",
		error:function()
		{
			alert("获取春耕Request error!");
		},
		success:function(data)
		{
			//alert("获取春耕记录Request success!");
			$.each(JSON.parse(data), function(i,n) {
				var tablePlowings = document.getElementById("plowings");
				
				var trPlowings = document.createElement("tr");				
				tablePlowings.appendChild(trPlowings);
				
				var tdPlowingsTime = document.createElement("td");
				tdPlowingsTime.innerHTML = n.time;
				
				var tdPlowingsInstruct = document.createElement("td");
				tdPlowingsInstruct.innerHTML = n.instruct;
				
				trPlowings.appendChild(tdPlowingsTime);
				trPlowings.appendChild(tdPlowingsInstruct);
			});
		}
	});
}

//剪枝
function getPrunings()
{
	var url = HOST+"/pruningsServlet";
	$.ajax({
		type:"get",
		url:url,
		async:true,
		datatype:"JSON",
		error:function()
		{
			alert("获取剪枝Request error!");
		},
		success:function(data)
		{
			//alert("获取剪枝记录Request success!");
			$.each(JSON.parse(data), function(i,n) {
				var tablePrunings = document.getElementById("prunings");
				
				var trPrunings = document.createElement("tr");				
				tablePrunings.appendChild(trPrunings);
				
				var tdPruningsTime = document.createElement("td");
				tdPruningsTime.innerHTML = n.time;
				
				var tdPruningsInstruct = document.createElement("td");
				tdPruningsInstruct.innerHTML = n.instruct;
				
				trPrunings.appendChild(tdPruningsTime);
				trPrunings.appendChild(tdPruningsInstruct);
			});
		}
	});
}

//喷药
function getSprayPesticides()
{
	var url = HOST+"/spraypesticidesServlet";
	$.ajax({
		type:"get",
		url:url,
		async:true,
		datatype:"JSON",
		error:function()
		{
			alert("获取喷药Request error!");
		},
		success:function(data)
		{
			//alert("获取喷药记录Request success!");
			$.each(JSON.parse(data), function(i,n) {
				var tableSpray = document.getElementById("sprayPesticide");
				
				var trSpray = document.createElement("tr");				
				tableSpray.appendChild(trSpray);
				
				var tdSprayTime = document.createElement("td");
				tdSprayTime.innerHTML = n.time;
				
				var tdSprayInstruct = document.createElement("td");
				tdSprayInstruct.innerHTML = n.mark;
				
				trSpray.appendChild(tdSprayTime);
				trSpray.appendChild(tdSprayInstruct);
			});
		}
	});
}