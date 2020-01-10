package com.sys.service;

import com.sys.entity.Supplier;

import java.util.List;
import java.util.Map;

/**
 * @author y_zzu 2019-11-21-20:55
 */
public interface SupplierService extends BaseService<Supplier> {
    List<Map<String, Object>> selectSupplier(Map<String, String> paramMap);
}
