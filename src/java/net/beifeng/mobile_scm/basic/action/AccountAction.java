package net.beifeng.mobile_scm.basic.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.beifeng.mobile_scm.basic.entity.Account;
import net.beifeng.mobile_scm.basic.entity.Dept;
import net.beifeng.mobile_scm.entity.Message;
import net.beifeng.mobile_scm.system.action.BasicAction;
import net.beifeng.mobile_scm.utils.StringUtils;

@SuppressWarnings("unchecked")
public class AccountAction extends BasicAction {

    private static final long serialVersionUID = -916154233480960968L;

    private List<Dept> deptList;
    private Account account;

    public String list() throws Exception {
        deptList = dao.queryList("dept.getDept", null);
        paginatedQuery("account.getAcc");
        return "list";
    }

    public String toAdd() throws Exception {
        deptList = dao.queryList("dept.getDept", null);
        return "add";
    }

    public String add() throws Exception {
        account.setAccountid(StringUtils.uniqueKey());
        dao.addObj("account.addAcc", account);
        return "succ";
    }

    public String toEdit() throws Exception {
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("account", account);
        account = (Account) dao.queryObject("account.getAcc", paraMap);

        if (account == null) {
            mess = new Message();
            mess.setTitle("帐户不存在");
            mess.setContent("要修改的帐户不存在,可能是其它用户已经删除了此帐户!");
            mess.setLink("account_list.do");
            return "message";
        }

        deptList = dao.queryList("dept.getDept", null);
        return "edit";
    }

    public String edit() throws Exception {
        dao.editObj("account.editAcc", account);
        return "succ";
    }

    public String del() throws Exception {
        dao.del("account.delAcc", account.getAccountid());
        return "succ";
    }

    public List<Dept> getDeptList() {
        return deptList;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
