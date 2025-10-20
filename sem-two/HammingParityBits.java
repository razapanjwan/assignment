import java.util.ArrayList;
import java.util.Scanner;

public class HammingParityBits {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter binary message (e.g. 1011): ");
        String input = sc.nextLine();

        System.out.print("Enter parity type (EVEN/ODD): ");
        String parityType = sc.next().toUpperCase();

        ArrayList<Integer> messageBits = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            messageBits.add(Character.getNumericValue(input.charAt(i)));
        }

        int r = calculateRequiredParityBits(messageBits.size());
        calculateParityBits(messageBits, r, parityType);
    }

    // Method to calculate number of required parity bits
    public static int calculateRequiredParityBits(int m) {
        int r = 0;
        while (Math.pow(2, r) < (m + r + 1)) {
            r++;
        }
        return r;
    }

    // Method to calculate and print parity bits
    public static void calculateParityBits(ArrayList<Integer> msg, int r, String parityType) {
        int s, blockStart, blockSize;

        for (int n = 0; n < r; n++) {
            blockStart = (int) Math.pow(2, n);
            blockSize = (int) Math.pow(2, n);
            s = 0;

            // Nested loops to calculate parity contribution
            for (int i = blockStart - 1; i < msg.size(); i += blockSize * 2) {
                for (int k = 0; k < blockSize; k++) {
                    if ((i + k) < msg.size() && msg.get(i + k) == 1) {
                        s++;
                    }
                }
            }

            // Decide parity bit value
            int parityBit;
            if (parityType.equals("EVEN")) {
                parityBit = (s % 2 == 0) ? 0 : 1;
            } else {
                parityBit = (s % 2 == 0) ? 1 : 0;
            }

            System.out.println("H" + (n + 1) + " (covers bits in blocks of " + blockSize + "): sum=" + s + ", parity bit=" + parityBit);
        }
    }
}
