import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class ShoppingSystem extends JFrame {
    private JTextField nameField;
    private JTextField itemAQuantityField, itemBQuantityField, itemCQuantityField,itemDQuantityField,itemEQuantityField
    ;
    private JTextArea queueTextArea;
    private JComboBox<String> paymentMethodComboBox; // Tambahkan JComboBox untuk memilih metode pembayaran
    private Queue<Customer<String, Integer, String>> customerQueue; // Perbarui deklarasi antrian pelanggan

    public ShoppingSystem() {
        setTitle("Sistem Perbelanjaan");
        setSize(500, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        

        customerQueue = new LinkedList<>();

        // Panel input
        JPanel inputPanel = new JPanel(new GridLayout(8, 2, 10, 10)); // Tambahkan satu baris untuk pilihan metode pembayaran
        inputPanel.setBackground(new Color(255, 165, 0));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel nameLabel = new JLabel("Nama:");
        nameLabel.setForeground(Color.WHITE);
        inputPanel.add(nameLabel);
        nameField = new JTextField();
        inputPanel.add(nameField);

        JLabel itemALabel = new JLabel("Apel (Rp. 7.500,00/kg) Jumlah:");
        itemALabel.setForeground(Color.WHITE);
        inputPanel.add(itemALabel);
        itemAQuantityField = new JTextField();
        inputPanel.add(itemAQuantityField);

        JLabel itemBLabel = new JLabel("Jeruk (Rp. 6.500,00/kg) Jumlah:");
        itemBLabel.setForeground(Color.WHITE);
        inputPanel.add(itemBLabel);
        itemBQuantityField = new JTextField();
        inputPanel.add(itemBQuantityField);

        JLabel itemCLabel = new JLabel("Mangga (Rp. 10.000,00/kg) Jumlah:");
        itemCLabel.setForeground(Color.WHITE);
        inputPanel.add(itemCLabel);
        itemCQuantityField = new JTextField();
        inputPanel.add(itemCQuantityField);
        
        JLabel itemDLabel = new JLabel("Anggur (Rp. 15.000,00) Jumlah:");
        itemDLabel.setForeground(Color.WHITE);
        inputPanel.add(itemDLabel);
        itemDQuantityField = new JTextField();
        inputPanel.add(itemDQuantityField);

        JLabel itemELabel = new JLabel("Alpukat (Rp. 17.500,00/kg) Jumlah:");
        itemELabel.setForeground(Color.WHITE);
        inputPanel.add(itemELabel);
        itemEQuantityField = new JTextField();
        inputPanel.add(itemEQuantityField);

        JLabel paymentMethodLabel = new JLabel("Metode Pembayaran:"); // Tambah label untuk metode pembayaran
        paymentMethodLabel.setForeground(Color.WHITE);
        inputPanel.add(paymentMethodLabel);
        String[] paymentMethods = {"COD", "PayLater", "Transfer Bank"}; // Daftar pilihan metode pembayaran
        paymentMethodComboBox = new JComboBox<>(paymentMethods);
        inputPanel.add(paymentMethodComboBox);

        JButton addButton = new JButton("Tambah ke Antrian");
        addButton.setBackground(new Color(218, 92, 20));
        addButton.setForeground(Color.WHITE);
        addButton.addActionListener(new AddButtonListener());
        inputPanel.add(addButton);

        // Panel queue display
        JPanel queuePanel = new JPanel(new BorderLayout());
        queuePanel.setBackground(new Color(255, 140, 0));
        queuePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel queueLabel = new JLabel("Antrian Pelanggan:");
        queueLabel.setForeground(Color.WHITE);
        queuePanel.add(queueLabel, BorderLayout.NORTH);
        queueTextArea = new JTextArea();
        queueTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(queueTextArea);
        queuePanel.add(scrollPane, BorderLayout.CENTER);

        JButton serveButton = new JButton("Layani Pelanggan");
        serveButton.setBackground(new Color(218, 92, 20));
        serveButton.setForeground(Color.WHITE);
        serveButton.addActionListener(new ServeButtonListener());
        queuePanel.add(serveButton, BorderLayout.SOUTH);

        // Add panels to frame
        add(inputPanel, BorderLayout.NORTH);
        add(queuePanel, BorderLayout.CENTER);

        // Tampilkan dialog login
        showLoginDialog();
    }

    private void showLoginDialog() {
        JDialog loginDialog = new JDialog(this, "Login", true);
        loginDialog.setSize(800, 500);
        loginDialog.setLayout(new BorderLayout());
        loginDialog.setLocationRelativeTo(null);

        JLabel text = new JLabel("D-MART");
        text.setFont(new Font("Arial", Font.BOLD, 48));
        text.setForeground(Color.WHITE);
        
        
        ImageIcon image = new ImageIcon("shopping.png"); 
        JLabel imageLabel = new JLabel(image);
        imageLabel.setBounds(100, 130, 200, 200);
        
        loginDialog.add(imageLabel);
        //Mengganti icon image dari login page
        loginDialog.setIconImage(image.getImage());

        //Mengganti icon image dari home page
        setIconImage(image.getImage());
        
        // Panel kiri dengan warna oranye
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(218, 92, 20)); // Warna oranye
        leftPanel.setPreferredSize(new Dimension(400, 500));
        loginDialog.add(leftPanel, BorderLayout.WEST);
        
       
        leftPanel.add(text);
        
        
        // Panel kanan untuk form login
        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setPreferredSize(new Dimension(400, 500));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Menambahkan margin
        loginDialog.add(rightPanel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Menambahkan margin antar komponen
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel loginLabel = new JLabel("LOGIN");
        loginLabel.setFont(new Font("Arial", Font.BOLD, 24));
        loginLabel.setForeground(new Color(218, 92, 20)); // Warna oranye
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        rightPanel.add(loginLabel, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel usernameLabel = new JLabel("Username");
        rightPanel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        JTextField usernameField = new JTextField(15);
        rightPanel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel passwordLabel = new JLabel("Password");
        rightPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        JPasswordField passwordField = new JPasswordField(15);
        rightPanel.add(passwordField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(new Color(218, 92, 20)); // Warna oranye
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText().trim();
                String password = new String(passwordField.getPassword()).trim();

                if (authenticate(username, password)) {
                    loginDialog.dispose();
                } else if(username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(loginDialog, "Username atau password tidak boleh kosong.", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(loginDialog, "Username atau password salah.", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        rightPanel.add(loginButton, gbc);

        loginDialog.setVisible(true);
    }

    private boolean authenticate(String username, String password) {
        // Implementasi sederhana untuk contoh ini
        // Di dunia nyata, seharusnya memeriksa username dan password dari database atau sumber lain
        return username.equals("Andreas") && password.equals("123");
    }

   

    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String name = nameField.getText().trim();
                if (name.isEmpty()) {
                    throw new IllegalArgumentException("Nama tidak boleh kosong.");
                }

                int itemAQuantity = parseQuantity(itemAQuantityField.getText().trim());
                int itemBQuantity = parseQuantity(itemBQuantityField.getText().trim());
                int itemCQuantity = parseQuantity(itemCQuantityField.getText().trim());
                int itemDQuantity = parseQuantity(itemDQuantityField.getText().trim());
                int itemEQuantity = parseQuantity(itemEQuantityField.getText().trim());

                int totalPrice = (itemAQuantity * 7500) + (itemBQuantity * 6500) + (itemCQuantity * 10000) + (itemDQuantity * 15000) + (itemEQuantity * 17500);

                String paymentMethod = (String) paymentMethodComboBox.getSelectedItem(); // Ambil metode pembayaran yang dipilih

                Customer<String, Integer, String> customer = new Customer<>(name, totalPrice, paymentMethod); // Perbarui konstruktor
                customerQueue.add(customer);
                writeFile(customer);

                updateQueueDisplay();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Jumlah barang harus berupa angka.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        private int parseQuantity(String text) {
            if (text.isEmpty()) {
                return 0;
            }
            return Integer.parseInt(text);
        }
    }

        private class ServeButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!customerQueue.isEmpty()) {
                Customer<String, Integer,String> customer = customerQueue.poll();
                JOptionPane.showMessageDialog(null,
                        "Nama: " + customer.getName() + "\nTotal Harga: Rp." + customer.getTotalPrice() + "\nMetode Pembayaran: " + customer.getPaymentMethod(),
                        "Pelanggan Dilayani", JOptionPane.INFORMATION_MESSAGE);
                updateQueueDisplay();
            } else {
                JOptionPane.showMessageDialog(null, "Tidak ada pelanggan dalam antrian.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private void updateQueueDisplay() {
        StringBuilder queueDisplay = new StringBuilder();
        for (Customer<String, Integer, String> customer : customerQueue) { // Perbarui iterasi
            queueDisplay.append("Nama: ").append(customer.getName())
                    .append(", Total Harga: Rp.").append(customer.getTotalPrice())
                    .append(", Metode Pembayaran: ").append(customer.getPaymentMethod()).append("\n"); // Tambahkan informasi metode pembayaran
        }
        queueTextArea.setText(queueDisplay.toString());
    }

    
    private void writeFile(Customer<String, Integer, String> customer) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("customers.txt", true))) {
            writer.write("Nama\t\t\t\t:" + customer.getName() + "\nTotal Harga\t\t\t:Rp." + customer.getTotalPrice() + "\nMetode Pembayaran\t:" + customer.getPaymentMethod());
            writer.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error menulis ke file.", "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ShoppingSystem frame = new ShoppingSystem();
            frame.setVisible(true);
        });
    }
}
