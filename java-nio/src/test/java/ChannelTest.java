import org.junit.Test;
import sun.nio.ch.FileChannelImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;

/**
 * Created by mandy on 2016/2/28.
 */
public class ChannelTest {
    String url = getClass().getClassLoader().getResource("RandomAccessFile").getPath();
    @Test
    public void testChannel() {
        try {
            RandomAccessFile raf = new RandomAccessFile(url, "rw");
            int[] ints = new int[]{1, 2, 3, 4,};
            ByteBuffer byteBuffer = ByteBuffer.allocate(20);
            IntBuffer intBuffer = byteBuffer.asIntBuffer();
            intBuffer.put(ints);
            FileChannel channel = raf.getChannel();
            channel.write(byteBuffer);


            int[] ints2 = new int[]{8};
            ByteBuffer byteBuffer2 = ByteBuffer.allocate(4);
            IntBuffer intBuffer2 = byteBuffer2.asIntBuffer();
            intBuffer2.put(ints2);

            SeekableByteChannel seekableByteChannel = (SeekableByteChannel) channel;
            seekableByteChannel.position(3);
            seekableByteChannel.write(byteBuffer2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testTransfer() {
        try {
            RandomAccessFile fromFile = new RandomAccessFile("fromFile", "rw");
            FileChannel fromChannel = fromFile.getChannel();

            RandomAccessFile toFile = new RandomAccessFile("toFile", "rw");
            FileChannel toChannel = toFile.getChannel();
            toChannel.transferFrom(fromChannel, 0, fromChannel.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
