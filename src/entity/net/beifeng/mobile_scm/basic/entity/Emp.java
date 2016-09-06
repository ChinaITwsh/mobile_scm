package net.beifeng.mobile_scm.basic.entity;

import java.io.Serializable;

import net.beifeng.mobile_scm.system.entity.SysUsers;

public class Emp implements Serializable {

    private static final long serialVersionUID = -4213392252405041338L;
    
    public static final int EMPTYPE_SALES = 1;
    public static final int EMPTYPE_OTHER = 2;

    private String empId;
    private String empName;
    private String tel;

    private Integer empType;
    private String empTypeName;

    private Dept dept;

    private String remark;

    private SysUsers user;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getEmpType() {
        return empType;
    }

    public void setEmpType(Integer empType) {
        if (empType != null) {
            switch (empType) {
            case EMPTYPE_SALES:
                empTypeName = "业务员";
                break;
            case EMPTYPE_OTHER:
                empTypeName = "其它";
                break;
            }
        }
        this.empType = empType;
    }

    public String getEmpTypeName() {
        return empTypeName;
    }

    public void setEmpTypeName(String empTypeName) {
        this.empTypeName = empTypeName;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public SysUsers getUser() {
        return user;
    }

    public void setUser(SysUsers user) {
        this.user = user;
    }

}
