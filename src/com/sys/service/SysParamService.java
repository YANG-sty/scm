package com.sys.service;

import com.sys.entity.SysParam;

import java.util.Map;

/**
 * @author y_zzu 2020-01-07-19:51
 */
public interface SysParamService extends BaseService<SysParam> {

    public Map<String,Object> selectList();
}
