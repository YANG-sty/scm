package com.sys.service.impl;

import com.sys.entity.AccountRecords;
import com.sys.entity.BuyOrder;
import com.sys.entity.BuyOrderDetail;
import com.sys.entity.Goods;
import com.sys.service.BuyOrderService;
import com.sys.service.GoodsService;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author y_zzu 2019-11-21-20:55
 */
@Service("buyOrderService")
public class BuyOrderServiceImpl extends BaseServiceImpl<BuyOrder> implements BuyOrderService {

    @Override
    public int insertBuyOrder(BuyOrder buyOrder) throws Exception {
        System.out.println("---------------------------service.buyOrdder: "+buyOrder.toString());
        int i = 0;
        //生成采购单号，bo 表示采购业务
        //bo -- 商品采购 buyorder
        //ro -- 商品退货
        String boId = "bo" + UUID.randomUUID().toString().replace("-", "");
        //设置采购单号
        buyOrder.setBoId(boId);
        try {
            i = buyOrderDao.insert(buyOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //设置采购明细主键 以及 采购单的外键值
        for (BuyOrderDetail buyOrderDetail : buyOrder.getBuyOrderDetails()) {
            buyOrderDetail.setBodId(UUID.randomUUID().toString().replace("-",""));
            //采购明细的外键，即采购单的主键，
            buyOrderDetail.setBoId(boId);
        }
        try {
            //将采购明细表进行插入
            buyOrderDetailDao.insertList(buyOrder.getBuyOrderDetails());
        } catch (Exception e) {
            e.printStackTrace();
        }

        AccountRecords accountRecords = new AccountRecords();
        //生成并设置 采购记录的主键
        accountRecords.setArId(String.valueOf("ar"+UUID.randomUUID().toString().replace("-","")));
        //经办人
        accountRecords.setArAttn(buyOrder.getBoAttn());
        //欠款
        accountRecords.setArArrears(buyOrder.getBoArrears());
        //bo表示商品采购，可以在参数表中加入相关内容,
        // 类型(业务类型）
        accountRecords.setArBusType("bo");
        //商品采购的时间应该，从系统获得，即在订单提交的时候进行创建
        accountRecords.setArDate(buyOrder.getBoDate());
        //优惠金额：应付金额 - 实付金额 - 欠款
        accountRecords.setArDiscount(buyOrder.getBoPayable().subtract(buyOrder.getBoPaid()).subtract(buyOrder.getBoArrears()));
        //操作员
        accountRecords.setArOperator(buyOrder.getBoOperator());
        //采购单号
        accountRecords.setArOrderId(buyOrder.getBoId());
        //实付
        accountRecords.setArPaid(buyOrder.getBoPaid());
        //应付
        accountRecords.setArPayable(buyOrder.getBoPayable());
        //备注
        accountRecords.setArRemark(buyOrder.getBoRemark());
        //供货商编号
        accountRecords.setSupId(buyOrder.getSupId());

        try {
            //插入数据。
            accountRecordsDao.insert(accountRecords);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return i;
    }





}
