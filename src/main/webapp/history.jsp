<%@ page import="java.util.List" %>
<%@ page import="db.HistoryService" %>
<%@ page import="db.History" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %><!DOCTYPE html>
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
        #btnSubmit{
            margin:auto;
            display:block;
        }
    </style>
</head>
<body>
<h1>위치 히스토리 목록</h1>
<b><a href="index.jsp">홈 |</a></b>
<b><a href="history.jsp"> 위치 히스토리 목록 |</a></b>
<b><a href="load-wifi.jsp"> Open API 와이파이 정보 가져오기 |</a></b>
<b><a href="bookmarklist.jsp"> 북마크 보기 |</a></b>
<b><a href="bookmarkgrouplist.jsp"> 북마크 그룹관리</a></b>
<p>

<table id="customers">
    <thead>
    <tr>
        <th>ID</th>
        <th>X좌표</th>
        <th>Y좌표</th>
        <th>조회일자</th>
        <th>비고</th>
    </tr>
    </thead>
    <tbody>
    <%
        HistoryService historyService = new HistoryService();
        List<History> historyWifiList = historyService.historyWifiList();

        for(History historyWifi: historyWifiList) {
    %>
    <tr>
        <td><%=historyWifi.getId()%></td>
        <td><%=historyWifi.getLat()%></td>
        <td><%=historyWifi.getLnt()%></td>
        <td><%=historyWifi.getSearchDate()%></td>
        <td>
            <button type=submit id="btnSubmit" onclick="location.href='historydelete.jsp?id=<%=historyWifi.getId()%>'">
                삭제</button>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

</body>
</html>
