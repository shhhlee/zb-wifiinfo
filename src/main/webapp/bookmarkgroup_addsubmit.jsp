<%@ page import="db.BookmarkGroup" %>
<%@ page import="db.BookmarkGroupService" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023-05-08
  Time: ���� 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=euc_kr" pageEncoding="euc_kr"%>

<% request.setCharacterEncoding("euc-kr"); %>
<%
  // parameter ó��(�ϸ�ũ �׷� �̸�, ����)
  String bookmarkGroupName = request.getParameter("name");
  Integer bookmarkGroupSeq = Integer.valueOf(request.getParameter("seq"));
  BookmarkGroup bookmarkGroup = new BookmarkGroup();
  bookmarkGroup.setBookmarkName(bookmarkGroupName);
  bookmarkGroup.setSeq(bookmarkGroupSeq);

  BookmarkGroupService bookmarkGroupService = new BookmarkGroupService();
  bookmarkGroupService.bookmarkGroupInsert(bookmarkGroup);

%>
<script type="text/javascript">
  location.href = "bookmarkgrouplist.jsp";
</script>

