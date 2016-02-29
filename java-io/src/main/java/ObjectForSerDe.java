import java.io.Serializable;

/**
 * Created by mandy on 2016/2/26.
 */
public class ObjectForSerDe implements Serializable {
    private int i;
    private int k;
    private double f;
    public void setAllField() {
        i = 1;
        k = 2;
        f = 2.1;
    }
}
