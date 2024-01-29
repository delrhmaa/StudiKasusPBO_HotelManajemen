package controllers;

import entity.AdminEntity;
import models.AdminModel;
import java.util.List;

public class AdminController {
    private AdminModel adminModel;

    public AdminController() {
        this.adminModel = new AdminModel();
    }


    public List <AdminEntity> viewAdmin(){
        return adminModel.lihatDaftarAdmin();
    }

    public AdminEntity login(String username, String password) {
        return adminModel.login(username, password);
    }
}

