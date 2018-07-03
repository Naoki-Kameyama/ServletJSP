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

<FORM action="Contoroller" method="get">
<table border=1>
	<tr>
		<th>QUESTION</th><th>ANSWER</th>
	</tr>

	<%

	ArrayList<Mori> qset = (ArrayList<Mori>)session.getAttribute("questionAnswer");
	Iterator<Mori> itr = qset.iterator();
	String mmm = "";
	Mori mori = new Mori();

	while(itr.hasNext()){
	 mori = itr.next();
		out.println("<tr>");
		out.println("<td>" + mori.getQuestion() + "</td>");
		%>
		<td><input type ="text" name="ans"></td>
		<%
		out.println("</tr>");
	}
	%>
</table>

<INPUT TYPE="hidden" NAME="button" VALUE="saiten">
<%
out.println("<INPUT TYPE=hidden NAME=aaa VALUE=" + mori.getAnswer() + ">");
%>
    <input type = "submit" value="採点">
</FORM>

	<a href="/projectSalary/top.jsp">TOP</a>

</body>
</html>