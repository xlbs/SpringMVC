package com.springmvc.controller;

import com.echarts.Option;
import com.echarts.interfact.AbstractEChartsAction;
import com.springmvc.utils.JSONUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xielbs
 * @create 2018-05-17 17:12
 * @desc ajax请求控制层
 **/
@RestController
@RequestMapping(value = "ajax")
public class AjaxControllerTest {

    //produces = {"text/html;charset=UTF-8;"}解决中文乱码
    @RequestMapping(value = "/ajaxTest", produces = {"text/html;charset=UTF-8;"})
    public String ajaxTest() throws Exception {
        Map<String, Object> map = new HashMap<>();

        //单Y轴柱形，曲线图测试
        Map<String, Object> textMapInit = new HashMap<String, Object>();
        textMapInit.put("axiscolor", "blue");
        //textMapInit.put("axisPointer-type", "cross");
        Map<String, Boolean> flagMapInit = new HashMap<String, Boolean>();
        //flagMapInit.put("boundarygap", false);//若为曲线时，设为false更佳
        flagMapInit.put("alignWithLabel", true);//柱形图坐标轴刻度与标签对齐
        flagMapInit.put("slider", true);//是否放大
        flagMapInit.put("inside", true);//鼠标滚动是否放大缩小
        flagMapInit.put("lgtextcolor", true);//图例文本颜色是否跟随图形颜色
        LinkedHashMap<String, Map<Object, Object>> mapInit = new LinkedHashMap<String, Map<Object,Object>>();
        Map<Object, Object> mapInit1 = new LinkedHashMap<Object, Object>();
        Map<Object, Object> mapInit2 = new LinkedHashMap<Object, Object>();
        for (int i = 20; i <= 30; i++) {
            mapInit1.put(i, Math.random()*100);
            mapInit2.put(i, Math.random()*100);
        	/*if (i<=26 && i>24) {
        		mapInit2.put(i, null);
			}else {
				mapInit2.put(i, Math.random()*100);
			}*/
        }
        mapInit.put("蒸发量(万)_bar_#99cccc", mapInit1);
//        mapInit.put("降雨量(万)_line_red", mapInit2);
        Option optionInit = AbstractEChartsAction.initBaseBar(textMapInit, flagMapInit, mapInit);

        //多Y轴柱形，曲线图测试
        Map<String, Object> textMapMul = new HashMap<String, Object>();
        textMapMul.put("y-axis", "蒸发量_万_left_0,降雨量_万_right");
        Map<String, Boolean> flagMapMul = new HashMap<String, Boolean>();
        flagMapMul.put("showYcolor", true);
        flagMapMul.put("slider", true);
        flagMapMul.put("inside", true);
        //flagMapMul.put("boundarygap", false);//若为曲线时，设为false更佳
        flagMapMul.put("showDot", false);//曲线时是否显示圆点
        LinkedHashMap<String, Map<Object, Object>> mapMul = new LinkedHashMap<String, Map<Object,Object>>();
        Map<Object, Object> mapMul1 = new LinkedHashMap<Object, Object>();
        Map<Object, Object> mapMul2 = new LinkedHashMap<Object, Object>();
        for (int i = 20; i <= 30; i++) {
            mapMul1.put(i, Math.random()*100);
            mapMul2.put(i, Math.random()*50);
        	/*if (i<=26 && i>24) {
        		mapMul2.put(i, null);
			}else {
				mapMul2.put(i, Math.random()*50);
			}*/
        }
        mapMul.put("蒸发量(万)_bar_#FF0000_0", mapMul1);
        mapMul.put("降雨量(万)_line_#838B8B_1", mapMul2);
        Option optionMul = AbstractEChartsAction.multiAxisBaseBar(textMapMul, flagMapMul, mapMul);

        //饼图测试
        Map<String, String> textMapPie = new HashMap<String, String>();
        textMapPie.put("radius","50%_80%");//设置为环形图
        textMapPie.put("ring-text","总降雨量：110L");//设置中间空白总文本
        Map<String, Boolean> flagMapPie = new HashMap<String, Boolean>();
        LinkedHashMap<String, Object> mapPie = new LinkedHashMap<String, Object>();
        mapPie.put("1月_#ffcc00", 50);
        mapPie.put("2月_#ccff00", 20);
        mapPie.put("3月_#9900ff", 40);
        Option optionPie = AbstractEChartsAction.standardPie(textMapPie, flagMapPie, mapPie);

        //仪表盘测试
        Map<String, Object> textMapDash = new HashMap<String, Object>();
        textMapDash.put("min", "0");
        textMapDash.put("max", "220");
        textMapDash.put("splitnumber", "11");
        textMapDash.put("data", "100");
        textMapDash.put("explain", "km/h");
        Option optionDash = AbstractEChartsAction.dashboardECharts(textMapDash);

        map.put("optionInit", optionInit);
        map.put("optionMul", optionMul);

        System.out.println(JSONUtils.serialize(map));
        return JSONUtils.serialize(map);

    }



}
