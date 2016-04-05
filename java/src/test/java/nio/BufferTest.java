package nio;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.StringReader;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * Created by mandy on 2016/2/28.
 */
public class BufferTest {
    @Test
    public void testBuffer() {
        StringReader sr = new StringReader("wokaka");
        int[] ints = new int[]{1, 2, 3, 4, 5};
        ByteBuffer bbuf = ByteBuffer.allocate(20);
        IntBuffer ibuf = bbuf.asIntBuffer();
        ibuf.put(ints);
        ByteInputStream bis = new ByteInputStream(bbuf.array(), 20);

        DataInputStream dis = new DataInputStream(bis);
        IntBuffer ib = IntBuffer.allocate(1024);
        ib.put(12);
        ib.put(13);
        ib.put(14);
        ib.flip();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);
        //dos.write(bbuf);
        System.out.println(ib);
    }
}
