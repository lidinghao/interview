package Tree;

/**
 * Created by mandy on 2016/3/22.
 */
public class BTreeLeafPage extends BTreePage {
    @Override
    public BTreePage getParent() {
        return null;
    }

    @Override
    public void setParent(BTreePage page) {

    }
}
