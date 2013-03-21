<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/admin/taglibs.jsp"%>
<%@ include file="init.jsp"%>
<script type="text/javascript">
var d ;
function ConfirmSendMail(obj) {
	$("#dialog_img").attr("src",obj);
	var sid = [];
	var count = 0 ;
	for(var i = 0 ;i < $(".vcheckbox").length;i++ ){
		if($(".vcheckbox").eq(i).attr("checked")=="checked"){
			count = count + 1;
			sid.push($(".vcheckbox").eq(i).val());
		}
	}
		
	$("#scount").html(" " +count +" "+sid.join(","));
	d = $( "#dialog-modal" ).dialog({
		height: 140,
		modal: true,
		buttons: {
			"确定发送": function() {
				ajaxTodo("sm/sm3001/sendMail/"+sid.join(","), null);
				$( this ).dialog( "close" );
			},
			Cancel: function() {
				$( this ).dialog( "close" );
			}
		}
	});
}
function viewPhotoClose(){
	d.dialog('destroy');
}
</script>

<div class="pageHeader">
<div class="accountInfo">
	<div class="alertInfo">
	</div>
	<div class="right">
	</div>
	<p><span>邀请活动 </span></p>
	<p><a href="demo_page2.html" target="dialog">COMBO运营</a></p>
</div>	
</div>

              
              <div class="pageContent" style="border-left:1px #B8D0D6 solid;border-right:1px #B8D0D6 solid">
             		<div class="panelBar">
                      <ul class="toolBar">
            				<li><a class="add" href="javascript:ConfirmSendMail();"><span>发送邮件</span></a></li>
                          
                          
                          
                      </ul>
                  </div>
                  <table class="table" width="100%" layoutH="148">
                      <thead>
                          <tr>
                          	<th width="30"><input type="checkbox" group="Id" class="checkboxCtrl"></th>
								<th width="30">序号</th>
								<th width="90">编号</th>
								<th width="60">姓名</th>
								<th width="60">学校</th>
								<th width="120">邮箱</th>
								<th width="60">邀请人</th>
								<th width="120">发布时间</th>
								<th width="70">审核状态</th>
								<th width="70">邮件状态</th>
								<th width="60">操作</th>
                          </tr>
                      </thead>
                      <tbody>
		<c:forEach var="g" items="${list}" varStatus="t">
		<tr target="sid_Id" rel="${g.ID}">
			<td><c:if test="${g.EMAILID==null&&g.TYPEID == '1'}"><input name="Id" value="${g.ID}" type="checkbox" class="vcheckbox"></c:if></td>
			<td>${t.index+1}</td>
			<td>${g.SEQ}</td>
			<td>${g.NAME}</td>
			<td>${g.SCHOOL}</td>
			<td>${g.EMAIL}</td>
			<td>${g.REALNAME}</td>
			
			<td>
				<fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${g.UPDATETIME}"/>
			</td>
			
			<td>${g.TYPEID==0||g.TYPEID==null ? "未审核":""}${g.TYPEID==1 ? "审核通过":""}${g.TYPEID==2 ? "删除中":""}</td>
			<td>${g.EMAILID==null ? "未发送":"已发送"}</td>
			<td>
				<a title="删除" target="ajaxTodo" href="${AppBase}/delete/${g.ID}" class="btnDel">删除</a>
			</td>
		</tr>
		</c:forEach>
                      </tbody>
                  </table>
              </div>
<div id="dialog-modal" title="发送邮件确认">
	<p>您选择的<span id="scount"></span>个邀请人   确认发送吗？</p>
</div>