package pers.tavish.jcip.ch16thejavamemorymodel;

import net.jcip.annotations.NotThreadSafe;

// 程序清单16-7
// don't do this
@NotThreadSafe
public class DoubleCheckedLocking {
    private static Resource resource;

    public static Resource getInstance() {
        if (resource == null) {
            synchronized (DoubleCheckedLocking.class) {
                if (resource == null)
                    resource = new Resource();
            }
        }
        return resource;
    }

    static class Resource {

    }
}