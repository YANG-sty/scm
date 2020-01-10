package com.sys.service.impl;

import com.sys.dao.DepartmentDao;
import com.sys.entity.Department;
import com.sys.entity.Page;
import com.sys.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author Administrator
 */
@Service("department")
public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements DepartmentService {
//    /**
//     * Resource 先找名字，没有再去找类型。
//     * Autowired是根据类型进行自动装配的
//     */
//    @Resource
//    private DepartmentDao departmentDao;
//
//    @Override
//    public int insert(Department entity) throws Exception {
//
//        return departmentDao.insert(entity);
//    }
//
//    @Override
//    public int update(Department entity) throws Exception {
//        return 0;
//    }
//
//    @Override
//    public int delete(Department entity) throws Exception {
//        return 0;
//    }
//
//    @Override
//    public int delete(String[] ids) throws Exception {
//        return 0;
//    }
//
//    @Override
//    public Department select(Department entity) {
//        return null;
//    }
//
//    /**
//     * 通过关键字分页查询
//     *
//     * @param page
//     * @return
//     */
//    @Override
//    public Page<Department> selectPageListDyc(Page<Department> page) {
//        return null;
//    }

}
