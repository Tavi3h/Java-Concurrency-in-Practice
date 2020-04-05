package pers.tavish.jcip.ch3sharingobjects;

// 程序清单3-14
// Don't do this.
public class StuffIntoPublic {

    public Holder holder;

    public void initialize() {
        holder = new Holder(42);
    }
}