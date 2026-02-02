package br.com.pointel.charvs;

import br.com.pointel.jarch.mage.WizProps;
import br.com.pointel.jarch.mage.WizString;

public class Setup {
    
    public static final String keyOnNewClipboardText = "FRAME_SETUP_COMP_ONCLIPBOADNEWTEXT";
    
    public static OnNewClipboardText getOnNewClipboardText() {
        return OnNewClipboardText.values()[WizProps.get(keyOnNewClipboardText, 0)];
    }

    public static final String keyOnNaming = "FRAME_SETUP_COMP_ONNAMING";
    
    public static OnNaming getOnNaming() {
        return OnNaming.values()[WizProps.get(keyOnNaming, 0)];
    }

    public static final String keyNameNumberedPrefix = "FRAME_SETUP_COMP_NAMENUMBEREDPREFIX";
    
    public static String getNameNumberedPrefix() {
        return WizProps.get(keyNameNumberedPrefix, "");
    }

    public static final String keyNameNumberedSize = "FRAME_SETUP_COMP_NAMENUMBEREDSIZE";
    
    public static Integer getNameNumberedSize() {
        return WizProps.get(keyNameNumberedSize, 0);
    }

    public static final String keyNameNumberedSuffix = "FRAME_SETUP_COMP_NAMENUMBEREDSUFFIX";
    
    public static String getNameNumberedSuffix() {
        return WizProps.get(keyNameNumberedSuffix, "");
    }

    public static final String keyNameExtension = "FRAME_SETUP_COMP_NAMEEXTENSION";
    
    public static String getNameExtension() {
        return WizString.firstNonEmpty(WizProps.get(keyNameExtension, ""), ".txt");
    }
    
    public static final String keyOnSave = "FRAME_SETUP_COMP_ONSAVE";
    
    public static OnSave getOnSave() {
        return OnSave.values()[WizProps.get(keyOnSave, 0)];
    }
    
    public static final String keyOnRecord = "FRAME_SETUP_COMP_ONRECORD";
    
    public static OnRecord getOnRecord() {
        return OnRecord.values()[WizProps.get(keyOnRecord, 0)];
    }

    public static final String keyRecordPrefix = "FRAME_SETUP_COMP_RECORDPREFIX";
    
    public static String getRecordPrefix() {
        return WizProps.get(keyRecordPrefix, "");
    }

    public static final String keyRecordSuffix = "FRAME_SETUP_COMP_RECORDSUFFIX";
    
    public static String getRecordSuffix() {
        return WizProps.get(keyRecordSuffix, "");
    }
    
}
