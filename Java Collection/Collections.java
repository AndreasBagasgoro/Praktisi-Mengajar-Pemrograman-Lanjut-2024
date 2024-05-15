import java.util.*;

public class Collections{
    public static void main(String[] args){
        
        // Arraylist
        // Implementasi dari list menggunakan array
        System.out.println("\n[CONTOH PENGGUNAAN ARRAYLIST]");
        System.out.println("--------------");
        ArrayList<String> names = new ArrayList<String>();
        names.add("Budi");
        names.add("Bambang");
        names.addAll(Arrays.asList("Waluyo", "Taufiq"));

        for(String name: names){
            System.out.println(name);
        }



        System.out.println("\n[CONTOH PENGGUNAAN REMOVE ARRAYLIST]");
        System.out.println("--------------");
        names.remove("Budi");

        for(String name: names){
            System.out.println(name);
        }



        System.out.println("\n[CONTOH PENGGUNAAN CONTAINS ARRAYLIST]");
        System.out.println("--------------");
        boolean found = names.contains("Waluyo");
        System.out.println(found ? "found" : "not found");



        // Linked List
        // Setiap node memiliki pointer ke node sebelum dan setelahnya
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

        for(String next = names3.poll(); next != null; next = names3.poll()){
            System.out.println(next);
        }



        // Deque
        // Data dapat diakses secara FIFO atau FIFO
        System.out.println("\n[CONTOH PENGGUNAAN DEQUE LIFO]");
        System.out.println("--------------");
        Deque<String> stack = new LinkedList<>();
        stack.offerFirst("Jono");
        stack.offerFirst("Subakti");
        stack.offerFirst("Mamat");
       
        for(String next = stack.pollFirst(); next != null; next = stack.pollFirst()){
            System.out.println(next);
        }



        System.out.println("\n[CONTOH PENGGUNAAN DEQUE FIFO]");
        System.out.println("--------------");
        Deque<String> stack2 = new LinkedList<>();
        stack2.offerFirst("Jono");
        stack2.offerFirst("Subakti");
        stack2.offerFirst("Mamat");
        for(String next = stack2.pollLast(); next != null; next = stack2.pollLast()){
            System.out.println(next);
        }

    }
}