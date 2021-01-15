package Model07162;
import Entity.AdminEntity07162;
import java.util.ArrayList;
public class AdminModel07162 implements ModelInterface07162
{
        private ArrayList<AdminEntity07162> adminEntityArrayList;
        public AdminModel07162()
    {
        adminEntityArrayList = new ArrayList<AdminEntity07162>();
    }
        public void insertAdmin(AdminEntity07162 admin)
    {
        adminEntityArrayList.add(admin);
    }
         public void view() {
        for (AdminEntity07162 adminEntity : adminEntityArrayList) {
            System.out.println(adminEntity.getNama());
            System.out.println(adminEntity.getPassword());
        }
    }
 @Override
    public int cekData(String nama, String password){
        int loop = 0;
        for(AdminEntity07162 admin : adminEntityArrayList){
            if(admin.getNama().equals(nama) && admin.getPassword().equals(password)){
            break;
            }else{
                loop++;
            }
        }
        return loop;
    }
    public AdminEntity07162 showDataAdmin(int index){
        return adminEntityArrayList.get(index);
    }
  }

