$(document).ready(function(){
    $(".menu li").on('mouseover',function(){
        $(this).find(".sub").stop().slideDown();
    });
    $(".menu li").on('mouseout',function(){
        $(this).find(".sub").stop().slideUp();
    });