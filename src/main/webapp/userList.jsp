<%--
  Created by IntelliJ IDEA.
  com.ua.furssov.User: user
  Date: 06.10.2022
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.ua.furssov.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>Id</th>
        <th>UserName</th>
        <th>Password</th>
        <th colspan="3">Operations</th>
    </tr>

    <%
        for (User user : (List<User>)request.getAttribute("users"))
        {
    %>
    <tr>
        <td><%=user.getId()%></td>
        <td><%=user.getUserName()%></td>
        <td><%=user.getPassword()%></td>
        <td>
            <a href="/users/read?id=<%=user.getId()%>">Read</a>
        </td>
        <td>
            <a href="/users/update?id=<%=user.getId()%>">Update</a>
        </td>
        <td>
            <a href="/users/delete?id=<%=user.getId()%>">Delete</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
