package Entity;

public class PembeliEntity07162 extends AbstractEntity07162 {
   private String alamat;

    public PembeliEntity07162(String nama, String password,String alamat) {
        super(nama, password);
        this.alamat = alamat;
    }
    @Override
    public String getNama() {
        return nama;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
