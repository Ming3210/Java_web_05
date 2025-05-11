<%@ page import="ra.model.Student" %><%--
  Created by IntelliJ IDEA.
  User: Hi
  Date: 11/05/2025
  Time: 10:57 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
    Student student = (Student) request.getAttribute("student");
%>
<html>
<head><title>Sửa thông tin</title></head>
<body>
<h2>Sửa thông tin sinh viên</h2>
<form action="edit-student" method="post">
    <input type="hidden" name="id" value="<%= student.getId() %>">
    Tên: <input type="text" name="name" value="<%= student.getName() %>" required><br>
    Tuổi: <input type="number" name="age" value="<%= student.getAge() %>" required><br>
    Địa chỉ: <input type="text" name="address" value="<%= student.getAddress() %>" required><br>
    <input type="submit" value="Cập nhật">
</form>
</body>
</html>
