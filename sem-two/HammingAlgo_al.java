import java.util.ArrayList;
public class HammingAlgo_al {

    // Method to calculate a single Hamming bit value
    public static int getAHammingBit(String parityScheme, int sum) {
        int bit;
        int r = sum % 2;

        if (parityScheme.equalsIgnoreCase("ODD")) {
            if (r != 0)
                bit = 0;
            else
                bit = 1;
        } else {
            if (r != 0)
                bit = 1;
            else
                bit = 0;
        }
        return bit;
    }

    // Method to calculate the sum of bits covered by the nth parity bit (Hn)
    public static int sumOfBits(ArrayList<Integer> msg, int n) {
        int sum = 0;
        int msgLength = msg.size();

        // Start from nth position and skip blocks of n bits alternately
        for (int i = n; i < msgLength; i += (2 * n)) {
            int k = 0;
            while (k < n && (i + k) < msgLength) {
                sum += msg.get(i + k);
                k++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        // Example input: 110000111001
        ArrayList<Integer> input = new ArrayList<>();
        int[] inputArray = {1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1};
        for (int bit : inputArray) input.add(bit);

        ArrayList<Integer> msg = new ArrayList<>();
        int[] msgArray = {2, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1};
        for (int bit : msgArray) msg.add(bit);

        String parityScheme = "ODD";
        int msgLength = msg.size();

        // Find number of parity bits based on message length
        int nHammingBits = 0;
        while (Math.pow(2, nHammingBits) < msgLength) {
            nHammingBits++;
        }

        System.out.println("Total Hamming Bits: " + nHammingBits);
        System.out.println("-------------------------------------");

        // Loop through all parity bits
        for (int i = 0; i < nHammingBits; i++) {
            int n = (int) Math.pow(2, i); // positions: 1, 2, 4, 8, 16, ...
            int sum = sumOfBits(msg, n);
            int h = getAHammingBit(parityScheme, sum);
            System.out.println("H" + n + " = " + h + " (Sum = " + sum + ")");
        }
    }
}
