package test;

import static org.junit.Assert.fail;

import design.Instagram;
import junit.framework.Assert;
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

    Assert.assertTrue(true); // not yet implemented
  }

  @Test
  public void testAddPost() {
    Assert.assertTrue(true); // not yet implemented
  }

  @Test
  public void testDeletePost() {
    Assert.assertTrue(true); // not yet implemented
  }

  @Test
  public void testDeleteUser() {
    Assert.assertTrue(true); // not yet implemented
  }

  @Test
  public void testFollowUser() {
    Assert.assertTrue(true); // not yet implemented
  }

  @Test
  public void testGenerateTimeline() {
    Assert.assertTrue(true); // not yet implemented
  }

  public String createRandomString() {
    Long l = random.nextLong();
    return l.toString();
  }

}
