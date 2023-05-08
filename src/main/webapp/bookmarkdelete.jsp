<%@ page import="db.BookmarkWifi" %>
<%@ page import="db.BookmarkWifiService" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023-05-07
  Time: 오전 8:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    int id = Integer.valueOf(request.getParameter("id"));
    BookmarkWifiService bookmarkGroupService = new BookmarkWifiService();
    BookmarkWifi bookmark = bookmarkGroupService.getBookmark(id);

%>
<body>
<h1>북마크 삭제</h1>
<b><a href="index.jsp">홈 |</a></b>
<b><a href="history.jsp"> 위치 히스토리 목록 |</a></b>
<b><a href="load-wifi.jsp"> Open API 와이파이 정보 가져오기 |</a></b>
<b><a href="bookmarklist.jsp"> 북마크 보기 |</a></b>
<b><a href="bookmarkgrouplist.jsp"> 북마크 그룹관리</a></b><p>
<p>
    <b>북마크를 삭제하시겠습니까?</b>
</p>
<form action="bookmark_deletesubmit.jsp" method="post">
    <table id="customers">
        <colgroup>
            <col style="width: 20%" />
            <col />
        </colgroup>
        <tbody>
            <tr>
                <th scope="row">북마크 이름</th>
                <td>
                    <%=bookmark.getBookmarkName()%>
                </td>
            </tr>
            <tr>
                <th scope="row">와이파이 명</th>
                <td>
                    <%=bookmark.getWifiName()%>
                </td>
            </tr>
            <tr>
                <th scope="row">등록일자</th>
                <td>
                    <%=bookmark.getRegisterDate()%>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center">
                    <a href="bookmarklist.jsp">돌아가기</a> |
                    <input type="submit" value="삭제">
                    <input type="hidden" name="bookmark-id" value="<%=bookmark.getId()%>"/>
                </td>
            </tr>
        </tbody>
    </table>
</form>
</body>
</html>
