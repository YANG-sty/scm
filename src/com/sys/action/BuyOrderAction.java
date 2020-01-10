package com.sys.action;

import com.sys.entity.BuyOrder;
import com.sys.entity.BuyOrderDetail;
import com.sys.service.BuyOrderService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Arrays;


@Controller
@RequestMapping("/buyOrder")
public class BuyOrderAction extends BaseAction{
    @Resource
    private BuyOrderService buyOrderService;

    @RequestMapping(value = "/insert")
    @ResponseBody
    public Object insert(BuyOrder buyOrder, String rows){

        // 提供 json 格式数据转 java 对象
        ObjectMapper mapper = new ObjectMapper();

        int i = 0 ;
        try {
            BuyOrderDetail[] buyOrderDetails = mapper.readValue(rows, BuyOrderDetail[].class);
            buyOrder.setBuyOrderDetails(Arrays.asList(buyOrderDetails));
            i = buyOrderService.insertBuyOrder(buyOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

}
