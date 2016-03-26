package Tree;

/**
 * Created by mandy on 2016/3/21.
 */
public abstract class BTreePage {
    public abstract BTreePage getParent();

    public abstract void setParent(BTreePage page);
}
