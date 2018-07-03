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
		<th>年月日</th><th>種類</th><th>支給額</th><th>控除額</th><th>差引支給額</th><th>累計支給額</th><th>累計差引支給額</th>
	</tr>

	<%
	double InputCumulative = 0;
	double TotalCumulative = 0;
	ArrayList<Salary> sset = (ArrayList<Salary>)session.getAttribute("list");
	Iterator<Salary> itr = sset.iterator();

	while(itr.hasNext()){

		Salary salary = itr.next();
		out.println("<tr>");
		out.println("<td>" + salary.getMonth() + "</td>");
		out.println("<td>" + salary.getType() + "</td>");
		out.println("<td>" + (int)salary.getInput() + "</td>");
		out.println("<td>" + (int)salary.getOutput() + "</td>");
		out.println("<td>" + (int)salary.getTotal() + "</td>");
		InputCumulative += salary.getInput();
		out.println("<td>" + (int)InputCumulative + "</td>");
		TotalCumulative += salary.getTotal();
		out.println("<td>" + (int)TotalCumulative + "</td>");
		%>
		<td>
		<FORM action="Contoroller" method="get">
	    <INPUT TYPE="hidden" NAME="button" VALUE="singleDelete">
	    <%
	    out.println("<INPUT TYPE=hidden NAME=sd VALUE=" + salary.getMonth() + ">");
	    %>
	    <input type = "submit" value="削除">
	    </FORM>
		</td>
		<%
		out.println("</tr>");

	}
	%>
</table>
<a href="/projectSalary/top.jsp">TOP</a>
<a href="/projectSalary/DeleteConfirm.jsp">初期化</a>



</body>
</html>