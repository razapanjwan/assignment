import java.util.*;
public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nums[] = {15, 31, 35, 38, 44, 46, 55, 79, 90, 92};

        System.out.println("Hint: The array contains 10 sorted numbers between 15 and 92.");
        System.out.print("Enter number to search: ");
        int target = sc.nextInt();

        int idx = findIndex(nums, target);

        if (idx >= 0) {
            System.out.println("Found at position (index): " + idx);
        } else {
            System.out.println("Not found in array.");
        }

        sc.close();
    }

    private static int findIndex(int[] data, int key) {
        int lo = 0;
        int hi = data.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1; // avoid overflow
            int v = data[mid];
            if (v == key) return mid;
            if (key < v) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }
}
