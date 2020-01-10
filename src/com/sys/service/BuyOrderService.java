package com.sys.service;

import com.sys.entity.BuyOrder;
import com.sys.entity.Goods;

/**
 * @author y_zzu 2019-11-21-20:55
 */
public interface BuyOrderService extends BaseService<BuyOrder> {

    public int insertBuyOrder(BuyOrder buyOrder) throws Exception;
}
