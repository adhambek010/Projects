<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
<div class="container">
    <div class="mt-3">
        <h2>Your Todos</h2>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Description</th>
                    <th>Target Date</th>
                    <th>Is Done</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${todos}" var="todo">
                    <tr>
                        <td>${todo.description}</td>
                        <td>${todo.targetDate}</td>
                        <td>${todo.done}</td>
                        <td>
                            <a href="update-todo?id=${todo.id}" class="btn btn-warning btn-sm">
                                <i class="bi bi-pencil-square"></i> Edit
                            </a>
                        </td>
                        <td>
                            <a href="delete-todo?id=${todo.id}" class="btn btn-danger btn-sm">
                                <i class="bi bi-trash"></i> Delete
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="add-todo" class="btn btn-success">Add todo</a>
    </div>
</div>