package io;

import org.junit.Test;

import java.io.*;

/**
 * Created by mandy on 2016/2/27.
 */
public class CharArrayReaderTest {
    String url = getClass().getClassLoader().getResource("CharArrayStream").getPath();

    @Test
    public void testCharArrayWriter() {
        CharArrayWriter caw = new CharArrayWriter();
        caw.append('1');
        caw.append('a');
        System.out.println(caw.toString());
    }
    @Test
    public void testCharArrayReader() {

        char[] chars = new char[2];
        CharArrayReader car = new CharArrayReader(chars);
        chars[0] = 'a';
        chars[1] = 'b';
        char[] cbuf = new char[2];
        try {
            car.read(cbuf);
            System.out.println(cbuf[0]);
            System.out.println(cbuf[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
