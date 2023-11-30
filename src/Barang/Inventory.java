package Barang;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<Barang> daftarBarang;
    public Inventory() {
        daftarBarang = new ArrayList<>();
    }
    public void terimaBarang(Barang barang) {
        daftarBarang.add(barang);
    }
    public void kurangiBarang(Barang barang, boolean isRent, int jumlah) {
        if (isRent == true) {
            barang.kurangiStok(jumlah);
        } else {
            daftarBarang.remove(barang);
        }
    }

    public Barang cariBarang(String kodeBarang) {
        for (Barang barang : daftarBarang) {
            if (barang.getKodeBarang().equals(kodeBarang)) {
                return barang;
            }
        }
        return null;
    }
    public void tandaTerimaBarang(Barang barang) {
        System.out.println("=====TANDA TERIMA BARANG=====");
        try {
            System.out.println(barang.getSupplier().showData());
            for (Barang cetak : daftarBarang) {
                System.out.println(cetak.infoBarang());
            }
        } catch (Exception e) {
            System.out.println("Exception "+e);
        }
    }
}
