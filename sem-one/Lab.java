
import java.io.File;
import java.util.Scanner;

public class Lab{
    public static void main(String[] args) {
        String fileName = "EVE01Sales.txt";
        File fileObj = new File(fileName);
        String line;
        String[] fields;
        try {
            Scanner fileInp = new Scanner(fileObj);
            if (fileInp.hasNextLine())
                fileInp.nextLine();
                line = fileInp.nextLine();
                fields = line.split("\t");
            String emp = fields[2];
            while(fileInp.hasNextLine()){
                
                while(emp.compareTo(fields[2]) == 0){
                    line = fileInp.nextLine();
                    fields = line.split("\t");
                    System.out.println(fields[2]);
                    emp = fields[2];
                }
            }
        } catch (Exception e) {
        }
    }
}