package net.beifeng.mobile_scm.sto.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import sun.awt.RepaintArea;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormat;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import net.beifeng.mobile_scm.sto.entity.StoCount;
import net.beifeng.mobile_scm.sto.entity.StoMobstock;
import net.beifeng.mobile_scm.sup.entity.Suptradedetail;
import net.beifeng.mobile_scm.system.action.BasicAction;
import net.beifeng.mobile_scm.system.entity.SysUsers;

public class MobStockAction extends BasicAction {

    private List<StoCount> countList;
    private List<StoMobstock> detailList;

    private String mobtypeid;

    private String detailType;

    @SuppressWarnings("unchecked")
    public String countMobType() throws Exception {
        // 当前用户查询范围
        SysUsers loginUser = (SysUsers) session.get("loginUser");
        String queryScope = loginUser.getQueryScope();
        String[] orgScope = queryScope.split(",");

        Map map = new HashMap();
        map.put("orgScope", orgScope);
        // 分组汇总查询
        countList = dao.queryList("mobStock.countMobtype", map);

        return "view";
    }

    public String showDetail() throws Exception {
        // 当前用户查询范围
        SysUsers loginUser = (SysUsers) session.get("loginUser");
        String queryScope = loginUser.getQueryScope();
        String[] orgScope = queryScope.split(",");

        Map map = new HashMap();
        map.put("orgScope", orgScope);
        map.put("mobtypeid", mobtypeid);

        // 明细查询
        detailList = dao.queryList("mobStock.getDetail", map);

        // 如何展示数据：jsp, excel
        if ("excel".equals(detailType)) {// 按execel方式处理
            response.setContentType("application/vnd.ms-excel");
            response.setContentType("attach: disop:");
            OutputStream os = response.getOutputStream();
            WritableWorkbook wb = Workbook.createWorkbook(os);
            WritableSheet sheet = wb.createSheet("detail", 0);
            sheet.addCell(new Label(0, 0, "手机型号"));
            sheet.addCell(new Label(1, 0, "串号一"));
            sheet.addCell(new Label(2, 0, "串号二"));
            sheet.addCell(new Label(3, 0, "入库价格"));
            Iterator<StoMobstock> detailIterator = detailList.iterator();
            int rowNo = 1;
            while (detailIterator.hasNext()) {
                StoMobstock mobstock = detailIterator.next();
                sheet.addCell(new Label(0, rowNo, mobstock.getMobtypeid()));
                sheet.addCell(new Label(1, rowNo, mobstock.getSn1()));
                sheet.addCell(new Label(2, rowNo, mobstock.getSn2()));
                sheet.addCell(new Number(3, rowNo, mobstock.getBuyprice()
                        .doubleValue(), new WritableCellFormat(
                        new NumberFormat("#,###.00"))));
                rowNo++;
            }
            wb.write();
            wb.close();
            return null;
        } else {
            return "detail";
        }
    }

    public List<StoCount> getCountList() {
        return countList;
    }

    public void setMobtypeid(String mobtypeid) {
        this.mobtypeid = mobtypeid;
    }

    public List<StoMobstock> getDetailList() {
        return detailList;
    }

    public void setDetailType(String detailType) {
        this.detailType = detailType;
    }
    
    public static void main(String[] args) throws BiffException, FileNotFoundException, IOException {
        Workbook wb = Workbook.getWorkbook(new FileInputStream("aa.xls"));
        Sheet sheet = wb.getSheet(0);
        Cell cell = sheet.getCell(3, 2);
        cell.getType();
        String content = cell.getContents();
        
    }

}
