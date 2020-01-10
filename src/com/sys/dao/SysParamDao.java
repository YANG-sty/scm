package com.sys.dao;

import com.sys.entity.Supplier;
import com.sys.entity.SysParam;

import java.util.List;

/**
 * @author y_zzu 2020-01-07-14:17
 */
public interface SysParamDao extends BaseDao<SysParam> {
    //查询当前表数据
    public List<SysParam> selectList(String type);
    //查询其它表的数据
    public List<SysParam> selectOtherTable(String sql);

}
