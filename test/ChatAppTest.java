package test;

import design.ChatApp;
import org.junit.BeforeClass;
import org.junit.Test;

public class ChatAppTest {

  static ChatApp chatApp;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    chatApp = new ChatApp();
  }

  @Test
  public void test() {

  }

}
