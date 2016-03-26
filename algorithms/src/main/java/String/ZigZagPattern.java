package String;

/**
 * Created by mandy on 2016/3/23.
 */
public class ZigZagPattern {
    //convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
    public static  String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        StringBuffer sb = new StringBuffer(s.length());
        int hip = numRows - 1 + numRows - 2 + 1;
        for (int i = 0; i < numRows; i++) {
            sb.append(chars[i]);
            int j = hip + i;
            while (j < chars.length) {
                sb.append(chars[j]);
                j+=hip;
            }
        }
        return sb.toString();
    }
}
