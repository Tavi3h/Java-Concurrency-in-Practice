package pers.tavish.jcip.ch16thejavamemorymodel;

import net.jcip.annotations.ThreadSafe;

// 程序清单16-4
@ThreadSafe
public class SafeLazyInitialization {
    private static Resource resource;

    public synchronized static Resource getInstance() {
        if (resource == null)
            resource = new Resource();
        return resource;
    }

    static class Resource {
    }
}