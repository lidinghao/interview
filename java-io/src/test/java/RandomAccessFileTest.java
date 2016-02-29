import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by mandy on 2016/2/27.
 */
public class RandomAccessFileTest {
    String url = getClass().getClassLoader().getResource("RandomAccessFile").getPath();

    @Test
    public void testRandomWrite() {
        try {
            RandomAccessFile raf = new RandomAccessFile(url, "rw");
            for (int i = 0; i < 5; i++) {
            raf.writeInt(i);
            }
            raf.seek(3);
            raf.writeInt(100);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testRandomRead() {
        try {
            RandomAccessFile raf = new RandomAccessFile(url, "rw");
            raf.seek(3);
            System.out.println(raf.readInt());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
