package algorithms;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SuffixTrieTest {

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {

  }

  @Test
  public void test() {
    SuffixTrie trie = new SuffixTrie();
    String reallyLongString = "abcdfbcg";
    trie.createSuffixTree(reallyLongString);

    Assert.assertEquals("bc", trie.getLongestRepeatedSubstring(reallyLongString));

  }

  @Test
  public void test2() {
    SuffixTrie t = new SuffixTrie();

    String reallyLongString = "abaaba";
    t.createSuffixTree(reallyLongString);
    
  }

}
