package View07162;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI07162 {
     JFrame TampilanAwal = new JFrame(); //tampilan awal
    JLabel login,daftar,top;
    JRadioButton radioadmin,radiopembeli; //tombol pilihan
    JTextField textnamalogin,textnamadaftar,textalamat;
    JLabel labelnamalogin,labelpasswordlogin,labelnamadaftar,labelpassworddaftar,labelalamat;
    JButton check,reg,update;
    JPasswordField passwordlogin,passworddaftar;
    
    private boolean ceklogin = false;
    public GUI07162(){ //komponen
        TampilanAwal.setSize(700, 630); //ukuran 
        TampilanAwal.setLayout(null);
        TampilanAwal.getContentPane().setBackground(Color.YELLOW); //warna background
        
        top = new JLabel("Rumah Makan");
        top.setBounds(225, 10, 600, 50);
        top.setFont(new Font("Times New Roman",Font.BOLD,40));
        TampilanAwal.add(top);
        
        login = new JLabel("Login");
        login.setBounds(100, 50, 100, 100);
        login.setFont(new Font("Times New Roman",Font.BOLD,30));
        TampilanAwal.add(login);
        
        radioadmin = new JRadioButton("admin");
        radioadmin.setBounds(30, 150, 100, 30);
        radioadmin.setBackground(Color.CYAN);
        TampilanAwal.add(radioadmin);
        
        radiopembeli = new JRadioButton("pembeli");
        radiopembeli.setBounds(140, 150, 100, 30);
        radiopembeli.setBackground(Color.CYAN);
        TampilanAwal.add(radiopembeli);
        
        labelnamalogin = new JLabel("Nama");
        labelnamalogin.setBounds(30, 180, 50, 30);
        TampilanAwal.add(labelnamalogin);
        
        textnamalogin = new JTextField();
        textnamalogin.setBounds(30, 210, 200, 30);
        TampilanAwal.add(textnamalogin);
        
        labelpasswordlogin = new JLabel("Password");
        labelpasswordlogin.setBounds(30, 240, 100, 30);
        TampilanAwal.add(labelpasswordlogin);
        
        passwordlogin = new JPasswordField();
        passwordlogin.setBounds(30, 270, 200, 30);
        TampilanAwal.add(passwordlogin);
        
        check = new JButton("check");
        check.setBounds(90, 320, 100, 40);
        check.setBackground(Color.CYAN);
        TampilanAwal.add(check);
        
         
        update = new JButton("update");
        update.setBounds(90,400,100,40);
        update.setBackground(Color.CYAN);
        TampilanAwal.add(update);
        
        daftar = new JLabel("Buat Akun");
        daftar.setFont(new Font("Times New Roman",Font.BOLD,30));
        daftar.setBounds(440, 50, 150, 100);
        TampilanAwal.add(daftar);
        labelnamadaftar = new JLabel("Nama");
        labelnamadaftar.setBounds(400, 210, 100, 30);
        TampilanAwal.add(labelnamadaftar);
        textnamadaftar = new JTextField();
        textnamadaftar.setBounds(400, 240, 200, 30);
        TampilanAwal.add(textnamadaftar);
        labelpassworddaftar = new JLabel("Password");
        labelpassworddaftar.setBounds(400, 270, 100, 30);
        TampilanAwal.add(labelpassworddaftar);
        passworddaftar = new JPasswordField();
        passworddaftar.setBounds(400, 300, 200, 30);
        TampilanAwal.add(passworddaftar);
        labelalamat = new JLabel("Alamat");
        labelalamat.setBounds(400, 330, 100, 30);
        TampilanAwal.add(labelalamat);
        textalamat = new JTextField();
        textalamat.setBounds(400, 360, 200, 30);
        TampilanAwal.add(textalamat);
        
        reg = new JButton("Daftar");
        reg.setBounds(460, 520, 100, 40);
        reg.setBackground(Color.CYAN);
        TampilanAwal.add(reg);
        TampilanAwal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TampilanAwal.setVisible(true);
        TampilanAwal.setLocationRelativeTo(null);
        radioadmin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                if(radioadmin.isSelected()){
                    radiopembeli.setSelected(false);
                    ceklogin=true;
                }
            }
        });
        radiopembeli.addActionListener(new ActionListener(){ //untuk pembeli
            @Override
            public void actionPerformed(ActionEvent ae){
                if(radiopembeli.isSelected()){
                    radioadmin.setSelected(false);
                    ceklogin=false;
                }
            }
        });
        check.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){ // login untuk admin
                if(ceklogin==true){
                    try{
                        Allobjctrl07162.admin.dataAdmin();
                        Allobjctrl07162.admin.login(textnamalogin.getText(), passwordlogin.getText());
                        String nama = Allobjctrl07162.admin.AdminEntity07162().getNama();
                        JOptionPane.showMessageDialog(null, "Selamat datang "+nama,"information", JOptionPane.INFORMATION_MESSAGE);
                        AdminGUI07162 admin = new AdminGUI07162();
                        TampilanAwal.dispose();
                    }catch(Exception exception){
                        JOptionPane.showMessageDialog(null, "Nama atau Password salah", "information", JOptionPane.INFORMATION_MESSAGE);
                    }
                        kosong(); //method kosong, jika datanya kosong
                }else{
                    try{ //login untuk pembeli
                       Allobjctrl07162.Pembeli.login(textnamalogin.getText(),passwordlogin.getText());
                       String nama = Allobjctrl07162.Pembeli.getData().getNama(); //memasukkan nama dan password jika benar 
                       JOptionPane.showMessageDialog(null, "Selamat datang "+nama,"information", JOptionPane.INFORMATION_MESSAGE);
                       PembeliGUI07162 prak = new PembeliGUI07162();
                       TampilanAwal.dispose();
                    }catch(Exception eception){ //jika nama atau password salah makan akan muncul tulisan
                        JOptionPane.showMessageDialog(null, "Nama atau Password salah", "information", JOptionPane.INFORMATION_MESSAGE);
                       kosong();
                    }
                }
            }
        });
        update.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                Update07162 update =new Update07162();
                TampilanAwal.dispose();
            }
            
        });
        
        reg.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                try{ 
                    String nama = textnamadaftar.getText(); //registrasi
                    String password = passworddaftar.getText();
                    String alamat = textalamat.getText();
                  
                    Allobjctrl07162.Pembeli.insert(nama,password,alamat); //jika suksesmaka muncul tulisan
                    JOptionPane.showMessageDialog(null, "Registrasi sukses", "information", JOptionPane.INFORMATION_MESSAGE);
                    kosong();
                }catch(Exception exception){
                    JOptionPane.showMessageDialog(null, "Format Penulisan Salah", "Registrasi Gagal", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
    void kosong(){
        textnamadaftar.setText(null); //settext null semua
        passworddaftar.setText(null);
        textalamat.setText(null);
        textnamalogin.setText(null);
        passwordlogin.setText(null);
    }
}
