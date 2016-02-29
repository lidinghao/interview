import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Created by mandy on 2016/2/28.
 */
public class SocketTest {
    @Test
    public void testSocket() {
        try {
            Socket socket = new Socket("jenkov.com", 80);
            InputStream inputStream = socket.getInputStream();
            System.out.println(inputStream.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
