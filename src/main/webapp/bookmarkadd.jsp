<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023-05-07
  Time: ���� 8:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=euc_kr" pageEncoding="euc_kr"%>

<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
<head>
    <title>�������� ���� ���ϱ�</title>
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
<h1>�ϸ�ũ �׷� �߰�</h1>
<b><a href="index.jsp">Ȩ |</a></b>
<b><a href="history.jsp"> ��ġ �����丮 ��� |</a></b>
<b><a href="load-wifi.jsp"> Open API �������� ���� �������� |</a></b>
<b><a href="bookmarklist.jsp"> �ϸ�ũ ���� |</a></b>
<b><a href="bookmarkgrouplist.jsp"> �ϸ�ũ �׷����</a></b><p>
<form action="bookmarkgroup_addsubmit.jsp" method="post">
    <table id="customers">
        <colgroup>
            <col style="width: 20%;"/>
            <col style="width: 80%;"/>
        </colgroup>
        <tr>
            <th>�ϸ�ũ �̸�</th>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <th>����</th>
            <td><input type="text" name="seq"></td>

        </tr>
        <tr>
            <td colspan="2" style="text-align: center"><input type="submit" value="�߰�"></td>
        </tr>
    </table>
</form>
</body>
</html>
