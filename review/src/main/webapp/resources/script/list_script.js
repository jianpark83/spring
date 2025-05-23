$(document).ready(function () {
  // 메뉴 드롭다운 효과
  $(".menu li").on("mouseover", function () {
    $(this).find(".sub").stop().slideDown();
  });

  $(".menu li").on("mouseout", function () {
    $(this).find(".sub").stop().slideUp();
  });
});