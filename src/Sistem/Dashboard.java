// Dashboard.java
package Sistem;

import Barang.*;

import java.util.Scanner;

public class Dashboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int id = 0;
        DataBarang dataBarangSystem = new DataBarang();

        System.out.println("=====SELAMAT DATANG DI SISTEM GUDANG=====");
        while (true) {
            System.out.println("\nSilahkan pilih menu kelola berikut");
            System.out.println("1. Penerimaan Barang");
            System.out.println("2. Pengeluaran Barang");
            System.out.println("3. Cek Stok");
            System.out.println("4. Informasi Supplier");
            System.out.println("0. Logout");
            System.out.print("Masukkan pilihan: ");

            int menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu) {
                case 1:
                    while (true) {
                        DataBarang dataBarang = new DataBarang();
                        String kodeBarang, namaBarang, tambahBarang;
                        int stok, kategori;
                        id += 1;
                        kodeBarang = "0" + id;

                        System.out.println("\n=====PENERIMAAN BARANG=====");
                        System.out.println("\nSilahkan isi form barang");
                        System.out.print("Nama Barang\t\t: ");
                        namaBarang = scanner.nextLine();
                        System.out.print("Jumlah Barang\t: ");
                        stok = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Kategori Barang");
                        System.out.println("1. Pakaian \t2. Elektronik " +
                                "\t3. Bahan Makanan \t4. Dokumen");
                        System.out.print("Kategori Pilihan : ");
                        kategori = scanner.nextInt();

                        if (kategori == 1) {
                            Barang pakaian = new Pakaian(kodeBarang, namaBarang, stok);
                            dataBarangSystem.tambahBarang(pakaian);
                        } else if (kategori == 2) {
                            Barang elektronik = new Elektronik(kodeBarang, namaBarang, stok);
                            dataBarangSystem.tambahBarang(elektronik);
                        } else if (kategori == 3) {
                            Barang bahanMakanan = new BahanMakanan(kodeBarang, namaBarang, stok);
                            dataBarangSystem.tambahBarang(bahanMakanan);
                        } else {
                            Barang dokumen = new Dokumen(kodeBarang, namaBarang, stok);
                            dataBarangSystem.tambahBarang(dokumen);
                        }

                        System.out.print("\n\t+Tambah Barang (y/n): ");
                        tambahBarang = scanner.nextLine();
                        if (tambahBarang.equals("n")) {
                            System.out.println("Barang telah tersimpan.");
                            System.out.println("Cetak bukti penyimpanan.");
                            dataBarangSystem.tampilkanDaftarBarang();
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("\n=====PENGELUARAN BARANG=====");
                    System.out.print("Masukkan ID Barang yang akan dikeluarkan: ");
                    String idBarangKeluar = scanner.nextLine();
                    Barang barangKeluar = dataBarangSystem.cariBarang(idBarangKeluar);
                    if (barangKeluar != null) {
                        System.out.println("Informasi Barang yang akan dikeluarkan:");
                        barangKeluar.infoBarang();
                        System.out.print("Masukkan jumlah barang yang akan dikeluarkan: ");
                        int jumlahKeluar = scanner.nextInt();
                        scanner.nextLine();
                        KurangiStok.kurangiStok(barangKeluar, jumlahKeluar);
                        System.out.println("Barang telah dikeluarkan.");
                    } else {
                        System.out.println("Barang dengan ID " + idBarangKeluar + " tidak ditemukan.");
                    }
                    break;
                case 3:
                    System.out.println("\n=====CEK STOK=====");
                    dataBarangSystem.tampilkanDaftarBarang();
                    break;
                case 4:
                    System.out.println("\n=====INFORMASI SUPPLIER=====");
                    // Implement supplier information
                    break;
                case 0:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("\n=====NOT FOUND=====");
            }
        }
    }
}
