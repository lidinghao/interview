package random.patternmatching;

/**
 * Created by mandy on 2015/11/30.
 */
public class BrutalForce {
    public int match(String text, String pattern){
        int n = text.length();
        int m = pattern.length();
        boolean isMatch = false;
        assert (n >= m);
        for(int i = 0;i <= n - m; i++) {
            int j = 0;
            int k = i;
            for (j = 0; j < m; j++,k++)
                if (text.charAt(k) != pattern.charAt(j))
                    break;


            if(j==m) {
                isMatch = true;
                return i+1;
            }

        }
        return 0;
    }
}
