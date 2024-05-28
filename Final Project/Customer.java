// Kelas generik untuk menyimpan informasi pelanggan
class Customer<T, U, V> {
    private T name;
    private U totalPrice;
    private V paymentMethod; // Menambahkan variabel untuk menyimpan metode pembayaran

    public Customer(T name, U totalPrice, V paymentMethod) {
        this.name = name;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
    }

    public T getName() {
        return name;
    }

    public U getTotalPrice() {
        return totalPrice;
    }

    public V getPaymentMethod() {
        return paymentMethod;
    }
}
