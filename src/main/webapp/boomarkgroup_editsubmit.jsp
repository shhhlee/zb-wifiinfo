<%@ page import="db.BookmarkGroupService" %>
<%@ page import="db.BookmarkGroup" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023-05-08
  Time: ¿ÀÀü 3:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=euc_kr" pageEncoding="euc_kr"%>

<% request.setCharacterEncoding("euc-kr"); %>
<%
  String name = request.getParameter("name");
  Integer order = Integer.valueOf(request.getParameter("seq"));
  int id = Integer.valueOf(request.getParameter("id"));
  BookmarkGroupService bookmarkGroupService = new BookmarkGroupService();
  BookmarkGroup bookmarkGroup = new BookmarkGroup();
  bookmarkGroup.setBookmarkName(name);
  bookmarkGroup.setSeq(order);
  bookmarkGroup.setId(id);
  bookmarkGroupService.edit(bookmarkGroup);


%>
<script type="text/javascript">
  location.href="bookmarkgrouplist.jsp";
</script>
