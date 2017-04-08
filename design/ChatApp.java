package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ChatApp {
  class User {
    int id;
    Set<Conversation> conversations;

    User(int id) {
      this.id = id;
      conversations = new HashSet<>();
    }
  }

  class Conversation {
    int id;
    Set<Integer> users;

    Message head;
    Message tail;

    Conversation(int id) {
      this.id = id;
      users = new HashSet<>();
      head = new Message(-1, null, null);
      tail = new Message(-1, null, null);
      head.next = tail;
      tail.prev = head;
    }

    public void addMessage(Message m) {
      Message next = head.next;
      m.next = next;
      m.prev = head;
      next.prev = m;
      head.next = m;
    }

    private void deleteMessage(Message m) {
      m.prev.next = m.next;
      m.next.prev = m.prev;
    }

    public List<Message> getRecentMessages(int n) {
      List<Message> res = new ArrayList<>();
      Message curr = head.next;
      while (curr != tail && n > 0) {
        res.add(curr);
        curr = curr.next;
        n--;
      }
      return res;
    }

  }

  class Message {
    Message prev;
    Message next;
    int id;
    String text;
    User fromUser;

    Message(int id, String text, User fromUser) {
      prev = next = null;
      this.id = id;
      this.text = text;
      this.fromUser = fromUser;

    }
  }

  Map<Integer, Conversation> conversationsMap;
  Map<Integer, User> usersMap;

  public ChatApp() {
    conversationsMap = new HashMap<>();
    usersMap = new HashMap<>();

    // TODO Auto-generated constructor stub
  }

  public List<Conversation> getAllConversationsForUser(int id) {
    if (usersMap.containsKey(id)) {
      User u = usersMap.get(id);
      return new ArrayList<Conversation>(u.conversations);
    }
    return null;
  }

  public List<Message> getRecentMessagesForConversation(int id) {
    if (conversationsMap.containsKey(id)) {
      Conversation conversation = conversationsMap.get(id);
      return conversation.getRecentMessages(id);
    }
    return null;
  }

  public void sendMessage(int conversationId, Message m) {
    if (conversationsMap.containsKey(conversationId)) {
      Conversation conversation = conversationsMap.get(conversationId);
      conversation.addMessage(m);
    }
  }

  public void deleteConversation(Conversation c) {
    if (conversationsMap.containsKey(c.id)) {
      conversationsMap.remove(c.id);
      for (int user : c.users) {
        if (usersMap.containsKey(user)) {
          User u = usersMap.get(user);
          u.conversations.remove(c.id);
        }
      }
    }
  }

  public void deleteUser(User u) {
    if (usersMap.containsKey(u.id)) {
      usersMap.remove(u.id);
      for (Conversation conv : u.conversations) {
        conv.users.remove(u.id);
      }
    }
  }

  public void createConversation(Conversation c, User u) {
    conversationsMap.putIfAbsent(c.id, c);
    u.conversations.add(c);
  }

  public void createUser(User u) {
    usersMap.putIfAbsent(u.id, u);
  }
}
