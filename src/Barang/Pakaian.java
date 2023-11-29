// Pakaian.java
package Barang;

public class Pakaian extends Barang {
    private String kategori;

    public Pakaian(String kodeBarang, String namaBarang, int stok) {
        super(kodeBarang, namaBarang, stok);
        this.kategori = "Pakaian";
        uniqueCode();
    }

    @Override
    public void uniqueCode() {
        kodeBarang = "PK" + getKodeBarang();
    }

    @Override
    public void infoBarang() {
        System.out.println("Kode Barang : " + getKodeBarang() +
                "\nNama Barang : " + getNamaBarang() +
                "\nStok Barang : " + getStok() +
                "\nKategori Barang : " + kategori);
    }

    @Override
    public void kurangiStok(int jumlah) {
        // Implement logic specific to Pakaian
        this.stok -= jumlah;
    }
}
