"use strict";
(function(){
  var $menu = $('.menu > ul');
  var $menu_content = $('.menu-content >div');
  // initial
  $menu_content.hide();
  $menu_content.eq(0).show();
  $menu.find('li').eq(0).addClass('my-active');
  // event bind
  $menu.delegate('li', 'click', function(){
    var index = $(this).index()
    //hide all
    $menu.find('li').removeClass('my-active')
    $(this).addClass('my-active');
    $menu_content.fadeOut(300, function(){
      $menu_content.eq(index).show();
    });
  }) 

})()