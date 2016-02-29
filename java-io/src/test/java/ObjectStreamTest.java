import org.junit.Test;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.net.URL;

/**
 * Created by mandy on 2016/2/26.
 */
public class ObjectStreamTest {
    @Test
    public void testObjectOutput() {
        URL url = getClass().getClassLoader().getResource("objectOutputStream");
        File file = new File(url.getPath());
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            ObjectForSerDe objectForSerDe = new ObjectForSerDe();
            objectForSerDe.setAllField();
            oos.writeObject(objectForSerDe);
            oos.flush();
            fos.getFD().sync();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    @Test
    public void testObjectInput() {
        URL url = getClass().getClassLoader().getResource("objectOutputStream");
        File file = new File(url.getPath());
        FileInputStream fos = null;
        try {
            fos = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream oos = new ObjectInputStream(fos);
            try {
                ObjectForSerDe objectForSerDe = (ObjectForSerDe) oos.readObject();
                java.lang.reflect.Field[] fields = objectForSerDe.getClass().getDeclaredFields();
                for (Field f : fields) {
                    f.setAccessible(true);
                }

                int i = fields[0].getInt(objectForSerDe);
                Type genericType = fields[1].getGenericType();
                System.out.println(fields[0].getInt(objectForSerDe));
                System.out.println(fields[1].getInt(objectForSerDe));
                System.out.println(fields[2].getDouble(objectForSerDe));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
//            } catch (NoSuchFieldException e) {
//                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
