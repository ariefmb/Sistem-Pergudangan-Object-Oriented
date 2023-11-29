// BahanMakanan.java
package Barang;

public class BahanMakanan extends Barang {
    private String kategori;

    public BahanMakanan(String kodeBarang, String namaBarang, int stok) {
        super(kodeBarang, namaBarang, stok);
        this.kategori = "Bahan Makanan";
        uniqueCode();
    }

    @Override
    public void uniqueCode() {
        kodeBarang = "BM" + getKodeBarang();
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
        // Implement logic specific to BahanMakanan
        this.stok -= jumlah;
    }
}
