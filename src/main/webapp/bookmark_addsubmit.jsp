<%@ page import="db.BookmarkWifiService" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023-05-08
  Time: 오전 3:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String wifiMgrNo = request.getParameter("wifiNo");
  int bookmarkGroupId = Integer.valueOf(request.getParameter("bookmark-group"));
  BookmarkWifiService bookmarkService = new BookmarkWifiService();
  bookmarkService.insert(wifiMgrNo, bookmarkGroupId);

%>
<script type="text/javascript">
  location.href="bookmarklist.jsp";
</script>