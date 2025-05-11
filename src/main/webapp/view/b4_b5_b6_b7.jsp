<%@ page import="ra.model.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Hi
  Date: 11/05/2025
  Time: 10:02 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head><title>Danh sách sinh viên</title></head>
<body>
<h2>Danh sách sinh viên</h2>
<table border="1">
    <tr>
        <th>STT</th><th>Tên</th><th>Tuổi</th><th>Địa chỉ</th><th>Hành động</th>
    </tr>
    <%
        List<Student> students = (List<Student>) request.getAttribute("studentList");
        int index = 1;
        for (Student s : students) {
    %>
    <tr>
        <td><%= index++ %></td>
        <td><%= s.getName() %></td>
        <td><%= s.getAge() %></td>
        <td><%= s.getAddress() %></td>
        <td style="display: flex; justify-content: center">
            <form action="edit-student" method="get">
                <input type="hidden" name="id" value="<%= s.getId() %>">
                <input type="submit" value="Sửa">
            </form>
            <form action="students" method="get" style="display:inline;">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" value="<%= s.getId() %>">
                <input type="submit" value="Xóa">
            </form>
        </td>
    </tr>
    <% } %>
</table>
<div>
    <p>Trang:
        <%
            int totalPages = (int) request.getAttribute("totalPages");
            int currentPage = (int) request.getAttribute("currentPage");
            String username = (String) request.getAttribute("username");

            for (int i = 1; i <= totalPages; i++) {
        %>
        <a href="students?page=<%= i %>&username=<%= username %>"
           style="<%= (i == currentPage) ? "font-weight:bold;" : "" %>">
            <%= i %>
        </a>
        <% } %>
    </p>
</div>
</body>
</html>
