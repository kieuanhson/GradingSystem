<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet"/>
    <script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="mx-auto col-6 col-md-8 col-lg-6">
            <h1 class="d-flex justify-content-center">Login to system</h1>
            <form:form modelAttribute="login" method="post" action="login">
                <div class="mb-3">
                    <form:label path="username" class="form-label">Username: </form:label>
                    <form:input path="username" class="form-control"/>
                </div>
                <div class="mb-3">
                    <form:label path="password" class="form-label">Password: </form:label>
                    <form:password path="password" class="form-control"/>
                </div>
                <div class="mb-3 align-content-center">
                    <button class="btn btn-primary" type="submit">Login</button>
                </div>
                <c:if test="${error ne null}">
                    <div class="error">
                            ${error}
                    </div>
                </c:if>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
