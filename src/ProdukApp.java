import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ProdukApp {
    List<Penjualan> transaksi = new ArrayList<>();
    Scanner set = new Scanner(System.in);
    DataProduk data = new DataProduk();
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        ProdukApp produk = new ProdukApp();
        produk.menu();
    }

    public void menu() {
        System.out.println("=================================================");
        System.out.println("Istana Furniture");
        System.out.println("=================================================");
        System.out.println("1. Kelola Produk");
        System.out.println("2. Transaksi");
        System.out.println("3. Lihat Transaksi");
        System.out.print("Pilih Menu:");
        System.out.println("=================================================");
        int x = set.nextInt();
        choiceMenu(x);
    }

    public void choiceMenu(int a) {
        switch (a) {
            case 1:
                set.nextLine();
                kelolaProduk();
                break;
            case 2:
                set.nextLine();
                transaksi();
                break;
            case 3:
                set.nextLine();
                lihatTransaksi();
                break;
        }
    }

    public void kelolaProduk() {
        System.out.println("=================================================");
        System.out.println("Kelola Produk - Istana Furniture");
        System.out.println("=================================================");
        System.out.println("1. Tambah Produk Baru");
        System.out.println("2. Lihat Daftar produk");
        System.out.println("3. Kembali");
        System.out.print("Pilih Menu:");
        System.out.println("=================================================");
        int x = set.nextInt();
        menukelolaProduk(x);
        set.nextLine();
    }

    public void menukelolaProduk(int a) {
        switch (a) {
            case 1:
                set.nextLine();
                addproduk();
                break;
            case 2:
                set.nextLine();
                readProduk();
                break;
            case 3:
                set.nextLine();
                menu();
                break;
        }
    }

    public void addproduk() {
        Produk produk = new Produk();
        System.out.println("Tambah Produk Baru");
        System.out.print("ID Produk:");
        produk.setId(set.nextInt());
        set.nextLine();
        System.out.print("Nama Produk:");
        produk.setNama(set.nextLine());
        System.out.print("Jumlah Produk:");
        produk.setJumlah(set.nextInt());
        System.out.print("Harga Produk:");
        produk.setHarga(set.nextFloat());
        set.nextLine();
        System.out.print("Deskripsi:");
        produk.setDeskripsi(set.nextLine());
        data.insertData(produk.getId(), produk.getNama(), produk.getDeskripsi(), produk.getHarga(), produk.getJumlah());
        kelolaProduk();
    }

    public void readProduk() {
        List listItem = new ArrayList();
        listItem = data.allData();
        System.out.println("ID Produk ---   Nama Produk               --- Jumlah ---  Harga           ---    Deskripsi");
        for (int i = 0; i < listItem.size(); i++) {
            Produk prd = (Produk) listItem.get(i);
            System.out.printf("      %d ---  %-15s  --- %d unit ---  Rp %.1f   ---   %s\n", prd.getId(), prd.getNama(), prd.getJumlah(), prd.getHarga(), prd.getDeskripsi());
        }
        System.out.println("\nKetik U untuk mengubah data produk");
        System.out.println("Ketik H untuk menghapus data produk");
        System.out.println("Ketik K untuk kembali ke menu");
        char ch = set.nextLine().charAt(0);
        if (ch == 'H' || ch == 'h') {
            deleteProduk(listItem);
        } else if (ch == 'U' || ch == 'u') {
            updateProduk(listItem);
        } else if (ch == 'K' || ch == 'k') {
            kelolaProduk();
        }
    }

    public void updateProduk(List prd) {
        DataProduk dataProduk = new DataProduk();
        boolean status = false;
        Produk produk = new Produk();
        System.out.println("Cari Produk");
        System.out.print("Masukkan ID:");
        int id = set.nextInt();
        produk = dataProduk.search(prd, id);
        if (produk != null) {
            status = true;
        } else {
            System.out.println("Data tidak ditemukan");
        }
        if (status) {
            System.out.println("ID Produk ---   Nama Produk               --- Jumlah ---  Harga           ---    Deskripsi");
            System.out.printf("      %d ---  %-15s  --- %d unit ---  Rp %.1f   ---   %s", produk.getId(), produk.getNama(), produk.getJumlah(), produk.getHarga(), produk.getDeskripsi());
            System.out.println("Ubah Produk");
            System.out.print("ID Produk:");
            produk.setId(set.nextInt());
            set.nextLine();
            System.out.print("Nama Produk:");
            produk.setNama(set.nextLine());
            System.out.print("Jumlah Produk:");
            produk.setJumlah(set.nextInt());
            System.out.print("Harga Produk:");
            produk.setHarga(set.nextFloat());
            set.nextLine();
            System.out.print("Deskripsi:");
            produk.setDeskripsi(set.nextLine());
            kelolaProduk();
        }
    }
    public void deleteProduk(List prd) {
        DataProduk dataProduk = new DataProduk();
        boolean status = false;
        Produk produk = new Produk();
        System.out.println("Cari Produk");
        System.out.print("Masukkan ID:");
        int id = set.nextInt();
        set.nextLine();
        produk = dataProduk.search(prd, id);
        if (produk != null) {
            status = true;
        } else {
            System.out.println("Data tidak ditemukan");
        }
        if (status) {
            System.out.println("ID Produk ---   Nama Produk               --- Jumlah ---  Harga           ---    Deskripsi");
            System.out.printf("      %d ---  %-15s  --- %d unit ---  Rp %.1f   ---   %s", produk.getId(), produk.getNama(), produk.getJumlah(), produk.getHarga(), produk.getDeskripsi());
            System.out.println("Hapus Produk");
            System.out.println("Anda Yakin [Y/T]?");
            char ch = set.nextLine().charAt(0);
            if (ch == 'Y' || ch == 'y') {
                dataProduk.delete(prd, id);
                kelolaProduk();
            } else if (ch == 'T' || ch == 't') {
                kelolaProduk();
            }
        }
    }

    public void transaksi() {
        int total = 0;
        double diskon = 0;
        double totalHarga = 0;
        double totalBayar = 0;
        System.out.println("Beli Produk - Istana Feature");
        List listItem = new ArrayList();
        Produk produk = new Produk();
        DataProduk dataProduk = new DataProduk();
        listItem = data.allData();
        Penjualan itemTrs = new Penjualan();

        System.out.println("ID Produk ---   Nama Produk               --- Jumlah ---  Harga           ---    Deskripsi");
        for (int i = 0; i < listItem.size(); i++) {
            Produk prd = (Produk) listItem.get(i);
            System.out.printf("      %d ---  %-15s  --- %d unit ---  Rp %.1f   ---   %s\n", prd.getId(), prd.getNama(), prd.getJumlah(), prd.getHarga(), prd.getDeskripsi());
        }
        boolean status = false;
        while (!status) {
            int id = 0;
            while (!status) {
                System.out.print("Masukkan ID Produk = ");
                id = set.nextInt();
                produk = dataProduk.search(listItem, id);
                if (produk != null) {
                    status = true;
                } else {
                    System.out.println("Item tidak ditemukan! Silakan pilih item lain...");
                }
            }
            status = false;
            System.out.print("Masukkan Jumlah Produk = ");
            int julh = set.nextInt();
            if (julh > produk.getJumlah()) {
                System.out.println("Stok item tidak mencukupi! Silakan pilih item lain...");
                julh = 0;
            } else {
                status = true;
                produk.setJumlah(produk.getJumlah() - julh);
            }
            set.nextLine();
            System.out.print("Selesai[y/n]?");
            char ah = set.nextLine().charAt(0);
            total += julh;
            set.nextLine();
            totalHarga += produk.getHarga() * julh;
            if (ah == 'Y' || ah == 'y') {
                System.out.println("Total Harga = " + totalHarga);
                if (totalHarga > 2500000.0 && totalHarga <= 5000000.0) {
                    System.out.println("Selamat Anda mendapatkan diskon sebesar 5%");
                    totalBayar = totalHarga - (totalHarga * (5.0 / 100));
                    diskon = 5.0;
                } else if (totalHarga > 5000000.0 && totalHarga <= 10000000.0) {
                    System.out.println("Selamat Anda mendapatkan diskon sebesar 15%");
                    totalBayar = totalHarga - (totalHarga * (15.0 / 100));
                    diskon = 15.0;
                } else if (totalHarga > 10000000) {
                    System.out.println("Selamat Anda mendapatkan diskon sebesar 20%");
                    totalBayar = totalHarga - (totalHarga * (20.0 / 100));
                    diskon = 20.0;
                } else {
                    totalBayar = totalHarga;
                }
                System.out.println("Total Bayar = " + totalBayar);
                System.out.print("Jumlah Uang = ");
                double julamhUang = set.nextDouble();
                System.out.println("Kembalian = " + (julamhUang - totalBayar));
                LocalDate now = LocalDate.now();
                Date tanggal = new Date();
//                SimpleDateFormat format = new SimpleDateFormat(f)
                String tgl  = " ";
                transaksi.add(new Penjualan(tgl, total, diskon, totalBayar, julamhUang));
                set.nextLine();
                System.out.print("Lanjut[y/n]?");
                char df = set.nextLine().charAt(0);
                if (df == 'Y' || df == 'y') {
                    menu();
                } else if (df == 'N' || df == 'n') {
                    System.exit(0);
                }
            } else if (ah == 'N' || ah == 'n') {
                status = false;
            }
        }
    }

    public void lihatTransaksi() {
        System.out.println("=========================================================");
        System.out.println("Tanggal  ---  Jumlah Item   --- Diskon --- Total Bayar   ---  Jumlah uang    --- Kembalian");
        Penjualan trs1 = new Penjualan();
        for (int j = 0; j < transaksi.size(); j++) {
            trs1 = transaksi.get(j);
            System.out.printf("   %s     --- %-5d unit          ---  %.1f    %.1f    %.1f   %.1f\n",
                    trs1.getTanggal(), trs1.getQty(), trs1.getDiskon(), trs1.getTotalBayar(), trs1.getJumlahUang(), trs1.getJumlahUang() - trs1.getTotalBayar());
        }
        System.out.print("Filter berdasarkan tanggal ?[y]");
        char df = set.nextLine().charAt(0);
        if (df == 'Y' || df == 'y') {
            System.out.print("Masukkan tanggal: ");
            String tgl = set.nextLine();
            System.out.println("Tanggal  ---  Jumlah Item   --- Diskon --- Total Bayar   ---  Jumlah uang    --- Kembalian");
            for (int j = 0; j < transaksi.size(); j++) {
//                trs1 = transaksi.get(j);
//                if (tgl.equals(trs1.getTanggal())) {
//                    System.out.printf("   %s     --- %-5d unit          ---  %.1f    %.1f    %.1f   %.1f\n",
//                            trs1.getTanggal(), trs1.getQty(), trs1.getDiskon(), trs1.getTotalBayar(), trs1.getJumlahUang(), trs1.getJumlahUang() - trs1.getTotalBayar());
//                }
            }
        } else if (df == 'N' || df == 'n') {
            menu();
        }
    }
}
