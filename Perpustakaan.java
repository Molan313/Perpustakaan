import java.util.Scanner;
import java.util.ArrayList;

public class Perpustakaan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int opsi;
        ArrayList<Buku> buku_buku = new ArrayList<>();

        banyakTambahanBuku(in, buku_buku);

        if(buku_buku.isEmpty()){
            System.out.println("Tidak ada buku yang ditambahkan");
        }
        else{
            do{
                opsi = menu(in);
                opsiMenu(opsi, buku_buku, in);
            }while(opsi != 0);
        }

        in.close();
    }

    public static int menu(Scanner in){
        int opsi = -1;
        do{
            try{
                System.out.println("Selamat Datang di Perpustakaan!!");
                System.out.println("Pilih menu");
                System.out.println("1. Tambah Buku\n2. Informasi buku\n3. Tambah stok buku\n4. Kurangi stok Buku\n5. Keluar");
                opsi = in.nextInt();
            }
            catch(Exception e){
                System.err.println("Opsi yang dimasukkan harus berupa angka");
                in.next();
            }
            if(opsi < 0 || opsi > 5){
                System.err.println("Pilih opsi sesuai menu");
            }
        }while(opsi < 0 || opsi > 5);

        return opsi;
    }

    public static void opsiMenu(int opsi, ArrayList<Buku> listBuku, Scanner in){
        switch (opsi) {
            case 1:
                banyakTambahanBuku(in, listBuku);
                break;
            case 2:
                if(listBuku.isEmpty()){
                    System.err.println("Tidak ada buku untuk ditampilkan");
                }
                else{
                    displayBuku(listBuku);
                }
                break;

            case 3:
                if(listBuku.isEmpty()){
                    System.err.println("Tidak ada buku yang dapat ditambahkan");
                }
                else{
                    System.out.println("Menambah stok buku");
                    tambahStok(listBuku, in);
                }
                break;

            case 4:
                if(listBuku.isEmpty()){
                    System.out.println("Tidak ada buku yang dapat dikurangi");
                }
                else{
                    System.out.println("Mengurangi stok buku");
                    kurangiStok(listBuku, in);
                }
                break;

            case 5:
                System.out.println("Terimakasih telah berkunjung!");
                System.exit(5);
        
            default:
                System.out.println("Input tidak diterima, masukkan sesuai menu");
                menu(in);
                break;
        }

        if(opsi != 5){
            System.out.println("Tekan Enter untuk kembali ke menu");
            in.nextLine();
            in.nextLine();
        }
    }

    public static void displayBuku(ArrayList<Buku> buku_buku){
        for(Buku b : buku_buku){
            System.out.println(b + "\n");
        }
    }

    public static void banyakTambahanBuku(Scanner in, ArrayList<Buku> buku_buku){
        int tambahanBuku = -1;
        do{
            try{
                System.out.println("Banyak buku yang akan ditambah ke perpustakaan: ");
                tambahanBuku = in.nextInt();
                if(tambahanBuku < 0){
                    System.out.println("Angka yang diinputkan tidak boleh negatif");
                }
            }
            catch(Exception e){
                System.err.println("Tipe data yang anda masukkan salah, masukkan input berupa angka");
                in.next();
            }
        }while(tambahanBuku < 0);
        if(tambahanBuku > 0){
            menambahBuku(tambahanBuku, in, buku_buku);
        }
    }

    public static void menambahBuku(int banyakBuku, Scanner in, ArrayList<Buku> buku_buku){
        int opsiBuku = 0;
        do{
            System.out.println("Pilih buku yang ingin ditambahkan: ");
            try{
                System.out.println("1. Buku Fiksi\n2. Buku NonFiksi");
                opsiBuku = in.nextInt();
                if(opsiBuku < 1 || opsiBuku > 2){
                    System.out.println("Input hanya boleh antara 1 dan 2");
                }
            }
            catch(Exception e){
                System.out.println("Input harus berupa angka");
                in.next();
            }

        }while(opsiBuku < 1 || opsiBuku > 2);

        switch (opsiBuku) {
            case 1:
                menambahBukuFiksi(banyakBuku, in, buku_buku);
                break;
            case 2:
                menambahBukuNonFiksi(banyakBuku, in, buku_buku);
                break;

            default:
                System.out.println("Input tidak diterima, masukkan sesuai pilihan");
                menambahBuku(banyakBuku, in, buku_buku);
                break;
        }
        
    }

    public static void menambahBukuFiksi(int banyakBuku, Scanner in, ArrayList<Buku> buku_buku){
        for(int i = 0; i < banyakBuku; i++){
            in.nextLine();
            int jumlahBuku = 0;
            int jumlahHalaman = 0;
            double hargaBuku = 0;
            boolean statusBuku = false;
            boolean progresCerita = false;
            
            System.out.println("\nMasukkan nomor Buku Fiksi ke-" + (i+1) + " ");
            String nomorBuku = in.nextLine();

            System.out.println("\nMasukkan Nama Buku Fiksi ke-" + (i+1) + " ");
            String namaBuku = in.nextLine();

            System.out.println("\nMasukkan nama penulis Buku Fiksi ke-" + (i+1) + " ");
            String penulisBuku = in.nextLine();

            System.out.println("\nMasukkan Jenis Buku Fiksi ke-" + (i+1) + " ");
            String jenisBuku = in.nextLine();

            System.out.println("\nMasukkan Genre Buku Fiksi ke-" + (i+1) + " ");
            String genreBuku = in.nextLine();

            while(true){
                try{System.out.println("\nMasukkan harga Buku Fiksi ke-" + (i+1) + " ");
                hargaBuku = in.nextDouble();
                if (hargaBuku < 0) {
                    System.out.println("Harga Buku tidak boleh kurang dari 0");
                }
                else{
                    break;
                }
            }
                catch(Exception e){
                    System.err.println("Masukkan tipe data yang benar. Input harus berupa angka");
                    in.next();
                }
            }

            while(true){
                try{System.out.println("\nMasukkan jumlah Buku Fiksi ke-" + (i+1) + " ");
                jumlahBuku = in.nextInt();
                if (jumlahBuku < 0) {
                    System.out.println("Jumlah Buku tidak boleh kurang dari 0");
                }
                else{
                    break;
                }
            }
                catch(Exception e){
                    System.err.println("Masukkan tipe data yang benar. Input harus berupa angka");
                    in.next();
                }
            }

            while (true) {
                try{System.out.println("\nMasukkan jumlah halaman dari Buku Fiksi ke-" + (i+1) + " ");
                jumlahHalaman = in.nextInt();
                if (jumlahHalaman < 0) {
                    System.out.println("Jumlah Halaman Buku tidak boleh kurang dari 0");
                }
                else{
                    break;
                }
            }
                catch(Exception e){
                    System.err.println("Masukkan tipe data yang benar. Input harus berupa angka");
                    in.next();
                }           
            }

            while (true) {
                try{System.out.println("\nMasukkan status dari Buku Fiksi ke-" + (i+1) + "\n(Input berupa true untuk buku yang masih diproduksi dan false untuk buku yang sudah tidak diproduksi)");
                statusBuku = in.nextBoolean();
                break;
            }
                catch(Exception e){
                    System.err.println("Masukkan tipe data yang benar. Input harus berupa true untuk buku yang masih diproduksi atau false untuk buku yang sudah tidak diproduksi");
                    in.next();
                }           
            }

            while (true) {
                try{System.out.println("\nMasukkan progres dari Buku Fiksi ke-" + (i+1) + "\n(Input berupa true untuk buku yang telah tamat dan false buku series yang masih on going)");
                statusBuku = in.nextBoolean();
                break;
            }
                catch(Exception e){
                    System.err.println("Masukkan tipe data yang benar. Input harus berupa true untuk buku yang telah tamat atau false untuk buku series yang masih on going");
                    in.next();
                }           
            }
        buku_buku.add(new BukuFiksi(namaBuku, nomorBuku, penulisBuku, hargaBuku, jumlahBuku, jumlahHalaman, statusBuku, jenisBuku, genreBuku, progresCerita)); 
        }
    }

    public static void menambahBukuNonFiksi(int banyakBuku, Scanner in, ArrayList<Buku> buku_buku){
        for(int i = 0; i < banyakBuku; i++){
            in.nextLine();
            int jumlahBuku = 0;
            int jumlahHalaman = 0;
            double hargaBuku = 0;
            boolean statusBuku = false;

            System.out.println("\nMasukkan nomor Buku NonFiksi ke-" + (i+1) + " ");
            String nomorBuku = in.nextLine();

            System.out.println("\nMasukkan Nama Buku NonFiksi ke-" + (i+1) + " ");
            String namaBuku = in.nextLine();

            System.out.println("\nMasukkan nama penulis Buku NonFiksi ke-" + (i+1) + " ");
            String penulisBuku = in.nextLine();

            System.out.println("\nMasukkan Jenis Buku NonFiksi ke-" + (i+1) + " ");
            String jenisBuku = in.nextLine();

            System.out.println("\nMasukkan Bidang Keilmuan Buku NonFiksi ke-" + (i+1) + " ");
            String bidangBuku = in.nextLine();

            while(true){
                try{System.out.println("\nMasukkan harga Buku NonFiksi ke-" + (i+1) + " ");
                hargaBuku = in.nextDouble();
                if (hargaBuku < 0) {
                    System.out.println("Harga Buku tidak boleh kurang dari 0");
                }
                else{
                    break;
                }
            }
                catch(Exception e){
                    System.err.println("Masukkan tipe data yang benar. Input harus berupa angka");
                    in.next();
                }
            }

            while(true){
                try{System.out.println("\nMasukkan jumlah Buku NonFiksi ke-" + (i+1) + " ");
                jumlahBuku = in.nextInt();
                if (jumlahBuku < 0) {
                    System.out.println("Jumlah Buku tidak boleh kurang dari 0");
                }
                else{
                    break;
                }
            }
                catch(Exception e){
                    System.err.println("Masukkan tipe data yang benar. Input harus berupa angka");
                    in.next();
                }
            }

            while (true) {
                try{System.out.println("\nMasukkan jumlah halaman dari Buku NonFiksi ke-" + (i+1) + " ");
                jumlahHalaman = in.nextInt();
                if (jumlahHalaman < 0) {
                    System.out.println("Jumlah Halaman Buku tidak boleh kurang dari 0");
                }
                else{
                    break;
                }
            }
                catch(Exception e){
                    System.err.println("Masukkan tipe data yang benar. Input harus berupa angka");
                    in.next();
                }           
            }

            while (true) {
                try{System.out.println("\nMasukkan status dari Buku NonFiksi ke-" + (i+1) + "\n(Input berupa true untuk buku yang masih diproduksi dan false untuk buku yang sudah tidak diproduksi)");
                statusBuku = in.nextBoolean();
                break;
            }
                catch(Exception e){
                    System.err.println("Masukkan tipe data yang benar. Input harus berupa true untuk buku yang masih diproduksi atau false untuk buku yang sudah tidak diproduksi");
                    in.next();
                }           
            }

        buku_buku.add(new BukuNonFiksi(namaBuku, nomorBuku, penulisBuku, hargaBuku, jumlahBuku, jumlahHalaman, statusBuku, jenisBuku, bidangBuku)); 
        }
    }

    public static int nomorBuku(ArrayList<Buku> buku_buku, Scanner in){
        int nomorBuku = -1;
        System.out.println("Pilih buku yang ingin diperbarui ");
        for(int i = 0; i< buku_buku.size(); i++){
            System.out.println((i+1) + ". " + buku_buku.get(i).getNamaBuku());
        }

        do{
            try{
                System.out.println("Masukkan nomor buku dari 1 sampai "+ buku_buku.size() + " ");
                nomorBuku = in.nextInt();
                if(nomorBuku < 1 || nomorBuku > buku_buku.size()){
                    System.err.println("Masukkan sesuai nomor yang ada");
                }
            }
            catch(Exception e){
                System.err.println("Masukkan harus berupa angka");
                in.next();
            }

        }while(nomorBuku < 1 || nomorBuku > buku_buku.size());

        return nomorBuku - 1;
    }

    public static void tambahStok(ArrayList<Buku> buku_buku, Scanner in){
        int nomorBuku= nomorBuku(buku_buku, in);
        int jumlahBaru =-1 ;
        if (!buku_buku.get(nomorBuku).getStatusBuku()){
            System.err.println("Stok buku tidak dapat ditambahkan karena buku ini sudah tidak diproduksi");
            nomorBuku(buku_buku, in);
        }
        else{
            do{
                try{
                    System.out.println("Banyak stok yang ditambahkan\t: ");
                    jumlahBaru = in.nextInt();
                    if(jumlahBaru < 0){
                        System.err.println("Tambahan tidak boleh kurang dari 0");
                    }
                }
                catch(Exception e){
                    System.err.println("Input harus berupa angka");
                    in.next();
                }
            }while(jumlahBaru < 0);
            buku_buku.get(nomorBuku).TambahBuku(jumlahBaru); 
        }
    }

    public static void kurangiStok(ArrayList<Buku> buku_buku, Scanner in){
        int nomorBuku = nomorBuku(buku_buku, in);
        int jumlahBaru = -1;
        do{
            try{
                System.out.println("Banyak stok yang dikurangi\t: ");
                jumlahBaru = in.nextInt();
                if (jumlahBaru < 0 || jumlahBaru > buku_buku.get(nomorBuku).getJumlahBuku()){
                    System.err.println("Jumlah tidak boleh kurang dari 0 dan tidak boleh melebih stok, stok "+ buku_buku.get(nomorBuku).getJumlahBuku());
                }
            }
            catch(Exception e){
                System.err.println("Input harus berupa angka");
                in.next();
            }
        }while(jumlahBaru < 0 || jumlahBaru > buku_buku.get(nomorBuku).getJumlahBuku());

        buku_buku.get(nomorBuku).KurangBuku(jumlahBaru);
    }
}
