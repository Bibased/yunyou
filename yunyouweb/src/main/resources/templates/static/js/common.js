/**
 * Created by dell on 2017/3/31.
 */
var home = "/index.html";
$(function () {
    $("#header-container").load("header.html");
    $("#footer-container").load("footer.html");
    $("#activity-right").load("component/activity-right.html");

});
function createEditor() {
    var editor = new wangEditor('editor');
    editor.config.menus = [
        'bold',
        'forecolor',
        '|',                // '|' 是菜单组的分割线
        'link',
        'unlink',
        'img',
        'video',
        '|',
        'undo',
        'redo',
        'fullscreen',
    ];
    editor.config.uploadImgUrl="/user/file/uploadImg";
//        editor.config.menuFixed = false;
    editor.create();
}



Date.prototype.Format = function (fmt) { //author: meizz
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "H+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}