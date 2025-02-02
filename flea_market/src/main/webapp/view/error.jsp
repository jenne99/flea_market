<%@page contentType="text/html; charset=UTF-8"%>

<%
	String error = (String) request.getAttribute("error");
	if (error == null) {
		error = "";
	}
	String cmd = (String) request.getAttribute("cmd");
	if (cmd == null) {
		cmd = "menu";
	}
%>

<html>
	<head>
		<title>エラー画面</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
	</head>
	<body>
		<!-- ブラウザ全体 -->
		<div id="wrap">
			<!-- ヘッダー部分 -->
			<%@ include file="/common/header.jsp" %>

			<!-- メニュー部分 -->
			<div id="menu">
				<div class="container">
					<!-- ページタイトル -->
					<div id="page_title">
						<h2>■■エラー■■</h2>
					</div>
				</div>
			</div>

			<!-- コンテンツ部分 -->
			<div id="main" class="container">

				<p class="error-msg"><%=error %></p>

				<p class="back-link">
					<%
					if (cmd.equals("menu")) {
					%>
						<!-- メニュー画面「/view/menu.jsp(仮)」へ遷移する -->
						<a href="<%=request.getContextPath()%>/view/menu.jsp">[メニューに戻る]</a>	
					<%
					} else if (cmd.equals("logout")) {
					%>
						<!-- ログイン画面「/logout(仮)」へ遷移する -->
						<a href="<%=request.getContextPath()%>/logout">[ログイン画面へ]</a>
					<%
					} else if (cmd.equals("list")) {
					%>
						<!-- 一覧画面「/list(仮)」へ遷移する -->
						<a href="<%=request.getContextPath()%>/list">[一覧表示に戻る]</a>
					<%
					}
					%>
				</p>
			</div>

			<!-- フッター部分 -->
			<%@ include file="/common/footer.jsp" %>

		</div>
	</body>
</html>