package recurrency;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * aplikacja po podaniu nazwy katalogu i nazwy pliku lub jego części przeszuka katalog (i jego podkatalogi) rekurencyjnie
 * i zwróci listę plików zawierających szukaną frazę w nazwie (lub tresci*)
 */
public class MainFileSearch {

    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    private static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj katalog, od którego ma się zacząć wyszukiwanie; np: /Users/Jarek/Kurs/Repet/");
        String directory = scanner.nextLine();
//        String directory = "/Users/Jarek/Kurs/Repet/";
        File file = new File(directory); // tworzę obiekt "deskryptora plików" - który zawiera informacje o danym pliku/katalogu
        System.out.println("Podaj szukaną frazę; np: Car - aplikacja wyszuka wszystkie pliki w katalogu i podkatalogach zawierające tę frazę");
        String text = scanner.nextLine();
//        String text = "Car";
        List<File> foundFiles = new ArrayList<>();
        searchInDirectoryFilesContainsText(file, text, foundFiles);

        System.out.println("Lista wyników:");
        for (File foundFile : foundFiles) {
            String entireText = foundFile.getAbsolutePath();
            int indexOf = entireText.indexOf(text);
            String string1 = entireText.substring(0, indexOf);
            String string2 = entireText.substring(indexOf, indexOf + text.length());
            String string3 = entireText.substring(indexOf + text.length());
            System.out.println(string1 + YELLOW_BOLD + string2 + ANSI_RESET + string3);
        }
    }

    public static void searchInDirectoryFilesContainsText(File file, String text, List<File> foundFiles) {
        if (file.exists() && file.isDirectory()) {
            File[] filesInDirectory = file.listFiles();
            for (File singleFile : filesInDirectory) {
                if (singleFile.isFile()) {
                    if (singleFile.getName().toLowerCase().contains(text.toLowerCase())) {
                        foundFiles.add(singleFile);
                    }
                } else if (singleFile.isDirectory()) {
                    searchInDirectoryFilesContainsText(singleFile, text, foundFiles);
                }
            }
        }
    }
}
