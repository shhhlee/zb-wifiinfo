<%@ page import="db.WifiDbService" %>
<%@ page import="db.HistoryService" %>
<%@ page import="java.util.List" %>
<%@ page import="db.Wifi" %>
<%@ page import="db.History" %>
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
<h1>와이파이 정보 구하기</h1>
<b><a href="index.jsp">홈 |</a></b>
<b><a href="history.jsp"> 위치 히스토리 목록 |</a></b>
<b><a href="load-wifi.jsp"> Open API 와이파이 정보 가져오기 |</a></b>
<b><a href="bookmarklist.jsp"> 북마크 보기 |</a></b>
<b><a href="bookmarkgrouplist.jsp"> 북마크 그룹관리</a></b>
<p>
<form method="get" action="./">
    <label for="lat">LAT:
        <input type="text" id="lat" name="lat" value='0.0'>
    </label>

    <label for="lnt">LNT:
        <input type="text" id="lnt" name="lnt" value='0.0'>
    </label>

    <button type="button" id="getLocationButton" onclick="navigator.geolocation
            .getCurrentPosition(getLocation, showLocationError);">내 위치 가져오기</button>
    <button type="submit" id="getWifiButton" value="">근처 WIFI 정보 가져오기</button>
</form>
</p>
<%
    String lat = request.getParameter("lat");
    String lnt = request.getParameter("lnt");
%>
<script>
    let lat = 0;
    let lnt = 0;

    function getLocation(position) {
        lat = position.coords.latitude;
        lnt = position.coords.longitude;

        document.getElementById("lat").value = lat;
        document.getElementById("lnt").value = lnt;
    }

    function showLocationError() {
        if (!navigator.geolocation) {
            throw "위치 정보가 지원되지 않습니다.";
        }
    }
</script>

<table id="customers">
    <thead>
    <tr>
        <th>거리(Km)</th>
        <th>관리번호</th>
        <th>자치구</th>
        <th>와이파이명</th>
        <th>도로명주소</th>
        <th>상세주소</th>
        <th>설치위치(층)</th>
        <th>설치유형</th>
        <th>설치기관</th>
        <th>서비스구분</th>
        <th>망종류</th>
        <th>설치년도</th>
        <th>실내외구분</th>
        <th>WIFI접속환경</th>
        <th>X좌표</th>
        <th>Y좌표</th>
        <th>작업일자</th>
    </tr>
    </thead>
    <tbody>
    <%
        if (lat == null && lnt == null) {
    %>
    <tr>
        <td colspan="17" style = "text-align: center;"> 위치 정보를 입력해주세요.</td>
    </tr>
    <%
    } else {
        History historyWifi = new History();
        historyWifi.setLnt(lnt);
        historyWifi.setLat(lat);

        HistoryService historyService = new HistoryService();
        historyService.historyInsert(historyWifi);

        WifiDbService wifiDbService = new WifiDbService();
        List<Wifi> wifiList = wifiDbService.listNear(lat, lnt);

        for (Wifi wifi : wifiList) {
    %>
    <tr>
        <td><%=wifi.getDist()%></td>
        <td><%=wifi.getX_SWIFI_MGR_NO()%></td>
        <td><%=wifi.getX_SWIFI_WRDOFC()%></td>
        <td>
            <a href = "detail.jsp?X_SWIFI_MGR_NO()=<%=wifi.getX_SWIFI_MGR_NO()%>">
                <%=wifi.getX_SWIFI_MAIN_NM()%>
            </a>
        </td>
        <td><%=wifi.getX_SWIFI_ADRES1()%></td>
        <td><%=wifi.getX_SWIFI_ADRES2()%></td>
        <td><%=wifi.getX_SWIFI_INSTL_FLOOR()%></td>
        <td><%=wifi.getX_SWIFI_INSTL_TY()%></td>
        <td><%=wifi.getX_SWIFI_INSTL_MBY()%></td>
        <td><%=wifi.getX_SWIFI_SVC_SE()%></td>
        <td><%=wifi.getX_SWIFI_CMCWR()%></td>
        <td><%=wifi.getX_SWIFI_CNSTC_YEAR()%></td>
        <td><%=wifi.getX_SWIFI_INOUT_DOOR()%></td>
        <td><%=wifi.getX_SWIFI_REMARS3()%></td>
        <td><%=wifi.getLAT()%></td>
        <td><%=wifi.getLNT()%></td>
        <td><%=wifi.getWORK_DTTM()%></td>
    </tr>
    <%
            }
        }
    %>
    </tbody>


</table>

</body>
</html>


