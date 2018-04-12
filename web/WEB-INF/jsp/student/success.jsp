<%-- 
    Document   : success
    Created on : 20-03-2018, 20:49:52
    Author     : lam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring MVC</title>
        <base href="${pageContext.servletContext.contextPath}"/>
    </head>
    <body>
        <h3>THÔNG TIN SINH VIÊN POLY</h3>
        <ul>
            <li>Họ và tên: ${name}</li>
            <li>Điểm trung bình: ${mark}</li>
            <li>Chuyên ngành: ${major}</li>
        </ul>
    </body>
</html>
