
$(function() {
	var londingmain=$(".loading_main");
/*	setTimeout(function(){
	   $(".loading_main").fadeOut(1000)
	},2000);*/
    setTimeout(function() {
                $('.loading_main').animate({
                    opacity: 0,
                    'z-index': "-"+1,
					display:"none"
                }, 600);
				$(".loading_main").fadeOut()
            }, 2000)
			$('.loading_main').click(function(){
			    $(this).animate({
                    opacity: 0,
                    'z-index': "-"+1
                }, 600);
				$(this).fadeOut()
	})
	$(".popupclickshow").click(function(){
      $(".popup").fadeIn().css("display","table");
	  
   });
   $(".busessclickshow_abouts").click(function(){
      $(".business_about_pop").fadeIn().css("display","table");
	  
	  
   });
   
   $(".busessclickshow_about").click(function(){
      $(".popup").fadeIn().css("display","table");
   });
   $(".popupclickhide").click(function(){
      $(".popup").fadeOut();
	  $("body").unbind("touchmove")
   });	
   $(".popup").bind("click",function(evt){
	   if($(evt.target).parents(".popupmain").length==0) {
	    $(".popup").fadeOut();
		$("body").unbind("touchmove")
	   }
    });

});
$(window).scroll(function() {
  var scrollTops = document.body.scrollTop || document.documentElement.scrollTop;
  if(scrollTops>5){
     $(".mhd").css({"position":"fixed"});
	 $(".mhd_fixndbox").css({"position":"fixed"});
  }else{
     $(".mhd").css({"position":"absolute"});
	 $(".mhd_fixndbox").css({"position":"fixed"});
  }
});
$(function() {
     $('.listsewwnnav .col-item').click(function(){
         $(this).parents(".listsewwnnav").css({"height":"100%"});
		 /*$('body').on('touchmove', function (event) {
			event.preventDefault();
		});*/
		 $('body').css({"overflow":"hidden"})
	});	
    $(".listsewwnnav .col-item").focus(function(){
      $(this).parents(".listsewwnnav").css({"height":"100% "});
	  $('body').on('touchmove', function (event) {
			event.preventDefault();
		});
    });
	$('.listsewwnnav .col-item').blur(function(){
          $(this).parents(".listsewwnnav").css({"height":"auto"});
		  
	});	
});

$(function (){
	var $listscreennetab = $('.prolist-screen .prolist-screen_group .col-item');
		$listscreennetab.click(function(){
			$(".prolist-screen_mian").show();
			
			$(this).addClass('art').siblings().removeClass('art');
			var index = $listscreennetab.index(this);
			$('.prolist-screen_mian .maingroup').eq(index).show().siblings().hide();
	});	
	
	var $listscreennearbytab = $('.screen_nearby .screen_nearby_hd ul li');
		$listscreennearbytab.hover(function(){
			$(this).addClass('art').siblings().removeClass('art');
			var index = $listscreennearbytab.index(this);
			$('.screen_nearby .screen_nearby_mc .screen_nearby_group').eq(index).show().siblings().hide();
	});	
	var $listscreennearbytab_list = $('.screentabox .category_hdtab .seectabhditem');
		$listscreennearbytab_list.click(function(){
			$(this).addClass('art').siblings().removeClass('art');
			var index = $listscreennearbytab_list.index(this);
			$('.screentabox .category_mincontab .secmaingroup').eq(index).show().siblings().hide();
	});	
	
	var $addsenbtab = $('.addsengroup .addsenitem');
		$addsenbtab.click(function(){
			$(this).toggleClass("art");
	});
	$(".screen_term_button .btn_reset")	.click(function(){
	   $addsenbtab.removeClass("art");  
	});
	
	
	
});
/*选择城市- */
function cityseach(){
	   $("#citysearchnatex").hide();
	   $("#citysearchdon").show();
};
function cityseachreturns(){
	   $("#citysearchnatex").show();
	   $("#citysearchdon").hide();
};
/*选择城市-返回顶部*/
function b() {
	var sorun=parseInt($(window).scrollTop());
	if(sorun >=100){
		 $("#moquu_top").show();
	}else{
	    $("#moquu_top").hide();
}}
$(document).ready(function() {
   b(),
   $("#moquu_top").click(function() {
   $(document).scrollTop(0)
   })
}),
$(window).scroll(function() {
b()
});

/*登录*/
$(function() {
	 var $tabboxcol = $('.tabboxcol .tabbox_hd .nvitem');
		$tabboxcol.click(function(){
			$(this).addClass('art').siblings().removeClass('art');
            var index = $tabboxcol.index(this);
			$('.tabboxcol .tabbox_group .tabbox_slide').eq(index).show().siblings().hide();
	});	
});


/*点餐 -单品 口味。*/
$(function() {
	 $('.cookton_main .cookton_group ul li').click(function(){
			$(this).addClass('art').siblings().removeClass('art');
	});	
	$(".singleremarks_btn").click(function(){
	    $(".cookbookbobopinpainx_prpop").scrollTop(1000);
		//alert($(".cookbookbobopinpainx_prpop").height())
	    $(this).parents(".cookton_main").children(".singleremarksbox").toggle();
	})
});

function cooktonssbox() {
       $(".cookbookbobopinpainx_prpop").fadeIn();
	   $(".buseemeunmain").css({"overflow":"hidden"})
	   /*$('body').on('touchmove', function (event) {
			event.preventDefault();
		});*/
		//$(".cookbookbobopinpainx_prpop").unbind("touchmove")
};
$(function() {
	 $(".cookbookbobopinpainx_prpop").bind("click",function(en){
	   if( $(en.target).closest(".cookbookboxmain").length == 0){ 
	    $(".cookbookbobopinpainx_prpop").fadeOut();
		 $(".buseemeunmain").css({"overflow":"auto"})
		$("body").unbind("touchmove")
	   }
    });
     $('.cookbookbox_close').click(function(){
		$(this).parents(".cookbookbobopinpainx_prpop").fadeOut();
	});	
    
    $(".book_historyrecord .book_historyrecord_hd").click(function(){
	   $(".book_historyrecord_con").toggle();
	   $(document).scrollTop(1000);
    });
});
/*订座。*/

$(function() {
	$(".unmritnicoenum").click(function(){
	   $(this).siblings(".usenmiconmarname").hide();
	   $(this).find(".pcanmunsec").addClass("art");
	   $(this).addClass("coickart");
   });
   $(".dainvunbtnchi").click(function(){
	  $(this).toggleClass("art")
      $("#daidingbocim").toggle();
	  $(document).scrollTop(100);
   });
});
/*订单详情。*/
$(function() {
	 $('.details_colgroup .details_colitemhd').click(function(){
			$(this).siblings(".details_coltiem").toggle();
	});	
});

/*商品相册 */
function clickalbumbtn(){
	   $(".busrinwhoec_pop").addClass("busrinwhoec_popart").show();
       $('body').on('touchmove', function (event) {
			event.preventDefault();
		});
};
$(function() {
   $(".business_album_prpop").bind("click",function(evt){
	    $(".popup").fadeOut();	   
    });
});
/*评论 */
$(function() {
   $(".business_comment_pandect .littgroup .listitem").click(function(evt){
	    $(this).addClass('art').siblings().removeClass('art');  
    });
});
/*座位 */
$(function() {
   $(".electseat_conbox_congusk .seatminrow .seatliitem").click(function(evt){
	    $(this).toggleClass('artrive');  
    });
	$(".electseat_conbox_congusk .seatminrow.seatminrow_selected.mysecond .seatliitem").unbind();
	$(".electseat_conbox_congusk .businesshopseat_coltiensec").click(function(evt){
	   $(this).parents(".businesshopseat_colcell").find(".seatminrow").toggle(); 
	   //$(this).find(".icn_a").toggle();
	   //$(this).find(".icn_b").toggle();
    });
});


$(function() {
		$('.spinmou').click(function(){
			$(this).addClass('delf').siblings().removeClass('delf');
	});	
});
$(function() {
	$('.ogon_heaferrightnav').click(function(){
			$(this).find(".navgroup").fadeToggle();
	});
	$(document).bind("click",function(evt){
	   if($(evt.target).parents(".ogon_heaferrightnav").length==0) {
	    $(".ogon_heaferrightnav").find(".navgroup").fadeOut()
	
	   }
    });
	
});

$(document).ready(function(){
    $(".icoarrow").click(function(){
       $(this).toggleClass('art');
	   $(".container .ico").toggleClass("icon-xiangshang2");
	   $(".container .ico").toggleClass("icon-xialajiantou");
       $('.lorlogin-grouppopup').fadeToggle();
	});
});
/*在线订座 - 选择性别*/
$(function() {
		$('.busonbook_formsexitem .formsexitem').click(function(){
			$(this).addClass('artitem').siblings().removeClass('artitem');
	});	
});

$(function() {
		$('.business_onlinebooking_group .titem').click(function(){
			$(this).addClass('art').siblings().removeClass('art');
	});	
});
/*$(window).scroll(function() {
  var woein=parseInt($(window).scrollTop());
	if(woein >=48){
		 $(".m_order").addClass("m_order_fiend");
	}else{
	    $(".m_order").removeClass("m_order_fiend");; 
	}
		
});*/
/*购物车*/
$(function() {
	
     /*$('.shoppingcart_numf').click(function(){
         $(this).parents(".businessmeun_Settlement").toggleClass("businessmeun_ordbox");
	});	*/
    $(".businessmeun_ordermbox").focus(function(){
       $(this).parents(".businessmeun_Settlement").addClass("businessmeun_ordbox");
    });
	$('.businessmeun_ordermbox').blur(function(){
         $(this).parents(".businessmeun_Settlement").removeClass("businessmeun_ordbox");
	});	
	
	$(".businessmeun_Settlement").bind("click",function(evt){
	if($(evt.target).parents(".ordergoodsto").length==0) {
	   $(this).removeClass("businessmeun_ordbox");
	}
	});
	
});
/*收藏*/
$(function() {
	$('.shopcollect_srenn').click(function(){
		$(this).hide();
		$(".shopcollect_cancel").fadeIn();
		$(".shopcollectpopup").fadeIn();
		$(".shopcollectpopup").fadeOut(2000);
		$(".shopcollectpopup i").removeClass().addClass("iconshoucangico7").css("color","#f30000");
		$(".shopcollectpopup p").html("收藏成功");
	});	
	$('.shopcollect_cancel').click(function(){
		$(this).hide();
		$(".shopcollect_srenn").fadeIn();
		$(".shopcollectpopup").fadeIn();
		$(".shopcollectpopup").fadeOut(2000);
		$(".shopcollectpopup i").removeClass().addClass("icon-shoucang").css("color","#fff");
		$(".shopcollectpopup p").html("取消收藏");
	});	
});
$(function() {
		$('.clickocom').click(function(){
			$(this).parents(".businesshopseat_itembox").hide();
			$("#businesshopseat_coltiense_edit").show();
	});	
	$('.clickocom_b').click(function(){
			$(this).parents(".businesshopseat_itembox").hide();
			$("#businesshopseat_coltiense_edit_2").show();
	});	
});
$(function() {
	$('.bonshbtnmin').click(function(){
			$(this).parents("#businesshopseat_coltiense_edit").hide();
			$("#businesshopseat_itembox_a").show();
	});	
	$('.bonshbtnmin_b').click(function(){
			$(this).parents(".businesshopseat_coltiense_edit_2").hide();
			$("#businesshopseat_itembox_b").show();
	});		
});


$(function() {
     $('.businesshopseat_shensuovibrn').click(function(){
		 
		 $(".businesshopseat").scrollTop($(".businesshopseat").scrollTop() + $(".businesshopseat").height());
         $(".businesshopseat_History").toggle();
		 $(".icn_a").toggle();
		 $(".icn_b").toggle();
		
	});	
});

/*点菜 ---活动上下滚动*/
function autoScroll(obj){  
			$(obj).find(".selllsoni").animate({  
				marginTop : "-30px"  
			},1000,function(){  
				$(this).css({marginTop : "0px"}).find("li:first").appendTo(this);  
			})  
		}  
$(function(){  
			setInterval('autoScroll(".scollkapple")',5000);
			  
});

		
function clickpelectsea(){
	   $("#electseatporpop").fadeIn();
};
function clicnelectseanone(){
	   $(".electseatporpop").fadeOut();
};
function clickbeltelcolctsea(){
	   $("#businesstelcinmucok").fadeIn();
};
function orderitem(){
	   $("#orderpoprt").fadeIn().css("display","table");
	   $(".ceseimbobtn").click(function(){
		   $(this).parents(".popup").fadeOut();
	   });
};
// 点菜 -优惠信息
function bussediscountpou(){
	   $("#busess_discountpopbox").fadeIn();
	   $('body').on('touchmove', function (event) {
			event.preventDefault();
		});
};
// 点菜 -商家简介
function bus_aboutsbtnclick(){
	   $("#bus_aboutsbclckprop").fadeIn();
	   $('body').on('touchmove', function (event) {
			event.preventDefault();
		});
};

/*左右滑动效果*/
!(function($){
    $.fn.extend({
        slider:function(sibling){
            sibling.first().after("<li id='bgli'></li>")

            $(this).hover(function(){
                var nowleft = $(this).position().left;
                var bjlileft = $("#bgli").position().left;
                if(nowleft>bjlileft){
                    $("#bgli").stop().animate({left:nowleft+20
                    },300,function(){
                        $("#bgli").stop().animate({left:nowleft},100)
                    })
                }else{
                    $("#bgli").stop().animate({left:nowleft-20
                    },300,function(){
                        $("#bgli").stop().animate({left:nowleft},100)
                    })
                }



            },function(){
                return false;
            })
        }
    })
})(jQuery);
/*调用方法*/
$(function(){
    var $li = $("#screennearbyhd>ul li");
$li.slider($li)
});
$(function(){
/*点餐*/
  $('.businessmeun_nav .businessmeun_navmain .businessmeun_shopbox').hide(1);
	var $businessmeun_tabbox = $('.businessmeun_nav .businessmeun_navhd .hditem');
	var $businessmeun_tabbox3 = $('.businessmeun_nav .businessmeun_navhd .hditem:nth-child(3)');
	
	$businessmeun_tabbox.click(function(){
			$(this).addClass('art').siblings().removeClass('art');
            var index = $businessmeun_tabbox.index(this);
			$('.businessmeun_nav .businessmeun_navmain .businessmeun_navgroup').eq(index).show().siblings().hide();
	});	
	$('.businessmeun_nav .businessmeun_navhd .hditem:nth-child(1)').click(function(){
        $(".businessmeun_navhd .bgli").animate({left:'0%'});
	});
	$('.businessmeun_nav .businessmeun_navhd .hditem:nth-child(2)').click(function(){
        $(".businessmeun_navhd .bgli").animate({left:'33.33%'});
	});
	$('.businessmeun_nav .businessmeun_navhd .hditem:nth-child(3)').click(function(){
        $(".businessmeun_navhd .bgli").animate({left:'66.66%'});
		
	});
});
/*会员中心 */
$(".memberAddresslist .address_girup .citem .sel").click(function(evt){
	    $(this).parents(".citem").addClass('art').siblings().removeClass('art');  
});
function clickaddresdeleteprop(){
	   $("#addresdeleteprop").fadeIn().css("display","table");;
};
function clickaddresdeleteprop_cancel(){
	   $("#addresdeleteprop").fadeOut();
};
/*会员中心-订单*/


$(function(){
   $(".morderreentnsase").click(function(){
       $(this).parents(".morderrenamvboain").hide();
	   $(".mordergroup").css({"margin-top":"46px"});
	});	
});
$(function(){
   $(".morder_sortbox_group .colitem").click(function(){
       $(this).addClass("art").siblings().removeClass("art");
	});	
});
function mordersearchbtn(){
	   $(".morder_screenbox ,.morder_sortbox ,.morder_deltebox ,.mordergroup .morderitem .morderitem_checkbox").hide();	
	   $(".morder_search").fadeIn();
	   $(".mordergroup").css({"margin-top":"90px"});
	   $(".membercollectiongroup").css({"margin-top":"45px"});
};
function morderscreenbtn(){
	   $(".morder_search ,.morder_sortbox ,.morder_deltebox ,.mordergroup .morderitem .morderitem_checkbox").hide();
	   $(".morder_screenbox").fadeIn();
	   $(".mordergroup").css({"margin-top":"235px"});
	   $(".membercollectiongroup").css({"margin-top":"185px"});
};
function mordersortbtn(){
	   $(".morder_search ,.morderrenamvboain ,.morder_deltebox ,.mordergroup .morderitem .morderitem_checkbox").hide();
	   $(".morder_sortbox").fadeIn();
	   $(".mordergroup").css({"margin-top":"120px"});
	   $(".membercollectiongroup").css({"margin-top":"70px"});
};
function morderdeltelbtn(){
	   $(".morder_search ,.morderrenamvboain ,.morder_sortbox ").hide();
	   $(".morder_deltebox ,.mordergroup .morderitem .morderitem_checkbox").fadeIn();
	    $(".membercollection_content .morderitem_checkbox").fadeIn();
	   $(".mordergroup").css({"margin-top":"90px"});
	   $(".membercollectiongroup").css({"margin-top":"40px"});
};


$(function(){
   $(".icoconebtn").click(function(){
       $(this).parents(".mbocabbox").hide();
	   $(".membercollectiongroup").css({"margin-top":"0"});
	   $(".mordergroup").css({"margin-top":"46px"});

	});	
});

/*禁止body滚动*/
$(function(){
   $(".bodyscollmoub").click(function(){
       $("body").css(["overflow","hidden"])
	   $('body').on('touchmove', function (event) {
			event.preventDefault();
		});
		
	});	
});
 
$(function(){
   $(".stimesortin_gropu").click(function(){
       $(this).toggleClass("stimesortin_gropu_art");

	});	
   $(".mordersreen_tiemcou li").click(function(){
       $(this).addClass('art').siblings().removeClass('art');

	});	

	$(".textareainput").focus(function(){
       $(this).css("height","auto");
    });
	$(".textareainput").blur(function(){
       $(this).css("height","1.7em");
    });
});

/*在线支付 - 筛选 */
$(function() {
    $('.payselet_group .selectitem .litmmain').click(function(){
       $(this).parents(".selectitem").addClass('defult').siblings().removeClass('defult');
   });	
    $('.paymentorder_hd .roomnum').click(function(){
	   $(this).toggleClass("roomnum_art");
       $(this).find(".cmain").toggle();
   });	
/*在线支付 - 发票 */
    $('.invoice_mzhnrun').click(function(){
         $(".invoice_main").toggle();
		 $(".icn_b").toggle();
		 $(".icn_a").toggle();
		 $(document).scrollTop($(document).height())
		 
	});	

    $('.invoice_main .sendietm').click(function(){
       $(this).toggleClass	('defult')
	   $(".invoice_main .sendietm_main").toggle();
	   $(document).scrollTop($(document).height())
   });	

    $('.meunshoporder .conbtn').click(function(){
       $(this).find(".ico").toggleClass("retshow")
	   $(".ordermeunbox").toggle();
   });	
});
function clickReplicePortrait(){
	   $("#memberReplicePortrait_box").fadeIn();
};
//底部菜单
$(function(){
	/*var buttonnavrelretState = true; 
	function buttonnavrelret(){
		var bodyheight=parseInt($("body").outerHeight());
		var scrollTop = document.body.scrollTop || document.documentElement.scrollTop;
		var bottomnavotopt =parseInt($("#bottomnavotop").offset().top);
	   if(scrollTop  >=  bottomnavotopt-bodyheight+4 ){
			 $(".bottom-nav").addClass("bottom-nav_relative").animate({position:"relative"});
		 }else{
			 $(".bottom-nav").removeClass("bottom-nav_relative");
		 }
		buttonnavrelretState = true;
	}
	$(window).scroll(function (){*/
	/*底部菜单-*/
	/*	if(buttonnavrelretState){ 
		  setTimeout(buttonnavrelret,200); uttonnavrelretState = false; 
		}else{ } 
	})*/
})
//底部菜单 emd
$(function(){
	$(".popupclickshow").click(function(){
     // $(".popupclickshow").fadeIn().css({"display":"table"});
	  $("body").unbind("touchmove")
	  
   });
   $('.cookbook_btnchinav .navbtn').click(function(){
       $(this).siblings("div").toggle();
   });	

})
function busaboutpop(){
    
}
//为等收藏
function touch_fun(_tihs){
   $(document).on("touchstart", function(e) {	
		startX = e.originalEvent.changedTouches[0].pageX,
		startY = e.originalEvent.changedTouches[0].pageY;
   });
   $(document).on("touchmove", function(e) {		
		moveEndX = e.originalEvent.changedTouches[0].pageX,
		moveEndY = e.originalEvent.changedTouches[0].pageY,
		X = moveEndX - startX,
		Y = moveEndY - startY;
		if ( Math.abs(Y) > Math.abs(X) && Y > 0) {
            $(_tihs).removeClass("proledel");
			//alert("上");
        }else if ( Math.abs(Y) > Math.abs(X) && Y < 0 ) {
		    $(_tihs).removeClass("proledel");
         } 
   });
}
$(".membercollection_content  .pro-item").on("touchstart", function(e) {	
   startX = e.originalEvent.changedTouches[0].pageX,
   startY = e.originalEvent.changedTouches[0].pageY;
   
		
});
$(".membercollection_content  .pro-item").on("touchmove", function(e) {		
		moveEndX = e.originalEvent.changedTouches[0].pageX,
		moveEndY = e.originalEvent.changedTouches[0].pageY,
		X = moveEndX - startX,
		Y = moveEndY - startY;
		if ( Math.abs(X) > Math.abs(Y) && X > 0 ) {
			$(this).removeClass("proledel");
		}
		else if ( Math.abs(X) > Math.abs(Y) && X < 0 ) {
		 $(this).addClass("proledel");
		}
		
		else{
			$("body").unbind("touchmove")
		}
		touch_fun(this)
});


