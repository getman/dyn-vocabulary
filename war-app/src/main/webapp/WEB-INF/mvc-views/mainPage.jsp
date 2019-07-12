<%--
  Created by IntelliJ IDEA.
  User: getman-lahudra
  Date: 06.02.2019
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%--<%@ page import="ru.aparfenov.vocabulary.model.dto.WordDto" %>--%>
<html>

<head>
    <title>Main page</title>
</head>
<body>
    Problem words:
    <c:if test="${not empty mainPageModel.problemWords}">

        <ul>
            <table border="1">
                <c:forEach var="listValue" items="${mainPageModel.problemWords}">
                    <tr><td>${listValue.wordEn} - ${listValue.translationsRu}</td></tr>
                </c:forEach>
            </table>
        </ul>

    General words:
    </c:if><c:if test="${not empty mainPageModel.generalWords}">

        <ul>
            <table border="1">
                <c:forEach var="listValue" items="${mainPageModel.generalWords}">
                    <tr><td>${listValue}</td></tr>
                </c:forEach>
            </table>
        </ul>

    </c:if>

    Add new
    <form:form method="POST"
               action="add-word" modelAttribute="new-word">
        <table>
            <tr>
                <td><form:label path="en">En</form:label></td>
                <td><form:input path="en"/></td>
            </tr>
            <tr>
                <td><form:label path="ru">Tr</form:label></td>
                <td><form:input path="ru"/></td>
            </tr>
            <tr>
                <td><form:label path="transcr">
                    Word transcription</form:label></td>
                <td><form:input path="transcr"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"/></td>
            </tr>
        </table>
    </form:form>

</body>
</html>
