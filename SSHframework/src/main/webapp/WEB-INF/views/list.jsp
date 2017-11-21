<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<script type="text/javascript">

var iframe1 = window.parent.document.getElementById("frame1");
iframe1.style.display="";
</script>

<html>
	<head>
		<%@ include file="common/jsp_contants.jsp"%>
		<%@ include file="common/charisma_include.jsp"%>
		<title>渠道查询</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<!-- 日历 -->
		<script type="text/javascript" src="<%=toolRoot%>/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="<%=toolRoot%>/paging.js"></script>
		<!-- header样式 -->
		<style type="text/css">
			#header{float: right;font-size:14px;margin-top:5px;}
			
			
			 /*
              * 外面盒子样式---自己定义
              */
            
            .page_div {
                margin-top: 20px;
                margin-bottom: 20px;
                font-size: 15px;
                font-family: "microsoft yahei";
                color: #666666;
                margin-right: 10px;
                padding-left: 20px;
                box-sizing: border-box;
            }
            /*
             * 页数按钮样式
             */
            
            .page_div a {
                min-width: 30px;
                height: 28px;
                border: 1px solid #dce0e0!important;
                text-align: center;
                margin: 0 4px;
                cursor: pointer;
                line-height: 28px;
                color: #666666;
                font-size: 13px;
                display: inline-block;
            }
            
            #firstPage,
            #lastPage {
                width: 50px;
                color: #0073A9;
                border: 1px solid #0073A9!important;
            }
            
            #prePage,
            #nextPage {
                width: 70px;
                color: #0073A9;
                border: 1px solid #0073A9!important;
            }
            
            .page_div .current {
                background-color: #0073A9;
                border-color: #0073A9;
                color: #FFFFFF;
            }
            
            .totalPages {
                margin: 0 10px;
            }
            
            .totalPages span,
            .totalSize span {
                color: #0073A9;
                margin: 0 5px;
            }
			
	    </style>
	    <script type="text/javascript">
	        
	    
	    	function compareDate(){
				if(document.getElementById("date01").value > document.getElementById("date02").value){
					alert("开始日期不能大于结束日期");
					return false;
					}
				document.getElementById("search").submit();
				return;
		    }
	    </script>
	</head>
	<body>
		<div class="container-fluid">
			<div class="row-fluid">
				<div id="content" class="span12">
					<div class="row-fluid sortable">
						<div class="box span12">
							<div class="box-content">
								<div class="">
									<div class="span12">
										<div class="alert alert-info">
											<div class="controls">
												<form id="search" class="form-horizontal" method="post" action="/news/list/">
															<input id= "pageNum" type="hidden" name="pageNum" value="">
															渠道  ： <input type="text" name="channel" id="channel" style="width: 100px;" value="">
														    &nbsp;&nbsp;&nbsp;  
														           创建日期：
													       <input type="text" style="width: 100px;" class="Wdate" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" name="startDate" id="date01" value="">  
													                       到
													       <input type="text" style="width: 100px;" class="Wdate" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" name="endDate" id="date02" value=""> 
													       &nbsp;&nbsp;&nbsp;
													
															<button type="button" class="btn btn-primary" style="vertical-align: top;" onclick="queryChannel();">
																搜 索
															</button>
												</form>
											</div>
										</div>
									</div>
								</div>
								<form action="/news/executRecord/" method="post" name="exeForm" id="exeForm">
								<div  style="width:100%; height:225px; overflow:scroll;">
									<table class="table table-striped table-bordered bootstrap-datatable datatable">
										<thead>
											<tr>
												<th>
													渠道
												</th>
												<th>
													渠道名称
												</th>
												<th>
													放款金额
												</th>
												<th>
													名单上载总量
												</th>
												<th>
													前端抽取量
												</th>
												<th>
													前端筛选通过件
												</th>
												<th>
	                                                                                                                                                前端拨打进度
	                                            </th>
	                                            <th>
	                                                                                                                                                前端筛选符合率
	                                            </th>
	                                            <th>
	                                                                                                                                                后端首拨
	                                            </th>
	                                            <th>
	                                                                                                                                                回件量
	                                            </th>
	                                            <th>
	                                                                                                                                               征信查询量
	                                            </th>
	                                            <th>
	                                                                                                                                               征信通过量
	                                            </th>
	                                            <th>
	                                                                                                                                               申请量
	                                            </th>
	                                            <th>
	                                                                                                                                               审批通过量
	                                            </th>
	                                            <th>
	                                                                                                                                               放款量
	                                            </th>
	                                            <th>
	                                                                                                                                               创建时间
	                                            </th>
											</tr>
										</thead>
										<tbody id="queryresult">
											
										</tbody>
										
									</table>
									</div>
									<div id="page" class="page_div"></div>
									</form>
								
							</div>
							<!--/span-->
						</div>
						<!--/row-->
					</div>
				</div>
			</div>
		</div>
			<!-------- 用户查看 ------->
			<div class="modal hide fade" id="businessInfo"
				style="width: 680px; height: 500px;">
			</div>
			<!-- 用户查看结束 -->
<script>
    function queryChannel(){
        var pageNum = $("#pageNum").val();
        var channel = $("#channel").val();
        var startDate = $("#date01").val();
        var endDate = $("#date02").val();
	    $.ajax({
	                url: "${pageContext.request.contextPath}/uploadExcel/queryChannel.do",
	                type: "post",
	                data: {pageNum:pageNum,channel:channel,startDate:startDate,endDate:endDate},
	                dataType: "json",
	                success: function(data) {
	                    console.log(data.page+";"+data.pageTotal+";"+data.rowsTotal);
	                    var content;
	                    $.each(eval(data).list, function(index,item){  
                            content += "<tr>";
                            content += "<td class=\"center\">&nbsp;"+item.channel+"</td>";
                            content += "<td class=\"center\">&nbsp;"+item.channelName+"</td>";
                            content += "<td class=\"center\">&nbsp;"+item.loadAmount+"</td>";
                            content += "<td class=\"center\">&nbsp;"+item.nameUploadAmount+"</td>";
                            content += "<td class=\"center\">&nbsp;"+item.frontExtractAmount+"</td>";
                            content += "<td class=\"center\">&nbsp;"+item.frontFiltedItems+"</td>";
                            
                            content += "<td class=\"center\">&nbsp;"+item.frontDealProccess+"</td>";
                            content += "<td class=\"center\">&nbsp;"+item.frontFiltedSuccess+"</td>";
                            content += "<td class=\"center\">&nbsp;"+item.backFirstGave+"</td>";
                            content += "<td class=\"center\">&nbsp;"+item.backItems+"</td>";
                            content += "<td class=\"center\">&nbsp;"+item.creditQuery+"</td>";
                            content += "<td class=\"center\">&nbsp;"+item.creditPassed+"</td>";
                            content += "<td class=\"center\">&nbsp;"+item.applicationAmount+"</td>";
                            content += "<td class=\"center\">&nbsp;"+item.auditSuccess+"</td>";
                            content += "<td class=\"center\">&nbsp;"+item.loadItems+"</td>";
                            content += "<td class=\"center\">&nbsp;"+item.createDate+"</td>";
                            content += "</tr>";
                        });  
	                    
	                    $("#queryresult").html(content);
	                    //分页
	                    $("#page").paging({
	                        pageNo: data.page,
	                        totalPage: data.pageTotal,
	                        totalSize: data.rowsTotal,
	                        callback: function(num) {
	                            $("#pageNum").val(num);
	                            console.log(num);
	                            queryChannel();
	                        }
	                    })
	                }
	            })
    }
   //分页
    $("#page").paging({
        pageNo:1,
        totalPage: 1,
        totalSize: 0,
    })
	
</script>
	</body>
</html>
