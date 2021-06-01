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

    <div align="center">
        <table border="1" cellpadding="10">
            <caption><h2>Xem thời khoá biểu</h2></caption>
            <tr>
                <th>Thứ 2</th>
                <th>Thứ 3</th>
                <th>Thứ 4</th>
                <th>Thứ 5</th>
                <th>Thứ 6</th>
            </tr>
            
            <c:forEach var="schedule" items="${listMark}">
                <tr>
                    <td><c:out value="${schedule.thu2}" /></td>
                    <td><c:out value="${schedule.thu3}" /></td>
                    <td><c:out value="${schedule.thu4}" /></td>
                    <td><c:out value="${schedule.thu5}" /></td>
                    <td><c:out value="${schedule.thu6}" /></td>
                </tr>
            </c:forEach>
        </table>
        <a href="subjectlist.jsp">Quay lại</a>
    </div>   
</body>
</html>