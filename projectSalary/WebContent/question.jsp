<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/projectSalary/css/main.css">
<title>Insert title here</title>
</head>
<body>

<%
	String userId = request.getParameter("question");
	%>

<div class="center">
<FORM action="Contoroller" method="get">
    <p>質問：<input type = "text" name="qu"><br>
    答え：<input type = "text" name="an"><br>
    <INPUT TYPE="hidden" NAME="button" VALUE="questionAdd">
    <%
     out.println("<INPUT TYPE=hidden NAME=q VALUE=" + userId  + ">");
    %>
    <input type = "submit" value="登録">
</FORM>
	<a href="/projectSalary/top.jsp">TOP</a>
	<%
	out.println("<a href=Contoroller?button=questionList&q="+userId+">Q&Aリスト</a>");
	%>



</body>
</html>