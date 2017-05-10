package geeks4geeks;

public class FirstSetBit {

  public static int getFirstBitSet(int num) {
    if (num <= 0) {
      return -1;
    }
    int count = 0;
    for (int j = 1; j <= num; j = j << 1) {
      if ((num ^ j) == 0) {
        return count;
      }
      count++;
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(getFirstBitSet(18));
  }
}
