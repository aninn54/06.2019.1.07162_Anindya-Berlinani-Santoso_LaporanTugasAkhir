package Controller07162;
import Entity.*;
import java.util.ArrayList;
public class AdminController07162 implements ControllerInterface07162 {
    AllObjectModel07162 allobject = new AllObjectModel07162();
    int indexLogin = 0;
     public AdminController07162() {    
    }
     public void dataAdmin() {
        String passwordAdmin[] = {"123"};
        String namaAdmin[] = {"Anindya"};
        for(int i = 0; i < namaAdmin.length; i++) {
            AllObjectModel07162.adminModel.insertAdmin(new AdminEntity07162 (namaAdmin[i],passwordAdmin[i]));
        }
    }
       @Override
    public void login(String nama, String password) {
        indexLogin = AllObjectModel07162.adminModel.cekData(nama, password);
    }
     public AdminEntity07162 AdminEntity07162() {
        return AllObjectModel07162.adminModel.showDataAdmin(indexLogin);
    }
    public void updateIsVerified(int index,int indexMakanan,PembeliEntity07162 pembeli ) {
        AllObjectModel07162.daftarPembelimodel.updateIsVerified(index, new 
        DaftarPembeliEntity07162 (indexMakanan, pembeli,true));
    }
    public ArrayList<DaftarPembeliEntity07162> cekDaftarPembeliModel() {
        return AllObjectModel07162.daftarPembelimodel.getdaftarpembeliArrayList();
    }
}
