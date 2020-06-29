package pers.tavish.jcip.ch16thejavamemorymodel;

import net.jcip.annotations.ThreadSafe;

// 程序清单16-5
@ThreadSafe
public class EagerInitialization {
    private static final Resource resource = new Resource();

    public static Resource getResource() {
        return resource;
    }

    static class Resource {
    }
}