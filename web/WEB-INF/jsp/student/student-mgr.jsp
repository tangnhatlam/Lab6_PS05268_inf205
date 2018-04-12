<%-- 
    Document   : student-mgr
    Created on : 25-03-2018, 22:24:25
    Author     : lam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring MVC</title>
        <base href="${pageContext.servletContext.contextPath}/">
    </head>
    <body>
        <h2>Quản lý sinh viên</h2>
        <form:form action="student-mgr.htm" modelAttribute="student">
            <div>Họ và tên</div>
            <form:input path="name"/>

            <div>Điểm</div>
            <form:input path="mark"/>

            <div>Chuyên ngành</div>

            <form:select path="major" items="${majors}" 
                         itemLabel="name" itemValue="id"/>
            
            <div>
                <button name="btnInsert">Thêm</button>
                <button name="btnUpdate">Cập nhật</button>         
            </div>
        </form:form>
        <hr>
        <table border="1">
            <tr>
                <td>Name</td>
                <td>Mark</td>
                <td>Major</td>
                <td>Edit</td>
                <td>Delete</td>
            </tr>
            <c:forEach var="rows" items="${listStudent}">
                <form action="student-mgr/delete.htm">
                    <tr>
                        <td>${rows.name}</td>
                        <td>${rows.mark}</td>
                        <td>${rows.major}</td>
                        <c:url var="edit" value="student-mgr/edit.htm">
                            <c:param name="txtName" value="${rows.name}"/>
                            <c:param name="txtMark" value="${rows.mark}"/>
                            <c:param name="txtMajor" value="${rows.major}"/>
                        </c:url>
                        <td><a href="${edit}">Edit</a></td>
                        <td>
                            <input type="hidden" name="txtName" value="${rows.name}"/>
                            <input type="submit" name="action" value="Delete"/>
                        </td>
                    </tr>
                </form>
            </c:forEach>    
        </table>
        
    </body>
</html>
