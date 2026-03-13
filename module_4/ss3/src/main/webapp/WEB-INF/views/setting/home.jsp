<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Settings</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body{
            background:#f2f2f2;
        }

        .settings-box{
            width:600px;
            margin:50px auto;
            background:white;
            padding:30px;
            border-radius:6px;
            box-shadow:0 2px 8px rgba(0,0,0,0.1);
        }

        .toast-container{
            position:fixed;
            top:20px;
            right:20px;
            z-index:9999;
        }
    </style>
</head>

<body>

<div class="settings-box">

    <h2 class="mb-4">Settings</h2>

    <form:form action="/settings" method="post" modelAttribute="settings">

        <!-- Language -->
        <div class="mb-3 row">
            <label class="col-sm-4 col-form-label">Languages</label>
            <div class="col-sm-8">

                <form:select path="language" cssClass="form-select">
                    <form:options items="${languages}"/>
                </form:select>

            </div>
        </div>

        <!-- Page Size -->
        <div class="mb-3 row">
            <label class="col-sm-4 col-form-label">Page Size</label>

            <div class="col-sm-8 d-flex align-items-center">

                <span class="me-2">Show</span>

                <form:select path="pageSize" cssClass="form-select w-auto">
                    <form:options items="${pageSizes}"/>
                </form:select>

                <span class="ms-2">emails per page</span>

            </div>
        </div>

        <!-- Spam Filter -->
        <div class="mb-3 row">
            <label class="col-sm-4 col-form-label">Spams filter</label>

            <div class="col-sm-8 form-check mt-2">

                <form:checkbox path="spamFilter" cssClass="form-check-input"/>
                <label class="form-check-label ms-2">
                    Enable spams filter
                </label>

            </div>
        </div>

        <!-- Signature -->
        <div class="mb-3 row">
            <label class="col-sm-4 col-form-label">Signature</label>

            <div class="col-sm-8">
                <form:textarea path="signature" rows="4" cssClass="form-control"/>
            </div>
        </div>

        <div class="text-center mt-4">

            <button type="submit" class="btn btn-primary px-4">
                Update
            </button>

            <button type="reset" class="btn btn-secondary px-4">
                Cancel
            </button>

        </div>

    </form:form>

</div>

<!-- Toast -->
<c:if test="${not empty settings}">
    <div class="toast-container">

        <div id="successToast" class="toast align-items-center text-bg-success border-0" role="alert">

            <div class="d-flex">
                <div class="toast-body">
                    Update successful!
                </div>

                <button type="button"
                        class="btn-close btn-close-white me-2 m-auto"
                        data-bs-dismiss="toast"></button>
            </div>

        </div>

    </div>
</c:if>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<script>
    const toastElement = document.getElementById('successToast');
    if (toastElement) {
        const toast = new bootstrap.Toast(toastElement);
        toast.show();
    }
</script>

</body>
</html>