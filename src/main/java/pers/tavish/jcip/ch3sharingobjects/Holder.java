package pers.tavish.jcip.ch3sharingobjects;

// 程序清单3-15
public class Holder {

    private int n;

    public Holder(int n) {
        this.n = n;
    }

    public void assertSanity(int n) {
        if (this.n != n) {
            throw new AssertionError("This statement is false.");
        }
    }
}