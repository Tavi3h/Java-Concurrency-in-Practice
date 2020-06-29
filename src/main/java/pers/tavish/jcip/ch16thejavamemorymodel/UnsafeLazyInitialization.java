package pers.tavish.jcip.ch16thejavamemorymodel;

import net.jcip.annotations.NotThreadSafe;

// 程序清单16-3
// don't do this
@NotThreadSafe
public class UnsafeLazyInitialization {
    private static Resource resource;

    public static Resource getInstance() {
        if (resource == null)
            resource = new Resource(); // unsafe publication
        return resource;
    }

    static class Resource {
    }
}