package br.com.pointel.charvs;

/**
 *
 * @author emuvi
 */
public class Gear {

    private final Event event;
    private final Action action;

    public Gear(Event event, Action action) {
        this.event = event;
        this.action = action;
    }

    public Event getEvent() {
        return event;
    }

    public Action getAction() {
        return action;
    }
    
}
