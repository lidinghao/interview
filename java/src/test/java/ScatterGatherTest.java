import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by mandy on 2016/2/28.
 */
public class ScatterGatherTest {
    //String url = getClass().getResource();
    @Test
    public void testScatter() {
        RandomAccessFile file = null;
        try {
            file = new RandomAccessFile("ScatterGatherFile","rw");
            FileChannel channel = file.getChannel();
            ByteBuffer magic = ByteBuffer.allocate(4);
            IntBuffer intBuffer = magic.asIntBuffer();
            intBuffer.put(1);

            ByteBuffer header = ByteBuffer.allocate(20);
            intBuffer = header.asIntBuffer();
            intBuffer.put(2);
            intBuffer.put(3);
            intBuffer.put(4);
            intBuffer.put(5);
            intBuffer.put(6);

            ByteBuffer body = ByteBuffer.allocate(20);
            intBuffer = body.asIntBuffer();
            intBuffer.put(6);
            intBuffer.put(7);
            intBuffer.put(8);
            intBuffer.put(9);
            intBuffer.put(10);

            ByteBuffer[] bufferArray = new ByteBuffer[]{magic, header, body};

            channel.write(bufferArray);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testGatheringWrite() {
        RandomAccessFile file = null;
        try {
            file = new RandomAccessFile("ScatterGatherFile","rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        FileChannel channel = file.getChannel();
        ByteBuffer magic = ByteBuffer.allocate(4);
        ByteBuffer header = ByteBuffer.allocate(20);
        ByteBuffer body = ByteBuffer.allocate(20);
        ByteBuffer[] buffers = new ByteBuffer[]{magic, header, body};
        try {
            channel.read(buffers);
            magic.flip();
            IntBuffer intBuffer = magic.asIntBuffer();
            System.out.println(intBuffer.get());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
