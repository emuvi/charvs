package br.com.pointel.charvs;

public class Gears {

    public Boolean requestFocusOnClipboardChange;
    
    public Gears() {
        requestFocusOnClipboardChange = true;
    }
    
    public boolean isToRequestFocusOnClipboardChange() {
        return Boolean.TRUE.equals(requestFocusOnClipboardChange);
    }    
    
}
