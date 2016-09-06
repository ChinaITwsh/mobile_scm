$().ready(function(){
    $("select[name=supTypeId]").relate($("select[name=supplierid]"));
    $("select[name=brand]").relate($("select[name=mobtypeid]"));
    
    
    $("input[name=returnprice]").bind("propertychange input", function(){
    
        $("input[name=totalmoney]").val(this.value * $("input[name=amount]").val());
    })
    
    $("input[name=sn1]").keypress(function(event){
        if (event.keyCode == 13) {
            addSn();
        }
    })
    
});

var sns = [];

function addSn(){

    var sn1 = $("input[name=sn1]").val().trim();
    
    if (sn1.length == 0) {
        $("input[name=sn1]").focus();
        return;
    }
    
    var sn = {
        sn1: sn1
    };
    
    $("input[name=sn1]").val("");
    $("input[name=sn1]").focus();
    
    for (var i = 0; i < sns.length; i++) {
        if (sns[i].sn1 == sn1) {
            sn.status = "已输入";
            return;
        }
    }
    
    //加入表格行
    var tr = $("<tr></tr>");
    $("<td></td>").appendTo(tr);
    $("<td>" + sn1 + "</td>").appendTo(tr);
    $("<td name='sn2'></td>").appendTo(tr);
    $("<td name='sup'></td>").appendTo(tr);
    $("<td name='mtype'></td>").appendTo(tr);
    $("<td><a href='#' onclick='return delSn(\"" + sn1 + "\")'>删除</a></td>").appendTo(tr);
    $("<td></td>").appendTo(tr);
    
    $("#tblSns").append(tr);
    
    
    
    setSerial();
    
    sns.push(sn);
    
    if (i == sns.length - 1) {
        $.getJSON("mobReturn_snExist.do", sn, function(data){
            var mobstock = data.mobstock;
            
            if (!mobstock) {
                sn.status = "这个串号不存在";
            }
            else {
                sn.status = "OK";
                sn.sn2 = mobstock.sn2;
                sn.supName = mobstock.firstSupName;
                sn.mobTypeName = mobstock.mobTypeName;
            }
            
            $("td:last", tr).html(sn.status);
            $("td[name=sn2]", tr).html(sn.sn2);
            $("td[name=sup]", tr).html(sn.supName);
            $("td[name=mtype]", tr).html(sn.mobTypeName);
			
            
            //数量
            var amount = 0;
            for (var j = 0; j < sns.length; j++) {
                if (sns[j].status == "OK") {
                    amount++;
                }
            }
            $("input[name=amount]").val(amount);
            
            //总价格
            var returnprice = $("input[name=returnprice]").val();
            if (returnprice.trim().length > 0) {
                $("input[name=totalmoney]").val(returnprice * amount);
            }
            else {
                $("input[name=totalmoney]").val("NaN");
            }
        })
    }
}


function setSerial(){
    var s = 0;
    $("tr", $("#tblSns")).each(function(){
        $("td:first", $(this)).html(s++);
    })
}

function submitFrm(frm){
    var strSns = [];
    for (var i = 0; i < sns.length; i++) {
        var sn = sns[i];
        if (sn.status == "OK") {
            strSns.push(sn.sn1 + "," + sn.sn2);
        }
        //alert(strSns[i])
    }
    //验证
    //.....
    ajaxSubmit(frm, {
        sns: strSns
    });
}

function delSn(sn1){
    $("tr", $("#tblSns")).each(function(){
        if ($("td:eq(1)", $(this)).html() == sn1) {
            $(this).remove();
        }
    })
    
    for (var i = 0; i < sns.length; i++) {
        if (sns[i].sn1 == sn1) {
            sns.splice(i, 1);
            break;
        }
    }
    setSerial();
    return false;
}
