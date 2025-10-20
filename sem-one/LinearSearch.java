public class LinearSearch{
    public static int search(int[] arr, int n){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == n){
                return i;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        int[] arr = {1,2,3,4,5};
        int n = 5;
        boolean isPresent;
        int result;
        try {
            result = search(arr, n);
            if (result < 0){
                isPresent = false;
            } else {
                isPresent = true;
            }
            System.out.println(isPresent);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}