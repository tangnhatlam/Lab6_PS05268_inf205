<%-- 
    Document   : student2
    Created on : 29-03-2018, 22:31:06
    Author     : lam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <base href="${pageContext.servletContext.contextPath}/">
    </head>
    <body>
        <h2>Quản lý sinh viên</h2>
	<form:form action="student2/update.htm" modelAttribute="student">
		<div>Họ và tên</div>
		<form:input path="name"/>
		
		<div>Điểm</div>
		<form:input path="mark"/>
		
                <div>Chuyên ngành</div>
                <form:select path="major" items="${majors}" 
                itemLabel="name" itemValue="id"/>
		
		<div>
			<button>Update</button>
		</div>
	</form:form>
    </body>
</html>
