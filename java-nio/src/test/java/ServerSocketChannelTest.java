import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by mandy on 2016/2/28.
 */
public class ServerSocketChannelTest {
    @Test
    public void test() {
        try {
            ServerSocketChannel  serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("localhost",9999));
            while (true) {
                serverSocketChannel.configureBlocking(false);
                Calendar calendar = Calendar.getInstance();
                System.out.println("we are in non-blocking mode!" + calendar.getTime());
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (socketChannel != null) {
                    System.out.println("incoming connection accepted");
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    socketChannel.read(buffer);
                    buffer.flip();
                    CharBuffer charBuffer = Charset.availableCharsets().get("UTF-8").decode(buffer);
                    System.out.println(charBuffer);
                    return;
                }
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelector() {
        try {
            Selector selector = Selector.open();
            int interestSet = SelectionKey.OP_ACCEPT;

            ServerSocketChannel  serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress("localhost",9999));

            serverSocketChannel.register(selector, interestSet);

         while (true) {
             int readyChannels = selector.select();
             if (readyChannels == 0) continue;
             Set<SelectionKey> selectedKeys = selector.selectedKeys();
             Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
             while (keyIterator.hasNext()){
                 SelectionKey selectedKey = keyIterator.next();
                 if (selectedKey.isAcceptable()) {
                     System.out.println("accept the incoming connection");
                     SocketChannel socketChannel = ((ServerSocketChannel) selectedKey.channel()).accept();
                     socketChannel.configureBlocking(false);
                     socketChannel.register(selectedKey.selector(), SelectionKey.OP_READ|SelectionKey.OP_WRITE);

                 }else if (selectedKey.isReadable()) {
                     System.out.println("read the incoming data from client");
                     ByteBuffer buffer = ByteBuffer.allocate(1024);
                     ((SocketChannel) selectedKey.channel()).read(buffer);
                     buffer.flip();
                     CharBuffer charBuffer = Charset.availableCharsets().get("UTF-8").decode(buffer);
                     System.out.println(charBuffer);

                 } else if (selectedKey.isWritable()) {
                     System.out.println("write the data to client");
                     CharBuffer charBuffer = CharBuffer.wrap("hello, client socket, I am server socket !");
                     ((SocketChannel) selectedKey.channel()).write(
                             Charset.availableCharsets().get("UTF-8").encode(charBuffer));
                 }
                 keyIterator.remove();
             }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
