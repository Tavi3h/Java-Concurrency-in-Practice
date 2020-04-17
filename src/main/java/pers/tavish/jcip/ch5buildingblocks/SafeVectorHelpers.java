package pers.tavish.jcip.ch5buildingblocks;

import java.util.Vector;

// 程序清单5-2
public class SafeVectorHelpers {

    public static Object getLast(Vector list) {
        synchronized (list) {
            int lastIndex = list.size() - 1;
            return list.get(lastIndex);
        }
    }

    public static void deleteLast(Vector list) {
        synchronized (list) {
            int lastIndex = list.size() - 1;
            list.remove(lastIndex);
        }
    }
}