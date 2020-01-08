<%--
  Created by IntelliJ IDEA.
  User: computer
  Date: 12/2/2019
  Time: 7:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Personal Data</title>
  </head>
  <body>
  <form name="personalDataForm" action="" method="POST">
    <table>
      <tr>
        <td>Your CNP :</td>
        <td><input type="text" name="cnp"/></td>
        <td> Country :</td>
        <td><input type="text" name="country"/></td>
        <td>Region :</td>
        <td><input type="text" name="region"/></td>
      </tr>
      <th><input type="submit" value="Submit" name="find"/></th>
    </table>
  </form>
  <h2>${person}</h2>
  <h2>${cities}</h2>
  </body>
</html>
