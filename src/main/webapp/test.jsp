<%--
  Created by IntelliJ IDEA.
  User: chans
  Date: 2023-10-16
  Time: 오후 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int sum = 0;

    for (int i = 0; i <= 10; i++) {
        sum += i;
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%=sum%>
</body>
</html>
