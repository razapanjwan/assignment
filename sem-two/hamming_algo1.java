public class hamming_algo1 {
    public static void main(String[] args) {
        // Input: 110000111001
        int[] inp = {1,1,0,0,0,0,1,1,1,0,0,1};

        // Use 9 instead of hamming bits and random number at index 0
        int[] msg = {2,9,9,1,9,1,0,0,9,0,0,1,1,1,0,0,9,1};

        String parityScheme = "ODD";
        int msgLength = msg.length;
        int sum = 0;
        int hammingBit = 0;

        // calculate hammingBit (generating sum)
        System.out.println("Indexes = " + msgLength);

        for (int i = 3; i < msgLength; i += 2) {
            sum += msg[i];
        }

        if (parityScheme.equalsIgnoreCase("ODD")) {
            int remainder = sum % 2;
            if (remainder != 0)
                hammingBit = 0;
            else
                hammingBit = 1;
        } else { // EVEN parity
            int remainder = sum % 2;
            if (remainder != 0)
                hammingBit = 1;
            else
                hammingBit = 0;
        }

        System.out.println("sum = " + sum);
        System.out.println("hammingBit = " + hammingBit);
    }
}