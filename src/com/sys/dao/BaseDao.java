package com.sys.dao;

import com.sys.entity.Page;

import java.util.List;

/**
 * @author y_zzu 2019-11-21-17:29
 */
public interface BaseDao<T> {
    /**
     * 添加单个对象
     * @param entity 对象
     * @return
     */
    public int insert(T entity);

    /**
     * 修改单个对象
     * @param entity 对象
     * @return
     */
    public int update(T entity);

    /**
     * 删除单个对象
     * @param entity 对象
     * @return
     */
    public int delete(T entity);

    /**
     * 删除多个对象。
     * @param ids
     * @return
     */
    public int delete(String[] ids);

    /**
     * 查询单个对象
     * @param entity 对象
     * @return
     */
    public T select(T entity);

    /**
     * 多关键字分页查询数据列表
     * @param page
     * @return
     */
    public List<T> selectPageListDyc(Page<T> page);

    /**
     * 通过关键字分页查询数据列表
     * @param page
     * @return
     */
    public List<T> selectPageListUseDyc(Page<T> page);

    /**
     * 多关键字分页查询，返回总记录数
     * @param page
     * @return
     */
    public Integer selectPageCountDyc(Page<T> page);

}
