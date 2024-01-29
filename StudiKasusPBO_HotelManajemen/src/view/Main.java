package view;

import controller.ReservasiController;
import models.ReservasiModel;
import view.AdminView;
import view.ReservasiView;

public class Main {
    public static void main(String[] args) {
        AdminView adminView = new AdminView();
        adminView.loginAdmin();

        // Assuming successful login, proceed with ReservasiView
        ReservasiModel model = new ReservasiModel();
        ReservasiController controller = new ReservasiController(model);
        ReservasiView reservasiView = new ReservasiView(controller);
        reservasiView.menuUtama();
    }
}
