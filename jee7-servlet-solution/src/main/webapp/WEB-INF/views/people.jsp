<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>People</title>
    <script type="text/javascript" src="resources/jquery-2.2.1/jquery.js"></script>
    <script type="text/javascript" src="resources/bootstrap-3.3.6/js/bootstrap.js"></script>
    <link type="text/css" rel="stylesheet" href="resources/bootstrap-3.3.6/css/bootstrap-jsf.css"/>
</head>
<body>
<div class="container">

    <h1>List of People</h1>

    <c:if test="${empty people}">
        <p>There are no people yet...</p>
    </c:if>
    <c:if test="${not empty people}">
        <table class="table table-striped">
            <tr>
                <th>Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Address</th>
            </tr>
            <c:forEach items="${people}" var="person">
                <tr>
                    <td>${person.id}</td>
                    <td>${person.firstName}</td>
                    <td>${person.lastName}</td>
                    <td>${person.address}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
<script>
    var $pageContent = $('body > div.container');
    $pageContent.hide();
    $(function () {
        $pageContent.fadeIn();
    });
</script>
</body>
</html>
