package com.sys.action;

import com.sys.entity.SysParam;
import com.sys.service.SysParamService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
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
    public Object insert(SysParam sysParam) {
        //添加到数据库的系统参数表

        return null;
    }

    /**
     * 重新加载参数
     */
    @RequestMapping(value = "/reload")
    @ResponseBody
    public void reloadSysParam(){

    }

    /**
     * 系统启动时加载参数
     */
    @PostConstruct
    public void initSysParam(){
        loadSysParam();
    }

    /**
     * 加载系统参数的方法
     */
    private void loadSysParam(){
        Map<String, Object> sysParamMap = sysParamService.selectList();
        application.setAttribute("sysParam",sysParamMap);
        System.out.println("====================>系统参数加载成功！！！！！！！！！");
    }
}
