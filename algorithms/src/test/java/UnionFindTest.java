import org.junit.Test;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by mandy on 2016/1/18.
 */
public class UnionFindTest {

    @Test
    public void testUnion() throws Exception {

    }

    @Test
    public void testFind() throws Exception {

    }

    @org.junit.Test
    public void testConnected() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("tinyUF.txt").getFile());
        Scanner sc = new Scanner(new FileInputStream(file));
        int N = sc.nextInt();
        UnionFind uf = new UnionFind(N);

        while (sc.hasNextInt()) {
            int p = sc.nextInt();
            int q = sc.nextInt();
            if (uf.connected(p,q))
                continue;
            else
                uf.union(p, q);

        }
        assertEquals(2, uf.count());


    }

    @org.junit.Test
    public void testCount() throws Exception {

    }
}