package pers.tavish.jcip.ch3sharingobjects;

// 程序清单3-4
public class CountingSheep {

    private volatile boolean asleep;

    public void tryToSleep() {
        while (!asleep) {
            countSomeSheep();
        }
    }

    private void countSomeSheep() {
        // One, two, three...
    }
}
