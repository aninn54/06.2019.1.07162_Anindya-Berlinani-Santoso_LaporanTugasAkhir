package Controller07162;
import Entity.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
public class PembeliController07162 implements ControllerInterface07162 {
    AllObjectModel07162 allobject = new AllObjectModel07162();
    int indexLogin = 0;
    public PembeliController07162() {
    }
     public PembeliEntity07162 getData() {
        return AllObjectModel07162.pembeliModel.getpembeliEntityArrayList(indexLogin);
    }

    private static class pembeli {

        public pembeli() {
        }
    }
    
    public void DaftarMakanan (int indexMakanan,  PembeliEntity07162 pembeli, boolean isVerified) {
        AllObjectModel07162.daftarPembelimodel.insertDataPembeli(new 
        DaftarPembeliEntity07162 (indexMakanan, pembeli, isVerified));
    }
     @Override
    public void login(String nama, String password) {
        indexLogin = AllObjectModel07162.pembeliModel.cekData(nama, password);
    }
      public void insert(String nama, String password, String alamat) {
        AllObjectModel07162.pembeliModel.insert(new PembeliEntity07162(nama,password,alamat));
    }
     
    public int cekDaftarPembeli (String nama ) {
        int cek = AllObjectModel07162.daftarPembelimodel.cekData(nama, null);
        return cek;
    }
    
    public DaftarPembeliEntity07162 showDaftarPembeli(int index) {
        return AllObjectModel07162.daftarPembelimodel.showDaftarPembeli(index);
    }
    
    public void update(String makanan, int Updatemakanan) {
        AllObjectModel07162.daftarPembelimodel.update(makanan, Updatemakanan);
    }
    public void deleteDataPembeli(int index) {
        AllObjectModel07162.daftarPembelimodel.hapusPembeliModel(index);
    }
    public DefaultTableModel daftarpem(){
        DefaultTableModel dtmdaftarpem = new DefaultTableModel();
        Object[] kolom ={"Password","Nama","Alamat","Makanan","Verified"};
        dtmdaftarpem.setColumnIdentifiers(kolom);
        int size = AllObjectModel07162.daftarPembelimodel.alldatapembeli().size();
        String verif = null;
        for(int i=0;i<size;i++){
            if(AllObjectModel07162.daftarPembelimodel.alldatapembeli().get(i).isIsVerified()==false){
                verif = "no";
            }else{
                verif = "yes";
            }
            Object [] data = new Object[6];
            data[0] = AllObjectModel07162.daftarPembelimodel.alldatapembeli().get(i).getPembeli().getNama();
            data[1] = AllObjectModel07162.daftarPembelimodel.alldatapembeli().get(i).getPembeli().getPassword();
            data[2] = AllObjectModel07162.daftarPembelimodel.alldatapembeli().get(i).getPembeli().getAlamat();
            data[3] = MakananEntity07162.makanan[AllObjectModel07162.daftarPembelimodel.alldatapembeli().get(i).getIndexMakanan()];
            data[4] = verif;
            dtmdaftarpem.addRow(data);
    }
        return dtmdaftarpem;
    }
}
