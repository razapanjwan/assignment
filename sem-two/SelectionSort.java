import java.util.*;
public class SelectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Fixed array of 5 names
        String[] names = new String[5];
        System.out.println("Enter 5 names:");
        for (int i = 0; i < names.length; i++) {
            names[i] = sc.nextLine();
        }

        // Sorted array
        String[] sorted = new String[names.length];

        // Selection by shortest length
        for (int i = 0; i < names.length; i++) {
            int min = pickMinIndex(names);
            sorted[i] = names[min]; // add shortest
            names[min] = null;      // mark used
        }

        // Print sorted list
        System.out.println("\nSorted names by length:");
        for (String s : sorted) {
            System.out.println(s);
        }

        sc.close();
    }

    private static int pickMinIndex(String[] arr) {
        int idx = -1;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == null) continue;
            if (idx == -1 || arr[j].length() < arr[idx].length()) idx = j;
        }
        return idx;
    }
}