<%@ page import="db.BookmarkWifiService" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023-05-08
  Time: 오전 6:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  int id = Integer.valueOf(request.getParameter("bookmark-id"));
  BookmarkWifiService bookmarkService = new BookmarkWifiService();
  bookmarkService.delete(id);

%>
<script type="text/javascript">
  location.href="bookmarklist.jsp";
</script>
