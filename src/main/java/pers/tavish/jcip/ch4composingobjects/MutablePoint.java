package pers.tavish.jcip.ch4composingobjects;

import net.jcip.annotations.NotThreadSafe;

// 程序清单4-5
// Don't do this.
@NotThreadSafe
public class MutablePoint {
    public int x, y;

    public MutablePoint() {
        this.x = 0;
        this.y = 0;
    }

    public MutablePoint(MutablePoint p) {
        this.x = p.x;
        this.y = p.y;
    }
}
