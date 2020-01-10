package com.sys.action;

import com.sys.entity.Department;
import com.sys.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


@Controller
@RequestMapping("/department")
public class DepartmentAction extends BaseAction{
    @Resource
    private DepartmentService departmentService;

    @RequestMapping(value = "/insert")
    public String insert(Department department) throws Exception {
        System.out.println("-------------action.department:"+department);
        departmentService.insert(department);
        return "forward:/jsp/main.jsp";
    }

}
