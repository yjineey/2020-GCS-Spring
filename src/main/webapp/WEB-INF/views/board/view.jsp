<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- include フォルダーのheader.jspパアイル に jstl 経路設定-->
<%@ include file="../include/header.jsp" %>		

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>掲示物照会</title>
			<script>
			    $(document).ready(function(){
			        $("#btnUpdete").click(function(){
			       //     location.href ="${path}/board/change.do"	
			            location.href ="${path}/board/change.do?bno=${dto.bno}"	
			        });
			    });
			</script>
			<script>
			    $(document).ready(function(){
			        $("#btnList").click(function(){
			                document.form1.action = "${path}/board/list.do";
			                document.form1.submit();
			        });
			    });
			</script>
	</head>
	<body>
		<h2>掲示物照会</h2>
		<form name="form1" method="post" >
		    <div> 作  成  日 : <fmt:formatDate value="${dto.regdate}" pattern="yyyy/MM/dd HH:mm:ss"/></div>
			<div> 修 正 日 :  <fmt:formatDate value="${dto.upd_date}" pattern="yyyy/MM/dd HH:mm:ss"/></div>
		    <div> 照  会  数 : ${dto.viewcnt}</div>
		    <div> タイトル: ${dto.title}    </div>
		    <div> 内 　 容  : ${dto.content}</div>
		    <div> 作 成 者 : ${dto.writer} </div>
		    <div> 修 正 者 : ${dto.upd_id}</div>
		     <p>
		    <div style="width:650px; text-align: center;">
		        <input type="hidden" name="bno" value="${dto.bno}">
		        <button type="button" id="btnList">リスト</button>       
		        <button type="button" id="btnUpdete">修正</button>
		     </div>
		</form>
	</body>
</html>