$(function(){
	var params = {};
	ajaxDispose('ajax/ajaxTest', params, getBarBack, 'json');
	
});

function getBarBack(res){
	//添加阴影及渐变
	// var itemStyle = {//柱形图渐变
	// 			normal: {
	// 				color: new echarts.graphic.LinearGradient(0, 0, 0, 1,//0,0,1,0从左到右渐变;0,0,0,1从上到下渐变
	// 						[
	// 						 {offset: 0, color: 'red'},
	// 						 {offset: 0.5, color: 'yellow'},
	// 						 {offset: 1, color: 'blue'}
	// 						]
	// 				),
	// 				label : {show: true, position:'top'}//柱形图显示数据
	// 			}
    // };
    // res.option.series[0].itemStyle=itemStyle;//设置柱形图渐变

	// var areaStyle = {//曲线渐变
	// 			normal: {
	// 				color: new echarts.graphic.LinearGradient(0, 0, 1, 0,
	// 						[
	// 						 {offset: 0,color: '#ffccff'},
	// 						 {offset: 1,color: '#ff00ff'}
	// 						]
	// 				)
	// 			}
	// };
	// res.option.series[1].areaStyle=areaStyle;//设置曲线渐变

	var position = function (point, params, dom, rect, size) {
	      return [point[0], '10%'];
	  }
	res.optionInit.tooltip.position=position;//设置炫富肯定位置
	
	var colorListTest = new Array();
	for(var i=0; i<11; i++){
		if(i==2){
            colorListTest[i] = "#ff0066";
		}else{
            colorListTest[i] = "#4fc293";
		}
	}
	var itemStyleaaa = {
		    normal:{  
		    	//每个柱子的颜色即为colorList数组里的每一项，如果柱子数目多于colorList的长度，则柱子颜色循环使用该数组
		        color:function (params){
                    var colorList = colorListTest;
                    return colorList[params.dataIndex];
                }
		    }
		};
	res.optionInit.series[0].itemStyle = itemStyleaaa;//修改柱子颜色

	initChart('echartsId', res.optionInit, testChartClick);
	initChart('echartsId1', res.optionMul);

}


/**
 * 图形的点击事件
 * @param params 数据参数
 * 图形图例：params.seriesName
 * X轴坐标值：params.name
 * Y轴数据值：params.value
 * 图形颜色：params.color
 * 图形类型：params.seriesType
 */
function testChartClick(params){
	alert("图形图例："+params.seriesName+"\nX轴坐标值："+params.name+"\nY轴数据值："+params.value+"\n图形颜色："+params.color+"\n图形类型："+params.seriesType);
}

/**
 * ajax请求（POST请求）
 * @param url 请求路径
 * @param params 参数
 * @param callback 回调函数
 * @param dataType 数据类型
 */
function ajaxDispose(url, params, callback, dataType){
	if(params == null){
		params = {};
	}
	params.nocache = new Date().getTime();
	if(dataType == null){
		dataType = "json";
	}
	$.ajax({
        type:"POST",
		url:url,
		data:params,
		dataType:dataType,
		timeout : 120000,//超时时间设置，单位毫秒
		success : function(response) {
			callback(response);
		},
		error : function(err) {
			callback(null);
		}
	});
}
