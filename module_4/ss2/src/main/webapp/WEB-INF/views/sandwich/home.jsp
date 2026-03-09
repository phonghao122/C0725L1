<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Sandwich Condiments</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body style="background:#f5f6fa">

<div class="container mt-5">

    <div class="row justify-content-center">

        <div class="col-md-6">

            <div class="card shadow">

                <div class="card-header bg-success text-white text-center">
                    <h3>Sandwich Condiments</h3>
                </div>

                <div class="card-body">

                    <form action="/sandwich" method="post">

                        <label class="form-label fw-bold">Select condiments:</label>

                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" name="condiment" value="Lettuce">
                            <label class="form-check-label">Lettuce</label>
                        </div>

                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" name="condiment" value="Tomato">
                            <label class="form-check-label">Tomato</label>
                        </div>

                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" name="condiment" value="Mustard">
                            <label class="form-check-label">Mustard</label>
                        </div>

                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" name="condiment" value="Sprouts">
                            <label class="form-check-label">Sprouts</label>
                        </div>

                        <div class="mt-3 d-grid">
                            <button type="submit" class="btn btn-primary">
                                Save
                            </button>
                        </div>

                    </form>

                    <hr>

                    <h5 class="text-center text-success">
                        Selected Condiments
                    </h5>

                    <ul class="list-group">

                        <c:forEach var="c" items="${condiments}">
                            <li class="list-group-item">${c}</li>
                        </c:forEach>

                    </ul>

                </div>

            </div>

        </div>

    </div>

</div>

</body>
</html>