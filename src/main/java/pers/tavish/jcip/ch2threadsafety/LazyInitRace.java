package pers.tavish.jcip.ch2threadsafety;

import net.jcip.annotations.NotThreadSafe;

// 程序清单2-3
// Don't do this.
@NotThreadSafe
public class LazyInitRace {

    private ExpensiveObject instance = null;

    public ExpensiveObject getInstance() {
        if (instance == null) {
            instance = new ExpensiveObject();
        }
        return instance;
    }
}

class ExpensiveObject {

}