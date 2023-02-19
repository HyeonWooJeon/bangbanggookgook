      $( document ).ready( function() {
        $( '.slider' ).slick( {
          autoplay: true,
          autoplaySpeed: 2500,
          dots : true,	
          fade : true,
        } );
        
 	} );
        
        $("ul.menu_ul li").click(function(e){
			e.preventDefault();
        	var tab_id = $(this).attr('data-tab');
        	var tab_id2 = $(this).attr('data-tab2');
        	
        	$("ul.menu_ul li").removeClass('current');
        	$('.ai_condiv').removeClass('current');
        	$('.menu_span').removeClass('current');
        	
        	$(this).addClass('current');
        	$("#"+tab_id).addClass('current');
        	$("#"+tab_id2).addClass('current');

        });
        
        $(document).ready(function(e){
			$('.third_right_slider1').slick({
				autoplay : true,
				autoplaySpeed:2500,
				dots : true,
				slidesToShow: 1,
          		slidesToScroll: 1,
				arrows : false,
          		
			})
		});
		

