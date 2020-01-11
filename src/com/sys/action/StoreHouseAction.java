package com.sys.action;

import com.sys.entity.Goods;
import com.sys.entity.Page;
import com.sys.entity.StoreHouse;
import com.sys.service.GoodsService;
import com.sys.service.StoreHouseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * @author y_zzu 2019-11-26-20:29
 */
@Controller
@RequestMapping("/storeHouse")
public class StoreHouseAction extends BaseAction {
    @Resource
    private StoreHouseService storeHouseService;

    /**
     * 添加商品
     * @param storeHouse
     * @return
     * @throws Exception
     */
    @RequestMapping("/insert")
    @ResponseBody
    public int insert(StoreHouse storeHouse) throws Exception{
        System.out.println("---------------action.storeHouse.insert: "+storeHouse.toString());
        int i = 0;
        i = storeHouseService.insert(storeHouse);
        if (i > 0) {
            //重新加载系统参数
            loadSysParam();
        }
        return i;
    }

    /**
     * 修改商品
     * @param storeHouse
     * @return
     * @throws Exception
     */
    @RequestMapping("/update")
    @ResponseBody
    public Object update(StoreHouse storeHouse) throws Exception {
        System.out.println("----------------------update.storeHouse.update: "+storeHouse.toString());
        int i = 0;
        i = storeHouseService.update(storeHouse);
        if (i > 0) {
            //重新加载系统参数
            loadSysParam();
        }

        return i;
    }

    /**
     * 删除商品
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping("/deleteList")
    @ResponseBody
    public Object deleteList(String[] ids) throws Exception {
        System.out.println("------------------------------deleteList.storeHouse.deleteList : "+ Arrays.asList(ids).toString());
        int i = 0;
        i = storeHouseService.delete(ids);
        return i;
    }
    /**
     * 通过关键字分页查询
     * @param page
     * @param storeHouse
     * @return
     */
    @RequestMapping("/selectPageListDyc")
    @ResponseBody
    public Object selectPageListDyc(Page<StoreHouse> page, StoreHouse storeHouse){
        page.setParamEntity(storeHouse);
        Page p = storeHouseService.selectPageListDyc(page);
        return p.getPageMap();
    }


}
