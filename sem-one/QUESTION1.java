import java.io.File;
import java.util.Scanner;


public class QUESTION1 {
    public static void main(String[] args) {
        String fileName = "EVE01Sales.txt";
        File fileToRead = new File(fileName);
        try {
            Scanner fileScanner = new Scanner(fileToRead);
            fileScanner.nextLine();
            while(fileScanner.hasNextLine()){
                String line = fileScanner.nextLine();
                System.out.println(line);
            }
            fileScanner.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}