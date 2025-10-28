import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sales {

    public static void main(String[] args) {

        Scanner consoleScanner = new Scanner(System.in);
        System.out.println("Please enter the full path to your sales .txt file:");
        String filePath = consoleScanner.nextLine();

        Map<String, Integer> productSales = new HashMap<>();
        int grandTotal = 0;

        
        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            if (fileScanner.hasNextLine()) {
                fileScanner.nextLine();
            }

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] fields = line.split("\t"); 

                if (fields.length < 4) {
                    System.out.println("[Warning] Skipping malformed line (not enough fields): " + line);
                    continue; 
                }

                try {
                    
                    String productName = fields[1]; 
                    int unitPrice = Integer.parseInt(fields[2]);
                    int qty = Integer.parseInt(fields[3]); 

                    int lineTotal = unitPrice * qty;


                    int currentTotal = productSales.getOrDefault(productName, 0);
                    int newTotal = currentTotal + lineTotal;
                    productSales.put(productName, newTotal);
                    grandTotal += lineTotal;

                } catch (NumberFormatException e) {
                    System.out.println("[Error] Skipping line with non-numeric data in price/qty: " + line);
                }
            }

        } catch (FileNotFoundException e) {
 
            System.out.println("\n[FATAL ERROR] The file was not found at the path you provided: " + filePath);
            System.out.println("Please check the path and try running the program again.");
            return; 
        } catch (Exception e) {
            System.out.println("\n[FATAL ERROR] An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
            return; 
        } finally {
            consoleScanner.close(); 
        }
        
        System.out.println("\n==============================================");
        System.out.println("      PRODUCT-WISE AGGREGATED SALES");
        System.out.println("==============================================");
        for (Map.Entry<String, Integer> entry : productSales.entrySet()) {
            System.out.printf("%-15s: %d\n", entry.getKey(), entry.getValue());
        }

        System.out.println("----------------------------------------------");
        System.out.println("GRAND TOTAL (All Products): " + grandTotal);
        System.out.println("==============================================");
    }
}
