package Tree;

import javafx.util.Pair;

import java.util.Vector;

/**
 * Created by mandy on 2016/3/21.
 */
public class BPlusTree {

    private class LeafPage{
        Vector<Pair<Integer,String>> tuples =new Vector<Pair<Integer, String>>(8);

    }
    private class InternalPage{
        int[] keys;

    }

}
