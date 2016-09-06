package net.beifeng.mobile_scm.basic.action;

import java.util.List;

import net.beifeng.mobile_scm.system.action.BasicAction;

public class ColorAction extends BasicAction {

    private List colorList;
    private String color;

    public String list() throws Exception {
        colorList = dao.queryList("color.getColor", null);
        return "list";
    }

    public String addColor() throws Exception {
        if (dao.queryList("color.getColor", color).size() > 0) {
            errMap.put("dupClr", "颜色已存在");
            colorList = dao.queryList("color.getColor", null);
            return "list";
        } else {
            dao.addObj("color.addColor", color);
            return "succ";
        }
    }

    public String delColor() throws Exception {
        dao.del("color.del", new String(color.getBytes("ISO8859-1"),"utf-8"));
        return "succ";
    }

    public List getColorList() {
        return colorList;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
