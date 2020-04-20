$('.page-reload').click(function() {
    location.reload(true)
});
$('body').on('click', '.modal [data-close]', function() {
    $(this).parents('.modal').fadeOut(); // 替换
    $(this).parents('.modal').hide(); // 替换
    // $('.modal-wrapper').removeClass('slideInUp');
    // $('.modal-wrapper').addClass('slideOutDown');
    $('body').removeClass('open-modal');
    $('#zt-overlay').fadeOut();
    setTimeout("removeOverlay()", 500);
});
$('body').on('click', '.modal .modal-wrapper', function() {
    $(this).parents('.modal').fadeOut(); // 替换
    $(this).parents('.modal').hide(); // 替换
    // $('.modal-wrapper').removeClass('slideInUp');
    // $('.modal-wrapper').addClass('slideOutDown');
    $('body').removeClass('open-modal');
    $('#zt-overlay').fadeOut();
    setTimeout("removeOverlay()", 500);
});
$('body').on('click', '.modal .modal-wrapper>div', function(e) {
    e.stopPropagation();
});
$('body').on('click', '[data-modal]', function() {
    var name = $(this).attr('data-modal');
    $('body').addClass('open-modal');
    $(name).fadeIn(); // 替换
    // $('.modal-wrapper').addClass('animated');
    // $('.modal-wrapper').removeClass('slideOutDown');
    // $('.modal-wrapper').addClass('slideInUp');
    $('body').append('<div id="zt-overlay"></div>');
    $(name).show();
    var top = parseInt((document.body.clientHeight - $(name).find('.modal-wrapper').height()) / 2);
    $(name).find('.modal-wrapper').css('margin-top', top + 'px');
});

$('body').on('click', '.modal', function(e) {
    $(this).fadeOut();
    // $('.modal-wrapper').removeClass('slideInUp');
    // $('.modal-wrapper').addClass('slideOutDown');
    $('body').removeClass('open-modal');
    $('#zt-overlay').fadeOut();
    setTimeout("removeOverlay()", 500);
});

function removeOverlay() {
    $('#zt-overlay').remove();
    $('.modal').hide();
}

$('table .sort').click(function() {

    var top = $(this).find('.top');
    var bottom = $(this).find('.bottom');
    console.log(top.css('display'))
    if (top.css('display') === 'none') {
        top.show().siblings('img').hide();
    } else {
        top.hide().siblings('img').show();
    }
});


// lv-select 下拉选框
$('.lv-select').each(function() {
    var text = $(this).find('dd .active .name').text();
    $(this).find('dt .value').html(text);
});

$('body').on('click', '.lv-select dt', function() {
    var dd = $(this).siblings('dd');
    var isShow = dd.css('display');
    var yes = $(this).find('.yes');
    var no = $(this).find('.no');
    if (isShow === 'none') {
        dd.show();
        yes.show();
        no.hide();
    } else {
        dd.hide();
        no.show();
        yes.hide();
    }
});
$('body').on('click', '.lv-select dd .item', function() {
    var dt = $(this).parent('dd').siblings('dt');
    var dtVal = dt.find('.value');
    var text = $(this).find('.name').text();
    var yes = dt.find('.yes');
    var no = dt.find('.no');
    $(this).addClass('active').siblings('.item').removeClass('active');
    dtVal.html(text);
    $(this).parent().hide();
    no.show();
    yes.hide();
});

/*翻页*/
$('.page-wrapper a').on('click', function() {
    $(this).addClass('active').siblings('a').removeClass('active');
});

function showMessage(msg) {
    $('body').append('<div class="ob-message"><span>' + msg + '</span></div>');
    setTimeout(function() {
        $('.ob-message').remove();
    }, 2000);
}

function closeMessage() {
    $('.ob-message').remove();
}

$('.text-btn').mousedown(function() {
    $(this).addClass('active');
});
$('.text-btn').mouseup(function() {
    $(this).removeClass('active');
});

$('.add-table').mousedown(function() {
    $(this).addClass('active');
});
$('.add-table').mouseup(function() {
    $(this).removeClass('active');
});

$('.order-food-menu-btn').mousedown(function() {
    $(this).addClass('active');
});
$('.order-food-menu-btn').mouseup(function() {
    $(this).removeClass('active');
});

$('.keyboard-btn').mousedown(function() {
    $(this).addClass('active');
});
$('.keyboard-btn').mouseup(function() {
    $(this).removeClass('active');
});

$('.order-food-menu-num-change').mousedown(function() {
    $(this).addClass('active');
});
$('.order-food-menu-num-change').mouseup(function() {
    $(this).removeClass('active');
});
$(function() {
    var ytWidth = $(".yt").width() + 16;
    $(".tb1").width(ytWidth);

    $(".tb2").css("left",ytWidth)




    $(".allCheck").click(function() {
        if ($(this).is(":checked")) {
            $(".allCheck").prop('checked',true)
            $("input[name='pkId']").each(function() {
                this.checked = true;         
                $(this).parents("tr").addClass('hover')
            });
            
        } else {
            $(".allCheck").prop('checked',false)
            $("input[name='pkId']").each(function() {
                this.checked = false;
                $(this).parents("tr").removeClass('hover')
            });
             
        }
    });

    $("input[name='pkId']").click(function(event) {
        /* Act on the event */
       if ($(this).is(":checked")) {
           $(this).attr("checked",true)
            $(this).parents("tr").addClass('hover')
        } else {
            $(this).attr("checked",false)
              $(this).parents("tr").removeClass('hover')
        }
    });

   



})