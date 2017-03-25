package test;

import static org.junit.Assert.fail;

import algorithms.LFUCache;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LFUCacheTest {

  static LFUCache cache;

  @BeforeClass
  public static void setUp() {
    cache = new LFUCache(2);
  }

  @Test
  public void testLFUCache() {
    cache.set(1, 1);
    cache.set(2, 2);

    Assert.assertEquals(1, cache.get(1));
    cache.set(3, 3);
    Assert.assertEquals(-1, cache.get(2));
    Assert.assertEquals(3, cache.get(3));
    cache.set(4, 4);

    Assert.assertEquals(-1, cache.get(1));
    Assert.assertEquals(3, cache.get(3));
    Assert.assertEquals(4, cache.get(4));

  }

  @Test
  public void testGet() {
    fail("Not yet implemented");
  }

  @Test
  public void testSet() {
    fail("Not yet implemented");
  }

}
