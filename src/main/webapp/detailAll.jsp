<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.gogo.demo.beans.Student" %><%--
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
          <th>学生ID</th><th>学生姓名</th><th>班级名称</th>
      </tr>
<% List<Student> list = (List<Student>)request.getSession().getAttribute("student");
for(int i=0;i<list.size();i++){
    Student sd=new Student();
    sd.setId(list.get(i).getId());
    sd.setName(list.get(i).getName());
    sd.setClass_id(list.get(i).getClass_id());
    sd.setClassname(list.get(i).getClassname());
    %>


      <tr>
          <th><%=sd.getId()%></th><th><%=sd.getName()%></th><th><%=sd.getClassname()%></th>
      </tr>

<%
}%>

  </table>
  <a href="index.jsp">返回</a>
  </body>
</html>
