<%-- 
    Document   : student
    Created on : 29-03-2018, 21:07:14
    Author     : lam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring MVC</title>
        
    </head>
    <body>
        <form action="student.htm" method="post">
            <div>Họ và tên</div>
            <input name="name" value="${student.name}"/>
            <div>Điểm trung bình</div>
            <input name="mark" value="${student.mark}"/>
            <div>Chuyên ngành</div>
            <label>
                <input name="major" type="radio" value="APP" ${student.major=='APP'?'checked':''}/>
                Ứng dụng phần mềm
            </label>
            <label>
                <input name="major" type="radio" value="WEB" ${student.major=='WEB'?'checked':''}/>
                Thiết kế trang web
            </label>
            <hr>
            <button>Cập nhật</button>
        </form>
    </body>
</html>
