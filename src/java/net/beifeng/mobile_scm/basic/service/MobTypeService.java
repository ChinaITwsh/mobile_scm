package net.beifeng.mobile_scm.basic.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import net.beifeng.mobile_scm.basic.entity.Mobtype;

public interface MobTypeService {

    void addType(Mobtype mobType) throws SQLException;

    List<Map> getBonus(String mobTypeId) throws SQLException;

    void editType(Mobtype mobType) throws SQLException;

    void delType(String mobtypeid) throws SQLException;

}
