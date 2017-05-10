package test;

import ctci.Animal;
import ctci.Cat;
import ctci.Dog;
import ctci.stacks.AnimalShelter;
import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class AnimalShelterTest {

  static AnimalShelter object;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    object = new AnimalShelter();
  }

  @Test
  public void testEnqueue() {
    for (int i = 0; i < 1000; i++) {
      Animal a;
      if (i % 2 == 0) {
        a = new Dog();
      } else {
        a = new Cat();
      }
      object.enqueue(a);
    }
  }

}
