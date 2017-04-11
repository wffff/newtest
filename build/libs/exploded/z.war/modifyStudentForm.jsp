<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/6
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/modifystudent" method="post">
    <header>学生修改</header>
    <p><label>学生ID:</label><input name="studentid"/></p>
    <p><label>学生姓名:</label><input name="studentname" /></p>
    <p><label>学生班级ID:</label><input name="studentclassid" /></p>
    <p><button type="submit">修改</button></p>
  </form>


  </body>
</html>
