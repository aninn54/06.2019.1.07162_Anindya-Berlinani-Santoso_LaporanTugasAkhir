package Entity;
public class DaftarPembeliEntity07162 {
    private PembeliEntity07162 pembeli; 
    private boolean isVerified;
    private int indexMakanan; 
     public DaftarPembeliEntity07162(int indexMakanan,
             PembeliEntity07162 pembeli, boolean isVerified) { 
         this.indexMakanan = indexMakanan;
        this.pembeli = pembeli;
        this.isVerified = isVerified;
    }
    public PembeliEntity07162 getPembeli() {
        return pembeli;
    }
    public boolean isIsVerified() {
        return isVerified;
    }
    public int getIndexMakanan() {
        return indexMakanan;
    }
    public void setPembeli(PembeliEntity07162 pembeli) {
        this.pembeli= pembeli;
    }
    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }
    public void setIndexMakanan(int indexMakanan) {
        this.indexMakanan = indexMakanan;
    }
}
