package net.beifeng.mobile_scm.test.action;

import java.sql.SQLException;

import net.beifeng.mobile_scm.test.service.TestService;

public class TestAction {

    private String name;

    private TestService testService;

    public String execute() throws SQLException {
        System.out.println(name);
        name = testService.validateName(name);
        return "ret";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTestService(TestService testService) {
        this.testService = testService;
    }

}
