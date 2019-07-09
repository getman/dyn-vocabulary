<%--
  Created by IntelliJ IDEA.
  User: getman-lahudra
  Date: 06.02.2019
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
</head>
<body>
    Problem words:
    <c:if test="${not empty mainPageModel.problemWords}">

        <ul>
            <c:forEach var="listValue" items="${mainPageModel.problemWords}">
                <li>${listValue}</li>
            </c:forEach>
        </ul>



    General words:
    </c:if><c:if test="${not empty mainPageModel.generalWords}">

        <ul>
            <c:forEach var="listValue" items="${mainPageModel.generalWords}">
                <li>${listValue}</li>
            </c:forEach>
        </ul>

    </c:if>

    <form method="POST" action="mainPage">
        <p>
            Word: <input type="text" name="word"> <br>
            Translation: <input type="text" name="translate"> <br>
            Transcription: <input type="text" name="transcription"> <br>
            <input type="submit" value="singleton"/>
        </p>
    </form>

</body>
</html>
