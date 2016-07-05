package Tree;

import java.util.Comparator;

/**
 * Created by mandy on 2016/1/6.
 */
public class BST<Key extends Comparable<Key>,Value> {
        Node root;
    private class Node {
        Key key;
        Value value;
        Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }

    public Value get(Key key) {
        return get(root, key);
    }
    public Value get(Node node, Key key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key)  == 0) return node.value;
        else if (key.compareTo(node.key) < 0) return get(node.left, key);
        else  return get(node.right, key);

    }
    public void put(Key key, Value value) {

        root = put(root, key, value);

    }

    private Node put(Node root, Key key, Value value) {
        if (root == null)
            return new Node(key, value);
        if (key.compareTo(root.key) < 0) {
            if (root.left == null) {
                root.left = new Node(key, value);
            }else
                put(root.left, key, value);
        } else if (key.compareTo(root.key) > 0) {
            if (root.right == null) {
                root.right = new Node(key, value);
            } else
                put(root.right, key, value);
        } else {
            root.key = key;
            root.value = value;

        }
        return root;
    }
}
