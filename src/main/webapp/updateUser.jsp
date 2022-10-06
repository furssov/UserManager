<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 06.10.2022
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ua.furssov.User" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <% User user = (User) request.getAttribute("user"); %>
 <form action="/users/update" method="post">
     <table>
         <tr>
             <td>
                 <label for="id">Id:</label>
             </td>
             <td>
                 <input type="text" id="id" value="<%=user.getId()%>" disabled>
             </td>
         </tr>
         <tr>
             <td>
                 <label for="userName">UserName: </label>
             </td>
             <td>
                 <input type="text" id="userName" name="username" value="<%=user.getUserName()%>"/>
             </td>
         </tr>
         <tr>
             <td>
                 <label for="password">Password: </label>
             </td>
             <td>
                 <input type="password" id="password" name="password" value="<%=user.getPassword()%>"/>
             </td>
         </tr>
         <tr>
             <td> <input type="submit" value="Update"></td>
         </tr>
     </table>

 </form>
</body>
</html>
