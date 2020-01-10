package com.sys.dao;

import com.sys.entity.BuyOrderDetail;

import java.util.List;

public interface BuyOrderDetailDao extends BaseDao<BuyOrderDetail> {
    /**
     * 集合数据的添加
     * insert into student value (1,’xiaoming',22),(2,'xiaohong',23);
     * @param buyOrderDetails
     * @return
     */
    public int insertList(List<BuyOrderDetail> buyOrderDetails);
}