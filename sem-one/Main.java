import java.io.File;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        
        String filePath = "EVE01Sales.txt";
        File fileToRead = new  File(filePath);
        String line = "";
        // int qty,unitprice; 
        String[] fields;
        try {
            Scanner fileInp = new Scanner(fileToRead);
            fileInp.nextLine();
            while(fileInp.hasNextLine()){
                line = fileInp.nextLine();
                fields = line.split("\t");
                // qty = Integer.parseInt(fields[4]);
                // unitprice = Integer.parseInt(fields[5]);
                // total = qty * unitprice;
                // System.out.println(total);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}