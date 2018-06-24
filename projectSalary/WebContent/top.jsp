<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<H2>給与の登録</H2>

    <FORM action="Contoroller" method="get">
    <INPUT TYPE="hidden" NAME="button" VALUE="insert">
    月：<input type = "text" name="month"><br>
    支給額：<input type = "text" name="input"><br>
    控除額：<input type = "text" name="output"><br>
    <input type = "submit" value="登録">
    </FORM>

    <FORM action="Contoroller" method="get">
    <INPUT TYPE="hidden" NAME="button" VALUE="select">
    <input type = "submit" value="参照">
    </FORM>

</body>
</html>