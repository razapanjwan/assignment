import java.util.ArrayList;
import java.util.Arrays;

public class hamming_algo_sir_al {
    public static void main(String[] args) {
        ArrayList<Integer> msg = new ArrayList<>(Arrays.asList(2,0,0,1,0,1,0,0,0,0,0,1,1,1,0,0,0,1)); 
        int s;
        int blockSize;
        int blockStart;

        for (int n = 0; n < 5; n++) {
            blockStart = (int) (Math.pow(2, n));
            blockSize = (int) Math.pow(2, n);
            s = 0;

            for (int i = blockStart; i < msg.size(); i += blockSize * 2) {  
                for (int k = 0; k < blockSize; k++) {
                    if ((i + k) < msg.size())
                        s += msg.get(i + k);
                }
            }

            System.out.println("for hamming bit-" + (n + 1) + " the sum is " + s);
        }
    }
}
