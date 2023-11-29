// Dokumen.java
package Barang;

public class Dokumen extends Barang {
    private String kategori;

    public Dokumen(String kodeBarang, String namaBarang, int stok) {
        super(kodeBarang, namaBarang, stok);
        this.kategori = "Dokumen";
        uniqueCode();
    }

    @Override
    public void uniqueCode() {
        kodeBarang = "DK" + getKodeBarang();
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
        // Implement logic specific to Dokumen
        this.stok -= jumlah;
    }
}
