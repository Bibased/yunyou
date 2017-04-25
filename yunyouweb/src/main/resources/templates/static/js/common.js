/**
 * Created by dell on 2017/3/31.
 */
var home = "/index.html";
$(function () {
    $("#header-container").load("header.html");
    $("#footer-container").load("footer.html");
});
function createEditor() {
    var editor = new wangEditor('editor');
    editor.config.menus = [
        '|',     // '|' 是菜单组的分割线
        'bold',
        'underline',
        'italic',
        'strikethrough',
        'eraser',
        'forecolor',
        'bgcolor',
        '|',
        'quote',
        'fontfamily',
        'fontsize',
        'head',
        'unorderlist',
        'orderlist',
        'alignleft',
        'aligncenter',
        'alignright',
        '|',
        'link',
        'unlink',
        'table',
        'emotion',
        '|',
        'img',
        'video',
        '|',
        'undo',
        'redo',
        'fullscreen'
    ];
    editor.config.uploadImgUrl="/img/upload";
    editor.config.uploadImgFileName = 'file';
//        editor.config.menuFixed = false;
    editor.create();
}

function getItemsApp(url,userId,cityCode) {
    var app = new Vue({
        el:"#page-box",
        data:{
            items:'',
            currentPage:1,
            totalPage:'',
            userId:userId,
            url:url,
            cityCode:cityCode,
            expense:'',
            startTime:'',
            days:'',
            size:1
        },
        methods:{
            prev: function (){
                if(this.currentPage <= 1) return;
                this.currentPage --;
                this.getPage(this.currentPage);
            },
            next:function() {
                if(this.currentPage >= this.totalPage) return;
                this.currentPage ++;
                this.getPage(this.currentPage);
            },
            getPage:function(index) {
                $.ajax({url:app.url,data:{pageId:index,userIds:app.userId,cityCode:app.cityCode,size:app.size,
                    startTime:app.startTime,expense:app.expense,days:app.days}})
                    .success(function (res,status,jqXHR){
                    console.log(res);
                    app.totalPage  = res.totalPages;
                    app.items = res.content;
                    app.currentPage = index;
                });
            }
        }
    });
    return app;
}

function GetRequest() {
    var url = location.search; //获取url中"?"符后的字串
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        var strs = str.split("&");
        for(var i = 0; i < strs.length; i ++) {
            theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);
        }
    }
    return theRequest;
}
function getStarApp(jumpUrl) {
    var starApp = new Vue({
        el:"#star-list",
        data:{
            stars:'',
            jumpUrl:jumpUrl
        },
        methods:{
            getStars:function() {
                $.ajax({url:'/user/star/query'}).success(function (res,status,jqXHR){
                    console.log(res);
                    starApp.stars = res;
                });
            }
        }
    });
    return starApp;
}
function creteImgs(input) {
    var files = input.files;
    var imgs =new Array();
    for(var i=0;i<files.length;i++){
        file = files[i];
        console.log(file);
        // 那么我们可以做一下诸如文件大小校验的动作
        if(file.size > 1024 * 1024 * 2) {
            alert('图片大小不能超过 2MB!');
            return false;
        }
        // 获取 window 的 URL 工具
        var URL = window.URL ;
        // 通过 file 生成目标 url
        var imgURL = URL.createObjectURL(file);
        imgs[i]=imgURL;
        return imgs;
    }
}
