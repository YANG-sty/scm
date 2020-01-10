package com.sys.action;

import com.sys.dao.BaseDao;
import com.sys.entity.Goods;
import com.sys.entity.Page;
import com.sys.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author y_zzu 2019-11-26-20:29
 */
@Controller
@RequestMapping("/goods")
public class GoodsAction extends BaseAction {
    @Resource
    private GoodsService goodsService;

    /**
     * 添加商品
     * @param goods
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/insert")
    @ResponseBody
    public int insert(Goods goods) throws Exception{
        System.out.println("---------------action.goods: "+goods.toString());
        int i = 0;
        i = goodsService.insert(goods);
        return i;
    }

    /**
     * 修改商品
     * @param goods
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Object update(Goods goods) throws Exception {
        System.out.println("----------------------update.goods: ");
        int i = 0;
        i = goodsService.update(goods);
        return i;
    }

    /**
     * 删除商品
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "deleteList")
    @ResponseBody
    public Object deleteList(String[] ids) throws Exception {
        System.out.println("------------------------------deleteList.goods : ");
        int i = 0;
        i = goodsService.delete(ids);
        return i;
    }
    /**
     * 通过关键字分页查询
     * @param page
     * @param goods
     * @return
     */
    @RequestMapping("/selectPageListDyc")
    @ResponseBody
    public Object selectPageListDyc(Page<Goods> page, Goods goods){
        page.setParamEntity(goods);
        Page p = goodsService.selectPageListDyc(page);
        return p.getPageMap();
    }
}
