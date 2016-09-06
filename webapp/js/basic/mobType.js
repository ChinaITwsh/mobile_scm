var parameter = {
    "mobType.bonusList": []
};

/**
 * 动态填加返利价
 */
function addBonus(){
    //从表单获得原始数据
    var bonusType = $("#bonusType").val();
    var bonusTypeId = bonusType.substring(0, bonusType.indexOf(":"));
    var bonusTypeName = bonusType.substring(bonusType.indexOf(":") + 1);
    var bonusPrice = $("#bonusPrice").val();
    
    //校验
    for (var i = 0; i < parameter["mobType.bonusList"].length; i++) {
        if (parameter["mobType.bonusList"][i].bonusTypeId == bonusTypeId) {
            window.alert("这个类别已经填加！");
            return false;
        }
    }
    
    var price = bonusPrice - 0;
    if (isNaN(price) || price <= 0) {
        window.alert("价格只能为正数！");
        return;
    }
    
    //完成填加
    var bonus = {
        bonusTypeId: bonusTypeId,
        bonusTypeName: bonusTypeName,
        bonusPrice: bonusPrice
    }
    //加入数组
    parameter["mobType.bonusList"].push(bonus);
    //生成新行
    drawNewLine(bonus);
}

function drawNewLine(bonus){
    var tr = $("<tr></tr>").attr("lineId", bonus.bonusTypeId);
    tr.append($("<td></td>").html(bonus.bonusTypeName));
    tr.append($("<td></td>").html((parseFloat(bonus.bonusPrice)).toFixed(2)));
    tr.append($("<td></td>").html("<a href='#' onclick='return delPrice(\"" + bonus.bonusTypeId + "\")'>删除</a>"));
    tr.appendTo($("#tblPrice"));
}

function delPrice(typeId){
    //删除数组中值
    for (var i = 0; i < parameter["mobType.bonusList"].length; i++) {
        if (parameter["mobType.bonusList"][i].bonusTypeId == typeId) {
            break;
        }
    }
    parameter["mobType.bonusList"].splice(i, 1);
    
    //删除表格行
    $("tr[lineId=" + typeId + "]", $("#tblPrice")).remove();
	
	return false;
}

//提交表单
function submitType(frm){
    for (var i = 0; i < parameter["mobType.bonusList"].length; i++) {
        parameter["mobType.bonusList"][i] = JSON.stringify(parameter["mobType.bonusList"][i]);
    }
    //这里可以加入原始的手动验证方式
    //。。。
    ajaxSubmit(frm, parameter);
}

function repass(callback){
    if ($("textarea[name=mobType.remark]").val() == $("input[name=mobType.buyprice]").val()) {
        callback("pass");
    }
    else {
        callback("密码不一致");
    }
}
