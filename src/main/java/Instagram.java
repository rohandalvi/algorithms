package design;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;

/**
 * 
 * @author rohan.dalvi
 *
 * Features:
 * 1. Add/delete user
 * 2. Add/delete Post
 * 3. Follow user
 * 4. Generate Timeline
 */
public class Instagram {
  static int counter = 0;
  static Random random = new Random();

  public class User {
    int id;
    String username;
    String email;
    Set<User> followed;

    public User(String username, String email) {
      id = counter++;
      this.username = username;
      this.email = email;
      followed = new HashSet<>(); // set of users this user follows
      followed.add(this);
    }

    public void follow(User u) {
      followed.add(u);
    }
  }

  public class Post {
    int id;
    User user;
    Date time;
    Post next, prev;

    Post(User user) {
      this.id = counter++;
      this.user = user;
      this.time = new Date();
      next = prev = null;
    }
  }

  Map<Integer, User> userMap;
  Map<Integer, Post> postMap;

  public Instagram() {
    // TODO Auto-generated constructor stub
    userMap = new HashMap<>();
    postMap = new HashMap<>();

  }

  public void deletePost(Post p) {
    User associatedUser = p.user;
    if (associatedUser != null && postMap.containsKey(associatedUser.id)) {
      if (p.prev != null)
        p.prev.next = p.next;
      if (p.next != null)
        p.next.prev = p.prev;
    }
  }

  public void addUser(User u) {
    if (!userMap.containsKey(u.id)) {
      userMap.put(u.id, u);
    }
  }

  public void deleteUser(User u) {
    if (userMap.containsKey(u.id)) {
      userMap.remove(u.id);
    }
    if (postMap.containsKey(u.id)) {
      postMap.remove(u.id);
    }
  }

  public void addPost(User u) {
    Post p = new Post(u);
    if (postMap.containsKey(u.id)) {
      Post temp = postMap.get(u.id);
      temp.prev = p;
      p.next = temp;
    }
    postMap.put(u.id, p);
  }

  public void followUser(User follower, User followee) {
    // follower follows followee
    if (!userMap.containsKey(follower.id)) {
      userMap.put(follower.id, follower);
    }
    if (!userMap.containsKey(followee.id)) {
      userMap.put(followee.id, followee);
    }

    follower.follow(followee);
  }

  public List<Post> generateTimeline(User u, int numberOfPosts) {
    List<Post> timelinePosts = new ArrayList<>();
    PriorityQueue<Post> queue = new PriorityQueue<>(new Comparator<Post>() {
      public int compare(Post a, Post b) {
        return b.time.compareTo(a.time);
      }
    });

    for (User followed : u.followed) {
      if (postMap.containsKey(followed.id)) {
        queue.add(postMap.get(followed.id));
      }
    }

    while (!queue.isEmpty() && numberOfPosts > 0) {
      Post post = queue.poll();
      timelinePosts.add(post);
      if (post.next != null) {
        queue.add(post.next);
      }
      numberOfPosts--;
    }

    return timelinePosts;
  }
}
