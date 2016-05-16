package BackTracking;

import com.sun.org.apache.bcel.internal.generic.LUSHR;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mandy on 2016/5/9.
 */
public class LetterCombinations {
    public Map<Integer, List<Character>> buildMap() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Map<Integer, List<Character>> map = new HashMap<>();
        for (int i = 2,j = 0; i <= 9&&j< 26; i++) {
            List<Character> list = new ArrayList<>();
            list.add(alphabet.charAt(j++));
            list.add(alphabet.charAt(j++));
            list.add(alphabet.charAt(j++));
            if (i == 7 || i == 9) {
                list.add(alphabet.charAt(j++));
            }
            map.put(i, list);

        }
        return map;
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        Map<Integer, List<Character>> map = buildMap();
        if (digits.length()==0) {
            result.add("");
        }
        combine(digits,0,"",result, map);
        return result;


    }

    public void combine(String digits, int index, String prefix, List<String> result, Map<Integer, List<Character>> map){
        if (index ==digits.length()){
            result.add(prefix);
            return;
        };
        List<Character> chars = map.get(Character.getNumericValue(digits.charAt(index)));
        for (Character ch : chars) {
            combine(digits, index+1, prefix+ch, result, map);
        }
    }

    public List<String> letterCombinationsV2(String digits) {
        String digitletter[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            char[] chars = digitletter[digits.charAt(i) - '0'].toCharArray();
            List<String> temp = new ArrayList<>();
            for (String s : result) {
                for (char ch : chars) {
                    temp.add(s + ch);
                }
            }
            result = temp;
        }
        return result;
    }


    @Test
    public void test() {
        List<String> list = letterCombinationsV2("27");
        list.forEach(System.out::println);
    }

}
