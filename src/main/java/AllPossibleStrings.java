package geeks4geeks;

public class AllPossibleStrings {

  /**
   * Given a string str your task is to complete the function printSpaceString which takes only one argument the string
   * str and prints all possible strings that can be made by placing spaces (zero or one) in between them.
   * 
   * For eg . for the string abc all valid strings will be abc$ ab c$ a bc$ a b c$
   * 
   * @param str
   */
  public void printSpace(String str) {
    int n = str.length();
    dfs(1, n, "" + str.charAt(0), str);
    
  }

  private void dfs(int index, int length, String temp, String str) {
    if (index == length) {
      System.out.println(temp + "$");
      return;
    }

    dfs(index + 1, length, temp + str.charAt(index), str);
    dfs(index + 1, length, temp + " " + str.charAt(index), str);
  }
}
