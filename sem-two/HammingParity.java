import java.util.Scanner;

public class HammingParity {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter binary message (e.g., 1011): ");
        String message = sc.nextLine();

        System.out.print("Enter parity type (EVEN/ODD): ");
        String parityType = sc.nextLine().trim().toUpperCase();

        int m = message.length();
        int r = 0;

        // Calculate number of parity bits needed
        while (Math.pow(2, r) < (m + r + 1)) {
            r++;
        }

        char[] code = new char[m + r + 1];
        int j = 0;

        // Fill the message and leave parity bit positions empty
        for (int i = 1; i < code.length; i++) {
            if (isPowerOfTwo(i)) {
                code[i] = 'P'; // placeholder for parity bits
            } else {
                code[i] = message.charAt(j++);
            }
        }

        // Calculate each parity bit
        for (int i = 0; i < r; i++) {
            int parityPos = (int) Math.pow(2, i);
            code[parityPos] = calculateParity(code, parityPos, parityType);
        }

        System.out.println("\nFinal Hamming code with " + parityType + " parity:");
        for (int i = code.length - 1; i > 0; i--) {
            System.out.print(code[i]);
        }
        System.out.println();
    }

    // Method to check if a number is a power of 2
    public static boolean isPowerOfTwo(int x) {
        return (x & (x - 1)) == 0;
    }

    // Method to calculate a single parity bit
    public static char calculateParity(char[] code, int parityPos, String parityType) {
        int count = 0;

        // Nested loops to check bits covered by this parity position
        for (int i = parityPos; i < code.length; i += 2 * parityPos) {
            for (int j = i; j < i + parityPos && j < code.length; j++) {
                if (code[j] == '1') {
                    count++;
                }
            }
        }

        // Determine parity bit value
        if (parityType.equals("EVEN")) {
            return (count % 2 == 0) ? '0' : '1';
        } else { // ODD parity
            return (count % 2 == 0) ? '1' : '0';
        }
    }
}
