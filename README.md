# PBO8
Penugasan matakuliah pemrograman berorientasi obyek pertemuan kesebelas yakni membuat GUI yang dapat memasukkan data dari file berekstensi 'CSV' kedalam database dengan menambahkan satu tombol bernama upload dari project penugasan yang telah dibuat kemarin pada repositori berikut 

https://github.com/UmarAziz01/PBO7 

berikut langkah-langkahnya

- Menduplikat Project yang telah dibuat dahulu saat UTS dan mengubah namanya dari PBO_Report menjadi PBO_Upload, dengan cara klik kanan pada project PBO_Report sehingga muncul gambar kurang lebih seperti ini
  ![image](https://github.com/user-attachments/assets/23ace3f3-9ff6-4296-9d20-9246b001d383)
  ![image](https://github.com/user-attachments/assets/c8f84e6a-4408-434d-8043-1b5237af215d)

  Dan Klik “Copy” lalu setelah itu cari project dengan nama PBO_Upload dan klik copy lalu klik 2x untuk membuka project baru yang telah dibuat
  ![image](https://github.com/user-attachments/assets/52150f41-9646-48f2-9df1-83fb8b080e24)


- Lalu tambahkan /  import beberapa class bawaan java
```java
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
```

  - Tambahkan button baru ke frame yang dulu sudah dibuat dengan Nama Upload dan Variable btnUpload sehingga muncul seperti ini
    ![image](https://github.com/user-attachments/assets/42c357c1-d697-48a1-ad19-3383f3e20344)
    ![image](https://github.com/user-attachments/assets/cd01984c-a24a-4a78-a3b4-5f9b51015dc8)

  - Lalu Klik dua kali pada button yang baru saja dibuat lalu salin kode ini dan tempelkan pada kode anda

```java
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
```
    
  ![image](https://github.com/user-attachments/assets/f4d0269b-c89b-4e43-bba3-5c9794e16a96)


  - Lalu buat koneksi jika belum ada, jika sudah maka lewati saja

```java
//deklarasi koneksi
Connection cn;
    PreparedStatement ps;
    Statement st;
    String driver = "org.postgresql.Driver";
    String koneksi = "jdbc:postgresql://localhost:5432/PBO_UTS";
    String user = "postgres";
    String password = " ";
```

```java
try {
            Class.forName(driver);
            cn = DriverManager.getConnection(koneksi, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CRUDKu.class.getName()).log(Level.SEVERE, null, ex);
        }
```
  ![image](https://github.com/user-attachments/assets/89524130-8224-416c-9787-5e7445311aef)

  - Lakukan Clean and Build Porject
    ![image](https://github.com/user-attachments/assets/2002f304-00ef-4ce2-b9b5-5660611ed40b)

  - Jalankan program jika clean and build Berhasil
    ![image](https://github.com/user-attachments/assets/bf28ed9c-339e-4196-a0ed-d614513d20be)

  - Lalu klik button upload
    ![image](https://github.com/user-attachments/assets/7cb6734d-38ee-434b-bbe6-f54edf691f62)

  - Pilih file CSV yang berisi inputan ke database
    ![image](https://github.com/user-attachments/assets/bacfae7d-81df-47a7-8c15-4c366475a361)

  - Jika belum memiliki maka buka MS Excel
    
    ![image](https://github.com/user-attachments/assets/1585f2a0-1882-4074-8458-a847e7420527)
    
  - Pilih 'Blank workbook'
    
    ![image](https://github.com/user-attachments/assets/ee28d0fb-ea3b-48ce-bf0e-8c2305d29226)
    
  - Masukkan data seperti di gambar
    ![image](https://github.com/user-attachments/assets/c0fbebdb-4396-437a-9697-84ca82a69fcd)
    
  - Masukkan data sesuai format dari database yang telah dibuat agar tidak terjadi error
    ![image](https://github.com/user-attachments/assets/492b14d3-1fa0-4c7d-9ab1-d0b0c127c3ee)

  - lakukan export ke ekstensi CSV dan klik Save As
    ![image](https://github.com/user-attachments/assets/0c542d6a-ae74-45ce-838a-4d46d3720cde)

  - dan lakukan kembali langkah upload diatas, lalu klik open
    ![image](https://github.com/user-attachments/assets/418955df-6e4e-4594-8474-f2cb4eb79b92)

  - data baru anda telah masuk kedalam database
    
    ![image](https://github.com/user-attachments/assets/63e7283f-ca9f-4b43-83b2-3c11b299a8ae)
    ![image](https://github.com/user-attachments/assets/61e3ebef-ac11-4fff-acf0-33746695c63e)
    ![image](https://github.com/user-attachments/assets/ab9e4ac7-278a-4f73-82fc-a5263eca20b1)

  - Sekian Penjelasan singkat dari saya





























