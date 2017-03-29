/**
 * 
 */
package test;

import algorithms.LCS;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author rohan.dalvi
 *
 */
public class LCSTest {

  @Test
  public void lcs_test() {
    LCS l = new LCS();

    String a = "ACBEA";
    String b = "ADCA";

    Assert.assertEquals(3, l.lcs(a, b, a.length() - 1, b.length() - 1));

    a = "ABA";
    b = "";
    Assert.assertEquals(0, l.lcs(a, b, a.length() - 1, b.length() - 1));
  }

  @Test
  public void lcsDP_test() {
    LCS l = new LCS();

    String a = "ACBEA";
    String b = "ADCA";

    Assert.assertEquals(3, l.lcsDP(a, b));
  }

}
