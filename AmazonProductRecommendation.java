import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class AmazonProductRecommendation {
  static int counter = 0;
  public class Product{
    int id;
    String name;
    Product prev;
    Product next;
    
    Product(String name){
      id = counter++;
      this.name = name;
      prev = next = null;
    }
  }
  
  public Set<Product> getRecommendations(Product product, int num){
    PriorityQueue<Product> queue = new PriorityQueue<>();
    Set<Product> set = new HashSet<>();
    
    while(product!=null && product.next!=null){
      queue.add(product.next);
      product = product.next;
    }
    
    while(!queue.isEmpty() && num > 0){
      Product p = queue.poll();
      set.add(p);
      num--;
    }
    return set;
  }
}
