import java.util.ArrayList;
import java.util.List;

public class Penjualan {
    private Produk produk;
    private String tanggal;
    private int qty;
    private double diskon;
    private double totalBayar;
    private double jumlahUang;
    private List listTransaksi = new ArrayList();
    public Penjualan(){
    }
    public Penjualan(Produk produk, int qty){
        this.produk = produk;
        this.qty = qty;
    }
    public Penjualan(String tgl,int qty, double diskon, double totalBayar, double jumlahUang){
//        this.produk = produk;
        this.tanggal = tgl;
        this.qty = qty;
        this.diskon = diskon;
        this.totalBayar = totalBayar;
        this.jumlahUang = jumlahUang;
    }
    public void insertTransaksi(Produk produk, int qty){
        Penjualan transaksi = new Penjualan(produk,qty);
        listTransaksi.add(transaksi);
    }
    public void insertTransaksi(String tgl,int qty, double diskon, double totalBayar, double jumlahUang){
        Penjualan transaksi = new Penjualan(tgl,qty,diskon, totalBayar, jumlahUang);
        listTransaksi.add(transaksi);
    }
    public List allData(){
        return listTransaksi;
    }
    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getQty(){
        return qty;
    }
    public void setQty(int qty){
        this.qty = qty;
    }

    public double getDiskon() {
        return diskon;
    }

    public void setDiskon(double diskon) {
        this.diskon = diskon;
    }

    public double getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(double totalBayar) {
        this.totalBayar = totalBayar;
    }

    public double getJumlahUang() {
        return jumlahUang;
    }

    public void setJumlahUang(float jumlahUang) {
        this.jumlahUang = jumlahUang;
    }

    public Produk getProduk(){
        return produk;
    }
    public boolean cariTransaksi(List<Penjualan> transaksi, int id, int banyak){
        for (Penjualan tr : transaksi) {
            if (tr.getProduk().getId() == id) {
                tr.setQty(tr.getQty() + banyak);
                return true;
            }
        }
        return false;
    }
    public double total(int qty){
        return  qty * getProduk().getHarga();
    }
}
