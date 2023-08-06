package recurrency;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println();

        System.out.println("Recurrency 1: " + recurrency_1_silnia(3));

        System.out.println();
        System.out.println("Recurrency 2: " + recurrency_2_potega(2, 5));

        System.out.println();
        System.out.println("Recurrency 3: " + recurrency_3_odwrocStringa("Buba"));

        System.out.println();
        System.out.println("Recurrency 3_1: piesek");
        System.out.println(recurrency_3_1_odwrocStringa("piesek", 1));

        System.out.println();
        System.out.println("Reccurency 4: (377)");
        System.out.println("14-ty element ciągu Fibonacciego = " + obliczNtyElementCiaguFibonacciego(14));

        System.out.println();
        System.out.println("Recurrency 4_2:");
        System.out.println("14-ty element ciągu Fibonacciego = " + obliczNtyElemenCiaguFibonacciego_2(14));

        System.out.println();
        System.out.println("10 binarnie: " + liczbaBinarnie(10));

        System.out.println();
        System.out.println("10 binarnie: " + liczbaBinarnie_Pawel(10));

        System.out.println();
        System.out.println("10 binarnie: " + liczbaBinarnie_Jarek(10));

        System.out.println();
        System.out.println("10 binarnie: " + binary(10));
    }

    public static int recurrency_1_silnia(int n) {
        if (n == 1) {
            return 1;
        } else {
            return recurrency_1_silnia((n - 1)) * n;
        }
    }

    public static int recurrency_2_potega(int x, int y){
        if (y == 1){
            return x;
        } else {
            return recurrency_2_potega(x, (y - 1)) * x;
        }
    }

    public static String recurrency_3_odwrocStringa(String tekst){
        if (tekst.length() == 1) {
            return tekst;
        } else {
            char literaDoDopisaniaNaKoniec = tekst.charAt(0);
            return recurrency_3_odwrocStringa(tekst.substring(1)) + literaDoDopisaniaNaKoniec;
        }
    }

    public static String recurrency_3_1_odwrocStringa(String tekst, int i){
        if (tekst.length() == 1){
            return tekst;
        }
        char literkaTejIteracji = tekst.charAt(0);

        printNMarks(i);
        System.out.println("Wchodzę do rekurencji: " + tekst.substring(1));
        String wynikRekurencji = recurrency_3_1_odwrocStringa(tekst.substring(1),++i);
        printNMarks(i);
        System.out.println("Wychodzę z rekurencji: " + wynikRekurencji);

        wynikRekurencji = wynikRekurencji + literkaTejIteracji;
        printNMarks(i);
        System.out.println("Dodaję literkę, obecnie: " + wynikRekurencji);

        return wynikRekurencji;
    }

    private static void printNMarks(int n){
        for (int i = 0; i < n; i++) {
            System.out.print(">");
        }
    }

    public static int obliczNtyElementCiaguFibonacciego(int n){
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        return obliczNtyElementCiaguFibonacciego((n - 2)) + obliczNtyElementCiaguFibonacciego((n - 1));
    }

    // ponieważ w powyższej metodzie obliczenie elementu ciagu wymaga wykonania obliczeń dla
    // argumentu (n - 2), a następnie wykonania praktycznie tych samych obliczeń dla elementu
    // (n - 1), pochłania to niepotrzebnie zasoby
    // rozwiązaniem jest wykonanie obliczeń raz i dodanie ich do mapy
    public static int obliczNtyElemenCiaguFibonacciego_2(int n) {
        Map<Integer, Integer> fibo = new HashMap<>();
        fibo.put(0, 0);
        fibo.put(1, 1);
//        if (n == 0){
//            return 0;
//        }
//        if (n == 1){
//            return 1;
//        }
        if (!fibo.containsKey((n - 2))){
            fibo.put((n - 2), obliczNtyElemenCiaguFibonacciego_2(n - 2));
        }
        if (!fibo.containsKey((n - 1))){
            fibo.put((n -1), obliczNtyElemenCiaguFibonacciego_2(n -1));
        }
        return fibo.get(n - 2) + fibo.get(n - 1);
    }

    public static String liczbaBinarnie(int number){
        Map<Integer, Integer> ints = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        int key = 0;
        boolean flag = false;
        while (!flag){
            int temp = number / 2;
            int element = (number % 2);
            ints.put(key, element);
            key++;
            number = temp;
            if (temp < 2){
                ints.put(key, temp);
                flag = true;
            }
        }
//        Map<Integer, Integer> sorted = ints.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
//
//        sorted.forEach((k, v) -> System.out.println(k + " " + v));

        ints.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .forEach(integerIntegerEntry -> stringBuilder.append(integerIntegerEntry.getValue()));

        return stringBuilder.toString();
    }

    public static String liczbaBinarnie_Pawel(int liczba){
        StringBuilder stringBuilder = new StringBuilder();
        while (liczba > 1){
            int reszta = liczba % 2;
            if (reszta == 1){
                stringBuilder.append("1");
            } else {
                stringBuilder.append("0");
            }
            liczba = liczba / 2;
        }
        stringBuilder.append("1");

        return stringBuilder.reverse().toString();
    }

    public static String liczbaBinarnie_Jarek(int liczba){
        StringBuilder stringBuilder = new StringBuilder();
        while (liczba > 1){
            stringBuilder.append(liczba % 2);
            liczba = liczba / 2;
        }
        stringBuilder.append(1);
        return stringBuilder.reverse().toString();
    }

    public static String binary(int liczba){
        if (liczba == 0){
            return "0";
        }
        if (liczba == 1){
            return "1";
        }
        return binary(liczba /2) + (liczba % 2);
    }
}
