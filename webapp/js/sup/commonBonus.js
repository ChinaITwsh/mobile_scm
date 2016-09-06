$().ready(function(){
    $("input[name=startdate]").datepicker();
    $("input[name=enddate]").datepicker();
})

function querySn(supid, mtid, sd, ed){
    window.showModalDialog("commonBonus_toQuerySn.do?supplierid=" + supid + "&mobtypeid=" + mtid + "&startdate=" + sd + "&enddate=" + ed + "&ts=" + new Date().getTime(), null, "center:true,dialogWidth:800,dialogHeight:500");
}
