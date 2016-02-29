import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

/**
 * Created by mandy on 2016/2/26.
 */
public class ByteArrayStreamTest {
    @Test
    public void testOutPut() {
        String url = getClass().getClassLoader().getResource("ByteArrayStream").getPath();
        Path path = Paths.get(url);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        try {
            dos.writeChar('a');
            dos.writeDouble(2.358);
            dos.writeInt(888);
            dos.flush();
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int ch1 = baos.toByteArray()[0];
        int ch2 = baos.toByteArray()[1];
        char ch  = (char)((ch1 << 8) + (ch2 << 0));
        System.out.println(ch);
//        try {
//            Files.write(path,baos.toByteArray(), StandardOpenOption.CREATE);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    @Test
    public void testInput() {
        byte[] byteArray = new byte[5];
        char a = 'a';

        byteArray[0] = (byte) ((a >>> 8) & 0xFF);
        byteArray[1] = (byte) ((a >>> 0) & 0xFF);
        ByteArrayInputStream bas = new ByteArrayInputStream(byteArray);

        byte[] byteArray2 = new byte[5];
        bas.read(byteArray2, 0, 5);

        int ch1 = byteArray2[0];
        int ch2 = byteArray2[1];
        char ch  = (char)((ch1 << 8) + (ch2 << 0));
        System.out.println(ch);


    }
}
