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

<div class="center">
<FORM action="Contoroller" method="get">
    <INPUT TYPE="hidden" NAME="button" VALUE="insert">
    <p>年(西暦)：<input type = "text" name="year"><br>
    月：<input type = "text" name="month"><br>
    日：<input type = "text" name="day"><br>
    種類：<input type = "text" name="type"><br>
    支給額：<input type = "text" name="input"><br>
    控除額：<input type = "text" name="output"><br>
    <input type = "submit" value="登録">
    </FORM>
	<a href="/projectSalary/top.jsp">TOP</a>
</div>
</body>
</html>