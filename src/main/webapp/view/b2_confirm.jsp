<%@ page import="ra.model.Person" %><%--
  Created by IntelliJ IDEA.
  User: Hi
  Date: 11/05/2025
  Time: 9:21 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
  Person person = (Person) request.getAttribute("person");
%>
<html>
<head>
  <title>Xác Nhận</title>
</head>
<body>
<h2>Thông Tin Sinh Viên Đã Được Gửi Thành Công!</h2>
<p><strong>Tên:</strong> <%= person.getName() %></p>
<p><strong>Tuổi:</strong> <%= person.getAge() %></p>
<p><strong>Địa chỉ:</strong> <%= person.getAddress() %></p>
</body>
</html>

</body>
</html>
