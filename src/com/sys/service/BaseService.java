package com.sys.service;

import com.sys.entity.Page;

/**
 * @author y_zzu 2019-11-21-17:34
 */
public interface BaseService<T> {
    //添加单个对象
    public int insert (T entity) throws Exception;

    //修改单个对象
    public int update(T entity) throws Exception;

    //删除单个对象
    public int delete(T entity) throws Exception;

    //删除多个对象
    public int delete(String[] ids) throws Exception;

    //查询单个对象
    public T select(T entity);

    /**
     * 通过关键字分页查询
     * @param page
     * @return
     */
    public Page<T> selectPageListDyc(Page<T> page);


}
