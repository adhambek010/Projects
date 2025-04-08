<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="\webjars\bootstrap\5.3.3\css\bootstrap.min.css" rel="stylesheet">
    <meta charset="UTF-8">
    <title>List Todos</title>
</head>
<body>
    <div class="container">
        <div class="mt-3">
            <h2>Your Todos</h2>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
        <%--                <th>Name</th>--%>
                        <th>Description</th>
                        <th>Target Date</th>
                        <th>Is Done</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${todos}" var="todo">
                        <tr>
                            <td>${todo.id}</td>
        <%--                    <td>${todo.username}</td>--%>
                            <td>${todo.description}</td>
                            <td>${todo.targetDate}</td>
                            <td>${todo.done}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="add-todo" class="btn btn-success">Add todo</a>
            <script src="\webjars\jquery\js\dist\jquery.min.js"></script>
            <script src="\webjars\jquery\4.0.0-beta\src\jquery.js"></script>
        </div>
    </div>
</body>
</html>
<%--\webjars\bootstrap\5.3.3\css\bootstrap.min.css--%>

<%--\META-INF\resources\webjars\bootstrap\5.3.3\js\bootstrap.min.js--%>

<%--\META-INF\resources\webjars\jquery\4.0.0-beta\src\jquery.js--%>
