public class BubbleSort{
    static void sort(int arr[], int n ){
        int i,j,temp;
        for(i = 0; i < n - 1; i++){
            boolean swapped = false;
            for(j = 0; j < n - i - 1; j++){
                if (arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
    }
    static void printArray(int arr[], int size){
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static void main(String[] args){
        int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
        int n = arr.length;
        sort(arr, n);
        System.out.println("Sorted array: ");
        printArray(arr, n);
    }
}