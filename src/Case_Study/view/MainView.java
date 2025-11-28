package Case_Study.view;

import Case_Study.common.CheckInput;
import Case_Study.controller.ATMController;
import Case_Study.entity.BankAccount;
import Case_Study.entity.Transaction;

import java.util.List;
import java.util.Scanner;

public class MainView {


    public static void main(String[] args) {
        do {
            try {
                ATMController atmController = new ATMController();
                Scanner sc = new Scanner(System.in);
                int choice;

                System.out.println("=====================================================");
                System.out.println("      █████╗ ████████╗███╗   ███╗    ████████╗");
                System.out.println("     ██╔══██╗╚══██╔══╝████╗ ████║    ╚══██╔══╝");
                System.out.println("     ███████║   ██║   ██╔████╔██║       ██║   ");
                System.out.println("     ██╔══██║   ██║   ██║╚██╔╝██║       ██║   ");
                System.out.println("     ██║  ██║   ██║   ██║ ╚═╝ ██║       ██║   ");
                System.out.println("     ╚═╝  ╚═╝   ╚═╝   ╚═╝     ╚═╝       ╚═╝   ");
                System.out.println("-----------------------------------------------------");
                System.out.println("               WELCOME TO OOP ATM SYSTEM             ");
                System.out.println("=====================================================");

                do {
                    System.out.println("\n╔════════════════════════════════════════╗");
                    System.out.println("║                🏧  ATM SYSTEM          ║");
                    System.out.println("╠════════════════════════════════════════╣");
                    System.out.println("║              CHỌN CHỨC NĂNG           ║");
                    System.out.println("╠════════════════════════════════════════╣");
                    System.out.println("║  1. 🔐 Đăng nhập (Login)               ║");
                    System.out.println("║  2. ➕ Đăng ký tài khoản (Register)    ║");
                    System.out.println("║  0. 🚪 Thoát chương trình              ║");
                    System.out.println("╚════════════════════════════════════════╝");
                    System.out.print("👉 Nhập lựa chọn: ");

                    choice = sc.nextInt();
                    sc.nextLine();

                    switch (choice) {
                        case 1:
                            do {
                                try{
                                    System.out.println("\n╔════════════════════════════════════════╗");
                                    System.out.println("║                🔐  ATM LOGIN           ║");
                                    System.out.println("╠════════════════════════════════════════╣");
                                    System.out.println("║        Vui lòng nhập thông tin         ║");
                                    System.out.println("╚════════════════════════════════════════╝");

                                    System.out.print(" 👉  💳  Nhập số tài khoản: ");
                                    String accountNumber = sc.nextLine();
                                    CheckInput.checkAccountNumber(accountNumber);

                                    System.out.print(" 👉  🔑  Nhập mã PIN (6 số): ");
                                    String pin = sc.nextLine();
                                    CheckInput.checkPIN(pin);
                                    if (atmController.login(accountNumber, pin)){
                                        choice = 0;
                                        break;
                                    }
                                }catch (Exception e){
                                    System.out.println(e.getMessage());
                                }
                            } while (true);
                            break;
                        case 2:
                            do {
                                try{
                                    System.out.println("\n╔════════════════════════════════════════╗");
                                    System.out.println("║              🔐  ATM REGISTER          ║");
                                    System.out.println("╠════════════════════════════════════════╣");
                                    System.out.println("║        Vui lòng nhập thông tin         ║");
                                    System.out.println("╚════════════════════════════════════════╝");

                                    System.out.print(" 👉  💳  Nhập điện thoại: ");
                                    String accountNumber = sc.nextLine();
                                    CheckInput.checkAccountNumber(accountNumber);
                                    System.out.print(" 👉  🔑  Nhập mã PIN (6 số): ");
                                    String pin = sc.nextLine();
                                    CheckInput.checkPIN(pin);
                                    System.out.print(" 👉  ➕  Nhập tên khách hàng: ");
                                    String ownerName = sc.nextLine();
                                    CheckInput.checkName(ownerName);
                                    if (!atmController.exitsAccount(accountNumber)){
                                        atmController.addBankAccount(new BankAccount(accountNumber, pin, ownerName,0));
                                        choice = 0;
                                    }else {
                                        throw new Exception("Tài khoản đã tồn tại");
                                    }
                                    atmController.login(accountNumber, pin);
                                    break;
                                }catch (Exception e){
                                    System.out.println(e.getMessage());
                                }
                            }while (true);
                            break;
                        case 0:
                            System.out.println("👋 Tạm biệt!");
                            break;
                        default:
                            System.out.println("⚠️ Lựa chọn không hợp lệ. Vui lòng thử lại!");
                            break;
                    }
                }while (choice != 0);

                do {
                    System.out.println("\n╔═══════════════ ATM MENU ═══════════════╗");
                    System.out.println("║ 1. 💵 Rút tiền                         ║");
                    System.out.println("║ 2. 💰 Nạp tiền                         ║");
                    System.out.println("║ 3. 📄 Xem số dư                        ║");
                    System.out.println("║ 4. 📜 Lịch sử giao dịch                ║");
                    System.out.println("║ 0. 🚪 Thoát                            ║");
                    System.out.println("╚════════════════════════════════════════╝");
                    System.out.print("👉 Nhập lựa chọn của bạn: ");
                    choice = sc.nextInt();
                    sc.nextLine();

                    switch (choice) {
                        case 1:
                            do {
                                try {
                                    System.out.print("👉 Nhập số tiền cần rút: ");
                                    String amountWithdraw = sc.nextLine();
                                    CheckInput.checkAmount(amountWithdraw);
                                    atmController.withdraw(Double.parseDouble(amountWithdraw));
                                    break;
                                }catch (Exception e){
                                    System.out.println(e.getMessage());
                                }
                            }while (true);
                            break;
                        case 2:
                            do {
                                try {
                                    System.out.print("👉 Nhập số tiền cần nạp: ");
                                    String amountDeposit = sc.nextLine();
                                    CheckInput.checkAmount(amountDeposit);
                                    atmController.deposit(Double.parseDouble(amountDeposit));
                                    break;
                                }catch (Exception e){
                                    System.out.println(e.getMessage());
                                }
                            }while (true);
                            break;
                        case 3:
                            System.out.print("👉 Số dư tài khoản: "+atmController.getBalance());
                            break;
                        case 4:
                            System.out.println("👉 Lịch sử giao dịch: ");
                            showHistory(atmController.showHistory());
                            break;
                        case 0:
                            System.out.println("👋 Tạm biệt!");
                            atmController.logout();
                            break;
                        default:
                            System.out.println("⚠️ Lựa chọn không hợp lệ. Vui lòng thử lại!");
                            break;
                    }
                }while (choice != 0);

                sc.close();
                break;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }while (true);
    }

    public static void showHistory(List<Transaction> transactions){
        for (Transaction transaction : transactions){
            showTransaction(transaction);
        }
    }

    public  static void showTransaction(Transaction transaction){
        System.out.println("Số tài khoản: "+transaction.getAccountNumber()
                            +"\nType: "+transaction.getType()
                            +"\nAmount: "+transaction.getAmount()
                            +"\nNgày giao dịch: "+transaction.getDateTime());
    }
}
