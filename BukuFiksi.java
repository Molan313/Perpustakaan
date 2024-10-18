public class BukuFiksi extends Buku{
    private String jenisBuku;
    private String genreBuku;
    private boolean statusBuku = true;

    BukuFiksi(){
    };

    BukuFiksi(String nama, String nomor, String penulis, double harga, int qty, int halaman, boolean sampul, String jenis, String genre, boolean Status){
        super(nama, nomor, penulis, harga, qty, halaman, sampul);
        this.jenisBuku = jenis;
        this.genreBuku = genre;
        this.statusBuku = Status;
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

    public boolean getStatusBuku(){
        return statusBuku;
    }

    public void setStatusBuku(boolean status){
        this.statusBuku = status;
    }

    @Override
    public String toString(){
        String status = getStatusBuku()?"On Going":"Tamat";
        return super.toString() + "Jenis Buku\t: " + getJenisBuku() + "\nGenre Buku\t: " + getGenreBuku() + "\nStatus Buku\t: " + status;
    }
}
