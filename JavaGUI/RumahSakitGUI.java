package JavaGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;


public class RumahSakitGUI {
    private JFrame frame;
    private JTextField txtTanggal;
    private JTextField txtNamaPasien;
    private JTextArea txtAreaAntrian;
    private JTextField txtJumlahAntrian;
    private Queue<String> namaAntrian;
    private int jumlahAntrian;

    public RumahSakitGUI() {
        initialize();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                RumahSakitGUI window = new RumahSakitGUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void initialize() {
        frame = new JFrame("Rumah Sakit Sehat");
        frame.setBounds(100, 100, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(6, 3));
        // frame.getContentPane().setBackground(new Color(0xA1DD70));
        ImageIcon image = new ImageIcon("logo.jpg");
        frame.setIconImage(image.getImage());

        

        JPanel panelTanggal = new JPanel();
        frame.getContentPane().add(panelTanggal);
        panelTanggal.setLayout(new FlowLayout());
        panelTanggal.setBackground(new Color(0xA1DD70));
        

        JLabel lblTanggal = new JLabel("Hari/tanggal (DD/MM/YYYY): ");
        panelTanggal.add(lblTanggal);

        JTextField txtTanggal = new JTextField();
        panelTanggal.add(txtTanggal);
        txtTanggal.setColumns(10);

        JPanel panelJumlahAntrian = new JPanel();
        frame.getContentPane().add(panelJumlahAntrian);
        panelJumlahAntrian.setBackground(new Color(0xA1DD70));

        JLabel lblJumlahAntrian = new JLabel("Jumlah antrean: ");
        panelJumlahAntrian.add(lblJumlahAntrian);

        JTextField txtJumlahAntrian = new JTextField();
        panelJumlahAntrian.add(txtJumlahAntrian);
        txtJumlahAntrian.setColumns(12);

        JButton btnSetJumlahAntrian = new JButton("Set Jumlah Antrian");
        btnSetJumlahAntrian.setBackground(new Color(0xF6EEC9));
        btnSetJumlahAntrian.addActionListener(e -> {
            try {
                jumlahAntrian = Integer.parseInt(txtJumlahAntrian.getText());
                namaAntrian = new ArrayDeque<>(jumlahAntrian);
                JOptionPane.showMessageDialog(frame, "Jumlah antrian berhasil diset!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Masukkan dalam bentuk angka!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        panelJumlahAntrian.add(btnSetJumlahAntrian);

        JPanel panelTambahAntrian = new JPanel();
        frame.getContentPane().add(panelTambahAntrian);
        panelTambahAntrian.setBackground(new Color(0xA1DD70));

        JLabel lblNamaPasien = new JLabel("Nama pasien: ");
        panelTambahAntrian.add(lblNamaPasien);

        JTextField txtNamaPasien = new JTextField();
        panelTambahAntrian.add(txtNamaPasien);
        txtNamaPasien.setColumns(12);

        JButton btnTambahAntrian = new JButton("Tambahkan Antrean");
        btnTambahAntrian.setBackground(new Color(0xF6EEC9));
        btnTambahAntrian.addActionListener(e -> {
            if (namaAntrian.size() < jumlahAntrian) {
                namaAntrian.offer(txtNamaPasien.getText());
                txtNamaPasien.setText("");
                updateAntrian();
            } else {
                JOptionPane.showMessageDialog(frame, "Antrean penuh!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });
        panelTambahAntrian.add(btnTambahAntrian);

        JPanel panelTampilkanAntrian = new JPanel();
        frame.getContentPane().add(panelTampilkanAntrian);
        panelTampilkanAntrian.setBackground(new Color(0xA1DD70));

        JButton btnTampilkanAntrian = new JButton("Tampilkan Antrian");
        btnTampilkanAntrian.addActionListener(e -> updateAntrian());
        panelTampilkanAntrian.add(btnTampilkanAntrian);
        btnTampilkanAntrian.setBackground(new Color(0xF6EEC9));

        JTextArea txtAreaAntrian = new JTextArea();
        txtAreaAntrian.setEditable(false);
        frame.getContentPane().add(new JScrollPane(txtAreaAntrian));

        JPanel panelLayaniCetak = new JPanel();
        frame.getContentPane().add(panelLayaniCetak);
        panelLayaniCetak.setBackground(new Color(0xA1DD70));

        JButton btnLayaniPasien = new JButton("Layani Pasien");
        btnLayaniPasien.setBackground(new Color(0xF6EEC9));
        btnLayaniPasien.addActionListener(e -> {
            String pasien = namaAntrian.poll();
            if (pasien != null) {
                JOptionPane.showMessageDialog(frame, "Melayani pasien " + pasien);
                updateAntrian();
            } else {
                JOptionPane.showMessageDialog(frame, "Tidak ada antrian!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });
        panelLayaniCetak.add(btnLayaniPasien);

        JButton btnCetakAntrian = new JButton("Cetak Antrian");
        btnCetakAntrian.setBackground(new Color(0xF6EEC9));
        btnCetakAntrian.addActionListener(e -> {
            String filePath = "Antrian.txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write("Antrian Rumah Sakit Sejahtera (" + txtTanggal.getText() + ")\n");
                int k = 1;
                for (String antrian : namaAntrian) {
                    writer.write(k + ". " + antrian + "\n");
                    k++;
                }
                JOptionPane.showMessageDialog(frame, "Data antrian berhasil disimpan di " + filePath);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Terjadi kesalahan saat menyimpan data antrian: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        panelLayaniCetak.add(btnCetakAntrian);
    }

    private void updateAntrian() {
        StringBuilder sb = new StringBuilder("Nama dalam antrian:\n");
        int i = 1;
        for (String nama : namaAntrian) {
            sb.append(i).append(". ").append(nama).append("\n");
            i++;
        }
        txtAreaAntrian.setText(sb.toString());
    }
}


