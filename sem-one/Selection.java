public class Selection{
    static void selectionSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n - 1; i++){
            int min_idx = i;
            for(int j = i + 1; j < n; j++){
                if(arr[j] > arr[min_idx]){
                    min_idx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }
    }
    static void printArr(int[] arr){
        for(int i : arr){
            System.out.println(i);
        }
    }
    public static void main(String[] args){
        int[] arr = {64,32,16,8,4,2,1};
        selectionSort(arr);
        printArr(arr);
    }
}
