package pers.tavish.jcip.ch16thejavamemorymodel;

import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Map;

// 程序清单16-8
@ThreadSafe
public class SafeStates {
    private final Map<String, String> states;

    public SafeStates() {
        states = new HashMap<>();
        states.put("alaska", "AK");
        states.put("alabama", "AL");
        /*...*/
        states.put("wyoming", "WY");
    }

    public String getAbbreviation(String s) {
        return states.get(s);
    }
}