import java.text.DecimalFormat;
public class Buku{
    // memberikan properti dari buku
    private String namaBuku;
    private String nomorBuku;
    private String penulisBuku;
    private double hargaBuku;
    private int jumlahBuku;
    private int jumlahHalaman;
    private boolean statusBuku = true;
    private double nilaiBuku;
    private static final DecimalFormat df = new DecimalFormat("#,###.00");

    // membuat constructor buku
    Buku(){};
    Buku(String nama, String nomor, String penulis, double harga, int qty, int halaman, boolean status){
        this.namaBuku = nama;
        this.nomorBuku = nomor;
        this.penulisBuku = penulis;
        this.hargaBuku = harga;
        this.jumlahBuku = qty;
        this.statusBuku = status;
        this.jumlahHalaman = halaman;
    }

    public String getNamaBuku(){
        return namaBuku;
    }

    public void setNamaBuku(String nama){
        this.namaBuku = nama;
    }

    public String getNomorBuku(){
        return nomorBuku;
    }

    public void setNomorBuku(String nomor){
        this.nomorBuku = nomor;
    }

    public String getPenulisBuku(){
        return penulisBuku;
    }

    public void setPenulisBuku(String penulis){
        this.penulisBuku = penulis;
    }

    public int getJumlahBuku(){
        return jumlahBuku;
    }

    public void setJumlahBuku(int qty){
        this.jumlahBuku = qty;
    }

    public int getHalamanBuku(){
        return jumlahHalaman;
    }

    public void setHalamanBuku(int halaman){
        this.jumlahHalaman = halaman;
    }
    public boolean getStatusBuku(){
        return statusBuku;
    }

    public void setStatusBuku(boolean jenis){
        this.statusBuku = jenis;
    }

    public double getHargaBuku(){
        return hargaBuku;
    }

    public void setHargaBuku(double harga){
        this.hargaBuku = harga;
    }

    public double getnilaiBuku(){
        this.nilaiBuku = this.hargaBuku * this.jumlahBuku;
        return (nilaiBuku); 
    }

    public void TambahBuku(int quantity){
        if(quantity > 0){
            jumlahBuku += quantity;
            System.out.println("Jumlah buku telah ditambahkan sebanyak " + quantity + " total buku saat ini " + jumlahBuku);
        }
        else{
            System.err.println("Jumlah buku harus lebih dari 0");
        }
    }

    public void KurangBuku(int quantity){
        if(quantity > 0){
            if(quantity > jumlahBuku){
                System.err.println("Jumlah buku yang ingin dikurangi tidak boleh lebih jumlah buku yang tersedia");
            }
            else{
                jumlahBuku -= quantity;
                System.out.println("Jumlah buku telah dikurangi sebanyak " + quantity + " total buku saat ini " + jumlahBuku);
            }
        }
        else{
            System.err.println("Jumlah buku harus lebih dari 0");
        }
    }

    @Override
    public String toString(){
        String buku = "";
        String status = getStatusBuku() ? "Aktif" : "Nonaktif";
        buku = "Informasi Buku\n" + "Nomor Buku\t: " + getNomorBuku() + "\nNama Buku\t: " + getNamaBuku() + "\nPenulis Buku\t: " + getPenulisBuku() + "\nHarga Buku\t: Rp " + df.format(getHargaBuku()) + "\nJumlah Buku\t: " + getJumlahBuku() + "\nJumlah Halaman\t: "+ getHalamanBuku() +" Halaman\nStatus Buku\t: " + status + "\nNilai Buku\t: Rp" + df.format(getnilaiBuku());
        return buku;
    };

}