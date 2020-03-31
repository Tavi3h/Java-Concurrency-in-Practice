package pers.tavish.jcip.ch3sharingobjects;

// 程序清单3-7
// Don't do this.
public class ThisEscape {

    private int num;

    public ThisEscape(EventSource source) {
        source.registerListener(new EventListener() {
            public void onEvent(Event e) {
                doSomething(e);
            }
        });
        num = 42;
    }

    private void doSomething(Event e) {
        if (num != 42) {
            System.out.println("Race condition detected");
        }
    }

    interface EventSource {
        void registerListener(EventListener e);
    }

    interface EventListener {
        void onEvent(Event e);
    }

    interface Event {

    }
}
