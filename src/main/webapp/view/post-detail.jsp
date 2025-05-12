<%--
  Created by IntelliJ IDEA.
  User: Hi
  Date: 12/05/2025
  Time: 10:56 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Post Detail</title>
</head>
<body>
<c:if test="${not empty post}">
    <h1>${post.title}</h1>
    <p><strong>Author:</strong> ${post.author}</p>
    <p><strong>Published on:</strong> ${post.publishDate}</p>
    <hr>
    <p>${post.content}</p>
    <a href="/PostController?action=findAll">Back to All Posts</a>
</c:if>
<c:if test="${empty post}">
    <p>Post not found.</p>
    <a href="/PostController?action=findAll">Back to All Posts</a>
</c:if>
</body>
</html>
