package br.com.pointel.charvs;

import br.com.pointel.jarch.flow.App;
import br.com.pointel.jarch.flow.AppGUI;
import br.com.pointel.jarch.mage.WizApp;

public class Charvs {

    public static void main(String[] args) {
        new App(new AppGUI( CharvsDesk.class)).start("Charvs", args);
    }
    
}
