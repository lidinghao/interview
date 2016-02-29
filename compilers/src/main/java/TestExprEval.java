/**
 * Created by mandy on 2016/1/23.
 */
import org.antlr.runtime.*;

import java.io.ByteArrayInputStream;

public class TestExprEval {
    public static void main(String[] args) throws Exception {
        String s = "x=1\ny=2\n3*(x+y)\n";
        ByteArrayInputStream in = new ByteArrayInputStream(s.getBytes());
        ANTLRInputStream input = new ANTLRInputStream(in);
        ExprEvalLexer lexer = new ExprEvalLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprEvalParser parser = new ExprEvalParser(tokens);
        parser.prog();
    }
}