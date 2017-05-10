package test;

import static org.junit.Assert.fail;

import design.Instagram;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

public class InstagramTest {

  static Instagram object;
  static Random random;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    object = new Instagram();
    random = new Random();
  }

  @Test
  public void testAddUser() {

    fail("Not yet implemented");
  }

  @Test
  public void testAddPost() {
    fail("Not yet implemented");
  }

  @Test
  public void testDeletePost() {
    fail("Not yet implemented");
  }

  @Test
  public void testDeleteUser() {
    fail("Not yet implemented");
  }

  @Test
  public void testFollowUser() {
    fail("Not yet implemented");
  }

  @Test
  public void testGenerateTimeline() {
    fail("Not yet implemented");
  }

  public String createRandomString() {
    Long l = random.nextLong();
    return l.toString();
  }

}
