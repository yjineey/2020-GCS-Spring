<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- include フォルダーのheader.jspパアイル に jstl 経路設定-->
<%@ include file="../include/header.jsp"%>

<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>掲示物作成</title>
		<script>
			$(document).ready(function() {
				$("#btnSave").click(function() {
					document.form1.submit();
				});
			});
		</script>
	
		<script>
			$(document).ready(function() {
				$("#btnList").click(function() {
					document.form1.action = "${path}/board/list.do";
					document.form1.submit();
				});
			});
		</script>
	</head>
	<body>
		<h2>掲示物作成</h2>
		<c:forEach var="name" items="${msg}" varStatus="status"><span style="color:red;">
		<p><c:out value="${name}" /></p></span></c:forEach>
	
			<form name="form1" method="post" action="${path}/board/insert.do">
			<br>
			<div>タイトル:<textarea name="title" id="title" rows="1.5" cols="100" placeholder="タイトルを入力してください">${title}</textarea></div>
			<div>内 容 :<textarea name="content" id="content" rows="25" cols="100" placeholder="内容を入力してください。">${content}</textarea></div>
			<div>作 成 者 :<textarea name="writer" id="writer" rows="1.5" cols="100" placeholder="作成者を入力してください">${writer}</textarea></div>
			<p>
			<div style="width: 650px; text-align: center;">
				<button type="button" id="btnList">リスト</button>
				<button type="button" id="btnSave">確認</button>
			</div>
		</form>
	</body>
</html>
