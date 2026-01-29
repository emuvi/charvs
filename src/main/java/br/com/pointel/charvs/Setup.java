package br.com.pointel.charvs;

import br.com.pointel.jarch.mage.WizProps;

public class Setup {
    
    public static final String keyOnNewClipboardText = "FRAME_SETUP_COMP_ONCLIPBOADNEWTEXT";
    public static final String keyOnNaming = "FRAME_SETUP_COMP_ONNAMING";
    public static final String keyNameNumberedPrefix = "FRAME_SETUP_COMP_NAMENUMBEREDPREFIX";
    public static final String keyNameNumberedSize = "FRAME_SETUP_COMP_NAMENUMBEREDSIZE";
    public static final String keyNameNumberedSuffix = "FRAME_SETUP_COMP_NAMENUMBEREDSUFFIX";
    public static final String keyOnSave = "FRAME_SETUP_COMP_ONSAVE";
    
    public static OnNewClipboardText getOnNewClipboardText() {
        return OnNewClipboardText.values()[WizProps.get(keyOnNewClipboardText, 0)];
    }
    
    public static OnNaming getOnNaming() {
        return OnNaming.values()[WizProps.get(keyOnNaming, 0)];
    }
    
    public static String getNameNumberedPrefix() {
        return WizProps.get(keyNameNumberedPrefix, "");
    }
    
    public static Integer getNameNumberedSize() {
        return WizProps.get(keyNameNumberedSize, 0);
    }
    
    public static String getNameNumberedSuffix() {
        return WizProps.get(keyNameNumberedSuffix, "");
    }
    
    public static OnSave getOnSave() {
        return OnSave.values()[WizProps.get(keyOnSave, 0)];
    }
    
}
