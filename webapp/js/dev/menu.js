/** 菜单类型：无子菜单*/
var MENUTYPE_NODE = 2;
var MENUTYPE_LINE = 3;

/**
 * 显示隐藏动作输入框
 * @param {Object} o
 */
function showHideActionRow(o){
    if (o.value == MENUTYPE_NODE) {
        $("#actionRow").css("display", "");
        $("input[name=menu.action.actionName]").removeAttr("disabled");
    } else {
        $("#actionRow").css("display", "none");
        $("input[name=menu.action.actionName]").attr("disabled", true);
    }
    
    if (o.value == MENUTYPE_LINE) {
        $("#menuNameRow").css("display", "none");
    } else {
        $("#menuNameRow").css("display", "");
    }
}

/**
 * 菜单表单校验
 */
function validateFrm(){
    var oMenuName = $("input[name=menu.menuName]");
    if (oMenuName.val().trim().length == 0 &&
    $("select[name=menu.type]").val() != MENUTYPE_LINE) {
        oMenuName.focus();
        window.alert("菜单名不能为空！");
        return false;
    }
    return true;
}

/**
 * 动作表单校验
 */
function validateActionFrm(){
	var oActionName = $("input[name=action.actionName]");
	if (oActionName.val().trim().length == 0) {
		oActionName.focus();
		window.alert("动作不能为空!");
		return false;
	}
	return true;
}
