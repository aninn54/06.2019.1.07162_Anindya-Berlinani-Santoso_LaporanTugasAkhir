package View07162;
import Entity.MakananEntity07162;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Update07162 {
    JComboBox pilmakanan = new JComboBox(MakananEntity07162.makanan);
    JButton konfirmasi,kembali;
    JFrame TampilanAwal = new JFrame();
    JTextArea area = new JTextArea();
    JLabel update,labelmakananUpdate;
    JTextField textmakananUpdate;
      public Update07162() {
        
        TampilanAwal.setSize(720,600);
        TampilanAwal.setLayout(null);
        TampilanAwal.getContentPane().setBackground(Color.LIGHT_GRAY);
        
        update = new JLabel("Update Data");
        update.setFont(new Font("Times New Roman",Font.BOLD,43));
        update.setBounds(240,30,300,80);
        TampilanAwal.add(update);
        
        labelmakananUpdate = new JLabel("Nama Pembeli");
        labelmakananUpdate.setBounds(300,180,150,30);
        TampilanAwal.add(labelmakananUpdate);
        
        textmakananUpdate = new JTextField();
        textmakananUpdate.setBounds(250,210,200,40);
        TampilanAwal.add(textmakananUpdate);
        
        pilmakanan.setBounds(276,270,150,40);
        TampilanAwal.add(pilmakanan);
        
        konfirmasi = new JButton("KONFIRMASI");
        konfirmasi.setBounds(290,330,120,40);
        konfirmasi.setBackground(Color.RED);
        TampilanAwal.add(konfirmasi);
        
        kembali = new JButton("KEMBALI");
        kembali.setBounds(290,380,120,40);
        kembali.setBackground(Color.GREEN);
        TampilanAwal.add(kembali);
        
        TampilanAwal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TampilanAwal. setVisible(true);
        TampilanAwal.setLocationRelativeTo(null);
        
        konfirmasi.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                int makananUpdate = pilmakanan.getSelectedIndex();
                Allobjctrl07162.Pembeli.update(textmakananUpdate.getText(), makananUpdate);
                JOptionPane.showMessageDialog(null,"BERHASIL DI UPDATE","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
                kosong();
            }
            
        });
        
        kembali.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                TampilanAwal.dispose();
                GUI07162 men = new GUI07162();
            }
            
        });
    }
    void kosong() {
        textmakananUpdate.setText(null);
    }
}
