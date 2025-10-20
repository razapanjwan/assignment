public class SelectionSort {
    public static void sort(int[] arr){
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
    public static void showArray(int[] arr){
        for(int val : arr){
            System.err.println(val + "");
        }
        System.err.println();
    }
    public static void main(String args[]){
        int[] arr = {65,17,34,22,10};
        showArray(arr);
        sort(arr);
        showArray(arr);
    }
}





































