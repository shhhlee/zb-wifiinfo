<%@ page import="db.BookmarkGroupService" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023-05-08
  Time: 오전 2:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int id = Integer.valueOf(request.getParameter("id"));
    BookmarkGroupService bookmarkGroupService = new BookmarkGroupService();
    bookmarkGroupService.delete(id);

%>
<script type="text/javascript">
    location.href="bookmarkgrouplist.jsp";
</script>

