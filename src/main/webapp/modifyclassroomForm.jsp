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
  <form action="/modifyclassroom" method="post">
    <header>班级修改</header>
    <p><label>班级ID:</label><input name="classid"/></p>
    <p><label>班级名称:</label><input name="classname" /></p>
    <p><button type="submit">修改</button></p>
  </form>


  </body>
</html>
