import java.util.Scanner;

public class Perpustakaan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int banyakBuku, opsi;

        banyakBuku = banyakTambahanBuku(in);

        if(banyakBuku == 0){
            System.out.println("Tidak ada buku yang ditambahkan");
        }
        else{
            Buku[] buku_buku= new Buku[banyakBuku];
            menambahBuku(banyakBuku, in, buku_buku);
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
                System.out.println("1. Informasi Buku\n2. Tambah buku\n3. Kurangi Buku\n4. Keluar");
                opsi = in.nextInt();
            }
            catch(Exception e){
                System.err.println("Opsi yang dimasukkan harus berupa angka");
            }
            if(opsi < 0 || opsi > 4){
                System.err.println("Pilih opsi sesuai menu");
            }
        }while(opsi < 0 || opsi > 4);

        return opsi;
    }

    public static void opsiMenu(int opsi, Buku[] listBuku, Scanner in){
        switch (opsi) {
            case 1:
                if(listBuku.length == 0 || listBuku == null ){
                    System.err.println("Tidak ada buku untuk ditampilkan");
                }
                else{
                    displayBuku(listBuku);
                }
                break;

            case 2:
                if(listBuku.length == 0 || listBuku == null ){
                    System.err.println("Tidak ada buku yang dapat ditambahkan");
                }
                else{
                    System.out.println("Menambah stok buku");
                    tambahStok(listBuku, in);
                }
                break;

            case 3:
                if(listBuku.length == 0 || listBuku == null){
                    System.out.println("Tidak ada buku yang dapat dikurangi");
                }
                else{
                    System.out.println("Mengurangi stok buku");
                    kurangiStok(listBuku, in);
                }
                break;

            case 4:
                System.out.println("Terimakasih telah berkunjung!");
                System.exit(4);
        
            default:
                System.out.println("Input tidak diterima, masukkan sesuai menu");
                menu(in);
                break;
        }

        if(opsi != 0){
            System.out.println("Tekan Enter untuk kembali ke menu");
            in.nextLine();
            in.nextLine();
        }
    }

    public static void displayBuku(Buku[] buku_buku){
        for(Buku b : buku_buku){
            System.out.println(b + "\n");
        }
    }

    public static int banyakTambahanBuku(Scanner in){
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
        return tambahanBuku;
    }

    public static void menambahBuku(int banyakBuku, Scanner in, Buku[] buku_buku){
        for(int i = 0; i < banyakBuku; i++){
            in.nextLine();
            int jumlahBuku = 0;
            int jumlahHalaman = 0;
            double hargaBuku = 0;
            boolean jenisSampul = false;
            
            System.out.println("\nMasukkan nomor buku ke-" + (i+1) + " ");
            String nomorBuku = in.nextLine();

            System.out.println("\nMasukkan nama buku ke-" + (i+1) + " ");
            String namaBuku = in.nextLine();

            System.out.println("\nMasukkan nama penulis buku ke-" + (i+1) + " ");
            String penulisBuku = in.nextLine();

            while(true){
                try{System.out.println("\nMasukkan harga buku ke-" + (i+1) + " ");
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
                try{System.out.println("\nMasukkan jumlah buku ke-" + (i+1) + " ");
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
                try{System.out.println("\nMasukkan jumlah halaman dari buku ke-" + (i+1) + " ");
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
                try{System.out.println("\nMasukkan jenis sampul dari buku ke-" + (i+1) + "\nInput berupa true untuk sampul yang hardcover dan false untuk sampul yang softcover ");
                jenisSampul = in.nextBoolean();
                break;
            }
                catch(Exception e){
                    System.err.println("Masukkan tipe data yang benar. Input harus berupa true untuk sampul hardcover atau false untuk sampul yang softcover");
                    in.next();
                }           
            }
        buku_buku[i] = new Buku(namaBuku, nomorBuku, penulisBuku, hargaBuku, jumlahBuku, jumlahHalaman, jenisSampul); 
        }
    }

    public static int nomorBuku(Buku[] buku_buku, Scanner in){
        int nomorBuku = -1;
        System.out.println("Pilih buku yang ingin diperbarui ");
        for(int i = 0; i< buku_buku.length; i++){
            System.out.println((i+1) + ". " + buku_buku[i].getNamaBuku());
        }

        do{
            try{
                System.out.println("Masukkan nomor buku dari 1 sampai "+ buku_buku.length + " ");
                nomorBuku = in.nextInt();
                if(nomorBuku < 1 || nomorBuku > buku_buku.length){
                    System.err.println("Masukkan sesuai nomor yang ada");
                }
            }
            catch(Exception e){
                System.err.println("Masukkan harus berupa angka");
                in.next();
            }

        }while(nomorBuku < 1 || nomorBuku > buku_buku.length);

        return nomorBuku - 1;
    }

    public static void tambahStok(Buku[] buku_buku, Scanner in){
        int nomorBuku= nomorBuku(buku_buku, in);
        int jumlahBaru =-1 ;
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
        
        buku_buku[nomorBuku].TambahBuku(jumlahBaru);
    }

    public static void kurangiStok(Buku[] buku_buku, Scanner in){
        int nomorBuku = nomorBuku(buku_buku, in);
        int jumlahBaru = -1;
        do{
            try{
                System.out.println("Banyak stok yang dikurangi\t: ");
                jumlahBaru = in.nextInt();
                if (jumlahBaru < 0 || jumlahBaru > buku_buku[nomorBuku].getJumlahBuku()){
                    System.err.println("Jumlah tidak boleh kurang dari 0 dan tidak boleh melebih stok, stok "+ buku_buku[nomorBuku].getJumlahBuku());
                }
            }
            catch(Exception e){
                System.err.println("Input harus berupa angka");
                in.next();
            }
        }while(jumlahBaru < 0 || jumlahBaru > buku_buku[nomorBuku].getJumlahBuku());

        buku_buku[nomorBuku].KurangBuku(jumlahBaru);
    }

}
