<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng ký tài khoản</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f9;
        }

        .container {
            width: 400px;
            margin: 50px auto;
            padding: 25px;
            background: white;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        input {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
        }

        .error {
            color: red;
            font-size: 13px;
            height: 16px;
            display: block;
            margin-top: 3px;
        }

        button {
            width: 100%;
            padding: 10px;
            margin-top: 15px;
            background: #007bff;
            color: white;
            border: none;
            cursor: pointer;
        }

        button:hover {
            background: #0056b3;
        }
    </style>

    <script>
        function setError(id, message) {
            document.getElementById(id).innerText = message;
        }

        function clearErrors() {
            setError("usernameError", "");
            setError("emailError", "");
            setError("passwordError", "");
            setError("confirmError", "");
        }

        function validateUsername() {
            let username = document.getElementById("username").value.trim();
            if (username.length < 4) {
                setError("usernameError", "Username phải ít nhất 4 ký tự");
                return false;
            }
            setError("usernameError", "");
            return true;
        }

        function validateEmail() {
            let email = document.getElementById("email").value.trim();
            let pattern = /^[^ ]+@[^ ]+\.[a-z]{2,}$/;
            if (!pattern.test(email)) {
                setError("emailError", "Email không hợp lệ");
                return false;
            }
            setError("emailError", "");
            return true;
        }

        function validatePassword() {
            let password = document.getElementById("password").value.trim();
            if (password.length < 6) {
                setError("passwordError", "Password phải ít nhất 6 ký tự");
                return false;
            }
            setError("passwordError", "");
            return true;
        }

        function validateConfirm() {
            let password = document.getElementById("password").value.trim();
            let confirm = document.getElementById("confirmPassword").value.trim();

            if (confirm !== password) {
                setError("confirmError", "Mật khẩu xác nhận không khớp");
                return false;
            }
            setError("confirmError", "");
            return true;
        }

        function validateForm() {
            clearErrors();

            let isValid = true;

            if (!validateUsername()) isValid = false;
            if (!validateEmail()) isValid = false;
            if (!validatePassword()) isValid = false;
            if (!validateConfirm()) isValid = false;

            return isValid;
        }
    </script>
</head>
<body>

<div class="container">
    <h2>Đăng ký tài khoản</h2>

    <form action="RegisterServlet" method="post" onsubmit="return validateForm()">

        <label>Username</label>
        <input type="text" id="username" name="username" onblur="validateUsername()">
        <span id="usernameError" class="error"></span>

        <label>Email</label>
        <input type="text" id="email" name="email" onblur="validateEmail()">
        <span id="emailError" class="error"></span>

        <label>Password</label>
        <input type="password" id="password" name="password" onblur="validatePassword()">
        <span id="passwordError" class="error"></span>

        <label>Confirm Password</label>
        <input type="password" id="confirmPassword" name="confirmPassword" onblur="validateConfirm()">
        <span id="confirmError" class="error"></span>

        <button type="submit">Đăng ký</button>

    </form>

    <!-- Hiển thị lỗi từ Servlet nếu có -->
    <%
        String error = (String) request.getAttribute("error");
        if (error != null) {
    %>
    <p style="color:red;"><%= error %></p>
    <%
        }
    %>

</div>

</body>
</html>