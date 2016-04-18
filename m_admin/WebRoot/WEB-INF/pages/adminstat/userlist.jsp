<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>模板页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@include file="/WEB-INF/pages/common/common.jsp" %>
	<script type="text/javascript" src="${basePath}/resources/sg/tz_page.js"></script>
<!-- 	 <script src="${basePath}/resources/js/echart/echarts-all.js"></script> -->
	<script type="text/javascript" src="${basePath}/resources/js/echart/echarts.js"></script>
	<script type="text/javascript" src="${basePath}/resources/js/date/WdatePicker.js"></script>
 </head>
 <body>
 
	<div class="wrap">
		<!-- left页面 -->
		<%@include file="/WEB-INF/pages/common/left.jsp" %>
		<div class="content">
			<div class="header">
				<ul class="fl">
					 <li class="titems"><a href="javascript:void(0);"><i class="fa fa-user"></i>欢迎gulj来到cms后台</a></li>
					 <li class="titems"><a href="javascript:void(0);"><i class="fa fa-envelope"></i>消息5个!</a></li>
					 <li class="titems"><a href="javascript:void(0);"><i class="fa fa-cog"></i>设置</a></li>
					 <li class="titems"><a href="${basePath}/logout"><i class="fa fa-share-alt"></i>退出</a></li>	
				</ul>
				<div class="fr sbtn none">
					<input type="text" class="fl" placeholder="搜索的关键字..."/><a href="#" class="fl"><i class="fa fa-search "></i></a>
				</div>
			</div>
			<div class="content"> 首页  &gt; 日记管理</div>
			<div class="cnt">
				<div style="padding:10px;">
					<input type="text"  id="date" onFocus="WdatePicker({onpicking:changeDate})" class="Wdate"/>	
				</div>
				<div class="tabwrap" id="main" style="height: 400px;">
				</div>	
			</div>
		</div>
	</div>
	<script>
	
		$(function(){
			var d = new Date().format('yyyy-MM-dd');
			loadData(d);
			$("#date").val(d);
		});
		
		function loadData(date){
			guAjax.request({
				path:adminPath,
				model:"adminstat",
				method:"groupusers",
				params:"username=gulj&password=123456",
// 				before:function(){
// 					loading("请稍后，数据加载中...");
// 				},
// 				error:function(){
// 					loading("请求出错...",4);
// 				},
// 				logout:function(){
// 					//记录用户退出的时间和记录，写入到数据库中....
// 				},
				success:function(data){
					var json = {
						title:date+"年度网站模块访问详情",	
						datas:parseData(data),
						timeLines:getTimeLine()
					};
					initChart("main",json);
				}
			},{"date":date});
		};
		
		// 点击日期的回调函数
		function changeDate(dp){
			var date = dp.cal.getNewDateStr();
			loadData(date);
		}
		
		
		function parseData(jsonArr){
			var jsonObj = {};
			for(var key in jsonArr){
				var num = jsonArr[key].num;
				var m = jsonArr[key].h;
				jsonObj["s"+parseInt(m)]= num;
			};
			var arr = [];
			for(var i=0;i<=23;i++){
				arr.push(jsonObj["s"+i]||0);
			}
			return arr;
		}
		
		//时间轴准备
		function getTimeLine(){
			var arr = [];
			for(var i=0;i<=23;i++){
				arr.push((i<10?"0"+i:i)+":00");
			}
			return arr;
		};

		function initChart(targetId,json){
			require.config({
	            paths: {
	                echarts: basePath+'/resources/js/echart'
	            }
	        });
	        require(
	            [
	                'echarts',
	                'echarts/chart/bar',
					'echarts/chart/pie',
					'echarts/chart/line'
	            ],
	           function (ec) {
	                var myChart = ec.init(document.getElementById(targetId));
	                var option = {
               	    title : {
               	    	x:"center",
               	        text: json.title,
               	        subtext: '时间/注册数'
               	    },
               	    tooltip : {
               	        trigger: 'axis'
               	    },
//                	    legend: {
//                	        data:['意向','预购','成交']
//                	    },
               	    toolbox: {
               	        show : true,
               	        feature : {
               	            mark : {show: true},
               	            dataView : {show: true, readOnly: false},
               	            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
               	            restore : {show: true},
               	            saveAsImage : {show: true}
               	        }
               	    },
               	    calculable : true,
               	    xAxis : [
               	        {	
               	        	name:"时间段",
               	            type : 'category',
               	            data :json.timeLines
               	        }
               	    ],
               	    yAxis : [
               	        {
               	        	name:"注册数",	
               	            type : 'value'
               	        }
               	    ],
               	    series : [
               	        {
               	            name:'成交',
               	            type:'line',
               	            smooth:true,
               	            itemStyle: {normal: {areaStyle: {type: 'default'}}},
               	        	markPoint : {
				                data : [
				                    {type : 'max', name: '最大值'},
				                    {type : 'min', name: '最小值'}
				                ]
				            },
				            markLine : {
				                data : [
				                    {type : 'average', name: '平均值'}
				                ]
				            },
               	            data:json.datas
               	        }
               	    ]
               	};
	                	                    
					myChart.setOption(option);
					var ecConfig = require('echarts/config');
					myChart.on(ecConfig.EVENT.CLICK, eConsole);
	            }
	        );
	}
		
	
	function eConsole(param) {
	};
	
 </script>
 <script type="text/javascript">
		$(function(){
			$(".nav").find("li.items").find("a").click(function(){
				var len = $(this).next().length;
				if(len>0){
					$(this).next().stop(true,true).slideToggle()
					.end().parents("li")
					.addClass("active")
					.siblings().removeClass("active")
					.find("ul").slideUp("slow");
				}
			});
		});
	</script>
 </body>
</html>
