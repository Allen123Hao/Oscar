/**
 * Created by AllenHao on 2016/11/4.
 */
function exportExcle(){
    $.ajax({
        url:"/oscar/export.do",
        type:"GET",
        dataType:"JSON",
        //data:{
        //    "industry":"金融app",
        //    "list":[{"name":"蚂蚁金服","rank":"第一名"},{"name":"陆金所","rank":"第二名"}]
        //},
        cache:false,
        success:function(res){
            console.log(res);
        },
        error:function(res){
            console.log(res);
        }
    });
}
