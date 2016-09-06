package net.beifeng.mobile_scm.basic.action;

import java.util.List;

import net.beifeng.mobile_scm.system.action.BasicAction;

public class ConfigAction extends BasicAction {

    private List configList;
    private String config;

    public String list() throws Exception {
        configList = dao.queryList("config.getConfig", null);
        return "list";
    }

    public String addConfig() throws Exception {
        if (dao.queryList("config.getConfig", config).size() > 0) {
            errMap.put("dupCfg", config);
            configList = dao.queryList("config.getConfig", null);
            return "list";
        } else {
            dao.addObj("config.addConfig", config);
            return "succ";
        }
    }

    public String delConfig() throws Exception {
        dao
                .del("config.del", new String(config.getBytes("iso8859-1"),
                        "utf-8"));
        return "succ";
    }

    public List getConfigList() {
        return configList;
    }

    public void setConfig(String config) {
        this.config = config;
    }

}
