package View07162;
import Controller07162.AllObjectModel07162;
import Controller07162.PembeliController07162;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
public class AdminGUI07162 {
     private static PembeliController07162 pembeli = new PembeliController07162();
    JFrame admin = new JFrame();
    JTable tabelpembeli = new JTable();
    JScrollPane scrolladmin = new JScrollPane(tabelpembeli);
    JButton back,verif,hapus;
    JLabel Admin,passlabel,namalabel;
    JTextField passtext,namatext;
     public AdminGUI07162(){
        admin.setSize(650,500);
        admin.setLayout(null);
        admin.getContentPane().setBackground(Color.ORANGE);
        
        Admin = new JLabel("Admin");
        admin.setBounds(250, 30, 200, 30);
        admin.setFont(new Font("Timer New Roman",Font.BOLD,40));
        admin.add(Admin);
        
        scrolladmin.setBounds(30, 100, 570, 200);
        tabelpembeli.setModel(pembeli.daftarpem());
        admin.add(scrolladmin);
        
        namalabel = new JLabel("NAMA");
        namalabel.setBounds(50, 320, 100, 30);
        admin.add(namalabel);
        
        namatext = new JTextField();
        namatext.setBounds(50, 350, 100, 30);
        admin.add(namatext);
        
        passlabel = new JLabel("Password");
        passlabel.setBounds(200, 320, 100, 30);
        admin.add(passlabel);
        
        passtext = new JTextField();
        passtext.setBounds(200, 350, 100, 30);
        admin.add(passtext);
        
        verif = new JButton("verif");
        verif.setBounds(350, 350, 100, 30);
        verif.setBackground(Color.GRAY);
        admin.add(verif);
        
        back = new JButton("back");
        back.setBounds(50, 400, 100, 30);
        back.setBackground(Color.GRAY);
        admin.add(back);
        
        hapus = new JButton("Hapus");
        hapus.setBounds(350, 400, 100, 30);
        hapus.setBackground(Color.GRAY);
        admin.add(hapus);
        
        admin.setLocationRelativeTo(null);
        admin.setVisible(true);
        admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        back.addActionListener(new ActionListener()
                {
            @Override
            public void actionPerformed(ActionEvent ae){
                admin.dispose();
                GUI07162 men = new GUI07162(); //nama objek men
            }
        });
        verif.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){ //untuk verifikasi nama dan password
                String nama = namatext.getText();
                String pass = passtext.getText();
                int index = AllObjectModel07162.daftarPembelimodel.cekData(nama, pass); //dicek
                Allobjctrl07162.admin.updateIsVerified(index, Allobjctrl07162.Pembeli.showDaftarPembeli(index).getIndexMakanan(),Allobjctrl07162.Pembeli.showDaftarPembeli(index).getPembeli());
                tabelpembeli.setModel(pembeli.daftarpem());
            }
        });
         hapus.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Allobjctrl07162.Pembeli.deleteDataPembeli(0);
                tabelpembeli.setModel(pembeli.daftarpem());
            }
        });
        tabelpembeli.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){ //method untuk kursor
                int i = tabelpembeli.getSelectedRow();
                namatext.setText(Allobjctrl07162.Pembeli.daftarpem().getValueAt(i, 0).toString());
                passtext.setText(Allobjctrl07162.Pembeli.daftarpem().getValueAt(i, 1).toString());
            }
        });
    }
}
