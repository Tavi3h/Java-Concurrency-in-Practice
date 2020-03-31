package pers.tavish.jcip.ch3sharingobjects;

import lombok.Getter;

// 程序清单3-6
// Don't do this.
@Getter
public class UnsafeStates {
    private String[] states = new String[]{
            "AK", "AL" // ...
    };
}
