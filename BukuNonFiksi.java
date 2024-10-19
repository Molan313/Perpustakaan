public class BukuNonFiksi extends Buku{
    private String jenisBuku;
    private String bidangBuku;

    BukuNonFiksi(){
    };

    BukuNonFiksi(String nama, String nomor, String penulis, double harga, int qty, int halaman, boolean status, String jenis, String bidang){
        super(nama, nomor, penulis, harga, qty, halaman, status);
        this.jenisBuku = jenis;
        this.bidangBuku = bidang;
    }

    public String getJenisBuku(){
        return jenisBuku;
    }

    public void setJenisBuku(String jenis){
        this.jenisBuku = jenis;
    }

    public String getBidangBuku(){
        return bidangBuku;
    }

    public void setGenreBuku(String bidang){
        this.bidangBuku = bidang;
    }

    // buku nonfiksi dikenakan diskon 5%
    @Override
    public double getnilaiBuku(){
        return super.getnilaiBuku() - (super.getHargaBuku() * (5/100));
    }

    @Override
    public String toString(){
        return super.toString() + "\nJenis Buku\t: " + getJenisBuku() + "\nBidang Buku\t: " + getBidangBuku();
    }
}

