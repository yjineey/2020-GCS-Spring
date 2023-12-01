<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- include フォルダーのheader.jspパアイル に jstl 経路設定-->
<%@ include file="../include/header.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>掲示板 一覧画面</title>
		<script>
			$(document).ready(function() {
				$("#btnWrite").click(function() {
					location.href = "${path}/board/write.do";
				});
			});
		</script>
	</head>
	<body>
		<h2>掲示板一覧画面</h2>
		<button type="button" id="btnWrite">入力</button>
		${exist }
		<table border="1" width="100%">
			<tr>
				<th>番号</th>
				<th>タイトル</th>
				<th>作成者</th>
				<th>作成日</th>
				<th>照会数</th>
				<th>修正者</th>
				<th>修正日</th>
			</tr>
			<c:choose>
				<c:when test="${fn:length(list) > 0}">
	
					<c:forEach var="row" items="${list}">
						<tr>
							<td>${row.bno}</td>
							<td><a href="${path}/board/view.do?bno=${row.bno}">${row.title}</a></td>
							<td>${row.writer}</td>
							<td><fmt:formatDate value="${row.regdate}"
									pattern="yyyy/MM/dd HH:mm:ss" /></td>
							<td>${row.viewcnt}</td>
							<td>${row.upd_id}</td>
							<td><fmt:formatDate value="${row.upd_date}"
									pattern="yyyy/MM/dd HH:mm:ss" /></td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr align="center">
						<td colspan="7">データがありません</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</table>
	</body>
</html>

