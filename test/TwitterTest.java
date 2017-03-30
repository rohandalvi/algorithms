package test;

import algorithms.Twitter;
import algorithms.Twitter.Tweet;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class TwitterTest {

  static Twitter myTwitter;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    myTwitter = new Twitter();
  }

  @Test
  public void test() {
    myTwitter.postTweet(1, 5);

    List<Tweet> result = myTwitter.getNewsFeed(1, 10);

    Assert.assertEquals(1, result.size());
    myTwitter.follow(1, 2);

    myTwitter.postTweet(2, 6);

    result = myTwitter.getNewsFeed(1, 10);

    Assert.assertEquals(2, result.size());
    for (int i = 0; i < result.size() - 1; i++) {
      Assert.assertTrue(result.get(i).getTimestamp() > result.get(i + 1).getTimestamp());
    }

    myTwitter.unfollow(1, 2);
    result = myTwitter.getNewsFeed(1, 10);
    Assert.assertEquals(1, result.size());

  }

}
