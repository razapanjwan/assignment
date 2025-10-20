import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class QUESTION2 {
    public static void main(String[] args){
        String fileName = "EVE01Sales.txt";
        File fileToRead = new File(fileName);
        Scanner fileRead;
        String[] fields;
        String line = "";
        int qty,unitprice,totalprice = 0;
        try {
            fileRead = new Scanner(fileToRead);
            line = fileRead.nextLine();
            line = fileRead.nextLine();
            fields = line.split("\t");

            while(fileRead.hasNextLine()){
                String product = fields[3];
                while(product.compareTo(fields[3]) == 0){
                    qty = Integer.parseInt(fields[4]);
                    unitprice = Integer.parseInt(fields[5]);
                    totalprice = qty * unitprice; 
                    // System.out.println(line);
                    line = fileRead.nextLine();
                    // System.out.println(line);
                    fields = line.split("\t");
                    System.out.println(product + " " + totalprice);   
                }
            }
            
            fileRead.close();
        } catch (FileNotFoundException e) {
            System.out.println("file was not opened" + " " + e);
        }
    }
}