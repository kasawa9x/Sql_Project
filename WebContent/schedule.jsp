<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<form action="showschedule" method="post">

    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Xem thời khoá biểu</h2></caption>
            <tr>
                <th>Tên môn học</th>
                <th>Thứ</th>
                <th>Kíp</th>
            </tr>
            
            <c:forEach var="schedule" items="${listSchedule}">
                <tr>
                    <td><c:out value="${schedule.tenMh}" /></td>
                    <td><c:out value="${schedule.thu}" /></td>
                    <td><c:out value="${schedule.ca}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>