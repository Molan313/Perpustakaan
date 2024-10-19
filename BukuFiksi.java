public class BukuFiksi extends Buku{
    private String jenisBuku;
    private String genreBuku;
    private boolean progresCerita = true;


    BukuFiksi(String nama, String nomor, String penulis, double harga, int qty, int halaman, boolean status, String jenis, String genre, boolean progres){
        super(nama, nomor, penulis, harga, qty, halaman, status);
        this.jenisBuku = jenis;
        this.genreBuku = genre;
        this.progresCerita = progres;
    }

    public String getJenisBuku(){
        return jenisBuku;
    }

    public void setJenisBuku(String jenis){
        this.jenisBuku = jenis;
    }

    public String getGenreBuku(){
        return genreBuku;
    }

    public void setGenreBuku(String genre){
        this.genreBuku = genre;
    }

    public boolean getProgresBuku(){
        return progresCerita;
    }

    public void setStatusBuku(boolean progres){
        this.progresCerita = progres;
    }

    @Override
    public String toString(){
        String progres = getProgresBuku()?"Tamat":"On Going";
        return super.toString() + "\nJenis Buku\t: " + getJenisBuku() + "\nGenre Buku\t: " + getGenreBuku() + "\nProgres Cerita\t: " + progres;
    }
}
