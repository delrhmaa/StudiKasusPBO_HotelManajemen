package models;
import entity.AdminEntity;

import java.util.ArrayList;
import java.util.List;
public class AdminModel {
    private static List<AdminEntity> daftarAdmin = new ArrayList<>();

    public AdminModel() {
        AdminEntity admin = new AdminEntity("Delyn", "07600", "Deldel", "1210");

        daftarAdmin.add(admin);
    }

    public static List<AdminEntity> lihatDaftarAdmin() {
        return daftarAdmin;
    }

    public static void tambahAdmin(AdminEntity admin) {
        daftarAdmin.add(admin);
    }

    public AdminEntity login(String username, String password) {
        for (AdminEntity admin : daftarAdmin) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                return admin;
            }
        }
        return null;
    }
}

