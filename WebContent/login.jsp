<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Quản lý đăng ký tín chỉ</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

                        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

                        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

                        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div style="text-align: center">
        <h1>Đăng nhập</h1>
        <form action="login" method="post">
            <label for="account	">Tài khoản:</label>
            <input id = account name="account" size="30" placeholder="Nhập tài khoản"/>
            <br><br>
            <label for="password">Mật khẩu:</label>
            <input id = password type="password" name="password" size="30" placeholder="Nhập mật khẩu" />
            <br>
            ${message}
            <br><br>           
            <button id=submit type="submit">Đăng nhập</button>
            <a id = logup href="register.jsp">Chưa có tài khoản?</a>
        </form>
    </div>
</body>
<script type="text/javascript">
 
    $(document).ready(function() {
        $("#loginForm").validate({
            rules: {
                account: {
                    required: true,
                    account: true
                },
         
                password: "required",
            },
             
            messages: {
                email: {
                    required: "Please enter email",
                    account: "Please enter a valid email address"
                },
                 
                password: "Please enter password"
            }
        });
 
    });
</script>
</html>