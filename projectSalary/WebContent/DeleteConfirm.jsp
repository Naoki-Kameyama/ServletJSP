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
<p>本当に初期化しますか？</p>

    <FORM action="Contoroller" method="get">
    <INPUT TYPE="hidden" NAME="button" VALUE="delete">
    <input type = "submit" value="はい">
    </FORM>

    <FORM action="Contoroller" method="get">
    <INPUT TYPE="hidden" NAME="button" VALUE="select">
    <input type = "submit" value="いいえ">
    </FORM>


</body>
</html>