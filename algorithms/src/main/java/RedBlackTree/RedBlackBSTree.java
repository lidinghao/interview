package RedBlackTree;

/**
 * Created by mandy on 2016/1/7.
 */
public class RedBlackBSTree<Key extends Comparable<Key>, Value> {
    private boolean RED = true;
    private boolean BLACK = false;
    private class Node {
         Key key;
         Value value;
        Node left, right;
        boolean color;

        public Node(Key key, Value value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }

        public boolean isRed(Node x) {
            if (x == null) {
                return false;
            }
            return x.color == RED;
        }
    }

}
