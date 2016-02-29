package SubstringSearch;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mandy on 2016/1/22.
 */
public class KMPTest {

    @Test
    public void testSearch() throws Exception {
        KMP kmp = new KMP("AABACAABABACAA", "BABAC");
        kmp.buildDFA();
        assertEquals(7, kmp.search());
        kmp.buildPrefixTable();
        assertEquals(7, kmp.search2());

    }

    @Test
    public void testBuildDFA() throws Exception {
        KMP kmp = new KMP("AABACAABABACAA", "ABABAC");
        kmp.buildDFA();
    }
}