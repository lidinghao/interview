package String;

import LinkedList.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by mandy on 2016/5/14.
 */
public class StringSearch {
    public int bruteForce(String haystack, String needle) {
        if (haystack.length() == 0 && needle.length() == 0) return 0;
        if (haystack.length() < needle.length()) return -1;
        for (int i = 0; i < haystack.length() - needle.length()+1; i++) {
            boolean match = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    match = false;
                }
            }
            if (match) return i;
        }
        return -1;
    }
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new LinkedList<>();
        if (s.length() == 0 || words.length == 0) return result;
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        int wordLen = words[0].length();
        int winSize = words.length * wordLen;
        for (int i = 0; i <= s.length() - winSize; i++) {
            Map<String, Integer> unused = new HashMap<>(wordCount);
            for (int j = 0; j < winSize; j+=wordLen) {
                String str = s.substring(i + j, i + j + wordLen);
                int count = unused.getOrDefault(str, -1);
                if (count == 1) {
                    unused.remove(str);
                } else if (count > 1) {
                    unused.put(str, count - 1);
                } else {
                    break;
                }


            }
            if (unused.size() == 0) result.add(i);
        }
        return result;
    }

    @Test
    public void test() {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        List<Integer> result = findSubstring(s, words);
        result.forEach(System.out::println);
    }
}
