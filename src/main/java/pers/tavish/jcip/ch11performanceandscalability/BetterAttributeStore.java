package pers.tavish.jcip.ch11performanceandscalability;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

// 程序清单11-5
@ThreadSafe
public class BetterAttributeStore {

    @GuardedBy("this")
    private final Map<String, String> attributes = new HashMap<String, String>();

    public boolean userLocationMatches(String name, String regexp) {
        String key = "users." + name + ".location";
        String location;
        synchronized (this) {
            location = attributes.get(key);
        }
        return location != null && Pattern.matches(regexp, location);
    }
}
