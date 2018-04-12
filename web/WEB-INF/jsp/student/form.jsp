<%-- 
    Document   : form
    Created on : 20-03-2018, 20:17:54
    Author     : lam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring MVC</title>
        <base href="${pageContext.servletContext.contextPath}/">
    </head>
    <body>
        <h2>SINH VIEN FPOLY</h2>
        <form action="student.htm" method="post">
            <div>Họ và tên</div>
            <input name="name"/>
            <div>Điểm trung bình</div>
            <input name="mark"/>
            <div>Chuyên ngành</div>
            <label>
                <input name="major" type="radio" value="Application"/>
                Ứng dụng phần mềm
            </label>
            <label>
                <input name="major" type="radio" value="WEB"/>
                Thiết kế trang web
            </label>
            
            <hr>
            <button>Lưu</button>
        </form>
    </body>
</html>
