package ctci.stacks;

import ctci.Animal;
import ctci.Cat;
import ctci.Dog;

import java.util.Stack;

public class AnimalShelter {
  Stack<Animal> orig;
  Stack<Animal> animal;
  Stack<Dog> dog;
  Stack<Cat> cat;
  int dogs, cats;

  public AnimalShelter() {
    // TODO Auto-generated constructor stub
    orig = new Stack<>();
    animal = new Stack<>();
    dog = new Stack<>();
    cat = new Stack<>();
    dogs = 0;
    cats = 0;
  }

  public void enqueue(Animal a) {
    orig.push(a);
  }

  public Animal dequeueAny() {
    if (isEmpty())
      return null;

    if (animal.isEmpty()) {
      peek();
    }
    Animal a = animal.pop();
    if (a instanceof Dog) {
      if (dogs > 0) {
        dogs--;
        return dequeueAny();
      }
      dog.pop();

    } else {
      if (cats > 0) {
        cats--;
        return dequeueAny();
      }
      cat.pop();
    }
    return a;

  }

  public Animal dequeueMyChoiceOfDog(Animal a) {
    if (isEmpty())
      return null;
    if (animal.isEmpty())
      peek();
    if (a instanceof Dog) {
      if (dog.isEmpty())
        return null;
      else {
        Animal anim = dog.pop();
        dogs++;
        return anim;
      }
    } else {
      if (cat.isEmpty())
        return null;
      else {
        Animal anim = cat.pop();
        cats++;
        return anim;
      }
    }
  }

  private void peek() {
    while (!orig.isEmpty()) {
      Animal a = orig.pop();
      if (a instanceof Dog) {
        dog.push((Dog) a);
      } else {
        cat.push((Cat) a);
      }
      animal.push(a);
    }
  }

  private boolean isEmpty() {
    return orig.isEmpty() && animal.isEmpty() && dog.isEmpty() && cat.isEmpty();
  }

}
