package String;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mandy on 2016/3/23.
 */
public class ZigZagPatternTest {

    @Test
    public void testConvert() throws Exception {
      String s = ZigZagPattern.convert("PAYPALISHIRING",3);
      assertEquals("PAHNAPLSIIGYIR",s);

    }
}