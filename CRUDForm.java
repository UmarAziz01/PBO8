package pbo_upload;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author ASUS
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class CRUDForm extends javax.swing.JFrame {

    private CRUDKu crud;
    private DefaultTableModel tableModel;
    
    Connection cn;
    PreparedStatement ps;
    Statement st;
    String driver = "org.postgresql.Driver";
    String koneksi = "jdbc:postgresql://localhost:5432/PBO_UTS";
    String user = "postgres";
    String password = " ";

    /**
     * Creates new form CRUDForm
     */
    public CRUDForm() {
        initComponents();
        crud = new CRUDKu(); // Inisialisasi objek CRUD
        tableModel = (DefaultTableModel) tblMK.getModel(); // Ambil model dari tabel
        loadData();
        try {
            Class.forName(driver);
            cn = DriverManager.getConnection(koneksi, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CRUDKu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadData() {
        tableModel.setRowCount(0); // Bersihkan tabel
        List<MataKuliah> mkList = crud.tampil();
        tableModel.setColumnIdentifiers(new Object[]{"Kode Mata Kuliah", "SKS", "Nama Mata Kuliah", "Semester Ajar"});

        for (MataKuliah m : mkList) {
            tableModel.addRow(new Object[]{m.getKodeMK(), m.getSKS(), m.getNamaMK(), m.getSemesterAjar()});
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfKodeMK = new javax.swing.JTextField();
        tfNamaMK = new javax.swing.JTextField();
        tfSKS = new javax.swing.JTextField();
        tfSmtAjar = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMK = new javax.swing.JTable();
        btnKeluar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnCetak = new javax.swing.JButton();
        btnUpload = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Kode MK");

        jLabel2.setText("SKS");

        jLabel3.setText("Nama MK");

        jLabel4.setText("Semester Ajar");

        tfSKS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSKSActionPerformed(evt);
            }
        });

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        tblMK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblMK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMKMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMK);

        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        jLabel6.setText("_________________________________________________________________________________________________________________________");

        btnCetak.setText("Cetak");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        btnUpload.setText("Upload");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfSmtAjar, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                            .addComponent(tfNamaMK)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfSKS, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                            .addComponent(tfKodeMK)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCetak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnKeluar, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(btnUpload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tfKodeMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfSKS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfNamaMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfSmtAjar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addComponent(jLabel6)
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfSKSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSKSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSKSActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:

        try {
            String kodeMK = tfKodeMK.getText();
            int sks = Integer.parseInt(tfSKS.getText());
            String namaMK = tfNamaMK.getText();
            int smtAjar = Integer.parseInt(tfSmtAjar.getText());

            if (crud.tambah(kodeMK, sks, namaMK, smtAjar)) { // dari class buku
                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan.");
                loadData();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menambahkan data.");
            }
        } catch (NumberFormatException ex) {
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        try {
            String kodeMK = tfKodeMK.getText();
            int sks = Integer.parseInt(tfSKS.getText());
            String namaMK = tfNamaMK.getText();
            int smtAjar = Integer.parseInt(tfSmtAjar.getText());

            if (crud.update(kodeMK, sks, namaMK, smtAjar)) {
                JOptionPane.showMessageDialog(this, "Data berhasil diupdate.");
                loadData();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Input harus benar.");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        try {
            String kodeMK = tfKodeMK.getText();
            if (crud.hapus(kodeMK)) {
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus.");
                loadData();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Input ISBN dengan benar.");
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        clearForm();
        loadData();
    }//GEN-LAST:event_btnResetActionPerformed

    private void tblMKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMKMouseClicked
        // TODO add your handling code here:
        int row = tblMK.getSelectedRow();
        tfKodeMK.setText(tblMK.getValueAt(row, 0).toString());
        tfSKS.setText(tblMK.getValueAt(row, 1).toString());
        tfNamaMK.setText(tblMK.getValueAt(row, 2).toString());
        tfSmtAjar.setText(tblMK.getValueAt(row, 3).toString());
    }//GEN-LAST:event_tblMKMouseClicked

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        System.exit(0);

    }//GEN-LAST:event_btnKeluarActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/PBO_UTS", "postgres", " ");
            String sql = "select * from mata_kuliah";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            File alamat = new File(".");
            System.out.println(alamat.getCanonicalPath());
            //String dir = "/src/bayuJasper/";
            File jasperFile = new File(alamat.getCanonicalPath() + "/src/pbo_report/" + "Cetak.jrxml");
            JasperDesign jd = JRXmlLoader.load(jasperFile);
            JRResultSetDataSource jds = new JRResultSetDataSource(rs);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jr, new HashMap<String, Object>(), jds);
            //String jrxmlFile = "src/pbopertemuan6/mahasiswa.jrxml";
            //FileInputStream inputStream = new FileInputStream(jrxmlFile);
            //JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jr, new HashMap<String, Object>(), conn);
            //JasperPrint jp = (JasperPrint) JasperFillManager.fillReportToFile(jr, null, conn);
            JasperViewer.viewReport(jp);
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jr, new HashMap<String, Object>(), jds);
//            JasperExportManager.exportReportToPdfFile(jasperPrint, "output_path/report.pdf");
        } catch (SQLException ex) {
            Logger.getLogger(CRUDForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CRUDForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(CRUDForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCetakActionPerformed

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        // TODO add your handling code here:
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File filePilihan = jfc.getSelectedFile();
            System.out.println("yang dipilih : " + filePilihan.getAbsolutePath());

            try (BufferedReader br = new BufferedReader(new FileReader(filePilihan))) {
                Class.forName(driver);
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/PBO_UTS", "postgres", " ");
                String baris;
                String pemisah = ";";

                while ((baris = br.readLine()) != null) {
                    String[] data = baris.split(pemisah);
                    String KodeMK = data[0];
                    String SKS = data[1];
                    String NamaMK = data[2];
                    String SemesterAjar = data[3];

                    if (!KodeMK.isEmpty() && !SKS.isEmpty() && !NamaMK.isEmpty() && !SemesterAjar.isEmpty()) {
                        String sql = "INSERT INTO mata_kuliah (KodeMK, SKS, NamaMK, SemesterAjar) VALUES (?, ?, ?, ?)";
                        ps = cn.prepareStatement(sql);
                        ps.setString(1, KodeMK);
                        ps.setInt(2, Integer.parseInt(SKS));
                        ps.setString(3, NamaMK);
                        ps.setInt(4, Integer.parseInt(SemesterAjar));
                        ps.executeUpdate();
                    } else {
                        JOptionPane.showMessageDialog(null, "Gagal diinput");
                    }
                }
                JOptionPane.showMessageDialog(null, "Sukses diinput");
                loadData();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CRUDForm.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Gagal diinput");
            } catch (IOException ex) {
                Logger.getLogger(CRUDForm.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Gagal diinput");
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(CRUDForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnUploadActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CRUDForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUDForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUDForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUDForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUDForm().setVisible(true);
            }
        });
    }

    private void clearForm() {
        tfKodeMK.setText("");
        tfSKS.setText("");
        tfNamaMK.setText("");
        tfSmtAjar.setText("");

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpload;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMK;
    private javax.swing.JTextField tfKodeMK;
    private javax.swing.JTextField tfNamaMK;
    private javax.swing.JTextField tfSKS;
    private javax.swing.JTextField tfSmtAjar;
    // End of variables declaration//GEN-END:variables
}
