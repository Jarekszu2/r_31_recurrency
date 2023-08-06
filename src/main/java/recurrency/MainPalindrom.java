package recurrency;

public class MainPalindrom {
    public static void main(String[] args) {
        System.out.println();

        String text = "anbna";
        System.out.println("Text: " + text + " : is palindrom - " + isItPalindrom(text));
    }

    public static boolean isItPalindrom(String text){
        if (text.length() == 0 || text.length() == 1){
            return true;
        }
        return text.charAt(0) == text.charAt(text.length() -1) && isItPalindrom(text.substring(1, text.length() - 1));
        // porównuję pierwszą i ostatnią literę tekstu, a następnie powtarzam to w rekurencji, redukując tekst o pierwszą
        // i ostatnią literę, aż osiągnę wartości graniczne length = 0 lub 1
    }
}
