<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<fmt:setLocale value="vi_VN"/>

<!DOCTYPE html>
<html>
<head>
    <title>Currency Converter</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body style="background:#f4f6f9;">

<div class="container mt-5">

    <div class="row justify-content-center">

        <div class="col-md-6">

            <div class="card shadow">

                <div class="card-header bg-primary text-white text-center">
                    <h3>USD → VND Converter</h3>
                </div>

                <div class="card-body">

                    <form action="/convert" method="post">

                        <div class="mb-3">
                            <label class="form-label">Amount (USD)</label>
                            <input type="number"
                                   step="0.01"
                                   name="usd"
                                   class="form-control"
                                   placeholder="Enter USD"
                                   required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Exchange Rate</label>
                            <input type="number"
                                   step="1"
                                   name="rate"
                                   class="form-control"
                                   value="25000">
                        </div>

                        <div class="d-grid">
                            <button type="submit" class="btn btn-success">
                                Convert to VND
                            </button>
                        </div>

                    </form>

                    <hr>

                    <h5 class="text-center text-success">
                        <fmt:formatNumber value="${result}" type="number"/> VND
                    </h5>

                </div>

            </div>

        </div>

    </div>

</div>

</body>
</html>