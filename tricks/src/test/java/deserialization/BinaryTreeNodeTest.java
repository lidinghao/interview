package deserialization;

import static org.junit.Assert.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mandy on 2016/1/16.
 */
public class BinaryTreeNodeTest {

    @org.junit.Test
    public void testPreOrder() throws Exception {
        ObjectMapper objMapper = new ObjectMapper();
        final String jsonStr = "{\n"
                + "  \"value\": 2,\n"
                + "  \"left\": {\n"
                + "    \"value\": 1,\n"
                + "    \"left\": null,\n"
                + "    \"right\": null\n"
                + "  },\n" + "  \"right\": {\n"
                + "    \"value\": 10,\n"
                + "    \"left\": {\n"
                + "      \"value\": 5,\n"
                + "      \"left\": null,\n"
                + "      \"right\": null\n"
                + "    },\n"
                + "    \"right\": null\n"
                + "  }\n"
                + "}";
        System.out.println(jsonStr);
        BinaryTreeNode<Integer> tree = objMapper.readValue(jsonStr,
                new TypeReference<BinaryTreeNode<Integer>>(){});
        final List<Integer> listExpected = Arrays.asList(2, 1, 10, 5);
        assertEquals(listExpected, tree.preOrder());
    }
}