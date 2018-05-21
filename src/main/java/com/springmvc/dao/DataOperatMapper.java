package com.springmvc.dao;

import com.springmvc.entity.SaveObj;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DataOperatMapper {

    /**
     * 查询
     * @param sql SQL语句
     * @return
     */
    public List<Map> querySql(@Param(value = "sql") String sql);

    /**
     * 保存
     * @param obj 对象
     * @return
     */
    public Integer saveSql(SaveObj obj);

    /**
     * 修改
     * @param sql SQL语句
     * @return
     */
    public Integer updateSql(@Param(value = "sql") String sql);

    /**
     * 删除
     * @param sql SQL语句
     * @return
     */
    public Integer deleteSql(@Param(value = "sql") String sql);



}
