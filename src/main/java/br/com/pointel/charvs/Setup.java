package br.com.pointel.charvs;

import br.com.pointel.jarch.mage.WizProps;

public class Setup {
    
    public static OnNewClipboardText doOnNewClipboardText() {
        return OnNewClipboardText.values()[WizProps.get("FRAME_SETUP_COMP_ONCLIPBOADNEWTEXT", 0)];
    }
    
    public static OnNaming doOnNaming() {
        return OnNaming.values()[WizProps.get("FRAME_SETUP_COMP_ONNAMING", 0)];
    }
    
    public static String getNameNumberedPrefix() {
        return WizProps.get("FRAME_SETUP_COMP_NAMENUMBEREDPREFIX", "");
    }
    
    public static Integer getNameNumberedSize() {
        return WizProps.get("FRAME_SETUP_COMP_NAMENUMBEREDSIZE", 0);
    }
    
    public static String getNameNumberedSuffix() {
        return WizProps.get("FRAME_SETUP_COMP_NAMENUMBEREDSUFFIX", "");
    }
    
    public static OnSave doOnSave() {
        return OnSave.values()[WizProps.get("FRAME_SETUP_COMP_ONSAVE", 0)];
    }
    
}
