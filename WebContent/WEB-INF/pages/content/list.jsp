<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/pages/common/common.jsp" %>
<script type="text/javascript" src="${basePath}/resources/sg/tz_page.js"></script>
</head>
<body>
 <div class="wrap">
		<div class="slider">
			<div class="logo">
				<a href="#"><img src="${basePath}/resources/images/logo.png"/></a>
			</div>
			<div class="nav">
				<ul>
					 <li class="items"><a href="javascript:void(0);"><i class="fa fa-home"></i>首页</a></li>
					 <li class="items active"><a href="javascript:void(0);"><i class="fa fa-signal"></i>统计报表</a></li>
					 <li class="items"><a href="javascript:void(0);"><i class="fa fa-inbox"></i>区块</a></li>
					 <li class="items"><a href="javascript:void(0);"><i class="fa fa-th"></i>表格</a></li>
					 <li class="items"><a href="javascript:void(0);"><i class="fa fa-send"></i>其他</a></li>
					 <li class="items">
						<a href="javascript:void(0);"><i class="fa fa-th-list"></i>表单</a>
						<ul>
							 <li class="citems"><a href="javascript:void(0);"><i class="fa fa-inbox"></i>区块</a></li>
							 <li class="citems"><a href="javascript:void(0);"><i class="fa fa-th"></i>表格</a></li>
							 <li class="citems"><a href="javascript:void(0);"><i class="fa fa-send"></i>其他</a></li>
						</ul>
						<span class="numicon c5">3</span>
					 </li>
					 <li class="items">
						<a href="javascript:void(0);"><i class="fa fa-tint"></i>按钮组</a>
						<ul>
							 <li class="citems"><a href="javascript:void(0);"><i class="fa fa-inbox"></i>区块</a></li>
							 <li class="citems"><a href="javascript:void(0);"><i class="fa fa-th"></i>表格</a></li>
							 <li class="citems"><a href="javascript:void(0);"><i class="fa fa-send"></i>其他</a></li>
							 <li class="citems"><a href="javascript:void(0);"><i class="fa fa-th"></i>表格</a></li>
							 <li class="citems"><a href="javascript:void(0);"><i class="fa fa-send"></i>其他</a></li>
						</ul>
						<span class="numicon c1">5</span>
					 </li>
					 <li class="items"><a href="javascript:void(0);"><i class="fa fa-pencil"></i>元素</a></li>
					 <li class="items"><a href="javascript:void(0);"><i class="fa fa-star"></i>Addons 5</a></li>
					 <li class="items"><a href="javascript:void(0);"><i class="fa fa-file-o"></i>Error</a></li>
				</ul>
			</div>
		</div>
		<div class="content">
			<div class="header">
				<ul class="fl">
					 <li class="titems"><a href="javascript:void(0);"><i class="fa fa-user"></i>欢迎keke来到cms后台</a></li>
					 <li class="titems"><a href="javascript:void(0);"><i class="fa fa-envelope"></i>消息5个!</a></li>
					 <li class="titems"><a href="javascript:void(0);"><i class="fa fa-cog"></i>设置</a></li>
					 <li class="titems"><a href="${basePath}/logOut"><i class="fa fa-share-alt"></i>退出</a></li>	
				</ul>
				<div class="fr sbtn none">
					<input type="text" class="fl" placeholder="搜索的关键字..."/><a href="#" class="fl"><i class="fa fa-search "></i></a>
				</div>
			</div>
			<div class="channel"> Home > Table</div>
			<div class="cnt">
				<div class="tabwrap">
					
					<!--表格-->
					<table class="tztab">
						<caption>
							2015年度一周统计报表数据
							<div class="fr sbtn">
								<input type="text" class="fl" placeholder="搜索的关键字..."/><a href="#" class="fl"><i class="fa fa-search "></i></a>
							</div>
						</caption>
						<!--头部
						<colgroup id="days">
							<col/>
							<col style="background:green;width:200px;"/>
							<col id="t"/>
						</colgroup>-->
						<thead>
							<tr>
								<th>主键 </th>	
								<th>标题<span class="up"></span> <span class="down"></span></th>	
								<th>作者</th>
								<th>创建时间</th>	
								<th>更新时间</th>	
								<th>是否置顶</th>	
								<th>是否删除</th>	
								<th>发布状态</th>	
								<th>频道ID</th>
								<th>是否允许评论</th>
								<th>操作</th>
							</tr>
						</thead>
						<!--身体部-->
						<tbody id="tbody" data-itemCount=${count}>
						<tr>
							<td id="loading" colspan="20"></td>
						</tr>
					   </tbody>
					</table>
				<div class="cpage"></div>
			</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	/*var opid = $(obj).data("opid");在jQuery里面有data方法自定义标签
	<a href="javascript:void(0)" onclick="tm_delete(this)" data-opid="${profit.id}">删除</a>
	分页一般是第一次加载用普通的list请求，也就是说这时候加载一次数据，要写在页面，之后点击分页的页数用ajax请求
	*/
	
		function loading2(target,mark){
			$.loading({target:$(target),mark:1}); 
		};

		var tzAdmin={
				init:function(itemCount){
					$(".cpage").tzPage(itemCount, {
						num_display_entries : 3, //主体页数
						num_edge_entries : 4,//边缘页数
						current_page : 0,//指明选中页码
						items_per_page : 10, //每页显示多条条
						prev_text : "首页",
						next_text : "尾页",
						showGo:true,//控制是否显示go 页 ,默认是true
						showSelect:true,//控制是否现在下拉框 默认是true
						callback : function(pageNo, psize) {//会回传两个参数一个当前页，显示的页数
							tzAdmin.loadData(pageNo, psize);
						}
					});
				},
				loadData:function(pageNo,pageSize,callback){
					$.ajax({
						type:"post",
						url:basePath+"/content/templete",
						beforeSend:function(){loading2($("#tbody"),2);},
						data:{pageNo:pageNo*pageSize,pageSize:pageSize},
						success:function(data){
							var $data=$(data);
							$("#tbody").html($data);
							var count=$data.find("#count").val();
							if(callback)callback(count);
							
						}
					});
				}
		};
		//只有等加载完回调函数时候才能加载count总数，函数里面传一个函数的参数，那个函数就是回调函数
		tzAdmin.loadData(0,10,function(count){
			tzAdmin.init(count);//保证分页只加载一份
		});//初始化分页插件
	</script>
</body>
</html>