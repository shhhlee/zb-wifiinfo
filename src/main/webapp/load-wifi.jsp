<%@ page import="db.WifiDbMain" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023-05-05
  Time: 오전 5:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>와이파이 정보 구하기</title>
    <style>
      p {
        font-family: Arial, Helvetica, sans-serif;
        font-weight: 900;
        text-align: center;
        font-size: 30px;
      }
      .center {
          text-align: center;
          font-size: 14px;
      }
    </style>
</head>
<body>
<%
    WifiDbMain wifiDbMain = new WifiDbMain();
    wifiDbMain.wifiDataInsert();
%>
  <p>WIFI 정보를 정상적으로 저장하였습니다.</p>
  <div class="center">
    <a href="index.jsp">홈 으로 가기</a>
  </div>
</body>
</html>
