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

    <!-- TODO Add a header to the page -->

    <!-- TODO What if there are no people? -->

    <!-- TODO If there are people, create a table with a row for each person... -->

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
