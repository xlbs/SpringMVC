package com.springmvc.service.imp;

import com.springmvc.entity.SaveObj;
import com.springmvc.dao.DataOperatMapper;
import com.springmvc.service.intf.IDataOperat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author xielbs
 * @create 2018-05-21 17:25
 * @desc 业务层实现
 **/
@Service
public class DataOperatImp implements IDataOperat {

    @Autowired
    private DataOperatMapper dataOperatMapper;

    @Override
    public List<Map> querySql(String sql) {
        return dataOperatMapper.querySql(sql);
    }

    @Override
    public Integer saveSql(SaveObj obj) {
        return dataOperatMapper.saveSql(obj);
    }

    @Override
    public Integer updateSql(String sql) {
        return dataOperatMapper.updateSql(sql);
    }

    @Override
    public Integer deleteSql(String sql) {
        return dataOperatMapper.deleteSql(sql);
    }
}
