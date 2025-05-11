<%--
  Created by IntelliJ IDEA.
  User: Hi
  Date: 12/05/2025
  Time: 3:43 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Task</title>
</head>
<body>
<h3>Create New Task</h3>
<form action="<%=request.getContextPath()%>/TaskController?action=Create" method="post">


    <label for="description">Description</label>
    <input type="text" id="description" name="description" required/><br>

    <label>Status</label>
    <input type="radio" id="active" name="status" value="true" checked/>
    <label for="active">Active</label>
    <input type="radio" id="inactive" name="status" value="false"/>
    <label for="inactive">Inactive</label><br>

    <input type="submit" value="Create"/>
</form>
</body>
</html>
