package BitManipulation;

/**
 * Created by mandy on 2016/5/6.
 */
public class NumberOfOneBits {
    public int hammingWeight(int n) {
        int x = 0;
        for(int i = 0; i < 32; i++){
            if(((n>>i)&1) == 1){
                x++;
            }
        }
        return x;
    }

    public int hammingWeightV2(int n) {
        int x = 0;
        while (n != 0) {
                x++;
               n &= n -1;

        }
        return x;
    }
}
