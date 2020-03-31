package pers.tavish.jcip.ch3sharingobjects;

import java.util.HashSet;
import java.util.Set;

// 程序清单3-5
class Secrets {

    public static Set<Secret> knownSecrets;

    public void initialize() {
        knownSecrets = new HashSet<Secret>();
    }
}

class Secret {

}
