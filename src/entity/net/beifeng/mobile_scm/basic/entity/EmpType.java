package net.beifeng.mobile_scm.basic.entity;

import java.io.Serializable;

public class EmpType implements Serializable {

    private static final long serialVersionUID = -1148042465806789448L;
    private int type;
    private String typeName;

    public EmpType() {
    }

    public EmpType(int type, String typeName) {
        super();
        this.type = type;
        this.typeName = typeName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

}
