$(function () {
	
	
	
	$("#search_button").button({
		icons:{						//这个是图标
			primary:"ui-icon-search",
		},
	});
	$("#error").dialog({
		 autoOpen:false,
		 modal:true,
		 resiable : false,
		 closeOnEscape : false,
		 draggable : false,
		 width :180,
		 heigth:30,
	}).parent().find('.ui-widget-header').hide();
	
	$("#question_button").button({
		icons:{						//这个是图标
			primary:" ui-icon-help",
		},
	}).click(function(){
		if ($.cookie('user')) {
			$("#article").dialog("open");
		}else{
			$("#error").dialog("open");
			setTimeout(function(){ 
				$('#error').dialog('close');
				$('#login').dialog('open'); 
				},1000);
		}
	});
	

	
	/*******cookice***/
	$('#member, #logout').hide();
	
	if ($.cookie('user')) {
		$('#member, #logout').show();
		$('#reg_a, #login_a').hide();
		$('#member').html($.cookie('user'));  //
	} else {
		$('#member, #logout').hide();
		$('#reg_a, #login_a').show();
	}
	$("#logout").click(function(){
		$.removeCookie('user');
		window.location.href = 'index.html';
	});
	$("#reg_a").click(function(){
		$("#reg").dialog("open");
	});
	$("#login_a").click(function(){
		$("#login").dialog("open");
	});
	$("#loading").dialog({
		autoOpen:false,
		modal : true,
		closeOnEscape : false,
		resizable : false,
		draggable : false,
		width :180,
		heigth:50,
	}).parent().parent().find('.ui-widget-header').hide();
	$('#reg').validate({  //表单验证
		rules:{
			USERNAME : {
				required : true,
				minlength : 2,
		},
			password:{
				required: true,
				minlength:4,
			},
			notpassword:{
			    equalTo:'#password',
		    },
			age:{
			   number:true,
			},
			birthday:{
				dateIOS:true,
			}
		},
		messages :{
			USERNAME:{
				required:'请必须输入姓名',
				minlength:'最小长度不小于2位',
			},
			password:{
				required:'必须填写密码',
				minlength:'最小长度不小于4位',
			},
			notpassword:{
				equalTo:'请输入相同密码',
			},
			age:{
				range:'请输入正确年龄',
			},
			birthday:{
				dateISO:'请输入正确日期',
			}
		}	
	});
	$("#reg").dialog({				//模块隐藏化
			autoOpen:false,
			modal:true,
			resizable : false,
			width :400,
			heigth:400,
		  buttons  :{
			'注册' :function(){
				$(this).submit();
				
			},
			'取消' :function(){
				$(this).dialog('close');
			}
		},
	
		}) .buttonset().validate({
			submitHandler : function(form){
				$(form).ajaxSubmit({
					url:"AddUserServlet.do",
					type:"POST",
					beforeSubmit : function (formData, jqForm, options) {
						$('#loading').dialog('open');
						$('#reg').dialog('widget').find('button').eq(1).button('disable');
						
					},
					success : function(responseText,statusText){
						alert(responseText);
						$('#reg').dialog('widget').find('button').eq(1).button('enable');
						if (responseText=="true") {
						    $.cookie('user',$("#USERNAME").val());
						    $('#loading').css('background', 'url(images/loading.gif) no-repeat 20px center').html('数据交互中...');		
						setTimeout(function(){
							$('#loading').dialog('close');
							$("#reg").dialog("close");
							$('#reg').resetForm();
							$('#reg span.star').html('*').removeClass('succ');
							$('#loading').css('background', 'url(images/loading.gif) no-repeat 20px center').html('数据交互中...');
							$('#member, #logout').show();
							$('#reg_a, #login_a').hide();
							$('#member').html($.cookie('user')); 
						},1000);
						}else{
							$('#loading').dialog('close');
							$("#reg").dialog("close");
							$('#reg').resetForm();
							$("#reg").dialog("open");
							alert("注册失败，请重新注册");
						};
					},
				});
			},
		});
		
	$("#BIRTHDAY").datepicker();  //用日期图标				//jquery.ui
	$("#reg input[title]").tooltip();  //  鼠标拉到某处 显示出title
	
		$("#login").dialog({
			autoOpen:false,
			modal:true,
			resizable : false,
			width :400,
			heigth:400,
		 buttons  : {
			'登陆' :function(){
				$(this).submit();
			},
			'取消' :function(){
				$(this).dialog('close');
			}
		}
			
}) .buttonset().validate({
	submitHandler : function(form){
		$(form).ajaxSubmit({
			url:"loginservlet.to",
			type:"POST",
			beforeSubmit : function (formData, jqForm, options) {
				$('#loading').dialog('open');
				$('#login').dialog('widget').find('button').eq(1).button('disable');
			},
			
				success :function(responseText,statusText){
			    
				if (responseText=="true") {
					$('#login').dialog('widget').find('button').eq(1).button('enable');
					$.cookie('user', $('#USER').val());
					alert($.cookie('user'));
					//$('#loading').dialog('close');
			//	$('#member').html($.cookie('USERNAME'));
				//alert($.cookie("user"));
				 
				setTimeout(function(){
					$('#loading').dialog('close');
					$("#login").dialog("close");
					$('#login').resetForm();
					$('#login span.star').html('*').removeClass('succ');
					$('#loading').css('background', 'url(img/loading.gif) no-repeat 20px center').html('数据交互中...');
					$('#member, #logout').show();
					$('#reg_a, #login_a').hide();
					$('#member').html($.cookie('user')); 
					
				},1000);
				}else{
					$('#login').dialog('widget').find('button').eq(1).button('enable');
					$('#loading').dialog('close');
					$('#login').resetForm();
					$("#login").dialog("close");
					alert("用户名或密码错误");
				}
			},
			
		});
	},
	
});
				
$("#article").dialog({
	 autoOpen:false,
	 modal:true,
	resizable : false,
	 width :500,
	 heigth:360,
    buttons  :{
	'发布' : function(){
		
				$(this).ajaxSubmit({
					url : 'AddAriticleServlet.add',
					type : 'POST',
					data : {
						user : $.cookie('user'),
						//content : $('.uEditorIframe').contents().find('#iframeBody').html(),
					},
					beforeSubmit : function (formData, jqForm, options) {
						$('#loading').dialog('open');
						$('#article').dialog('widget').find('button').eq(1).button('disable');
					},
					success : function (responseText, statusText) {
						if (responseText) {
							$('#article').dialog('widget').find('button').eq(1).button('enable');
							$('#loading').css('background', 'url(images/success.gif) no-repeat 20px center').html('数据新增成功...');
							setTimeout(function () {
								$('#loading').dialog('close');
								$('#article').dialog('close');
								$('#article').resetForm();
								$('#loading').css('background', 'url(images/loading.gif) no-repeat 20px center').html('数据交互中...');
								window.location.href="index.html";
							}, 1000);
						}
					},
				});
			}
		}
	});

$(".article_content").uEditor();
	
	$.ajax({
			url:"ShowContentServlet.show",
			type:"post",
			success : function (response,atstus,xhr){
				//alert(response);
//				alert(response.length);
				var json=$.parseJSON(response);
				var html =''; 
				var arr=[];
				var summary=[];
				$.each(json, function(index,value){
					html +="<h4>"+value.userName+"发表于"+value.addtime+"</h4><h3>"+ value.title+"</h3><div class='editor'>"+value.content1+"</div><div class='bottom'><span class='comment' data-id='" + value.id + "'>"+ value.count +"条评论 </span><span class='up'>收起</span></div><hr noshade='noshade' size='1'/><div class='comment_list'></div>";
					});
				$('.content').append(html);  //显示html在content	
				$.each($('.editor'), function (index, value) {
					arr[index]=$(value).html();
					summary[index]=arr[index].substring(0,200); //substr 选择字符串包括html
					if(summary[index].substr(199,200)=='下'){
						summary[index]=replacePos(summary[index],200,' ');
					}
					if(arr[index].length >200){
						summary[index]+='...<span class="down">显示全部</span> ';
						$(value).html(summary[index]);
					}
					$('.bottom .up').hide();
				});
				$.each($('.editor '), function (index, value) {
					$(this).on('click', '.down', function () {
						$('.editor').eq(index).html(arr[index]);
						$(this).hide();
						$('.bottom .up').eq(index).show();
					});
				});
				$.each($('.bottom '), function (index, value) {
					$(this).on('click', '.up', function () {
						$('.editor').eq(index).html(summary[index]);
						$(this).hide();
						$('.editor .down').eq(index).show();
					});
				});
				$.each($('.bottom'), function (index, value) {
					$(this).on('click','.comment',function(){
						var comment_this=this;
						if ($.cookie('user')) {
							if(!$('.comment_list').eq(index).has('form').length){
					
						
//								success : function (response, status){
//									
									
									$.ajax({
										url:'ShowCommentServlet.look',
										type:'post',
										data : {
											
											titleid: $(comment_this).attr('data-id'),
										},
										beforeSend : function (jqXHR, settings) {
											$('.comment_list').eq(index).append('<dl class="comment_load"><dd>正在加载评论</dd></dl>');
										},
										success : function(response,status){
											$('.comment_list').eq(index).find('.comment_load').hide();
											var count1=0;
											var json_comment = $.parseJSON(response);
//											  count1=json_comment.length;//
											
											$.each(json_comment, function (index2, value) {
												count1=value.pageTotle;
												alert(count1);
												$('.comment_list').eq(index).append('<dl class="comment_content"><dt>' + value.username + '</dt><dd>' + value.comment_content + '</dd><dd class="date">' + value.addtime + '</dd></dl>');
											});
											$('.comment_list').eq(index).append('<dl><dd><span class="load_more">加载更多评论</span></dd></dl>'); //
											var page1=2;///**/
											if (page1 > count1) {
												$('.comment_list').eq(index).find('.load_more').off('click');
												$('.comment_list').eq(index).find('.load_more').hide();
											}
											$('.comment_list').eq(index).find('.load_more').button().on('click', function () {
												$('.comment_list').eq(index).find('.load_more').button('disable');   /***/
												$.ajax({
													url : 'ShowCommentServlet.look',
													type : 'POST',
													data : {
														titleid : $(comment_this).attr('data-id'),
														page1 : page1,
													},
													beforeSend : function (jqXHR, settings) {
														$('.comment_list').eq(index).find('.load_more').html('<img src="images/more_load.gif" />');
														
													},
													success : function (response, status) {
														var json_comment_more = $.parseJSON(response);
														$.each(json_comment_more, function (index3, value) {
															$('.comment_list').eq(index).find('.comment_content').last().after('<dl class="comment_content"><dt>' + value.username + '</dt><dd>' + value.comment_content + '</dd><dd class="date">' + value.addtime + '</dd></dl>');
														});
														$('.comment_list').eq(index).find('.load_more').button('enable');
														$('.comment_list').eq(index).find('.load_more').html('加载更多评论');
														page1++;
												//		if (responseText) {
															//$(_this).button('enable');
												//			$('#loading').css('background', 'url(images/success.gif) no-repeat 20px center').html('数据新增成功...');
															if ( page1> count1 ) {
																$('.comment_list').eq(index).find('.load_more').off('click');
																$('.comment_list').eq(index).find('.load_more').hide();
															}
//															setTimeout(function () {
//																var date = new Date();
//																$('#loading').dialog('close');
//																$('.comment_list').eq(index).prepend('<dl class="comment_content"><dt>' + $.cookie('user')+ '</dt><dd>' + $('.comment_list').eq(index).find('textarea').val() + '</dd><dd>' +date.getFullYear() + '-' + (date.getMonth()+ 1) + '-' + date.getDate() + ' ' + date.getHours() + ':' +date.getMinutes() + ':' + date.getSeconds() + '</dd></dl>');
//																$('.comment_list').eq(index).find('form').resetForm();
//																$('#loading').css('background', 'url(images/loading.gif) no-repeat 20px center').html('数据交互中...');
//															}, 1000);
												//		}
													},
												});
											});
											/****/		
													
											$('.comment_list').eq(index).append("<form><dl class='comment_add'><dt><textarea name='comment'></textarea></dt><dd><input type='hidden'name='titleid' value='" + $(comment_this).attr('data-id')+"' /><input type='hidden'name='user' value='"+$.cookie('user') +"'/><input type='button' value='发布'/></dd></dl></form>");
											  $('.comment_list').eq(index).find('input[type=button]').button().click(function(){
												 var _this=this;
												$('.comment_list').eq(index).find('form').ajaxSubmit({
													url: 'AddCommentServlet.comment',
													type:'post',
													beforeSubmit : function (formData, jqForm, options) {
														$('#loading').dialog('open');
														$(_this).button('disable');
												   },
													success : function (responseText, statusText) {
														if (responseText) {
															$(_this).button('enable');
															$('#loading').css('background', 'url(images/success.gif) no-repeat 20px center').html('数据新增成功...');
															setTimeout(function () {
																var date = new Date();
																$('#loading').dialog('close');
																$('.comment_list').eq(index).prepend('<dl class="comment_content"><dt>' + $.cookie('user')+ '</dt><dd>' + $('.comment_list').eq(index).find('textarea').val() + '</dd><dd>' +date.getFullYear() + '-' + (date.getMonth()+ 1) + '-' + date.getDate() + ' ' + date.getHours() + ':' +date.getMinutes() + ':' + date.getSeconds() + '</dd></dl>');
																$('.comment_list').eq(index).find('form').resetForm();
																$('#loading').css('background', 'url(images/loading.gif) no-repeat 20px center').html('数据交互中...');
															}, 1000);
														}
													},
												});
											});	
										}
									});
									
	//							},
	//						});
							
							}if($('.comment_list').eq(index).is(':hidden')){
								$('.comment_list').eq(index).show();
							}else{
								$('.comment_list').eq(index).hide();	
							}
//							$('.comment_list').eq(index).find('input[type=button]').button().click(function () {
//								var _this = this;
//								$('.comment_list').eq(index).find('form').ajaxSubmit({
//									url : 'addcomment.comment',
//									type : 'POST',
//									beforeSubmit : function (formData, jqForm, options) {
//										$('#loading').dialog('open');
//										$(_this).button('disable');
//									},
//									success : function (responseText, statusText) {
//										if (responseText) {
//											$(_this).button('enable');
//											$('#loading').css('background', 'url(images/success.gif) no-repeat 20px center').html('数据新增成功...');
//											setTimeout(function () {
//												$('#loading').dialog('close');
//												$('.comment_list').eq(index).find('form').resetForm();
//												$('#loading').css('background', 'url(images/loading.gif) no-repeat 20px center').html('数据交互中...');
//											}, 1000);
//										}
//									},
//								});
//							});
							
						}else{
							$("#error").dialog("open");
							setTimeout(function(){ 
								$('#error').dialog('close');
								$('#login').dialog('open'); 
								},1000);
						}
					});
				
					
				});
			/*	$.each($('.editor'), function (index, value) {
 				      arr[index]=$(value).height();
 				      if ($(value).height() > 148) {
	 				$(value).next('.bottom').find('.up').hide();
		 	}
 				      $(value).height(148);
			});
				$.each($('.bottom .down'), function (index, value) {
					$(this).click(function() {
						$(this).parent().prev().height(arr[index]);
						$(this).hide();
						$(this).parent().find('.up').show();
					});
				});
				$.each($('.bottom .up'), function (index, value) {
					$(this).click(function() {
						$(this).parent().prev().height(148);
						$(this).hide();
						$(this).parent().find('.down').show();
					});
				});*/
		},
		});
	$('#tabs').tabs({
		//disabled:true,  禁用卡
		//collapsible:true,  收缩卡
		//event: 'mouseover',触发事件
		//active:1,  默认页面   默认也可以收缩
		show:true,
		hide:true,
	});
	$("#accordion").accordion();
});

/***********************************/
 function validatorloginName(){  
             var loginName=$("USERNAME").val;  
             $.ajax({  
                    type: "POST",      
                     url: "checkuser.check",      
                      data:{
                    	  USERNAME: loginName,   
                      },
                     success: function(data){  
                    if(data=="true"){ 
                    	$("#eu").append("抱歉！用户名已存在！");
                    	setTimeout( function(){
                    		$("#eu").hide();
                    	},2000);
                    }else{  }   
                    }            
                    });     
            } 
 ///替换字符的函数
 function replacePos(strObj, pos, replaceText) {
		return strObj.substr(0, pos-1) + replaceText + strObj.substring(pos, strObj.length);
	}

 
   























