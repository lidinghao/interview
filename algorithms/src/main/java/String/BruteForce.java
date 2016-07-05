package String;

/**
 * Created by mandy on 2016/1/19.
 */
public class BruteForce {
    public static int search(String pattern, String text) {
        int N = text.length();
        int M = pattern.length();
        for (int i = 0; i < N -M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (text.charAt(i+j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == M) {
                return i;
            }
        }
        return N;
    }

    public static int search2(String pattern, String text) {
        int N = text.length();
        int M = pattern.length();
        int j ;
        int i;
        for (i = 0, j= 0; i < N && j < M; i++) {
            if (text.charAt(i) == pattern.charAt(j)) j++;
            else {
                i -= j;
                j=0;
            }
        }
        if (j == M) return i - M;
        else return  N;
    }
}
