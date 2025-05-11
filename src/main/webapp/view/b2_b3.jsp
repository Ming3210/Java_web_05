<%--
  Created by IntelliJ IDEA.
  User: Hi
  Date: 11/05/2025
  Time: 9:03 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% String error = (String) request.getAttribute("error"); %>
<% if (error != null) { %>
<p style="color: red;"><%= error %></p>
<% } %>
<form action="/B2Controller" method="post">
  <label for="name">Name: </label>
    <input type="text" id="name" name="name"><br><br>
    <label for="age">Age: </label>
    <input type="text" id="age" name="age"><br><br>
    <label for="address">Address: </label>
    <input type="text" id="address" name="address"><br><br>
    <input type="submit" value="Submit">
</form>


</body>
</html>
