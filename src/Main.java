import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя файла ввода: ");
        String inputFileName = scanner.nextLine();

        System.out.print("Введите имя файла вывода: ");
        String outputFileName = scanner.nextLine();

        scanner.close();

        try {
            FileReader inputFileReader = new FileReader(inputFileName);

            int[] char_counter = new int[26 * 2];
            int c;
            while ((c = inputFileReader.read()) != -1) {
                if (Character.isLetter(c)) {
                    if (Character.isUpperCase(c)) {
                        char_counter[c - 'A']++;
                    } else {
                        char_counter[c - 'a' + 26]++;
                    }
                }
            }
            inputFileReader.close();

            FileWriter outputFileWriter = new FileWriter(outputFileName);
            for (int i = 0; i < 26 * 2; i++) {
                if (char_counter[i] > 0) {
                    if (i < 26) {
                        outputFileWriter.write((char) ('A' + i) + ": " + char_counter[i] + "\n");
                    } else {
                        outputFileWriter.write((char) ('a' + i - 26) + ": " + char_counter[i] + "\n");
                    }
                }
            }
            outputFileWriter.close();
        }
        catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}