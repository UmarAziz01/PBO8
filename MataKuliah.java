package pbo_upload;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class MataKuliah {

    private String KodeMK;
    private int SKS;
    private String NamaMK;
    private int SemesterAjar;

    public MataKuliah(String KodeMK, int SKS, String NamaMK, int SemesterAjar) {
        this.KodeMK = KodeMK;
        this.SKS = SKS;
        this.NamaMK = NamaMK;
        this.SemesterAjar = SemesterAjar;
    }

    /**
     * @return the KodeMK
     */
    public String getKodeMK() {
        return KodeMK;
    }

    /**
     * @param KodeMK the KodeMK to set
     */
    public void setKodeMK(String KodeMK) {
        this.KodeMK = KodeMK;
    }

    /**
     * @return the SKS
     */
    public int getSKS() {
        return SKS;
    }

    /**
     * @param SKS the SKS to set
     */
    public void setSKS(int SKS) {
        this.SKS = SKS;
    }

    /**
     * @return the NamaMK
     */
    public String getNamaMK() {
        return NamaMK;
    }

    /**
     * @param NamaMK the NamaMK to set
     */
    public void setNamaMK(String NamaMK) {
        this.NamaMK = NamaMK;
    }

    /**
     * @return the SemesterAjar
     */
    public int getSemesterAjar() {
        return SemesterAjar;
    }

    /**
     * @param SemesterAjar the SemesterAjar to set
     */
    public void setSemesterAjar(int SemesterAjar) {
        this.SemesterAjar = SemesterAjar;
    }
}
