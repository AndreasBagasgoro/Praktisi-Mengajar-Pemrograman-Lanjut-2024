
import java.io.*;
import java.util.*;

public class Collections {
    public static void main(String[] args) {
        try {
            // Arraylist
            System.out.println("\n[CONTOH PENGGUNAAN ARRAYLIST]");
            System.out.println("--------------");
            ArrayList<String> names = new ArrayList<String>();
            names.add("Budi");
            names.add("Bambang");
            names.addAll(Arrays.asList("Waluyo", "Taufiq"));

            for (String name : names) {
                System.out.println(name);
            }

            System.out.println("\n[CONTOH PENGGUNAAN REMOVE ARRAYLIST]");
            System.out.println("--------------");
            names.remove("Budi");

            for (String name : names) {
                System.out.println(name);
            }

            System.out.println("\n[CONTOH PENGGUNAAN CONTAINS ARRAYLIST]");
            System.out.println("--------------");
            boolean found = names.contains("Waluyo");
            System.out.println(found ? "found" : "not found");

            // Menyimpan data ArrayList ke file
            FileWriter fileWriter = new FileWriter("names.txt");
            for (String name : names) {
                fileWriter.write(name + "\n");
            }
            fileWriter.close();

            // Linked List
            System.out.println("\n[CONTOH PENGGUNAAN LINKED LIST]");
            System.out.println("--------------");
            List<String> names2 = new LinkedList<String>();
            names2.add("Heru");
            names2.add("Herlambang");
            System.out.println(names2);

            // Queue
            System.out.println("\n[CONTOH PENGGUNAAN QUEUE]");
            System.out.println("--------------");
            Queue<String> names3 = new ArrayDeque<>(10);
            names3.offer("Sujianto");
            names3.offer("Jundi Muhammad Fauzan");

            for (String next = names3.poll(); next != null; next = names3.poll()) {
                System.out.println(next);
            }

            // Deque
            // LIFO
            System.out.println("\n[CONTOH PENGGUNAAN DEQUE LIFO]");
            System.out.println("--------------");
            Deque<String> stack = new LinkedList<>();
            stack.offerFirst("Jono");
            stack.offerFirst("Subakti");
            stack.offerFirst("Mamat");

            for (String next = stack.pollFirst(); next != null; next = stack.pollFirst()) {
                System.out.println(next);
            }

            // FIFO
            System.out.println("\n[CONTOH PENGGUNAAN DEQUE FIFO]");
            System.out.println("--------------");
            Deque<String> stack2 = new LinkedList<>();
            stack2.offerFirst("Jono");
            stack2.offerFirst("Subakti");
            stack2.offerFirst("Mamat");

            for (String next = stack2.pollLast(); next != null; next = stack2.pollLast()) {
                System.out.println(next);
            }

            // Menyimpan nomor data antrian ke file
            FileWriter numberWriter = new FileWriter("queue_numbers.txt");
            for (int i = 1; i <= names3.size(); i++) {
                numberWriter.write(i + "\n");
            }
            numberWriter.close();

            // Menyimpan tanggal
            FileWriter dateWriter = new FileWriter("dates.txt");
            Date currentDate = new Date();
            dateWriter.write(currentDate.toString());
            dateWriter.close();

        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}

