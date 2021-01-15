package Model07162;
import Entity.*;
import java.util.ArrayList;
import java.text.ParseException;
public class DaftarPembeliModel07162 implements ModelInterface07162 {
    private ArrayList<DaftarPembeliEntity07162> daftarpembeliArrayList;
    public DaftarPembeliModel07162(){
    daftarpembeliArrayList = new ArrayList<DaftarPembeliEntity07162>();
        }
    public void insertDataPembeli(DaftarPembeliEntity07162 daftarpembeli){
        daftarpembeliArrayList.add(daftarpembeli);
    }
    public ArrayList<DaftarPembeliEntity07162> getdaftarpembeliArrayList(){
        return daftarpembeliArrayList;
    }
    public int size() {
        return daftarpembeliArrayList.size();
    }
    @Override
     public void view() {
        for (DaftarPembeliEntity07162 pembelientity : daftarpembeliArrayList) {
            System.out.println("==============================================");
            System.out.println("nama : " + pembelientity.getPembeli().getNama()+"\nPassword : " + pembelientity.getPembeli().getPassword() + "\nAlamat : "+pembelientity.getPembeli().getAlamat()+"\n Makanan : "+MakananEntity07162.makanan[pembelientity.getIndexMakanan()] + "\n isVerified : ");
            if(pembelientity.isIsVerified()==false) {
                System.out.println("Belum Di Verifikasi Admin");
            } else {
                System.out.println("Sudah Di Verifikasi Admin");
            }
            System.out.println("==============================================");
        }
    }
     @Override
    public int cekData(String nama, String password ){
        int loop = 0;
        if(daftarpembeliArrayList.size() ==0){
            loop = -1;//data kosong
        }else{
            for(int i = 0; i <daftarpembeliArrayList.size(); i++){
            if(daftarpembeliArrayList.get(i).getPembeli().getPassword().equals(password)){
                loop = i;
                break;
            }else{
                loop = -2;
                }
            }
        }   return loop;
    }
    public DaftarPembeliEntity07162 showDaftarPembeli(int index){
        return daftarpembeliArrayList.get(index); //menampilkan data pembeli
    }
    public void hapusPembeliModel(int index) {
        daftarpembeliArrayList.remove(daftarpembeliArrayList.get(index)); //menghapus data pembeli
    }
    public void updateIsVerified(int index,DaftarPembeliEntity07162 daftarpembeli){
    daftarpembeliArrayList.set(index, daftarpembeli); 
    }
    public ArrayList <DaftarPembeliEntity07162> alldatapembeli(){
        return  daftarpembeliArrayList;
    }
     private int cariMakanan(String makanan){
        int index=-1;
        for(int i=0;i <daftarpembeliArrayList.size();i++) {
           if(makanan.equals(daftarpembeliArrayList.get(i).getPembeli().getNama()))
               index=i;
       }
       return index;
    }
     public void update(String makanan, int Updatemakanan){
            int data;
        if(cariMakanan(makanan)!=-1){
            daftarpembeliArrayList.get(cariMakanan(makanan)).setIndexMakanan(Updatemakanan);
            data = 1;
        }
        else {
            data = 0;
        }
    }
}
