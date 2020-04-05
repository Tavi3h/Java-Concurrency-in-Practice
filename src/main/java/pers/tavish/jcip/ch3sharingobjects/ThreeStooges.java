package pers.tavish.jcip.ch3sharingobjects;

import net.jcip.annotations.Immutable;

import java.util.HashSet;
import java.util.Set;

// 程序清单3-11
@Immutable
public class ThreeStooges {

    private final Set<String> stooges = new HashSet<>();

    public ThreeStooges() {
        stooges.add("Moe");
        stooges.add("Larry");
        stooges.add("Curly");
    }

    public boolean isStooge(String name) {
        return stooges.contains(name);
    }
}
