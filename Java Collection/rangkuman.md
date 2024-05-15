# JAVA COLLECTION

Pengertian Java Collection
adalah sebuah kerangka kerja yang menyediakan arsitektur untuk menyimpan dan memanipulasi sekelompok objek. Koleksi Java dapat mencapai semua operasi yang Anda lakukan pada sebuah data seperti pencarian, pengurutan, penyisipan, manipulasi, dan penghapusan. Java Collection berarti satu unit objek. Framework Java Collection menyediakan banyak interface (__Set__, __List__, __Queue__, __Deque__) dan class (__ArrayList__, __Vector__, __LinkedList__, __PriorityQueue__, __HashSet__, __LinkedHashSet__, __TreeSet__).
---
## Framework Java Collection

Kerangka Kerja Koleksi Java terdiri dari beberapa bagian berikut:
1.	**Interfaces**
Antarmuka Java Collections Framework menyediakan tipe data abstrak untuk merepresentasikan koleksi. java.util.Collection adalah antarmuka akar dari Collections Framework. Ia berada di bagian atas hirarki kerangka kerja Collections. Ini berisi beberapa metode penting seperti size(), iterator(), add(), remove(), clear() yang harus diimplementasikan oleh setiap kelas Collection.
2.	**Implementation Classes**
Kerangka kerja Java Collections menyediakan kelas-kelas implementasi untuk antarmuka koleksi inti. Kita dapat menggunakannya untuk membuat berbagai jenis koleksi dalam program Java.
Beberapa kelas koleksi yang penting adalah ArrayList, LinkedList, HashMap, TreeMap, HashSet, dan TreeSet. Kelas-kelas ini menyelesaikan sebagian besar kebutuhan pemrograman kita, tetapi jika kita membutuhkan kelas koleksi khusus, kita dapat mengembangkannya untuk membuat kelas koleksi khusus.
3.	**Algorithms**
Algoritma adalah metode yang berguna untuk menyediakan beberapa fungsi umum seperti mencari, menyortir, dan mengacak.
---
## Jenis-Jenis Koleksi

1.	**List**: Menyimpan elemen dalam urutan tertentu. Contoh class: ArrayList, LinkedList, Vector.
2.	**Set**: Tidak memperbolehkan duplikasi elemen. Contoh class: HashSet, LinkedHashSet, TreeSet.
3.	**Map**: Setiap kunci unik dipetakan ke nilai tertentu. Contoh class: HashMap, LinkedHashMap, TreeMap.
4.	**Queue**: Mengikuti prinsip FIFO (First-In-First-Out). Contoh class: PriorityQueue, LinkedList.
---
## Cara Menggunakan

Membuat Objek Koleksi: Gunakan konstruktor untuk membuat objek koleksi. Misalnya

```java
    ArrayList<String> list = new ArrayList<>();
```

---
## Contoh Penggunaan

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Membuat objek ArrayList
        ArrayList<String> list = new ArrayList<>();

        // Menambahkan elemen
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        // Iterasi melalui elemen
        for (String fruit : list) {
            System.out.println(fruit);
        }
    }
}
```




