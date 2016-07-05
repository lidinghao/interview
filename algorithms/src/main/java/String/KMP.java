package String;

/**
 * Created by mandy on 2016/1/22.
 */
public class KMP {
    private final String text;
    private  String pattern;
    private int[][] dfa;
    private int radix = 3;
    private int[] pi;
    public int charToInt(char c) {
        if (c == 'A')
            return 0;
        else if (c == 'B')
            return 1;
        else
            return 2;

    }
    public KMP(String text, String pattern) {
        this.text = text;
        this.pattern = pattern;
        dfa = new int[3][pattern.length()];
        pi = new int[pattern.length()+1];
    }

    public int search2(){
        int i;
        int N = text.length();
        int M = pattern.length();
        int k;
        for (i = 0, k = 0; i < N && k < M; i++) {
            while (k >= 0 && pattern.charAt(k + 1) != text.charAt(i))
                k = pi[k];
            k++;
        }
        if (k == M) return i - M;
        else return N;

    }

    public void buildPrefixTable() {
        int M = pattern.length();
        int k = 0;
        pi[0] = -1;
        for (int i = 1; i <= M; i++) {
            while (k >= 0 && pattern.charAt(k+1-1) != pattern.charAt(i-1))
                k = pi[k];
            pi[i] = ++k;
        }

    }

    public int search() {
        int N = text.length();
        int M = pattern.length();
        int i ;
        int j ;
        for (i = 0, j= 0; i < N && j < M; i++) {
            int charIndex = charToInt(text.charAt(i));
            j = dfa[charIndex][j];

        }
        if (j == M) {
            return i - M;
        } else {
            assert i == N;
            return N;
        }

    }


    public void buildDFA() {
        int M = pattern.length();
        int charIndex = charToInt(pattern.charAt(0));
        dfa[charIndex][0] = 1;
        int X = 0;
        for (int i = 1; i < M; i++) {
            for (int j = 0; j < radix; j++) {
                dfa[j][i] = dfa[j][X];
            }
            charIndex = charToInt(pattern.charAt(i));
            dfa[charIndex][i] = i + 1;

            X = dfa[charIndex][X];
        }

    }


}
