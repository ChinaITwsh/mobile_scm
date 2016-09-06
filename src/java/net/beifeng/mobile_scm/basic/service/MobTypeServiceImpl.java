package net.beifeng.mobile_scm.basic.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.beifeng.mobile_scm.basic.entity.BonusPrice;
import net.beifeng.mobile_scm.basic.entity.Mobtype;
import net.beifeng.mobile_scm.dao.CommonDao;
import net.beifeng.mobile_scm.utils.StringUtils;
import net.sf.json.JSONObject;

public class MobTypeServiceImpl implements MobTypeService {

    private CommonDao dao;

    @Override
    public void addType(Mobtype mobType) throws SQLException {

        dao.addObj("mobType.addType", mobType);
        dao.batchInsert("mobType.addBonusPrice", getBonusPriceList(mobType));
    }

    @Override
    public void editType(Mobtype mobType) throws SQLException {

        dao.editObj("mobType.editType", mobType);

        dao.del("mobType.delBonusPrice", mobType.getMobtypeid());

        dao.batchInsert("mobType.addBonusPrice", getBonusPriceList(mobType));

    }

    @Override
    public void delType(String mobtypeid) throws SQLException {
        dao.del("mobType.delType", mobtypeid);
        dao.del("mobType.delBonusPrice", mobtypeid);
        
    }

    private List<BonusPrice> getBonusPriceList(Mobtype mobType) {
        List<BonusPrice> bonusPriceList = new ArrayList<BonusPrice>();
        String[] bonusList = mobType.getBonusList();

        for (String strBonus : bonusList) {
            JSONObject js = JSONObject.fromObject(strBonus);
            BonusPrice bonusPrice = (BonusPrice) JSONObject.toBean(js,
                    BonusPrice.class);
            bonusPrice.setId(StringUtils.uniqueKey());
            bonusPrice.setMobTypeId(mobType.getMobtypeid());
            bonusPriceList.add(bonusPrice);
        }
        return bonusPriceList;
    }

    @Override
    public List<Map> getBonus(String mobTypeId) throws SQLException {
        return dao.queryList("mobType.getBonus", mobTypeId);
    }

    public void setDao(CommonDao dao) {
        this.dao = dao;
    }
}
