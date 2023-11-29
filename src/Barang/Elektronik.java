// Elektronik.java
package Barang;

public class Elektronik extends Barang {
    private String kategori;

    public Elektronik(String kodeBarang, String namaBarang, int stok) {
        super(kodeBarang, namaBarang, stok);
        this.kategori = "Elektronik";
        uniqueCode();
    }

    @Override
    public void uniqueCode() {
        kodeBarang = "EL" + getKodeBarang();
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
        // Implement logic specific to Elektronik
        this.stok -= jumlah;
    }
}
