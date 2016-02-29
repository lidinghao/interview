import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Created by mandy on 2016/2/27.
 */
public class InputStreamReaderTest {
    String path = getClass().getClassLoader().getResource("InputStreamReader").getPath();
    @Test
    public void testInputStreamWriter() {
        try {
            FileOutputStream fis = new FileOutputStream(path);
            BufferedWriter br = new BufferedWriter(new OutputStreamWriter(fis, StandardCharsets.UTF_8));
            try {
                br.write("我卡卡");
                br.flush();
               // fis.getFD().sync();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testInputStreamReader() {
        try {
            FileInputStream fis = new FileInputStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis, StandardCharsets.UTF_8));
            try {
                System.out.println(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
