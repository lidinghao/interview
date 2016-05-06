package BitManipulation;

import junit.framework.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by mandy on 2016/5/6.
 */
public class RepeatedDNASeq {
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        char[] seq = s.toCharArray();
        Set<Integer> set = new HashSet<>();
        Set<Integer> hasRecordedSet = new HashSet<>();
        List<String> list = new ArrayList<>();
        if (len <= 10) return list;
        int A = 0, C = 1, G = 2, T =3;
        Map<Character, Integer> table = new HashMap<>();
        table.put('A', 0);
        table.put('C', 1);
        table.put('G', 2);
        table.put('T', 3);
        int x = 0;
        for (int i = 0; i < 10; i++) {
            x = ((x << 2) | table.get(seq[i]));
        }
        set.add(x);
        for (int i = 10; i < len; i++) {
            x = ((x << 2) | table.get(seq[i])) & 0xFFFFF;
            if (set.contains(x) && !hasRecordedSet.contains(x)) {
                hasRecordedSet.add(x);
                list.add(String.copyValueOf(seq, i - 9, 10));
            } else {
                set.add(x);
            }
        }
        return list;
    }
    public List<String> findRepeatedDnaSequencesV2(String s) {
        int len = s.length();
        char[] seq = s.toCharArray();
        Map<Integer, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        if (len <= 10) return list;
        int A = 0, C = 1, G = 2, T =3;
        Map<Character, Integer> table = new HashMap<>();
        table.put('A', 0);
        table.put('C', 1);
        table.put('G', 2);
        table.put('T', 3);
        int x = 0;
        for (int i = 0; i < 10; i++) {
            x = ((x << 2) | table.get(seq[i]));
        }
        map.put(x, 1);
        for (int i = 10; i < len; i++) {
            x = ((x << 2) | table.get(seq[i])) & 0xFFFFF;
            Integer count = map.get(x);
            if (count != null) {
                map.put(x, count + 1);
            } else {
                map.put(x, 1);
            }
        }
        return list;
    }
    @Test
    public void test() {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> list = findRepeatedDnaSequences(s);
        Assert.assertEquals(2,list.size());
        Assert.assertEquals("AAAAACCCCC",list.get(0));
        Assert.assertEquals("CCCCCAAAAA",list.get(1));
        String s2 = "AAAAAAAAAAA";
        List<String> list2 = findRepeatedDnaSequences(s2);
        Assert.assertEquals(1,list2.size());
    }
}
