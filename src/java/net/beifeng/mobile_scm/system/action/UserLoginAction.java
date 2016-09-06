package net.beifeng.mobile_scm.system.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.beifeng.mobile_scm.system.entity.SysUsers;
import net.beifeng.mobile_scm.system.service.UserLoginService;

import com.opensymphony.xwork2.ActionContext;

public class UserLoginAction extends BasicAction {

    private static final long serialVersionUID = -5549010450995875964L;
    private String account;
    private String passwd;
    private String vcode;

    private HttpServletResponse response;

    private UserLoginService userLoginService;
    

    public String execute() {

        Map<String, Object> session = ActionContext.getContext().getSession();
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            return null;
        }

        String realVcode = (String) session.get("vcode");
        if (!realVcode.equalsIgnoreCase(vcode)) {
            out.print("vcode error");
            out.close();
            return null;
        }

        SysUsers acc = null;
        try {
            acc = userLoginService.validateUser(account, passwd);
        } catch (SQLException e) {
            out.print("db error");
            out.close();
            return null;
        }
        if (acc == null) {
            out.print("userpass error");
            out.close();
            return null;
        }

        // 将用户信息放入SESSION
        session.remove("vcode");
        session.put("loginUser", acc);
        session.put("skin", acc.getSkin());

        // 查询有权限的Action列表

        try {
            session.put("actionList", userLoginService.getActionList(acc
                    .getRoleIdList()));
        } catch (SQLException e) {
            out.print("db error");
            out.close();
            return null;
        }

        out.print("success");
        out.close();
        return null;
    }

    public void logout() throws Exception {
        request.getSession().invalidate();

        PrintWriter out = response.getWriter();
        out
                .print("<script type='text/javascript'>top.location='start.do'</script>");
        out.close();
    }

    public String close() throws Exception {
        request.getSession().invalidate();
        return "message";
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }

  
    @Override
    public void setServletResponse(HttpServletResponse arg0) {
        this.response = arg0;
    }

    public void setUserLoginService(UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }

}
