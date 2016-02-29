package MaximumFlow;


import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * Created by mandy on 2015/12/8.
 */
public class FlowNetworkTest {
    @Test
    public void testFlowNetworkConstructedFromInputStream(){
        String str =
                "6\n" +
                "8\n" +
                "0 1 2.0\n" +
                "0 2 3.0\n" +
                "1 3 3.0\n" +
                "1 4 1.0\n" +
                "2 3 1.0\n" +
                "2 4 1.0\n" +
                "3 5 2.0\n" +
                "4 5 3.0";
        InputStream in = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
        FlowNetwork fn = new FlowNetwork(in);
        Assert.assertEquals(fn.V(), 6 );
        Assert.assertEquals(fn.E(), 8);
    }


}
