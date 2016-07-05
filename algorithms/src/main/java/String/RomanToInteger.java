package String;

/**
 * Created by lihao on 16/5/7.
 */
public class RomanToInteger {
    public int romanToInt(String s) {
       int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && toInt(s.charAt(i)) > toInt(s.charAt(i - 1))) {
                result += toInt(s.charAt(i)) - 2 * toInt(s.charAt(i - 1));
            } else {
                result += toInt(s.charAt(i));
            }
        }
        return result;

    }

    public int toInt(char roman) {
        switch (roman) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }


    }
}
