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
<form action="showtable" method="post">

    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Đăng kí môn học</h2></caption>
            <tr>
            	
                <th>Mã môn học</th>
                <th>Tên môn học</th>
                <th>Tên giảng viên</th>
                <th>Thứ</th>
                <th>Kíp</th>
                <th>Đã đăng kí</th>
                <th>Tối đa</th>
            </tr>
            
            <c:forEach var="tableshow" items="${listTableShow}">
                <tr>
                	
                    <td><c:out value="${tableshow.maMh}" /></td>
                    <td><c:out value="${tableshow.tenMh}" /></td>
                    <td><c:out value="${tableshow.tenGv}" /></td>
                    <td><c:out value="${tableshow.ngay}" /></td>
                    <td><c:out value="${tableshow.ca}" /></td>
                    <td><c:out value="${tableshow.soSv}" /></td>
                    <td><c:out value="${tableshow.maxSv}" /></td>
                    <td>
                        <td><a href="addsubject?stucode=<c:out value='${user.maSv }'/>&classcode=<c:out value='${tableshow.maGv }'/>">Thêm môn học</a>
                        <td><a href="deletesubject?stucode=<c:out value='${user.maSv }'/>&classcode=<c:out value='${tableshow.maGv }'/>">Xoá môn học</a>              
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="subjectlist.jsp">Quay lại</a>
    </div>   
</body>
</html>