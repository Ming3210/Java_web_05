<%--
  Created by IntelliJ IDEA.
  User: Hi
  Date: 12/05/2025
  Time: 10:49 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All Posts</title>
</head>
<body>
<h1>All Blog Posts</h1>

<c:choose>
    <c:when test="${not empty posts}">
        <c:forEach var="post" items="${posts}">
            <div style="border: 1px solid #ccc; margin: 10px; padding: 10px;">
                <h2>${post.title}</h2>
                <p><strong>Author:</strong> ${post.author}</p>
                <p><strong>Date:</strong> ${post.publishDate}</p>
                <p>${post.content}...</p>
                <a href="/PostController?action=findById&id=${post.id}">Read More</a>
            </div>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <p>No posts found.</p>
    </c:otherwise>
</c:choose>
</body>
</html>

