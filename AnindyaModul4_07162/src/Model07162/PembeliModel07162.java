package Model07162;
import Entity.PembeliEntity07162;
import java.util.ArrayList;
public class PembeliModel07162 implements ModelInterface07162 
{
    private ArrayList<PembeliEntity07162> pembeliEntityArrayList;
    
    public PembeliModel07162()
    {
        pembeliEntityArrayList = new ArrayList<PembeliEntity07162>();
    }
    public void insert(PembeliEntity07162 pembeliEntity){ //menambah data pembeli
    pembeliEntityArrayList.add(pembeliEntity);  
    }
   
    @Override
    public void view() {
        for (PembeliEntity07162 pembeliEntity : pembeliEntityArrayList) {
            System.out.println("==============================================");
            System.out.println("nama : "+ pembeliEntity.getNama()+ "\nPassword : "+ pembeliEntity.getPassword()+"\n Alamat : "+pembeliEntity.getAlamat());
            System.out.println("==============================================");
        }
    }
    public int cekData(String nama, String password){
        int loop = 0;
        while (!pembeliEntityArrayList.get(loop).getNama().equals(nama) && 
                !pembeliEntityArrayList.get(loop).getPassword().equals(password)){
            loop++;
        }
        return loop;
    }
    public PembeliEntity07162 getpembeliEntityArrayList(int index){ //
        return pembeliEntityArrayList.get(index);
    }
}
