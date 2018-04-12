<%-- 
    Document   : staff
    Created on : Apr 9, 2018, 8:18:22 AM
    Author     : Lam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <base href="${pageContext.servletContext.contextPath}/">
    </head>
    <body>
        <h2>Quản lý nhân viên</h2>
        <form:form action="staff-mgr/index.htm" modelAttribute="staff" method="post" enctype="multipart/form-data">
            <div>ID</div>
            <form:input path="id"/>

            <div>Name</div>
            <form:input path="name"/>
            
            <label>
                <form:radiobutton path="gender" value="0" />
                Nam
            </label>
            <label>
                <form:radiobutton path="gender" value="1" />
                Nữ
            </label>

            <div>Birthday</div>
            <form:input path="birthday"/>
            
            <div>Photo</div>
            <form:input type="file" path="photo"/>  
            <div>Email</div>
            <form:input path="email"/>
            <div>Phone</div>
            <form:input path="phone"/>
            <div>Salary</div>
            <form:input path="salary"/>
            <div>Notes</div>
            <form:textarea path="notes"/>
            
            <form:select path="departs_id" items="${departs}" 
                         itemLabel="name" itemValue="id"/>
            
            <div>
                <button name="btnInsert">Thêm</button>
                <button name="btnUpdate">Cập nhật</button>         
            </div>
        </form:form>
        <hr>
        <table border="1">
            <tr>
                    <td>Id</td>
                    <td>Name</td>
                    <td>Gender</td>
                    <td>Birthday</td>
                    <td>Photo</td>
                    <td>Email</td>
                    <td>Phone</td>
                    <td>Salary</td>
                    <td>Notes</td>
                    <td>Depart</td>
                
                
            </tr>
            <c:forEach var="rows" items="${listStaff}">
                <form action="staff-mgr/delete.htm">
                    <tr>
                        <td>${rows.id}</td>
                        <td>${rows.name}</td>
                        <td>${rows.gender}</td>
                        <td>${rows.birthday}</td>
                        <td>${rows.photo}</td>
                        <td>${rows.email}</td>
                        <td>${rows.phone}</td>
                        <td>${rows.salary}</td>
                        <td>${rows.notes}</td>
                        <td>${rows.departs_id}</td>
                        <c:url var="edit" value="staff-mgr/edit.htm">
                            <c:param name="txtId" value="${rows.id}"/>
                            <c:param name="txtName" value="${rows.name}"/>
                            <c:param name="txtGender" value="${rows.gender}"/>
                            <c:param name="txtBirthday" value="${rows.birthday}"/>
                            <c:param name="txtPhoto" value="${rows.photo}"/>
                            <c:param name="txtEmail" value="${rows.email}"/>
                            <c:param name="txtPhone" value="${rows.phone}"/>
                            <c:param name="txtSalary" value="${rows.salary}"/>
                            <c:param name="txtNotes" value="${rows.notes}"/>
                            <c:param name="txtDeparts" value="${rows.departs_id}"/>
                        </c:url>
                        <td><a href="${edit}">Edit</a></td>
                        <td>
                            <input type="hidden" name="txtId" value="${rows.id}"/>
                            <input type="submit" name="action" value="Delete"/>
                        </td>
                    </tr>
                </form>
            </c:forEach>    
        </table>
    </body>
</html>
