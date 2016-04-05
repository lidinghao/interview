package nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * Created by mandy on 2016/2/28.
 */
public class SocketChannelTest {
    @Test
    public void test() {
        try {
            SocketChannel socketChannel =SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("localhost", 9999));
            CharBuffer charBuffer = CharBuffer.wrap("hello, server socket, I am client socket");
            while (charBuffer.hasRemaining()) {
                socketChannel.write(Charset.availableCharsets().get("UTF-8").encode(charBuffer));
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("read the incoming data from server");
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            socketChannel.read(buffer);
            buffer.flip();
            CharBuffer charBuffer2 = Charset.availableCharsets().get("UTF-8").decode(buffer);
            System.out.println(charBuffer2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
