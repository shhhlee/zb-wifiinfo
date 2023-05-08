<%@ page import="db.WifiDbService" %>
<%@ page import="java.util.List" %>
<%@ page import="db.Wifi" %>
<%@ page import="db.BookmarkGroupService" %>
<%@ page import="db.BookmarkGroup" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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

<body>
<%
    String X_SWIFI_MGR_NO = request.getParameter("X_SWIFI_MGR_NO()");
    WifiDbService wifiService = new WifiDbService();
    Wifi wifi = wifiService.detail(X_SWIFI_MGR_NO);
    BookmarkGroupService bookmarkGroupService = new BookmarkGroupService();
    List<BookmarkGroup> bookmarkGroupList = bookmarkGroupService.list();
%>
<h1>와이파이 정보 구하기</h1>
<b><a href="index.jsp">홈 |</a></b>
<b><a href="default.asp"> 위치 히스토리 목록 |</a></b>
<b><a href="load-wifi.jsp"> Open API 와이파이 정보 가져오기</a></b>
<b><a href="bookmarklist.jsp"> 북마크 보기 |</a></b>
<b><a href="bookmarkgrouplist.jsp"> 북마크 그룹관리</a></b>
<p>
<form action="bookmark_addsubmit.jsp" method="post">
    <select name="bookmark-group" id="bookmark-group">
        <option value="default">북마크 그룹 이름 선택</option>
        <%for(BookmarkGroup bookmarkGroup: bookmarkGroupList) {%>
        <option value="<%=bookmarkGroup.getId()%>"><%=bookmarkGroup.getBookmarkName() %></option>
        <%} %>
    </select>
    <input type="hidden" name="wifiNo" value="<%=wifi.getX_SWIFI_MGR_NO()%>">
    <input type="submit" value="북마크 추가하기">
</form>
</p>
<table id="customers">
    <colgroup>
        <col style="width: 20%;"/>
        <col style="width: 80%;"/>
    </colgroup>
    <tbody>
        <tr>
            <th>거리(Km)</th>
            <td>
                0.0000
            </td>
        </tr>
        <tr>
            <th>관리번호</th>
            <td>
                <%=wifi.getX_SWIFI_MGR_NO()%>
            </td>
        </tr>
            <th>자치구</th>
            <td>
                <%=wifi.getX_SWIFI_WRDOFC()%>
            </td>
        </tr>
        <tr>
            <th>와이파이명</th>
            <td>
                <%=wifi.getX_SWIFI_MAIN_NM()%>
            </td>
        </tr>
        <tr>
            <th>도로명주소</th>
            <td>
                <%=wifi.getX_SWIFI_ADRES1()%>
            </td>
        </tr>
        <tr>
            <th>상세주소</th>
            <td>
                <%=wifi.getX_SWIFI_ADRES2()%>
            </td>
        </tr>
        <tr>
            <th>설치위치(층)</th>
            <td>
                <%=wifi.getX_SWIFI_INSTL_FLOOR()%>
            </td>
        </tr>
        <tr>
            <th>설치유형</th>
            <td>
                <%=wifi.getX_SWIFI_INSTL_TY()%>
            </td>
        </tr>
        <tr>
            <th>설치기관</th>
            <td>
                <%=wifi.getX_SWIFI_INSTL_MBY()%>
            </td>
        </tr>
        <tr>
            <th>서비스구분</th>
            <td>
                <%=wifi.getX_SWIFI_SVC_SE()%>
            </td>
        </tr>
        <tr>
            <th>망종류</th>
            <td>
                <%=wifi.getX_SWIFI_CMCWR()%>
            </td>
        </tr>
        <tr>
            <th>설치년도</th>
            <td>
                <%=wifi.getX_SWIFI_CNSTC_YEAR()%>
            </td>
        </tr>
        <tr>
            <th>실내외구분</th>
            <td>
                <%=wifi.getX_SWIFI_INOUT_DOOR()%>
            </td>
        </tr>
        <tr>
            <th>WIFI접속환경</th>
            <td>
                <%=wifi.getX_SWIFI_REMARS3()%>
            </td>
        </tr>
        <tr>
            <th>X좌표</th>
            <td>
                <%=wifi.getLAT()%>
            </td>
        </tr>
        <tr>
            <th>Y좌표</th>
            <td>
                <%=wifi.getLNT()%>
            </td>
        </tr>
        <tr>
            <th>작업일자</th>
            <td>
                <%=wifi.getWORK_DTTM()%>
            </td>
        </tr>
    </tbody>


</table>

</body>
</html>