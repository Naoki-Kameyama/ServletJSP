<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="model.Salary" %>
<%@ page import="model.Mori" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/projectSalary/css/main.css">
<title>Insert title here</title>
</head>
<body>



<table border=1>
	<tr>
		<th>QUESTION</th><th>ANSWER</th>
	</tr>

	<%
	ArrayList<Mori> qset = (ArrayList<Mori>)session.getAttribute("questionList");
	Iterator<Mori> itr = qset.iterator();
	String mmm = "";


	while(itr.hasNext()){

		Mori mori = itr.next();
		mmm = mori.getUserId();
		out.println("<tr>");
		out.println("<td>" + mori.getQuestion() + "</td>");
		out.println("<td>" + mori.getAnswer() + "</td>");
		out.println("</tr>");

	}
	%>
</table>
<%
out.println("<a href=/projectSalary/question.jsp?question="+ mmm +">戻る</a>");
%>



</body>
</html>