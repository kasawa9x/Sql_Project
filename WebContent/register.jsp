<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Quản lý đăng ký tín chỉ</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>
        <body>
</head>
<body>
	<div style="text-align: center">
        <h2>Đăng ký</h2>
        <form action="adduser" method="post">
            <label for="maSv">Mã sinh viên:</label>
            <input id = id name="maSv" size="30" placeholder="Mã SV"/>
            <br><br>
            <label for="taikhoan">Tài khoản:</label>
            <input id = account name="taikhoan" size="30" placeholder="Tên tài khoản"/>
            <br><br>
            <label for="matkhau">Mật khẩu:</label>
            <input id = password name="matkhau" type ="password" size="30" placeholder="Mật khẩu"/>
            <br><br>  
            <label for="tenSv">Tên:</label>
            <input id = name name="tenSv" size="30" placeholder="Tên"/>
            <br><br> 
            <button id = logup type="submit">Tạo tài khoản</button>
            <br> 
           	
            ${message}
           
            <br><br>  
            <a href="login.jsp">Quay lại</a>
        </form>
    </div>
</body>
</html>