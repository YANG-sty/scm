package com.sys.action;

import com.sys.entity.Page;
import com.sys.entity.Supplier;
import com.sys.service.SupplierService;
import com.sys.servlet.SysInitServlet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author y_zzu 2019-11-21-20:57
 */
@Controller
@RequestMapping("/supplier")
public class SupplierAction extends BaseAction {

    @Resource
    private SupplierService supplierService;

    /**
     * 时间查询
     * @param start 开始时间
     * @param end 结束时间
     * @return
     */
    @RequestMapping("/selectSupplier")
    @ResponseBody
    public Object selectSupplier(String start,String end){
        System.out.println("start:"+ start+"||end:"+end);
        Map<String, String> paramMap =new HashMap<String, String>();
        paramMap.put("start", start);
        paramMap.put("end", end);

        return supplierService.selectSupplier(paramMap);
    }

    /**
     * 添加供应商
     * @param supplier
     * @throws Exception
     */
    @RequestMapping(value = "/insert")
    @ResponseBody //如果返回json 格式的数据
    public Object insert(Supplier supplier) throws Exception {
        System.out.println("----------action.supplier: "+ supplier);
        int i = 0;
        i = supplierService.insert(supplier);
        return i;
    }

    @RequestMapping(value = "/selectPageListDyc")
    @ResponseBody //如果返回json 格式的数据
    public Object selectPageListDyc(Page<Supplier> page, Supplier supplier){
        page.setParamEntity(supplier);
        System.out.println("----------page: "+page);

        Page p = supplierService.selectPageListDyc(page);
        return p.getPageMap();
    }
    
    @RequestMapping(value = "update")
    @ResponseBody
    public Object update(Supplier supplier) throws Exception {
        System.out.println("-------------------------update.action:");
        int i = 0;
        i = supplierService.update(supplier);
        return i;
    }

    @RequestMapping(value = "deleteList")
    @ResponseBody
    public Object deleteList(String[] ids) throws Exception {
        System.out.println("------------------------------deleteList.action:");
        int i = 0;
        i = supplierService.delete(ids);
        return i;
    }


//    @RequestMapping(value = "/doAjax")
//    @ResponseBody //返回json 格式
//    public Object doAjax(Supplier supplier){
//        System.out.println("-------------doAjax.supplier: "+ supplier);
//        supplier.setSupName("supName-test");
//        return supplier;
//    }
}
