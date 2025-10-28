public class hamming_algo {
    // Method to calculate a single Hamming bit value
   public static int getAHammingBit(String parityScheme, int sum) {
        int hammingBit;
        int remainder = sum % 2;
        if (parityScheme.equalsIgnoreCase("ODD")) {
            if (remainder != 0)
                hammingBit = 0;
            else
                hammingBit = 1;
        } 
        else {
            if (remainder != 0)
                hammingBit = 1;
            else
                hammingBit = 0;
        }
        return hammingBit;
    }
    // Method to calculate the sum of bits covered by the nth parity bit (Hn)
    public static int sumOfBits(int[] message, int position) {
        int sum = 0;
        int messageLength = message.length;

        // Start from nth position and skip blocks of n bits alternately
        for (int i = position; i < messageLength; i += (2 * position)) {
            int k = 0;
            while (k < position && (i + k) < messageLength) {
                sum += message[i + k];
                k++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        // Example input: 110000111001
        int[] input = {1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1};

        int[] message = {2, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1};

        String parityScheme = "ODD";  
        int length = message.length;

        // Find number of parity bits based on message length
        int numHammingBits = 0;
        while (Math.pow(2, numHammingBits) < length) {
            numHammingBits++;
        }

        System.out.println("Total Hamming Bits: " + numHammingBits);
        System.out.println("-------------------------------------");

        // Loop through all parity bits
        for (int i = 0; i < numHammingBits; i++) {
            int position = (int) Math.pow(2, i); // positions: 1, 2, 4, 8, 16, ...
            int sum = sumOfBits(message, position);
            int hammingBit = getAHammingBit(parityScheme, sum);
            System.out.println("H" + position + " = " + hammingBit + " (Sum = " + sum + ")");
        }
    }
}