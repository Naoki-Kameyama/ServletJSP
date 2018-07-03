<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="model.Salary" %>
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
		<th>月</th><th>種類</th><th>支給額</th><th>控除額</th><th>差引支給額</th><th>累計支給額</th><th>累計差引支給額</th>
	</tr>

	<%
	double InputCumulative = 0;
	double TotalCumulative = 0;
	ArrayList<Salary> akey = (ArrayList<Salary>)session.getAttribute("key");
	Iterator<Salary> itr = akey.iterator();
	while(itr.hasNext()){
		Salary key = itr.next();
		out.println("<tr>");
		out.println("<td>" + key.getMonth() + "</td>");
		out.println("<td>" + key.getType() + "</td>");
		out.println("<td>" + (int)key.getInput() + "</td>");
		out.println("<td>" + (int)key.getOutput() + "</td>");
		out.println("<td>" + (int)key.getTotal() + "</td>");
		InputCumulative += key.getInput();
		out.println("<td>" + (int)InputCumulative + "</td>");
		TotalCumulative += key.getTotal();
		out.println("<td>" + (int)TotalCumulative + "</td>");
		out.println("</tr>");
	}
	%>
</table>
<a href="/projectSalary/top.jsp">TOP</a>


</body>
</html>