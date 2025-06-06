package br.com.pointel.charvs;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author emuvi
 */
public class Gears extends ArrayList<Gear> {
    
    public <R> R actOn(Event event, Object input, Class<? extends R> returnClazz) {
        var result = input;
        for (var gear : this) {
            if (Objects.equals(gear.getEvent(), event)) {
                result = gear.getAction().execute(result);
            }
        }
        return returnClazz.cast(result);
    }
    
}
