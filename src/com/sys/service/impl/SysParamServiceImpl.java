package com.sys.service.impl;

import com.sys.dao.SysParamDao;
import com.sys.entity.SysParam;
import com.sys.service.SysParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author y_zzu 2020-01-07-19:52
 */
@Service("sysParamService")
public class SysParamServiceImpl extends BaseServiceImpl<SysParam> implements SysParamService{

    @Override
    public Map<String, Object> selectList() {

        //查询 系统参数表 数据
        List<SysParam> sysParams = sysParamDao.selectList("");
        //系统参数 Map 用来存放所有字段的相关参数信息
        Map<String, Object> sysParamMap = new HashMap<>();

        Map<String, Object> fieldMap=null;

        for (SysParam sysParam : sysParams) {
            if ("1".equals(sysParam.getSysParamType())) {
                //获取需要执行 SQL，用来查询其它表
                String sql = sysParam.getSysParamValue();
                System.out.println("===============" + sql);
                //执行查询，并把结果存在 List 中，元素为系统参数类型的实体
                //select s.sh_id as sys_param_value,s.sh_name as sys_param_text from store_house s
                List<SysParam> otherList = sysParamDao.selectOtherTable(sql);
                //再次进行初始化，防止之前数据的干扰
                fieldMap = new HashMap<String, Object>();
                //遍历
                for (SysParam param : otherList) {
                    //("1","一级供应商")
                    fieldMap.put(param.getSysParamValue(), param.getSysParamText());
                }
                //把字段相关 Map 存放在系统参数 Map，用原参数表查询的 sysParam 对象的 sysParamField 作为 kdy
                //("supType","1,一级供应商")
                sysParamMap.put(sysParam.getSysParamField(), fieldMap);
            } else {
                //判断系统参数的 map 中是否存在字段的 map
                if (sysParamMap.get(sysParam.getSysParamField()) == null) {
                    //再次进行初始化，防止之前数据的干扰
                    fieldMap = new HashMap<String, Object>();
                    //("1","一级供应商")
                    fieldMap.put(sysParam.getSysParamValue(), sysParam.getSysParamText());
                    //系统参数 map
                    //("supType","1,一级供应商")
                    sysParamMap.put(sysParam.getSysParamField(), fieldMap);
                } else {
                    //获得，sysParamMap中存在的 map 集合，
                    //获得 key 为 "supType" 的所有map
                    fieldMap = (Map<String, Object>) sysParamMap.get(sysParam.getSysParamField());
                    //将最新的("3","三级供应商") 放到 相同的 filedMap 中
                    fieldMap.put(sysParam.getSysParamValue(), sysParam.getSysParamText());

                }
            }
        }
        return sysParamMap;
    }
}
