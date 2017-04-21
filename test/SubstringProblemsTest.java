package test;

import algorithms.SubstringProblems;
import org.junit.BeforeClass;
import org.junit.Test;

public class SubstringProblemsTest {

  static SubstringProblems problems;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    problems = new SubstringProblems();
  }

  @Test
  public void test() {
    String str = "rohan";
    problems.allSubstrings(str);
  }

}
