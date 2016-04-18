<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>模板页面</title>
	<meta http-equiv="pragma" adminstat="no-cache">
	<meta http-equiv="cache-control" adminstat="no-cache">
	<meta http-equiv="expires" adminstat="0">    
	<meta http-equiv="keywords" adminstat="keyword1,keyword2,keyword3">
	<meta http-equiv="description" adminstat="This is my page">
	<%@include file="/WEB-INF/pages/common/common.jsp" %>
	<script type="text/javascript" src="${basePath}/resources/sg/tz_page.js"></script>
<!-- 	 <script src="${basePath}/resources/js/echart/echarts-all.js"></script> -->
	 <script src="${basePath}/resources/js/echart/echarts.js"></script>
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
				<select onchange="loadData(this.value)">
					<option>请选择年份</option>
					<c:forEach begin="2010" end="2020" var="year">
						<option value="${year}">${year}</option>	
					</c:forEach>
				</select>
				<div class="tabwrap" id="main" style="height: 400px;">
				</div>	
			</div>
		</div>
	</div>
	<script>
	
		$(function(){
			loadData(new Date().getFullYear());
		});
		
		function loadData(year){
			$.ajax({
				type:"post",
				url:"http://localhost:8080/m_admin/admin/stat/list",
				data:{year:year},
				success:function(data){
					var json = {
						title:year+"年度潭州教育网站模块访问详情",	
						datas:parseData(data)
					};
					initChart("main",json);
				}
			});
		};
		
		
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
		}
	
// 		function initChart(targetId,json){
// 			var myChart = echarts.init(document.getElementById(targetId));
// 			var option  = {
// 				    title : {
// 				    	x: "center",
// 				        text: json.title,
// 				        subtext: "月份/总数"
// 				    },
// 				    tooltip : {
// 				        trigger: 'axis'
// 				    },
				   
// 				    toolbox: {
// 				        show : true,
// 				        feature : {
// 				            mark : {show: true},
// 				            dataView : {show: true, readOnly: false},
// 				            magicType : {show: true, type: ['line', 'bar']},
// 				            restore : {show: true},
// 				            saveAsImage : {show: true}
// 				        }
// 				    },
				    
// 				    calculable : true,
// 				    xAxis : [
// 				        {
// 				            type : 'category',
// 				            data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
// 				        }
// 				    ],
// 				    yAxis : [
// 				        {
// 				            type : 'value'
// 				        }
// 				    ],
// 				    series : [
// 				        {
// 				            name:'访问人数',
// 				            type:'bar',
// 				            data:json.datas,
// 				            markPoint : {
// 				                data : [
// 				                    {type : 'max', name: '最大值'},
// 				                    {type : 'min', name: '最小值'}
// 				                ]
// 				            },
// 				            markLine : {
// 				                data : [
// 				                    {type : 'average', name: '平均值'}
// 				                ]
// 				            }
// 				        }
// 				    ]
// 				};
// 			myChart.setOption(option);
// 			myChart.on(ecConfig.EVENT.CLICK, eConsole);
// 			myChart.on(ecConfig.EVENT.DBLCLICK, eConsole);
// 			myChart.on(ecConfig.EVENT.HOVER, eConsole);
// 			myChart.on(ecConfig.EVENT.DATA_ZOOM, eConsole);
// 			myChart.on(ecConfig.EVENT.LEGEND_SELECTED, eConsole);
// 			myChart.on(ecConfig.EVENT.MAGIC_TYPE_CHANGED, eConsole);
// 			myChart.on(ecConfig.EVENT.DATA_VIEW_CHANGED, eConsole);
// 		}

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
						myChart.setOption(option);
						var ecConfig = require('echarts/config');
						myChart.on(ecConfig.EVENT.CLICK, eConsole);
		            }
		        );
		}
			
		
		function eConsole(param) {
		    var mes = '【' + param.type + '】';
		    if (typeof param.seriesIndex != 'undefined') {
		        mes += '  seriesIndex : ' + param.seriesIndex;
		        mes += '  dataIndex : ' + param.dataIndex;
		    }
		    alert(JSON.stringify(param)+"==="+mes);
		   // if (param.type == 'hover') {
		   //     document.getElementById('hover-console').innerHTML = 'Event Console : ' + mes;
		    //}
		   // else {
		   //     document.getElementById('console').innerHTML = mes;
		  //  }
		   // console.log(param);
		}
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
