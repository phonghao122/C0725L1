<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>English - Vietnamese Dictionary</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body style="background:#f4f6f9">

<div class="container mt-5">

    <div class="row justify-content-center">

        <div class="col-md-6">

            <div class="card shadow">

                <div class="card-header bg-primary text-white text-center">
                    <h3>English → Vietnamese Dictionary</h3>
                </div>

                <div class="card-body">

                    <form action="/dictionary" method="post">

                        <div class="mb-3">
                            <label class="form-label">Enter English word</label>

                            <input type="text"
                                   name="word"
                                   class="form-control"
                                   placeholder="Example: hello"
                                   required>
                        </div>

                        <div class="d-grid">
                            <button class="btn btn-success">
                                Translate
                            </button>
                        </div>

                    </form>

                    <hr>

                    <h4 class="text-center text-success">
                        ${word} = ${result}
                    </h4>

                </div>

            </div>

        </div>

    </div>

</div>

</body>
</html>