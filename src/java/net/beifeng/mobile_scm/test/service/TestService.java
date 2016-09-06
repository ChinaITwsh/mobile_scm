package net.beifeng.mobile_scm.test.service;

import java.sql.SQLException;

public interface TestService {

    public abstract String validateName(String name) throws SQLException;

}