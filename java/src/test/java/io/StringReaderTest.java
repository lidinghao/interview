package io;

import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by mandy on 2016/2/27.
 */
public class StringReaderTest {
    String url = getClass().getClassLoader().getResource("CharArrayStream").getPath();
    @Test
    public void testStringReader() {
        String str = new String();
        StringReader sr = new StringReader(str);
        str = "qwert";
        try {
            System.out.println((char)sr.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStringWriter() {
        StringWriter sw = new StringWriter();
        sw.write("wowo");
        System.out.println(sw.getBuffer().toString());
    }
}
