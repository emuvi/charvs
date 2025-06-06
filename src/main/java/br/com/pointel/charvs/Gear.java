package br.com.pointel.charvs;

import java.util.Arrays;

/**
 *
 * @author emuvi
 */
public class Gear {

    private final Event event;
    private final On action;

    public Gear(Event event, On action) {
        if (event.getActOnClazzs() != null) {
            var found = false;
            for (var actOnClazzs : Arrays.asList(event.getActOnClazzs())) {
                if (action.getClass().equals(actOnClazzs)) {
                    found = true;
                }
            }
            if (!found) {
                throw new RuntimeException("This action is not the right instance for this event.");
            }
        }
        this.event = event;
        this.action = action;
    }

    public Event getEvent() {
        return event;
    }

    public On getAction() {
        return action;
    }
    
}
