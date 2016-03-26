package io;

import org.junit.Test;

import java.io.*;
import java.net.URL;

/**
 * Created by mandy on 2016/2/26.
 */
public class DataStreamTest {
    URL url = getClass().getClassLoader().getResource("dataInputStream");
    @Test
    public void testDataOutputStream() {
        File file = new File(url.getPath());
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        DataOutputStream dos = new DataOutputStream(fos);
        try {
            dos.writeChar('a');
            dos.writeDouble(2.358);
            dos.writeInt(888);
            dos.flush();
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testDataInputStream() {
        File file = new File(url.getPath());
        FileInputStream fis = null;
        try {
           fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        DataInputStream dis = new DataInputStream(fis);
        try {
            System.out.println(dis.readChar());
            System.out.println(dis.readDouble());
            System.out.println(dis.readInt());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBufferedInputStream() {
        File file = new File(url.getPath());
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedInputStream bis = new BufferedInputStream(fis);
        DataInputStream dis = new DataInputStream(bis);
        try {
            System.out.println(dis.readChar());
            System.out.println(dis.readDouble());
            System.out.println(dis.readInt());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
