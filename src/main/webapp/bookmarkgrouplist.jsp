<%@ page import="db.BookmarkGroupService" %>
<%@ page import="db.BookmarkGroup" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023-05-07
  Time: 오전 7:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=euc_kr" pageEncoding="euc_kr"%>

<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
<head>
    <title>와이파이 정보 구하기</title>
    <style>
        #customers {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #customers td, #customers th {
            border: 1px solid #ddd;
            padding: 2px;
        }

        #customers tr:nth-child(even){background-color: #f2f2f2;}

        #customers tr:hover {background-color: #ddd;}

        #customers th {
            padding-top: 8px;
            padding-bottom: 8px;
            background-color: #04AA6D;
            color: white;
            font-size: 12px;

        }
        th {
            text-align: center;
        }
        td {
            text-align: left;
            font-size: 12px;
        }
        form {
            font-size: 12px;
        }
        b{
            font-size: 12px;
        }

        /* visited link */
        a:visited {
            color: purple;
        }

        /* mouse over link */
        a:hover {
            color: hotpink;
        }

        /* selected link */
        a:active {
            color: blue;
        }
        input {
            width: 10%;
        }
        .button {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 12px;
            margin: 4px 2px;
            cursor: pointer;
        }
    </style>
</head>
<%
    BookmarkGroupService bookmarkGroupService = new BookmarkGroupService();
    List<BookmarkGroup> bookmarkGroupList = bookmarkGroupService.list();
%>
<body>
<h1>북마크 그룹</h1>
<b><a href="index.jsp">홈 |</a></b>
<b><a href="history.jsp"> 위치 히스토리 목록 |</a></b>
<b><a href="load-wifi.jsp"> Open API 와이파이 정보 가져오기 |</a></b>
<b><a href="bookmarklist.jsp"> 북마크 보기 |</a></b>
<b><a href="bookmarkgrouplist.jsp"> 북마크 그룹관리</a></b>
<p>
    <button type="button" onclick="location.href='bookmarkadd.jsp'">북마크 그룹 이름 추가</button>
</p>
<table id="customers">
    <thead>
        <tr>
            <th>ID</th>
            <th>북마크이름</th>
            <th>순서</th>
            <th>등록일자</th>
            <th>수정일자</th>
            <th>비고</th>
        </tr>
        </thead>
    <tbody>
        <%
            for(BookmarkGroup bookmarkGroup: bookmarkGroupList) {
        %>
        <tr>
            <td><%=bookmarkGroup.getId() %></td>
            <td><%=bookmarkGroup.getBookmarkName() %></td>
            <td><%=bookmarkGroup.getSeq() %></td>
            <td><%=bookmarkGroup.getRegisterDate() %></td>
            <td><%=bookmarkGroup.getEditDate() == null ? "" :  bookmarkGroup.getEditDate()%></td>
            <td>
                <a href="bookmarkedit.jsp?id=<%=bookmarkGroup.getId() %>">수정</a>
                <a href="bookmarkgroup_deletesubmit.jsp?id=<%=bookmarkGroup.getId() %>">삭제</a>
            </td>
        </tr>
        <% } %>
    </tbody>

</table>
</body>
</html>
