package deserialization;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by mandy on 2016/1/16.
 */
public class BinaryTreeNode<E> {
    public E value;
    public BinaryTreeNode<E> left;
    public BinaryTreeNode<E> right;
    @JsonCreator
    public BinaryTreeNode(@JsonProperty("value") E value) {
        this.value = value;
    }
    public ArrayList<E> preOrder() {
        ArrayList result = new ArrayList();
        if (value == null) {
            return result;
        } else {
            preOrder(this,result);
            return result;
        }
    }

    private void preOrder(BinaryTreeNode<E> root, ArrayList result) {
        if (root == null) {
            return;
        }
        result.add(root.value);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }


}
