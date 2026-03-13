<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Simple Calculator</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body style="background:#f5f6fa">

<div class="container mt-5">

    <div class="row justify-content-center">

        <div class="col-md-6">

            <div class="card shadow">

                <div class="card-header bg-primary text-white text-center">
                    <h3>Simple Calculator</h3>
                </div>

                <form:form action="/calculator" method="post" modelAttribute="calculatorForm"></form:form>
                <div class="card-body">

                    <form action="/calculator" method="post">

                        <div class="mb-3">
                            <label class="form-label">First Number</label>
                            <input type="number" step="any" name="num1" class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Second Number</label>
                            <input type="number" step="any" name="num2" class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Operator</label>
                            <select name="operator" class="form-select">
                                <option value="add">Addition (+)</option>
                                <option value="sub">Subtraction (-)</option>
                                <option value="mul">Multiplication (*)</option>
                                <option value="div">Division (/)</option>
                            </select>
                        </div>

                        <div class="d-grid">
                            <button class="btn btn-success">
                                Calculate
                            </button>
                        </div>

                    </form>

                    <hr>

                    <c:if test="${error != null}">
                        <div class="alert alert-danger text-center">
                                ${error}
                        </div>
                    </c:if>

                    <c:if test="${result != null}">
                        <h4 class="text-center text-success">
                            Result: ${result}
                        </h4>
                    </c:if>

                </div>

            </div>

        </div>

    </div>

</div>

</body>
</html>