# 📘 README – Hướng Dẫn Sử Dụng ATM Console

## 🔐 1. Hướng dẫn đăng nhập

Để đăng nhập vào hệ thống ATM, bạn cần:

- **Số tài khoản:**  
  ➜ Chính là **số điện thoại** bạn đã dùng khi đăng ký.

- **Mã PIN:**  
  ➜ Gồm **6 chữ số**.  
  ➜ Ví dụ hợp lệ: `123456`, `098765`, `000111`.

👉 Sau khi nhập đúng **số tài khoản** và **PIN**, bạn sẽ được chuyển đến menu ATM để rút tiền, nạp tiền, xem số dư và xem lịch sử giao dịch.

---

## 📝 2. Hướng dẫn đăng ký tài khoản

Khi đăng ký mới, bạn cần nhập:

1. **Số điện thoại**  
   - Đây sẽ là **số tài khoản**
   - Yêu cầu nhập đúng định dạng số điện thoại Việt Nam (10 số).

2. **Mã PIN (6 số)**  
   - Dùng để đăng nhập  
   - Không được chứa chữ hoặc ký tự đặc biệt.

3. **Tên chủ tài khoản**  
   - Ví dụ: “Nguyễn Văn A”, “Lê Hồng Quân”

Sau khi đăng ký thành công:

- Tài khoản mới được tạo sẽ có **số dư = 0**
- Bạn cần **nạp tiền** trước khi thực hiện chức năng **rút tiền**

---

## 💡 Gợi ý sử dụng

- Nếu quên mã PIN → phải tạo tài khoản mới (không hỗ trợ đặt lại PIN).
- Lịch sử giao dịch được lưu tự động vào file CSV.
- Hệ thống hoạt động theo mô hình **MVC + Repository**, dễ mở rộng.

