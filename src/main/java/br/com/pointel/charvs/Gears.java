package br.com.pointel.charvs;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 *
 * @author emuvi
 */
public class Gears extends ArrayList<Gear> {
    
    public void filterAct(Event filter, Consumer<? super Gear> act) {
        stream()
                .filter(g -> g.getEvent().equals(filter))
                .forEach(act);
    }
    
}
