package algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {
  static int timestamp = 0;

  public class Tweet {
    int id;
    int timestamp;
    Tweet next;

    Tweet(int id) {
      this.id = id;
      this.timestamp = Twitter.timestamp++;
      next = null;
    }

    public int getTimestamp() {
      return timestamp;
    }
  }

  class User {
    Set<Integer> followed;
    int id;
    Tweet tweetHead;

    User(int id) {
      this.id = id;
      followed = new HashSet<>();
      tweetHead = null;
      followed.add(id);
    }

    public void addTweet(int tweetId) {
      if (tweetHead == null) {
        tweetHead = new Tweet(tweetId);
      } else {
        Tweet tweet = new Tweet(tweetId);
        tweet.next = tweetHead;
        tweetHead = tweet;
      }
    }
  }

  Map<Integer, User> userMap;

  public Twitter() {
    // TODO Auto-generated constructor stub
    userMap = new HashMap<>();
  }

  public void postTweet(int userId, int tweetId) {
    if (!userMap.containsKey(userId)) {
      userMap.put(userId, new User(userId));
    }
    User u = userMap.get(userId);
    u.addTweet(tweetId);
  }

  public void follow(int followerId, int followeeId) {
    if (!userMap.containsKey(followerId)) {
      userMap.put(followerId, new User(followerId));
    }
    if (!userMap.containsKey(followeeId)) {
      userMap.put(followeeId, new User(followeeId));
    }

    User follower = userMap.get(followerId);
    follower.followed.add(followeeId);
  }

  public void unfollow(int followerId, int followeeId) {
    if (followerId == followeeId) {
      return; // you cannot unfollow yourself
    }
    if (userMap.containsKey(followerId) && userMap.containsKey(followeeId)) {
      User follower = userMap.get(followerId);
      follower.followed.remove(followeeId);
    }
  }

  public List<Tweet> getNewsFeed(int userId, int count) {
    if (!userMap.containsKey(userId)) {
      return new ArrayList<Tweet>();
    }

    User user = userMap.get(userId);
    PriorityQueue<Tweet> queue = new PriorityQueue<>(new Comparator<Tweet>() {
      @Override
      public int compare(Tweet o1, Tweet o2) {
        // TODO Auto-generated method stub
        return o2.timestamp - o1.timestamp;
      }
    });

    for (int followeeId : user.followed) {
      User followee = userMap.get(followeeId);
      if (followee == null)
        continue;
      Tweet tHead = followee.tweetHead;

      if (tHead == null)
        continue;
      queue.add(tHead);
    }

    List<Tweet> result = new ArrayList<>();
    while (!queue.isEmpty() && count > 0) {
      Tweet t = queue.poll();
      result.add(t);
      if (t.next != null) {
        queue.add(t.next);
      }
      count--;
    }
    return result;
  }
}
