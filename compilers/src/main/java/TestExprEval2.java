import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import sun.org.mozilla.javascript.internal.ast.AstNode;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Created by mandy on 2016/1/23.
 */
public class TestExprEval2 {
    public static void main(String[] args) throws IOException, RecognitionException {
    String s = "x=1\ny=2\n3*(x+y)\n";
    ByteArrayInputStream in = new ByteArrayInputStream(s.getBytes());
    ANTLRInputStream input = new ANTLRInputStream(in);
        ExprEval2Lexer lexer = new ExprEval2Lexer(input);
        CommonTokenStream stream = new CommonTokenStream(lexer);
        ExprEval2Parser parser = new ExprEval2Parser(stream);
        CommonTree t = parser.prog().getTree();
        int j = 0;
    }





}
