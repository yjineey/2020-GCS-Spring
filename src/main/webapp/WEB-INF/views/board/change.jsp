<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- include フォルダーのheader.jspパアイル に jstl 経路設定-->
<%@ include file="../include/header.jsp" %>		

<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>掲示物修正</title>
		<script>
			$(document).ready(function() {
				$("#btnUpdete").click(function() {
					document.form1.action = "${path}/board/update.do?bno=${dto.bno}"
					document.form1.submit();
				});
				$("#btnDelete").click(function() {
					if (confirm("削除しますか?")) {
						document.form1.action = "${path}/board/delete.do";
						document.form1.submit();
					}
				});
			});
			$(document).ready(function() {
				$("#btnBack").click(function() {
					location.href = "${path}/board/view.do?bno=${dto.bno}"
				});
			});
		</script>
	</head>
	<body>
		<h2>掲示物修正</h2>
		<c:forEach var="name" items="${msg}" varStatus="status"><span style="color:red;">
			<p><c:out value="${name}" /></p></span>
		</c:forEach>
	
		 <form name="form1" method="post"> 
		<%--<form method="post">--%>
			<p>
			<div>作 成 日 :<fmt:formatDate value="${dto.regdate}" pattern="yyyy/MM/dd HH:mm:ss" /></div>
			<div>修 正 日 :<fmt:formatDate value="${dto.upd_date}" pattern="yyyy/MM/dd HH:mm:ss" /></div>
			<div>照 会 数 : ${dto.viewcnt}</div>
			<div>タイトル:<textarea name="title" id="title" rows="4.5" cols="120" placeholder="タイトルを入力してください。">${dto.title}</textarea></div>
			<div>内    &nbsp;&nbsp;&nbsp;  容 :<textarea name="content" id="content" rows="20" cols="120" placeholder="内容を入力してください。">${dto.content}</textarea></div>
			<div>作 成 者 : ${dto.writer}</div>
			<div>修 正 者 :<textarea name="upd_id" id="upd_id" rows="1.5" cols="120" placeholder="修正者を入力してください。">${dto.upd_id}</textarea></div>
			<p>
			
			<div style="width: 650px; text-align: center;">
				<input type="hidden" name="bno" value="${dto.bno}">
				<input type="hidden" name="viewcnt" value="${dto.viewcnt}"/>
				<input type="hidden" name="writer" value="${dto.writer}"/>
				<button type="button" id="btnUpdete">修正</button>
				<button type="button" id="btnDelete">削除</button>
				<button type="button" id="btnBack">キャンセル</button>
			</div>
		</form>
	</body>
</html>