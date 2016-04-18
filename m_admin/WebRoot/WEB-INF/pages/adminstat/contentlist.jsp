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
	 <script src="${basePath}/resources/js/echart/echarts.js"></script>
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
					<input type="text"  id="date" onFocus="WdatePicker({onpicking:changeDate,dateFmt:'yyyy'})" class="Wdate"/>	
				</div>
				<div class="tabwrap" id="main" style="height: 400px;">
				</div>	
			</div>
			<div class="tabwrap">
				<select id="sort">
					<option value="asc">升序</option>
					<option value="desc" selected="selected">降序</option>
				</select>
				<!--表格-->
				<table class="tztab">
					<thead>
						<tr>
							<th>主键</th>
							<th>标题 <span class="up"></span> <span class="down"></span></th>	
							<th>创建时间</th>	
							<th>操作</th>
						</tr>
					</thead>
					<!--身体部-->
					<tbody id="tbody">
						<tr>
							<td id="loading" colspan="50"></td>
						</tr>
					</tbody>
				</table>
				<div class="cpage"></div>
			</div>
		</div>
		
	</div>
	<script>
	
		$(function(){
			loadData(new Date().getFullYear());
		});
		
		// 点击日期的回调函数
		function changeDate(dp){
			var date = dp.cal.getNewDateStr();
			loadData(date);
		}
		
		//数据加载，初始化统计报表
		function loadData(year){
			$.ajax({
				type:"post",
				url:"http://localhost/m_admin/admin/stat/list",
				data:{year:year},
				success:function(data){
					var json = {
						title:year+"年度模块访问详情",	
						datas:parseData(data)
					};
					initChart("main",json);//初始化统计报表
				}
			});
		};

		//数据月份补零
		function parseData(jsonArr){
			var jsonObj = {};
			for(var key in jsonArr){
				var num = jsonArr[key].num;
				var m = jsonArr[key].m;
				jsonObj["s"+parseInt(m)]= num;
			};
			var arr = [];
			for(var i=1;i<=12;i++){
				arr.push(jsonObj["s"+i]||0);
			}
			return arr;
		};
	

		//统计报表的初始化
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
					'echarts/chart/pie'
	            ],
	           function (ec) {
	                var myChart = ec.init(document.getElementById(targetId));
	                var option  = {
						    title : {
						    	x: "center",
						        text: json.title,
						        subtext: "月份/总数"
						    },
						    tooltip : {
						        trigger: 'axis'
						    },
						   
						    toolbox: {
						        show : true,
						        feature : {
						            mark : {show: true},
						            dataView : {show: true, readOnly: false},
						            magicType : {show: true, type: ['line', 'bar']},
						            restore : {show: true},
						            saveAsImage : {show: true}
						        }
						    },
						    
						    calculable : true,
						    xAxis : [
						        {
						            type : 'category',
						            data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
						        }
						    ],
						    yAxis : [
						        {
						            type : 'value'
						        }
						    ],
						    series : [
						        {
						            name:'访问人数',
						            type:'bar',
						            data:json.datas,
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
						            }
						        }
						    ]
						};
	                //添加报表数据给echart
					myChart.setOption(option);
	                //初始化echart的config对象
					var ecConfig = require('echarts/config');
	                //执行config的回调函数
					myChart.on(ecConfig.EVENT.CLICK, eConsole);
	            }
	        );
		};
			
		//点击柱形图回调事件
// 		var timer = null;
// 		function eConsole(d) {
// 			//获取用户点击的数据
// 			var month = parseInt(d.name);
// 			//参数
// 	 		var params ={
//  				month:month,
//  				order:"create_time desc",
//  				pageNo:0,
//  				pageSize:30
// 	 		};
// 			loading2($("#tbody"),4);
// 			//执行业务
// 			clearTimeout(timer);
// 	 		timer = setTimeout(function(){
// 	 			$.ajax({
// 		 			type:"post",
// 		 			url:adminPath+"/adminstat/groupcontent",
// 		 			data:params,
// 		 			success:function(data){
// 		 				var len = data.length;
// 		 				var html = "";
// 		 				for(var i=0;i<len;i++){
// 		 					html+="<tr>"+
// 		 					"	<td>"+data[i].id+"</td>"+
// 		 					"	<td>"+data[i].title+"</td>"+
// 		 					"	<td>"+data[i].time+"</td>"+
// 		 					"	<td>操作</td>"+
// 		 					"</tr>";
// 		 				}
// 		 				$("#tbody").html(html);
// 		 			}
// 		 		});
// 	 		},200);
// 		};
		
		
		var mark = true;
		function eConsole(d) {
			//获取用户点击的数据
			var month = parseInt(d.name);
			var sort = document.getElementById("sort").value||"desc";
			//参数
	 		var params ={
 				month:month,
 				order:"create_time "+sort,
 				pageNo:0,
 				pageSize:30
	 		};
			loading2($("#tbody"),4);
			if(mark){
				mark = !mark;
				//执行业务
	 			$.ajax({
		 			type:"post",
		 			url:adminPath+"/adminstat/groupcontent",
		 			data:params,
		 			error:function(){mark=true;},
		 			success:function(data){
		 				var len = data.length;
		 				var html = "";
		 				for(var i=0;i<len;i++){
		 					html+="<tr>"+
		 					"	<td>"+data[i].id+"</td>"+
		 					"	<td>"+data[i].title+"</td>"+
		 					"	<td>"+data[i].time+"</td>"+
		 					"	<td>操作</td>"+
		 					"</tr>";
		 				}
		 				$("#tbody").html(html);
		 				mark = true;
		 			}
		 		});
			}
		};
		
// 		function initChart(targetId,json){
//			var myChart = echarts.init(document.getElementById(targetId));
//			var option  = {
//				    title : {
//				    	x: "center",
//				        text: json.title,
//				        subtext: "月份/总数"
//				    },
//				    tooltip : {
//				        trigger: 'axis'
//				    },
			   
//				    toolbox: {
//				        show : true,
//				        feature : {
//				            mark : {show: true},
//				            dataView : {show: true, readOnly: false},
//				            magicType : {show: true, type: ['line', 'bar']},
//				            restore : {show: true},
//				            saveAsImage : {show: true}
//				        }
//				    },
			    
//				    calculable : true,
//				    xAxis : [
//				        {
//				            type : 'category',
//				            data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
//				        }
//				    ],
//				    yAxis : [
//				        {
//				            type : 'value'
//				        }
//				    ],
//				    series : [
//				        {
//				            name:'访问人数',
//				            type:'bar',
//				            data:json.datas,
//				            markPoint : {
//				                data : [
//				                    {type : 'max', name: '最大值'},
//				                    {type : 'min', name: '最小值'}
//				                ]
//				            },
//				            markLine : {
//				                data : [
//				                    {type : 'average', name: '平均值'}
//				                ]
//				            }
//				        }
//				    ]
//				};
//			myChart.setOption(option);
//			myChart.on(ecConfig.EVENT.CLICK, eConsole);
//			myChart.on(ecConfig.EVENT.DBLCLICK, eConsole);
//			myChart.on(ecConfig.EVENT.HOVER, eConsole);
//			myChart.on(ecConfig.EVENT.DATA_ZOOM, eConsole);
//			myChart.on(ecConfig.EVENT.LEGEND_SELECTED, eConsole);
//			myChart.on(ecConfig.EVENT.MAGIC_TYPE_CHANGED, eConsole);
//			myChart.on(ecConfig.EVENT.DATA_VIEW_CHANGED, eConsole);
//		}
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
