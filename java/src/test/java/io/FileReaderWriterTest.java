package io;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by mandy on 2016/2/27.
 */
public class FileReaderWriterTest {
    String path = getClass().getClassLoader().getResource("FileWriter").getPath();
    @Test
    public void testFileWriter() {
        FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(path);
                fileWriter.write('a');
                fileWriter.write('b');
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        
    }
    @Test
    public void testFileReader(){
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
            char[] chars = new char[2];
            fileReader.read(chars);
            System.out.println(chars[0]);
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
    

}
