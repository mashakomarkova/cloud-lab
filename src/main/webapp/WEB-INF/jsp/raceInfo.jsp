<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <link rel="stylesheet" href="style.css"/>
</head>
<body>

<style>
    table {
        font-family: arial, sans-serif;
        border-collapse: collapse;
        width: 100%;
    }

    td, th {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 8px;
    }

    tr:nth-child(even) {
        background-color: #dddddd;
    }

    ul {
        list-style-type: none;
        margin: 0;
        padding: 0;
        overflow: hidden;
        background-color: #333;
    }

    li {
        float: left;
    }

    li a {
        display: block;
        color: white;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
    }

    li a:hover {
        background-color: #111;
    }
</style>

<ul>
    <li><a class="active" href="/">Racers</a></li>
    <li><a href="/racer/info">Racer info</a></li>
    <li><a href="/endpoint/info">Endpoint info</a></li>
    <li><a href="/racer/info2">Racer delay info</a></li>
    <li><a href="/endpoint/info2">Endpoint statistic</a></li>
</ul>

<table>
    <tr>
        <th>Racer</th>
        <th>Delay</th>
    </tr>
    <c:forEach var="info" items="${info}">
        <tr>
            <td>${info.racer.name}</td>
            <td>${info.delay}</td>
        </tr>
    </c:forEach>

</table>


</body>

</html>