package net.beifeng.mobile_scm.sup.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import net.beifeng.mobile_scm.sup.entity.MobReturn;
import net.beifeng.mobile_scm.sup.entity.Suptradedetail;

public interface MobReturnService {

    void add(MobReturn mobReturn, Suptradedetail suptradedetail,
            List<Map> snList) throws SQLException;

}
