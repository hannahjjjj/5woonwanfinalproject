$(function() {
    $(window).scroll(function() {
        if ($(this).scrollTop() > 600) {
            $('.ScrollButton').fadeIn();
        } else {
            $('.ScrollButton').fadeOut();
        }
    });
        
    $("#TopButton").click(function() {
        $('html').animate({scrollTop : 0}, 500);
    });
 
    $("#BottomButton").click(function() {
        $('html').animate({scrollTop : ($('#footer').offset().top)}, 500);
    });
});
