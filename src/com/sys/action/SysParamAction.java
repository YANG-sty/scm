package com.sys.action;

import com.sys.entity.Page;
import com.sys.entity.SysParam;
import com.sys.service.SysParamService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Map;

/**
 * 系统参数
 * @author y_zzu 2020-01-08-16:14
 */
@Controller
@RequestMapping("/sysParam")
public class SysParamAction extends BaseAction{
    @Resource
    private SysParamService sysParamService;

    /**
     * 添加系统参数
     * @param sysParam
     * @return
     */
    @RequestMapping(value = "/insert")
    @ResponseBody//如果返回json格式，需要这个注解，这里用来测试环境
    public Object insert(SysParam sysParam) throws Exception {
        System.out.println("---------------------action.sysparam.insert:"+sysParam.toString());
        //添加到数据库的系统参数表
        int i = sysParamService.insert(sysParam);
        if (i > 0) {
            //重新加载系统参数
            loadSysParam();
        }
        return i;
    }

    /**
     * 修改系统参数
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(SysParam sysParam) throws Exception {
        System.out.println("---------------------action.sysparam.update:"+sysParam.toString());
        //更新
        int i = sysParamService.update(sysParam);
        if (i > 0) {
            //重新加载系统参数
            loadSysParam();
        }
        return i;
    }

    /**
     * 删除，需要考虑其他地方有没有引用该数据，
     * 否则在显示数据的时候，会出现，之前还有数据显示，在删除之后显示的内容为空。
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "deleteList")
    @ResponseBody
    public Object deleteList(String[] ids) throws Exception {
        System.out.println("------------------------------action.sysparam.deleteList:"+ Arrays.asList(ids).toString());
        int i = 0;
        i = sysParamService.delete(ids);
        if (i > 0) {
            //重新加载系统参数
            loadSysParam();
        }
        return i;
    }

    /**
     * 查询数据
     * @param page
     * @param sysParam
     * @return
     */
    @RequestMapping(value = "/selectPageListDyc")
    @ResponseBody //如果返回json 格式的数据
    public Object selectPageListDyc(Page<SysParam> page, SysParam sysParam){
        page.setParamEntity(sysParam);
        System.out.println("----------action.sysParam.page: "+page.toString());

        Page p = sysParamService.selectPageListDyc(page);
        return p.getPageMap();
    }


    /**
     * 重新加载参数
     * 貌似没有用到
     * 将 loadSysParam() 方法抽取到BaseAction中，
     * 在其它action 中的方法对 系统参数的数据进行修改后，重新加载一遍系统的参数信息。
     */
    @RequestMapping(value = "/reload")
    @ResponseBody
    public void reloadSysParam(){
        loadSysParam();
    }

    /**
     * 系统启动时加载参数
     */
    @PostConstruct
    public void initSysParam(){
        loadSysParam();
    }

}
