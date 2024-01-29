package view;

import entity.AdminEntity;

import java.util.Scanner;

public class AdminView {
    private controllers.AdminController adminController;
    private Scanner scanner;
    private static int lastAdminId = 0;

    public AdminView() {
        this.adminController = new controllers.AdminController();
        this.scanner = new Scanner(System.in);
    }
    public void loginAdmin() {
        Scanner input = new Scanner(System.in);

        boolean loginSuccess = false;
        do {
            System.out.println("Masukkan Username Admin: ");
            String username = input.nextLine();
            System.out.println("Masukkan Password Admin: ");
            String password = input.nextLine();

            AdminEntity admin = adminController.login(username, password);

            if (admin != null) {
                System.out.println("Login berhasil!");
                loginSuccess = true;
                adminController.viewAdmin();
            } else {
                System.out.println("Login gagal. Username atau password salah.");
            }
        } while (!loginSuccess);
    }
}
