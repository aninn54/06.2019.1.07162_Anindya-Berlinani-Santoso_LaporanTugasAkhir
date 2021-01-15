
package Entity;

public class AbstractEntity07162 {
    protected String nama,password;

    public AbstractEntity07162(String nama, String password) {
        this.nama = nama;
        this.password = password;
    }
    
    public AbstractEntity07162(){
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
