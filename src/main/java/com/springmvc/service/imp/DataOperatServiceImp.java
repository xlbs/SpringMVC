package com.springmvc.service.imp;

import com.springmvc.entity.SaveObj;
import com.springmvc.dao.DataOperatMapper;
import com.springmvc.service.intf.IDataOperatService;
import com.springmvc.utils.JSONUtils;
import net.sf.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author xielbs
 * @create 2018-05-21 17:25
 * @desc 业务层实现
 **/
@Service
public class DataOperatServiceImp implements IDataOperatService {

    @Autowired
    private DataOperatMapper dataOperatMapper;

    @Override
    public List<Map> querySql(String sql) {
        return dataOperatMapper.querySql(sql);
    }

    @Override
    public Long[] saveSql(String sql) {
        SaveObj saveObj = new SaveObj(sql);
        Integer affectCount = dataOperatMapper.saveSql(saveObj);
        Long[] result = new Long[affectCount];
        for(int i=0; i<affectCount;i++){
            result[i] = saveObj.getId()+i;
        }
        return result;
    }

    @Override
    public boolean updateSql(String sql) {
        Integer  affectCount = dataOperatMapper.updateSql(sql);
        if(affectCount<=0){
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteSql(String sql) {
        Integer  affectCount = dataOperatMapper.deleteSql(sql);
        if(affectCount<=0){
            return false;
        }
        return true;
    }

    @Override
    public Long[] batchSaveSql(String tabName, String fieldName, String datelist){
        try {
            StringBuffer sb = new StringBuffer();
            Map<String,Object> field = JSONUtils.deserialize(fieldName, new JSONUtils.ObjectToken<Map<String,Object>>(){});
            List<Map<String,Object>> list = JSONUtils.deserialize(datelist, new JSONUtils.ObjectToken<List<Map<String,Object>> >(){});
            String sql = "";
            for (String str : field.keySet()){
                sql += str + ",";
            }
            sql = sql.substring(0,sql.length()-1);
            if(sql!=""){
                sb.append(" INSERT INTO "+tabName +" ("+sql+") VALUES ");
            }
            for (Map<String,Object> map : list){
                sql = "";
                for (String str : field.keySet()){
                    if(field.get(str) instanceof String){
                        sql += "'"+map.get(str)+"'" + ",";
                    }else if(field.get(str) instanceof  Integer){
                        sql += Integer.valueOf(map.get(str)+"") + ",";
                    }else if(field.get(str) instanceof  Long){
                        sql += Long.valueOf(map.get(str)+"") + ",";
                    }else if(field.get(str) instanceof  Double){
                        sql += Double.valueOf(map.get(str)+"") + ",";
                    }else{
                        sql += "'"+map.get(str)+"'" + ",";
                    }
                }
                sql = sql.substring(0,sql.length()-1);
                sb.append(" ("+sql+"),");
            }
            String sbSql = sb.toString();
            sbSql = sbSql.substring(0,sbSql.length()-1);
            System.out.println(sbSql);
            SaveObj saveObj = new SaveObj(sbSql);
            Integer affectCount = dataOperatMapper.saveSql(saveObj);
            Long[] result = new Long[affectCount];
            for(int i=0; i<affectCount;i++){
                result[i] = saveObj.getId()+i;
            }
            return result;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional
    public boolean executeTrans(String sqlList){
        try {
            List<String> list = JSONUtils.deserialize(sqlList, new JSONUtils.ObjectToken<List<String>>(){});
            for (String sql : list){
                sql = sql.trim();//去掉首尾的空格
                String head = sql.substring(0,6);
                if("SELECT".equals(head)||"select".equals(head)){
                    dataOperatMapper.querySql(sql);
                }else if("UPDATE".equals(head)||"update".equals(head)){
                    dataOperatMapper.updateSql(sql);
                }else if("INSERT".equals(head)||"insert".equals(head)){
                    SaveObj saveObj = new SaveObj(sql);
                    dataOperatMapper.saveSql(saveObj);
                }else if("DELETE".equals(head)||"delete".equals(head)){
                    dataOperatMapper.deleteSql(sql);
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
