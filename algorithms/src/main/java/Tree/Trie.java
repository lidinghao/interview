package Tree;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by mandy on 2016/4/8.
 */
public class Trie {
    public void insert(String word) {
        if (word == null) {
            return;
        }
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.map[index] == null) {
                cur.map[index] = new Node();
            }
            cur = cur.map[index];
            cur.path++;

        }
        cur.end++;

    }

    public boolean search(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.map[index] == null) {
                return false;
            }
            cur = cur.map[index];
        }
        return cur.end > 0 ? true : false;
    }

    public void delete(String word) {
        if (!search(word)) {
            return;
        }
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (--cur.map[index].path == 0) {
                cur.map[index] = null;
                return;
            }

        }
        cur.end--;
    }


    public int prefixNumber(String pre) {
        Node cur = root;
        for (int i = 0; i < pre.length(); i++) {
            int index = pre.charAt(i) - 'a';
            cur = cur.map[index];
            if (cur == null) {
                return 0;
            }
        }
        return cur.path;
    }

    private static class Node {
        public int path = 0;
        public int end = 0;
        public Node[] map = new Node[26];
    }

    private Node root = new Node();

    @Test
    public void test() {
        Trie trie = new Trie();
        trie.insert("my");
        trie.insert("hello");
        trie.insert("world");
        Assert.assertTrue(trie.search("hello"));
        Assert.assertFalse(trie.search("hell"));
        trie.delete("hell");
        Assert.assertTrue(trie.search("hello"));
        trie.insert("he");
        trie.insert("hell");
        Assert.assertEquals(3, trie.prefixNumber("he"));
        Assert.assertEquals(2, trie.prefixNumber("hell"));


    }
}
