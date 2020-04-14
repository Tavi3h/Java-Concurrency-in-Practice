package pers.tavish.jcip.ch4composingobjects;

import net.jcip.annotations.Immutable;

// 程序清单4-6
@Immutable
public class Point {
    public final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
