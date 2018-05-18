package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author xielbs
 * @create 2018-05-17 17:12
 * @desc 视图请求控制层
 **/
@Controller
@RequestMapping(value = "/viewTest")
public class ViewControllerTest {

//    public static void main(String[] args) {
//        StringBuffer sb = new StringBuffer();
//        sb.append("SELECT * FROM s_user ");
//        List<Map> list = DAOFactory.getInstance().getQueryInterface().querySqlReturnListMap(sb.toString());
//        System.out.print(list.toString());
//    }

    @RequestMapping(value = "/ftlTest")
    public ModelAndView ftlView(){
        ModelAndView mav = new ModelAndView();
//        StringBuffer sb = new StringBuffer();
//        sb.append("SELECT * FROM s_user ");
//        List<Map> list = DAOFactory.getInstance().getQueryInterface().querySqlReturnListMap(sb.toString());
//        System.out.print(list.toString());
        mav.setViewName("index.ftl");
        return mav;
    }

    @RequestMapping(value = "/jspTest")
    public ModelAndView jspView(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index.jsp");
        return mav;
    }

    @RequestMapping(value = "/htmlTest")
    public ModelAndView htmlView(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index.html");
        return mav;
    }

    @RequestMapping(value = "/echartsTest")
    public ModelAndView echartsTest(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("echarts/echarts.jsp");
        return mav;
    }


}
