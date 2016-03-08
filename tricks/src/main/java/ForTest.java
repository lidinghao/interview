/**
 * Created by mandy on 2016/3/4.
 */
public class ForTest {
    int field = 0;
    @MyDeser
    public  ForTest(@MyDeserField("field") int field) {
        this.field = field;

    }
}
