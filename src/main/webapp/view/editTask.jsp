<%--
  Created by IntelliJ IDEA.
  User: Hi
  Date: 12/05/2025
  Time: 4:27 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Task</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h3 {
            color: #333;
        }
        form {
            max-width: 500px;
            padding: 15px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        label {
            display: block;
            margin: 10px 0 5px;
            font-weight: bold;
        }
        input[type="text"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        .radio-group {
            margin-bottom: 15px;
        }
        .radio-group label {
            display: inline;
            margin-right: 15px;
            font-weight: normal;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<h3>Edit Task</h3>
<form action="TaskController" method="post">
    <input type="hidden" name="action" value="Update" />
    <input type="hidden" name="id" value="${task.id}" />

    <label for="description">Description</label>
    <input type="text" id="description" name="description" value="${task.description}" required />

    <div class="radio-group">
        <label>Status</label>
        <input type="radio" id="active" name="status" value="true" ${task.completed ? "checked" : ""} />
        <label for="active">Active</label>
        <input type="radio" id="inactive" name="status" value="false" ${!task.completed ? "checked" : ""} />
        <label for="inactive">Inactive</label>
    </div>

    <input type="submit" value="Update" />
</form>
</body>
</html>