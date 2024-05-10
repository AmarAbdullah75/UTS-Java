import java.util.*;
public class DataProduk {
    private List listproduk = new ArrayList();

    public DataProduk(){
        this.listproduk = new ArrayList();
    }

    public List allData(){
        return listproduk;
    }

    public void insertData(int id,String nama, String deskripsi, float harga, int jumlah){
        Produk item = new Produk(id,nama,deskripsi,harga,jumlah);
        listproduk.add(item);
    }

    public Produk search(List<Produk> items, int id){
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id){
                return items.get(i);
            }
        }
        return null;
    }

    public Produk delete(List<Produk> items, int id){
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id){
                return items.remove(i);
            }
        }
        return null;
    }
}
