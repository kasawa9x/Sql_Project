<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Quản lý đăng ký tín chỉ</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

                        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

                        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

                        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div style="text-align: center">
        <h1>Chào mừng đến với website của học viện</h1>
        <b>${user.tenSv} (${user.taikhoan})</b>
        <br><br>
        <form action="logout" method="post">
        <button type="submit">Đăng xuất</button>
        </form>
    </div>
    <form action="showtable" method="post">
    <div style="text-align: center">
    	<select id="semester" name="semester">
        	
        	<option id = Ki6 value="6">Kì 6</option>
        
        	<option id = Ki8 value="8">Kì 8</option>

    	</select>
    	<select id="major" name="major">
        	<option value="CNTT">Công nghệ thông tin</option>
        	<option value="KT">Kinh tế</option>
    	</select>
    	<input id = submit type="submit" value="Đăng kí môn học">
    </div>
    </form>
    <div style="text-align: center">
    <a href="showschedule?stucode=<c:out value='${user.maSv }'/>">Xem thời khoá biểu</a>
   
    </div>
</body>
</html>