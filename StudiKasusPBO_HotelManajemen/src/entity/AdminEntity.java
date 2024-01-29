package entity;

public class AdminEntity extends Identitas{
    private String namaAdmin;
    private String id;

    public AdminEntity(String username, String password, String namaAdmin, String id) {
        super(username, password);
        this.namaAdmin = namaAdmin;
        this.id = id;
    }

    public String getNamaAdmin() {
        return namaAdmin;
    }

    public void setNamaAdmin(String namaAdmin) {
        this.namaAdmin = namaAdmin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void AdminView() {
        System.out.println("Data Admin ");
        System.out.println("Id Admin: " + getId());
        System.out.println("Nama Admin: " + getNamaAdmin());
        System.out.println("Username: " + getUsername());
        System.out.println("Password: " + getPassword());
    }
}
