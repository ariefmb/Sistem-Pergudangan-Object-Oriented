package App.PengeluaranBarang;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Barang.Barang;
import Barang.Gudang;

public class PengeluaranBarang extends JFrame {

    private Gudang gudang;

    private JTextField kodeBarangField;
    private JTextField jumlahField;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PengeluaranBarang().setVisible(true));
    }

    public PengeluaranBarang() {
        gudang = new Gudang();
        setTitle("Goods Withdrawal System");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        JLabel kodeBarangLabel = new JLabel("ID Barang:");
        kodeBarangField = new JTextField();
        JLabel jumlahLabel = new JLabel("Jumlah Barang yang Ingin Dikurangi:");
        jumlahField = new JTextField();
        JButton kurangiStokButton = new JButton("Kurangi Stok");
        JButton berhentiSimpanButton = new JButton("Berhenti Menyimpan");
        JButton cariBarangButton = new JButton("Cari Barang");
        JButton kembaliButton = new JButton("Kembali ke Menu Utama");
        JButton tampilkanInfoButton = new JButton("Tampilkan Info Produk");

        // Set layout manager
        setLayout(new java.awt.GridLayout(5, 2, 10, 10));
        add(kodeBarangLabel);
        add(kodeBarangField);
        add(jumlahLabel);
        add(jumlahField);
        add(kurangiStokButton);
        add(berhentiSimpanButton);
        add(cariBarangButton);
        add(kembaliButton);
        add(tampilkanInfoButton);

        // Set button actions
        kurangiStokButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kurangiStokClicked(kodeBarangField.getText(), jumlahField.getText());
            }
        });

        berhentiSimpanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                berhentiSimpanClicked(kodeBarangField.getText());
            }
        });

        cariBarangButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cariBarangClicked(kodeBarangField.getText());
            }
        });

        kembaliButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kembaliKeMenuUtama();
            }
        });

        tampilkanInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tampilkanInfoProduk();
            }
        });
    }

    private void kurangiStokClicked(String kodeBarang, String jumlah) {
        try {
            int quantity = Integer.parseInt(jumlah);
            Barang barang = gudang.cariBarang(kodeBarang);

            if (barang != null) {
                int result = JOptionPane.showConfirmDialog(null,
                        "Anda yakin ingin mengurangi stok barang dengan kode " + kodeBarang + " sebanyak " + quantity + "?",
                        "Konfirmasi",
                        JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION) {
                    gudang.kurangiBarang(barang.getKodeBarang(), quantity);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Barang dengan kode: " + kodeBarang + " tidak ditemukan.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Masukkan jumlah yang valid.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void berhentiSimpanClicked(String kodeBarang) {
        System.out.println("Berhenti Menyimpan clicked for barang with kode: " + kodeBarang);
    }

    private void cariBarangClicked(String kodeBarang) {
        Barang barang = gudang.cariBarang(kodeBarang);

        if (barang != null) {
            JOptionPane.showMessageDialog(null, barang.infoBarang(), "Informasi Barang", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Barang dengan kode: " + kodeBarang + " tidak ditemukan.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void kembaliKeMenuUtama() {
        System.out.println("Kembali ke Menu Utama clicked");
    }

    private void tampilkanInfoProduk() {
        // Gantilah dengan logika yang sesuai untuk mendapatkan informasi produk yang dimasukkan oleh pengguna
        // Implementasi sederhana: menggunakan string kosong
        String infoProduk = getInfoProdukYangDimasukkanPengguna();

        if (infoProduk != null && !infoProduk.isEmpty()) {
            JOptionPane.showMessageDialog(null, infoProduk, "Info Produk", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Tidak ada info produk yang dimasukkan oleh pengguna.", "Info Produk", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private String getInfoProdukYangDimasukkanPengguna() {
        // Gantilah dengan logika yang sesuai untuk mengambil informasi produk yang dimasukkan oleh pengguna dari struktur data yang sesuai
        // Contoh sederhana: mengembalikan string kosong
        return "";
    }
}
