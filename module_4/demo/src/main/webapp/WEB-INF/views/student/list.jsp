<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Student Management</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" rel="stylesheet">

</head>
<body style="background:#f4f6f9;">

<div class="container mt-5">

    <!-- Header -->
    <div class="text-center mb-4">
        <h1 class="fw-bold text-primary">Student Management System</h1>
        <p class="text-muted">Manage students easily</p>
        <h5 class="text-success">${mess}</h5>
    </div>

    <!-- Card -->
    <div class="card shadow">

        <div class="card-header d-flex justify-content-between align-items-center bg-dark text-white">
            <h4 class="mb-0"><i class="bi bi-people-fill"></i> Student List</h4>

            <a href="/student/add" class="btn btn-success">
                <i class="bi bi-person-plus"></i> Add Student
            </a>
        </div>

        <div class="card-body">

            <table class="table table-hover align-middle text-center">

                <thead class="table-secondary">
                <tr>
                    <th style="width:20%">ID</th>
                    <th style="width:40%">Name</th>
                    <th style="width:40%">Action</th>
                </tr>
                </thead>

                <tbody>

                <c:forEach var="s" items="${students}">
                    <tr>
                        <td>
                            <span class="badge bg-primary fs-6">${s.id}</span>
                        </td>

                        <td class="fw-semibold">
                                ${s.name}
                        </td>

                        <td>

                            <a href="/student/detail/${s.id}" class="btn btn-warning btn-sm">
                                <i class="bi bi-eye"></i> Detail
                            </a>

                            <form action="/student/delete/${s.id}" method="post" style="display:inline;">
                                <button type="submit"
                                        class="btn btn-danger btn-sm"
                                        onclick="return confirm('Are you sure to delete this student?')">
                                    <i class="bi bi-trash"></i> Delete
                                </button>

                            </form>

                        </td>
                    </tr>
                </c:forEach>

                </tbody>

            </table>

        </div>

    </div>

</div>

</body>
</html>