import org.apache.tools.ant.taskdefs.Java;
import org.junit.Test;

import javax.tools.*;
import java.net.URI;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by mandy on 2016/3/1.
 */
public class CompilerTest {
    @Test
    public void test() {
        String sourceCode = "public class Main { " +
                "public static void main(String[] args) {" +
                "System.out.println(\"Hello World!\");" +
                "}" +
                "}";


    JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
    StandardJavaFileManager javaFileManager = javaCompiler.getStandardFileManager(null, null, null);
    JavaSourceFromString javaSourceFromString = new JavaSourceFromString("Main", sourceCode);
        Iterable<? extends JavaFileObject> compilationUnits =
                Arrays.asList(javaSourceFromString);
       JavaCompiler.CompilationTask task = javaCompiler.getTask(null, javaFileManager, null, null, null, compilationUnits);
        boolean  result = task.call();
        if (result) {
            System.out.println("compile success");
        }


    }
    /**
     * A file object used to represent source coming from a string.
     */
    static class JavaSourceFromString extends SimpleJavaFileObject {
        /**
         * The source code of this "file".
         */
        final String code;

        /**
         * Constructs a new JavaSourceFromString.
         * @param name the name of the compilation unit represented by this file object
         * @param code the source code for the compilation unit represented by this file object
         */
        JavaSourceFromString(String name, String code) {
            super(URI.create("string:///" + name.replace('.','/') + Kind.SOURCE.extension),
                    Kind.SOURCE);
            this.code = code;
        }

        @Override
        public CharSequence getCharContent(boolean ignoreEncodingErrors) {
            return code;
        }
    }
}
