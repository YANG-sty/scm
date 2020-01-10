package com.sys.action;

import com.sys.entity.Account;
import com.sys.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author y_zzu 2019-11-21-20:41
 */
@Controller
@RequestMapping("/account")
public class AccountAction extends BaseAction {
    @Resource
    private AccountService accountService;

    @RequestMapping(value = "/login")
    public String login(Account account, HttpServletRequest request, HttpSession session){
        System.out.println("-------------acction.account: "+account);
        Account account1 = accountService.login(account);
        if(account1 != null){
            //存session
            session.setAttribute("account",account1);
            return "forward:/WEB-INF/main/main.jsp";
        }else {
            request.setAttribute("msg","用户名或密码有误！！！");
            return "forward:/login.jsp";
        }
    }

}
