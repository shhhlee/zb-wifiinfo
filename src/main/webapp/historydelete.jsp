<%@ page import="db.HistoryService" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023-05-07
  Time: 오전 1:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%
  HistoryService historyService = new HistoryService();
  historyService.delete(Integer.parseInt(request.getParameter("id")));

%>
<script>
  location.href="history.jsp";
</script>
</body>
</html>
