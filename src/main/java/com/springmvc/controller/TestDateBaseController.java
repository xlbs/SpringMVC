package com.springmvc.controller;

import com.springmvc.service.intf.IDataOperat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author xielbs
 * @create 2018-05-21 17:29
 * @desc 数据库操作控制层
 **/
@RestController
@RequestMapping(value = "/dateBase")
public class TestDateBaseController {

    @Autowired
    private IDataOperat iTestDataBase;

    /**
     * 查询
     * @return
     */
    @RequestMapping(value = "/querySql", method={RequestMethod.GET, RequestMethod.POST})
    public List<Map> querySql(){
        StringBuffer sb = new StringBuffer();
        sb.append("select * from u_unit");
        return iTestDataBase.querySql(sb.toString());
    }


}
