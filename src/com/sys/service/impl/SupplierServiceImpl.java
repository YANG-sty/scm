package com.sys.service.impl;

import com.sys.dao.SupplierDao;
import com.sys.entity.Page;
import com.sys.entity.Supplier;
import com.sys.service.BaseService;
import com.sys.service.SupplierService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author y_zzu 2019-11-21-20:55
 */
@Service("supplierService")
public class SupplierServiceImpl extends BaseServiceImpl<Supplier> implements SupplierService {
    @Override
    public List<Map<String, Object>> selectSupplier(Map<String, String> paramMap) {

        return supplierDao.selectSupplier(paramMap);
    }
//    @Resource
//    private SupplierDao supplierDao;
//
//    @Override
//    public int insert(Supplier entity) throws Exception {
//        return supplierDao.insert(entity);
//    }
//
//    @Override
//    public int update(Supplier entity) throws Exception {
//        return supplierDao.update(entity);
//    }
//
//    @Override
//    public int delete(Supplier entity) throws Exception {
//        return 0;
//    }
//
//    @Override
//    public int delete(String[] ids) throws Exception {
//        return supplierDao.delete(ids);
//    }
//
//    @Override
//    public Supplier select(Supplier entity) {
//        return null;
//    }
//
//    /**
//     * 通过关键字分页查询
//     * @param page
//     * @return
//     */
//    @Override
//    public Page<Supplier> selectPageListDyc(Page<Supplier> page) {
//        page.setList(supplierDao.selectPageListDyc(page));
//        page.setTotalRecord(supplierDao.selectPageCountDyc(page));
//        return page;
//    }
}
