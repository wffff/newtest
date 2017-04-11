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
  <table border="8" cellspacing="10">
    <tr>
      <th><a href="/showstudent">查询所有学生</a></th>
      <th><a href="/showclass">查询所有班级</a></th>
    </tr>
    <tr>
      <th><a href="/addStudentForm.jsp">添加学生</a></th>
      <th><a href="/addclassroomForm.jsp">添加班级</a></th>
    </tr>
    <tr>
      <th><a href="/modifyStudentForm.jsp">修改学生</a></th>
      <th><a href="/modifyclassroomForm.jsp">修改班级</a></th>
    </tr>

    <tr>
      <th><a href="/deleteStudentForm.jsp">删除学生按ID</a></th>
      <th><a href="/deleteclassroomForm.jsp">删除班级</a></th>
    </tr>

    <tr>
      <th><a href="/showall">查询对应关系</a></th>
    </tr>
  </table>


  </body>
</html>
