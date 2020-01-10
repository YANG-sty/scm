package com.sys.service.impl;

import com.sys.dao.*;
import com.sys.entity.BuyOrderDetail;
import com.sys.entity.Page;
import com.sys.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

/**
 * @author y_zzu 2019-11-26-16:21
 */
public class BaseServiceImpl<T> implements BaseService<T> {

    protected BaseDao<T> baseDao;

    @Resource
    protected SupplierDao supplierDao;
    @Resource
    protected AccountDao accountDao;
    @Resource
    protected DepartmentDao departmentDao;
    @Resource
    protected GoodsDao goodsDao;
    @Resource
    protected AccountRecordsDao accountRecordsDao;
    @Resource
    protected BuyOrderDao buyOrderDao;
    @Resource
    protected BuyOrderDetailDao buyOrderDetailDao;
    @Resource
    protected SysParamDao sysParamDao;

    //在构造方法后，初始化之前
    @PostConstruct
    private void initBaseDao() throws Exception {
        /*//完成以下逻辑，需要对开发对象进行命名与使用规范
        //this 关键字指对象本身，这里指的是调用此方法的实现类（子类）
        //com.sys.service.impl.SupplierServiceImpl@2bbd4546
        System.out.println("=====================this: "+this);
        //class com.sys.service.impl.BaseServiceImpl
        System.out.println("=====================父类基本信息: "+this.getClass().getSuperclass());
        //com.sys.service.impl.BaseServiceImpl<com.sys.entity.Supplier>
        System.out.println("=====================父类和泛型的信息: "+this.getClass().getGenericSuperclass());

        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        //获取第一个参数的class
        Class clazz = (Class) type.getActualTypeArguments()[0];
        //class com.sys.entity.Supplier
        System.out.println("============================class: "+clazz);
        //转化为属性名（相关的mapper子类的引用名）Supplier supplierDao
        String localField = clazz.getSimpleName().substring(0,1).toLowerCase()+clazz.getSimpleName().substring(1)+"Dao";
        //supplierDao
        System.out.println("============================localField: " + localField);
        //getDeclaredField:可以使用于包括私有、默认、受保护、公共字段，但不包括继承的字段
        Field field = this.getClass().getSuperclass().getDeclaredField(localField);
        //protected com.sys.dao.SupplierDao com.sys.service.impl.BaseServiceImpl.supplierDao
        System.out.println("===========================field: "+field);
        //org.apache.ibatis.binding.MapperProxy@2b5a1cfa
        System.out.println("===========================field对应对的对象: "+field.get(this));

        Field baseField = this.getClass().getSuperclass().getDeclaredField("baseDao");
        //protected com.sys.dao.BaseDao com.sys.service.impl.BaseServiceImpl.baseDao
        System.out.println("==============================baseField: "+baseField);
        //null
        System.out.println("==============================baseField对应的对象未赋值前: "+baseField.get(this));

        //field.get(this)获取当前this的field字段的值。
        // 例如：Supplier对象中，baseDao所指向的对象为其子类型SupplierDao对象，子类型对象已被spring实例化于容器中
        baseField.set(this, field.get(this));
        //org.apache.ibatis.binding.MapperProxy@a0e2803
        System.out.println("==============================baseField对应的对象: "+baseField.get(this));
        //org.apache.ibatis.binding.MapperProxy@a0e2803
        System.out.println("==============================baseField对应的对象: "+baseDao);*/


        //完成以下逻辑，需要对开发对象进行命名与使用规范
        //this 关键字指对象本身，这里指的是调用此方法的实现类（子类）

        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        //获取第一个参数的class
        Class clazz = (Class) type.getActualTypeArguments()[0];
        //转化为属性名（相关的mapper子类的引用名）Supplier supplierDao
        String localField = clazz.getSimpleName().substring(0,1).toLowerCase()+clazz.getSimpleName().substring(1)+"Dao";
        //getDeclaredField:可以使用于包括私有、默认、受保护、公共字段，但不包括继承的字段
        Field field = this.getClass().getSuperclass().getDeclaredField(localField);

        Field baseField = this.getClass().getSuperclass().getDeclaredField("baseDao");

        //field.get(this)获取当前this的field字段的值。
        // 例如：Supplier对象中，baseDao所指向的对象为其子类型SupplierDao对象，子类型对象已被spring实例化于容器中
        baseField.set(this, field.get(this));

    }

    @Override
    public int insert(T entity) throws Exception {
        return baseDao.insert(entity);
    }

    @Override
    public int update(T entity) throws Exception {
        return baseDao.update(entity);
    }

    @Override
    public int delete(T entity) throws Exception {
        return baseDao.delete(entity);
    }

    @Override
    public int delete(String[] ids) throws Exception {
        return baseDao.delete(ids);
    }

    @Override
    public T select(T entity) {
        return baseDao.select(entity);
    }

    /**
     * 通过关键字分页查询
     *
     * @param page
     * @return
     */
    @Override
    public Page<T> selectPageListDyc(Page<T> page) {
        page.setList(baseDao.selectPageListDyc(page));
        page.setTotalRecord(baseDao.selectPageCountDyc(page));
        return page;
    }

}
