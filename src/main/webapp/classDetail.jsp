<%@ page import="java.util.List" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="com.gogo.demo.beans.Classroom" %>
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
          <th>教室ID</th><th>教室名称</th>
      </tr>
<% List<Classroom> list = (List<Classroom>)request.getSession().getAttribute("classroom");
for(int i=0;i<list.size();i++){
    Classroom cl=new Classroom();
    cl.setId(list.get(i).getId());
    cl.setClassname(list.get(i).getClassname());

    %>


      <tr>
          <th><%=cl.getId()%></th><th><%=cl.getClassname()%></th>
      </tr>

<%
}%>

  </table>
  <a href="index.jsp">返回</a>
  </body>
</html>
