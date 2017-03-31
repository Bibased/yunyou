/**
 * Created by dell on 2017/3/31.
 */
$(function () {
    $("#header-container").load("header.html");
    $("#footer-container").load("footer.html");

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