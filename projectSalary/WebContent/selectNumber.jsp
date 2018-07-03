
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

    <form action ="Contoroller" method="get">
    <input type="hidden" name="button" value="keySelect">
    <p>年(西暦)：<input type="text" name="selectYear"><br>
    月：<input type="text" name="selectMonth"><br>
    <input type="submit" value="検索">
    </form>

    <a href="/projectSalary/top.jsp">TOP</a>

</div>
</body>
</html>