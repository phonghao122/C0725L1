<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        .container {
            width: 1000px;
            margin: 40px auto;
        }

        h2 {
            text-align: center;
        }

        .search-box {
            margin-bottom: 15px;
            display: flex;
            gap: 10px;
        }

        input {
            padding: 6px;
            width: 200px;
        }

        button {
            padding: 6px 12px;
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background-color: white;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: center;
        }

        th {
            background-color: #007bff;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        .price {
            color: red;
            font-weight: bold;
        }

        img {
            width: 80px;
            height: 60px;
            object-fit: cover;
        }

        <style>
         .sl-toast {
             position: fixed;
             top: 20px;
             right: 20px;
             background-color: #28a745;
             color: white;
             padding: 12px 20px;
             border-radius: 6px;
             display: flex;
             align-items: center;
             gap: 10px;
             box-shadow: 0 4px 10px rgba(0,0,0,0.2);
             opacity: 0;
             transform: translateX(100%);
             transition: all 0.4s ease;
             z-index: 9999;
         }

        .sl-toast.show {
            opacity: 1;
            transform: translateX(0);
        }

        .toast-dot {
            width: 10px;
            height: 10px;
            background-color: white;
            border-radius: 50%;
        }
    </style>
    </style>

    <script>
        function searchProduct() {

            let nameFilter = document.getElementById("searchName").value.toLowerCase().trim();
            let minPrice = document.getElementById("minPrice").value;
            let maxPrice = document.getElementById("maxPrice").value;

            let table = document.getElementById("productTable");
            let rows = table.getElementsByTagName("tr");

            for (let i = 1; i < rows.length; i++) {

                let cols = rows[i].getElementsByTagName("td");
                if (cols.length === 0) continue;

                let name = cols[1].innerText.toLowerCase().trim();

                // Lấy giá và loại bỏ dấu , hoặc .
                let priceText = cols[2].innerText.replace(/[^0-9]/g, "");
                let price = parseFloat(priceText);

                let matchName = name.includes(nameFilter);

                let matchMin = (minPrice === "" || price >= parseFloat(minPrice));
                let matchMax = (maxPrice === "" || price <= parseFloat(maxPrice));

                if (matchName && matchMin && matchMax) {
                    rows[i].style.display = "";
                } else {
                    rows[i].style.display = "none";
                }
            }
        }

        function confirmDelete(productId) {
            return confirm("Bạn có chắc chắn muốn xóa sản phẩm ID = " + productId + " không?");
        }

        function openModal() {
            document.getElementById("productModal").style.display = "block";
        }

        function closeModal() {
            document.getElementById("productModal").style.display = "none";
        }

        function validateForm() {

            let isValid = true;

            let name = document.getElementById("name").value.trim();
            let price = document.getElementById("price").value;
            let quantity = document.getElementById("quantity").value;
            let color = document.getElementById("color").value;
            let category = document.getElementById("category").value;

            // Reset lỗi
            document.getElementById("nameError").innerText = "";
            document.getElementById("priceError").innerText = "";
            document.getElementById("quantityError").innerText = "";
            document.getElementById("colorError").innerText = "";
            document.getElementById("categoryError").innerText = "";

            if (name === "") {
                document.getElementById("nameError").innerText = "Tên sản phẩm không được để trống";
                isValid = false;
            }

            if (price === "" || parseFloat(price) <= 10000000) {
                document.getElementById("priceError").innerText = "Giá phải lớn hơn 10.000.000";
                isValid = false;
            }

            if (quantity === "" || parseInt(quantity) <= 0 || !Number.isInteger(parseFloat(quantity))) {
                document.getElementById("quantityError").innerText = "Số lượng phải là số nguyên dương";
                isValid = false;
            }

            if (color === "") {
                document.getElementById("colorError").innerText = "Vui lòng chọn màu sắc";
                isValid = false;
            }

            if (category === "") {
                document.getElementById("categoryError").innerText = "Vui lòng chọn danh mục";
                isValid = false;
            }

            return isValid;
        }
        window.addEventListener("DOMContentLoaded", function () {

            let message = "${mess}";

            if (message && message.trim() !== "") {
                showToast(message);
            }

            function showToast(msg) {
                let toast = document.getElementById("toast");
                let toastMsg = document.getElementById("toastMsg");

                toastMsg.innerText = msg;
                toast.classList.add("show");

                // Tự ẩn sau 3 giây
                setTimeout(function () {
                    toast.classList.remove("show");
                }, 3000);
            }
        });
    </script>
</head>

<body class="bg-light">

<div class="container mt-5">

    <h2 class="text-center mb-4">Danh sách sản phẩm</h2>

    <!-- Nút thêm -->
    <div class="d-flex justify-content-end mb-3">
        <button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#productModal">
            Thêm sản phẩm
        </button>
    </div>

    <!-- SEARCH -->
    <div class="row g-2 mb-3">
        <div class="col-md-4">
            <input type="text" id="searchName" class="form-control" placeholder="Tìm theo tên">
        </div>
        <div class="col-md-3">
            <input type="number" id="minPrice" class="form-control" placeholder="Giá từ">
        </div>
        <div class="col-md-3">
            <input type="number" id="maxPrice" class="form-control" placeholder="Giá đến">
        </div>
        <div class="col-md-2">
            <button class="btn btn-primary w-100" onclick="searchProduct()">Tìm kiếm</button>
        </div>
    </div>

    <!-- TABLE -->
    <table id="productTable" class="table table-bordered table-striped table-hover text-center align-middle">
        <thead class="table-dark">
        <tr>
            <th>STT</th>
            <th>Tên sản phẩm</th>
            <th>Giá</th>
            <th>Số lượng</th>
            <th>Màu sắc</th>
            <th>Danh mục</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td class="text-danger fw-bold">
                    <fmt:formatNumber value='${product.price}' type='number' groupingUsed='true'/>
                </td>
                <td>${product.quantity}</td>
                <td>${product.color}</td>
                <td>${product.categoryName}</td>
                <td>
                    <form action="/product" method="post"
                          onsubmit="return confirmDelete(${product.id})">
                        <input type="hidden" name="id" value="${product.id}">
                        <input type="hidden" name="action" value="delete">
                        <button class="btn btn-danger btn-sm">Xóa</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<!-- MODAL -->
<div class="modal fade" id="productModal" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <h5 class="modal-title">Thêm sản phẩm</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <form action="/product" method="post" onsubmit="return validateForm()">

                <div class="modal-body">

                    <input type="hidden" name="action" value="addProduct">

                    <div class="mb-3">
                        <label class="form-label">Tên sản phẩm</label>
                        <input type="text" id="name" name="name" class="form-control">
                        <small id="nameError" class="text-danger"></small>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Giá</label>
                        <input type="number" id="price" name="price" class="form-control">
                        <small id="priceError" class="text-danger"></small>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Số lượng</label>
                        <input type="number" id="quantity" name="quantity" class="form-control">
                        <small id="quantityError" class="text-danger"></small>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Màu sắc</label>
                        <select id="color" name="color" class="form-select">
                            <option value="">--Chọn màu--</option>
                            <option value="Đỏ">Đỏ</option>
                            <option value="Xanh">Xanh</option>
                            <option value="Trắng">Trắng</option>
                            <option value="Vàng">Vàng</option>
                        </select>
                        <small id="colorError" class="text-danger"></small>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Danh mục</label>
                        <select id="category" name="category_id" class="form-select">
                            <option value="">--Chọn danh mục--</option>
                            <c:forEach items="${categories}" var="c">
                                <option value="${c.id}">${c.name}</option>
                            </c:forEach>
                        </select>
                        <small id="categoryError" class="text-danger"></small>
                    </div>

                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                    <button type="submit" class="btn btn-primary">Thêm</button>
                </div>

            </form>

        </div>
    </div>
</div>
<!-- TOAST -->
<div class="sl-toast" id="toast"><div class="toast-dot"></div><span id="toastMsg"></span></div>
</body>

</html>