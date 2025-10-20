
//     public static void main(String[] args) {
//         String fileName = "EVE01Sales.txt";
//         File fileObj = new File(fileName);
//         String line = "";
//         try {
//             Scanner fileInp = new Scanner(fileObj);
//             while(fileInp.hasNextLine()){
//                 line = fileInp.nextLine();
//                 System.out.println(line);
//             }
//         } catch (Exception e) {
//             System.out.println(e);
//         }
//     }
// }

public class Reading{
    public static void sorting(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n - 1; i++){
            int min_idx = i;
            for(int j = i + 1; j < n; j++){
                if(arr[j] < arr[min_idx]){
                    min_idx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {64,32,16,8,4,2,1};
        sorting(arr);
        for(int i:arr){
            System.out.println(i);
        }
    }
}