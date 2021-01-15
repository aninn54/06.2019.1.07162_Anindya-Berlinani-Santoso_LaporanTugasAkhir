package View07162;
import Entity.MakananEntity07162;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.*;
public class PembeliGUI07162 {
    JFrame Pembeli = new JFrame();
    JButton back,daftarbtn;
    JTextArea area = new JTextArea();
    JLabel datapembeli,daftarmakanan;
    JComboBox pilmakanan = new JComboBox(MakananEntity07162.makanan);
     int cek = Allobjctrl07162.Pembeli.cekDaftarPembeli
        (Allobjctrl07162.Pembeli.getData().getPassword());
    public PembeliGUI07162(){
        Pembeli.setSize(720, 600);
        Pembeli.setLayout(null);
        Pembeli.getContentPane().setBackground(Color.PINK);
        
        datapembeli = new JLabel("Data Pembeli");
        datapembeli.setFont(new Font("Timer New Roman",Font.BOLD,30));
        datapembeli.setBounds(90, 30, 200, 30);
        Pembeli.add(datapembeli);
        
        area.setBounds(30, 90, 400, 300);
        Pembeli.add(area);
        
        daftarmakanan = new JLabel("Daftar Makanan");
        daftarmakanan.setBounds(450, 30, 250, 30);
        daftarmakanan.setFont(new Font("Times New Roman",Font.BOLD,30));
        Pembeli.add(daftarmakanan);
        
        pilmakanan.setBounds(450, 90, 230, 30);
        Pembeli.add(pilmakanan);
       
         
        daftarbtn = new JButton("Daftar");
        daftarbtn.setBounds(500, 200, 100, 30);
        daftarbtn.setBackground(Color.GRAY);
        Pembeli.add(daftarbtn);
        
        back = new JButton("Back");
        back.setBounds(30, 500, 100, 30);
        back.setBackground(Color.red);
        
        Pembeli.add(back);
        Pembeli.setVisible(true);
        Pembeli.setLocationRelativeTo(null);
        Pembeli.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if(cek==-1){ //cek data, apabila kita belum daftar pembeli
            JOptionPane.showMessageDialog(null, "Anda Belum Daftar sebagai pembeli", "Information", JOptionPane.INFORMATION_MESSAGE);        
        }else if(cek==-2){
            JOptionPane.showMessageDialog(null,"Anda Belum Daftar sebagai pembeli", "Information", JOptionPane.INFORMATION_MESSAGE);
        }else{
            area.setText(datapembeli());
        }
        daftarbtn.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae){
            int indexmakanan = pilmakanan.getSelectedIndex();
            Allobjctrl07162.Pembeli.DaftarMakanan
            (indexmakanan,Allobjctrl07162.Pembeli.getData(), false);
            area.setText(datapembeli());
        }
        });
        
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Pembeli.dispose();
                GUI07162 men = new GUI07162(); //nama objek menu
            }
        });
    }
    String datapembeli(){
        int cek = Allobjctrl07162.Pembeli.cekDaftarPembeli(Allobjctrl07162.Pembeli.getData().getNama());
        String cekverif; 
        if(Allobjctrl07162.Pembeli.showDaftarPembeli(cek).isIsVerified()==false){
            cekverif = "belum diverifikasi";
        }else{
            cekverif = "sudah diverifikasi";
        }
         String text = "Nama = "+Allobjctrl07162.Pembeli.showDaftarPembeli(cek).getPembeli().getNama()+"\n"
                +"Alamat = "+Allobjctrl07162.Pembeli.showDaftarPembeli(cek).getPembeli().getAlamat()+"\n"
                +"Verifikasi = "+cekverif+"\n"
                +"Makanan = "+MakananEntity07162.makanan[Allobjctrl07162.Pembeli.showDaftarPembeli(cek).getIndexMakanan()];
        return text;
    }
}
