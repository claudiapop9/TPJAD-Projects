<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <%--<script type="text/javascript" src="js/client-home.js"></script>--%>

    <%--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">--%>
    <link type="text/css" rel="stylesheet" href="css/client-home.css">

    <title>Management System :: Home</title>
</head>
<style>
    table {
        border-collapse: collapse;
        width: 100%;
    }

    tr:nth-child(even){background-color: #f2f2f2}

    th {
        background-color: #688daf;
        color: white;
        border-collapse: collapse;
    }
    th, td {
        padding: 8px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    tr:hover {background-color: #b8c4f5;}

    div {
        border-radius: 5px;
        background-color: #f2f2f2;
        padding: 20px;
    }
</style>
<body>
<div>
<form name="personalDataForm" action="" method="POST">
    <table>
        <tr>
            <td>Your CNP :</td>
            <td><input type="text" name="cnp"/></td>
            <td> Country :</td>
            <td><input type="text" name="country"/></td>
            <td>City Name :</td>
            <td><input type="text" name="cityName"/></td>
        </tr>
        <th><input type="submit" value="Submit" name="find"/></th>
    </table>
</form>
</div>
<table id="persons-table">
    <tr>
        <th>CNP</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>City Name</th>
    </tr>
    <c:forEach items="${persons}" var="person">
        <tr>
            <td>${person.cnp}</td>
            <td>${person.firstName}</td>
            <td>${person.lastName}</td>
            <td>${person.city}</td>
        </tr>
    </c:forEach>
</table>
<br>
<table>
    <tr>
        <th>Name</th>
        <th>Region</th>
        <th>Country</th>
    </tr>
    <c:forEach items="${cities}" var="city">
        <tr>
            <td>${city.name}</td>
            <td>${city.region}</td>
            <td>${city.country}</td>
        </tr>
    </c:forEach>
</table>

<%--<h2>${persons}</h2>--%>
<%--<h2>${cities}</h2>--%>

</body>
</html>

<%--<div class="modal fade" id="flightModal" tabindex="-1" role="dialog" aria-labelledby="flightModalLabel"--%>
<%--aria-hidden="true">--%>
<%--<div class="modal-dialog" role="document">--%>
<%--<div class="modal-content">--%>
<%--<div class="modal-header">--%>
<%--<h5 class="modal-title" id="flightModalLabel"></h5>--%>
<%--<button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--<span aria-hidden="true">&times;</span>--%>
<%--</button>--%>
<%--</div>--%>
<%--<div class="modal-body">--%>
<%--<h6>Departure</h6>--%>
<%--<span id="flightModalDepartureLocation"></span>--%>
<%--<br/>--%>
<%--<span id="flightModalDepartureTime"></span>--%>
<%--<h6>Arrival</h6>--%>
<%--<span id="flightModalArrivalLocation"></span>--%>
<%--<br/>--%>
<%--<span id="flightModalArrivalTime"></span>--%>
<%--<br/>--%>
<%--<h6>Duration</h6>--%>
<%--<span id="flightModalDuration"></span>--%>
<%--</div>--%>
<%--<div class="modal-footer">--%>
<%--<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>

