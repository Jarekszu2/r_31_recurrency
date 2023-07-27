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
}
