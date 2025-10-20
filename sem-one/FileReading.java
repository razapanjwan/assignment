
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class FileReading{
    public static void main(String[] args){
        String fileName = "EVE01Sales.txt";
        File fileObj = new File(fileName);
        Scanner fileInp;
        String line;
        String[] fields;
        int total = 0;
        try{
            fileInp = new Scanner(fileObj); 
            ArrayList<SalesRecord> records = new ArrayList<>();
            if (fileInp.hasNextLine()) fileInp.nextLine();
            // fields = fileInp.nextLine().split("\t");
            
            while(fileInp.hasNextLine()){
                line = fileInp.nextLine();
                fields = line.split("\t");
                Date date = parseDate(fields[0]);
                SalesRecord newSalesRecord = new SalesRecord(date,fields[1],fields[2],fields[3],Integer.parseInt(fields[4]),Integer.parseInt(fields[5]));
                records.add(newSalesRecord);
            };
            records.sort(Comparator.comparing(rec -> rec.product));
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
            for (int i = 0; i < records.size();) {
                SalesRecord r = records.get(i);
                String product = r.product;
                int sum = 0;
                while(product.equals(records.get(i).product) && i < records.size()){
                    sum += records.get(i).getSalesRecord();
                    i++;
                }
                System.out.println(product + sum);
                
            }
            
        } catch(Exception e){
            System.out.println(e);
        }
    }
    static Date parseDate(String strDate) throws Exception{
        try {
            return new SimpleDateFormat("dd-MMM-yyyy").parse(strDate);
        } catch (Exception e) {
            return new SimpleDateFormat("dd-MMM-yyyy").parse(strDate); 
        }
    }
    static class SalesRecord{
        Date date;
        String region;
        String repId;
        String product;
        int qty;
        int unitprice;

        public SalesRecord(Date date,String region, String repId, String product, int qty, int unitprice){
            this.date = date;
            this.region = region;
            this.repId = repId;
            this.product = product;
            this.qty = qty;
            this.unitprice = unitprice;
        }
        
        int getSalesRecord(){
            return this.qty * this.unitprice;
        }
        int getMonth(){
            Calendar cal = Calendar.getInstance();
            cal.setTime(this.date);
            return cal.get(Calendar.MONTH);
        }
    }
}

