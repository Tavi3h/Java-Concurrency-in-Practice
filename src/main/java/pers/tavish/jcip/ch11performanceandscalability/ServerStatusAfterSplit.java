package pers.tavish.jcip.ch11performanceandscalability;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashSet;
import java.util.Set;

@ThreadSafe
public class ServerStatusAfterSplit {

    @GuardedBy("users")
    public final Set<String> users;

    @GuardedBy("queries")
    public final Set<String> queries;

    public ServerStatusAfterSplit() {
        users = new HashSet<>();
        queries = new HashSet<>();
    }

    public void addUser(String u) {
        synchronized (users) {
            users.add(u);
        }
    }

    public void addQuery(String q) {
        synchronized (queries) {
            queries.add(q);
        }
    }

    public void removeUser(String u) {
        synchronized (users) {
            users.remove(u);
        }
    }

    public void removeQuery(String q) {
        synchronized (users) {
            queries.remove(q);
        }
    }
}
