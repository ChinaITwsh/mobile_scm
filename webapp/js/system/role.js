function checkFrm(){
    var oRoleName = $("input[name=role.roleName]");
    if (oRoleName.val().trim().length == 0) {
        oRoleName.focus();
        window.alert("角色名称不能为空！");
        return false;
    }
    return true;
}
