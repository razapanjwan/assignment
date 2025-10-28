import java.util.*;
public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int data[] = new int[n];

        System.out.println("Enter " + n + " numbers to sort in ascending order:");
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }

        System.out.println("Original Array: " + Arrays.toString(data));

        for (int pass = 0; pass < data.length - 1; pass++) {
            for (int j = 0; j < data.length - pass - 1; j++) {
                if (data[j] > data[j + 1]) {
                    swap(data, j, j + 1);
                }
            }
        }
        System.out.println("Sorted Array (Ascending): " + Arrays.toString(data));
        sc.close();
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}