package com.sys.dao;


import com.sys.entity.Supplier;

import java.util.List;
import java.util.Map;

/**
 * @author y_zzu by
 */
public interface SupplierDao extends BaseDao<Supplier> {
    /**
     * 时间查询，start< time < end
     * @param paramMap
     * @return
     */
    List<Map<String, Object>> selectSupplier(Map<String, String> paramMap);
}