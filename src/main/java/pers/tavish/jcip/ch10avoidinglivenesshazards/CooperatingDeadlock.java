package pers.tavish.jcip.ch10avoidinglivenesshazards;

import net.jcip.annotations.GuardedBy;
import pers.tavish.jcip.ch4composingobjects.Point;

import java.util.HashSet;
import java.util.Set;

// 程序清单10-5
public class CooperatingDeadlock {
    // Warning: deadlock-prone!
    class Taxi {

        @GuardedBy("this")
        private Point location, destination;

        private final Dispatcher dispatcher;

        public Taxi(Dispatcher dispatcher) {
            this.dispatcher = dispatcher;
        }

        public synchronized Point getLocation() {
            return location;
        }

        public synchronized void setLocation(Point location) {
            this.location = location;
            if (location.equals(destination))
                dispatcher.notifyAvailable(this);
        }

        public synchronized Point getDestination() {
            return destination;
        }

        public synchronized void setDestination(Point destination) {
            this.destination = destination;
        }
    }

    class Dispatcher {

        @GuardedBy("this")
        private final Set<Taxi> taxis;

        @GuardedBy("this")
        private final Set<Taxi> availableTaxis;

        public Dispatcher() {
            taxis = new HashSet<>();
            availableTaxis = new HashSet<>();
        }

        public synchronized void notifyAvailable(Taxi taxi) {
            availableTaxis.add(taxi);
        }

        public synchronized Image getImage() {
            Image image = new Image();
            for (Taxi t : taxis)
                image.drawMarker(t.getLocation());
            return image;
        }
    }

    static class Image {
        public void drawMarker(Point p) {
        }
    }
}
