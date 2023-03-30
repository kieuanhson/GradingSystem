<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home page</title>
</head>
<body>
<c:choose>
    <c:when test="${sessionScope.account.role eq 'Teacher'}">
        <h2>Hello, teacher ${sessionScope.account.displayName}!</h2>
    </c:when>
    <c:when test="${sessionScope.account.role eq 'Student'}">
        <h2>Hello, student ${sessionScope.account.displayName}</h2>
    </c:when>
    <c:otherwise>
        <h2>Hello World!</h2>
    </c:otherwise>
</c:choose>
</body>
</html>
