package pers.tavish.jcip.ch16thejavamemorymodel;

import net.jcip.annotations.ThreadSafe;

// 程序清单16-6
@ThreadSafe
public class ResourceFactory {
    private static class ResourceHolder {
        public static Resource resource = new Resource();
    }

    public static Resource getResource() {
        return ResourceFactory.ResourceHolder.resource;
    }

    static class Resource {
    }
}