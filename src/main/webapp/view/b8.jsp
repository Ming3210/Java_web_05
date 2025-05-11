<%--
  Created by IntelliJ IDEA.
  User: Hi
  Date: 12/05/2025
  Time: 1:56 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task List</title>
</head>
<body>
<h3>List of Tasks</h3>
<table border="1">
    <thead>
    <tr>
        <th>No</th>
        <th>Task ID</th>
        <th>Description</th>
        <th>Status</th>
        <th colspan="2">Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="task" items="${taskList}" varStatus="loop">
        <tr>
            <td>${loop.index + 1}</td>
            <td>${task.id}</td>
            <td>${task.description}</td>
            <td>
                <c:choose>
                    <c:when test="${task.completed}">
                        Active
                    </c:when>
                    <c:otherwise>
                        Inactive
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <a href="TaskController?action=edit&id=${task.id}">Edit</a> |
                <a href="TaskController?action=delete&id=${task.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="view/newTask.jsp">Create new task</a>
</body>
</html>
