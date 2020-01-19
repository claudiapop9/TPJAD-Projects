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
        <td>Your First Name :</td>
        <td><input type="text" name="weight"/></td>
      </tr>
      <tr>
        <td>Your Last Name :</td>
        <td><input type="text" name="height"/></td>
      </tr>
      <th><input type="submit" value="Submit" name="find"/></th>
    </table>
  </form>
  <h2>${fullName}</h2>
  </body>
</html>
