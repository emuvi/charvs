package br.com.pointel.charvs;

import java.io.File;
import java.util.ArrayList;

import br.com.pointel.jarch.mage.WizObject;
import br.com.pointel.jarch.mage.WizProps;
import br.com.pointel.jarch.mage.WizString;

public class Setup {
    
    public static final String keyOnNewClipboardText = "FRAME_SETUP_COMP_ON_CLIPBOARD_NEW_TEXT";
    
    public static OnNewClipboardText getOnNewClipboardText() {
        return OnNewClipboardText.values()[WizProps.get(keyOnNewClipboardText, 0)];
    }

    public static final String keyOnNaming = "FRAME_SETUP_COMP_ON_NAMING";
    
    public static OnNaming getOnNaming() {
        return OnNaming.values()[WizProps.get(keyOnNaming, 0)];
    }

    public static final String keyNameNumberedPrefix = "FRAME_SETUP_COMP_NAME_NUMBERED_PREFIX";
    
    public static String getNameNumberedPrefix() {
        return WizProps.get(keyNameNumberedPrefix, "");
    }

    public static final String keyNameNumberedSize = "FRAME_SETUP_COMP_NAME_NUMBERED_SIZE";
    
    public static Integer getNameNumberedSize() {
        return WizProps.get(keyNameNumberedSize, 0);
    }

    public static final String keyNameNumberedSuffix = "FRAME_SETUP_COMP_NAME_NUMBERED_SUFFIX";
    
    public static String getNameNumberedSuffix() {
        return WizProps.get(keyNameNumberedSuffix, "");
    }

    public static final String keyNameExtension = "FRAME_SETUP_COMP_NAME_EXTENSION";
    
    public static String getNameExtension() {
        return WizString.firstNonEmpty(WizProps.get(keyNameExtension, ""), ".txt");
    }

    public static final String keyStripFirstLines = "FRAME_SETUP_COMP_STRIP_FIRST_LINES";
    
    public static Integer getStripFirstLines() {
        return WizProps.get(keyStripFirstLines, 0);
    }

    public static final String keyInsertAtBegin = "FRAME_SETUP_COMP_INSERT_AT_BEGIN";
    
    public static String getInsertAtBegin() {
        return WizProps.get(keyInsertAtBegin, "");
    }

    public static final String keyInsertAtEnd = "FRAME_SETUP_COMP_INSERT_AT_END";
    
    public static String getInsertAtEnd() {
        return WizProps.get(keyInsertAtEnd, "");
    }

    public static final String keyApplyReplacesList = "FRAME_SETUP_COMP_APPLY_REPLACES_LIST";
    
    public static Boolean getApplyReplacesList() {
        return WizProps.get(keyApplyReplacesList, false);
    }

    public static final String keyReplaceVarsHolders = "FRAME_SETUP_COMP_REPLACE_VARS_HOLDERS";
    
    public static Boolean getReplaceVarsHolders() {
        return WizProps.get(keyReplaceVarsHolders, false);
    }

    public static final String keyTrimFinalText = "FRAME_SETUP_COMP_TRIM_FINAL_TEXT";
    
    public static Boolean getTrimFinalText() {
        return WizProps.get(keyTrimFinalText, false);
    }

    public static ArrayList<Replace> readReplacesList() throws Exception {
        var file = new File("replaces.ser");
        if (!file.exists()) {
            return new ArrayList<>();
        }
        return (ArrayList<Replace>) WizObject.read(file);
    }

    public static void writeReplacesList(ArrayList<Replace> replaces) throws Exception {
        WizObject.write(new File("replaces.ser"), replaces);
    }
    
    public static final String keyOnSaveExists = "FRAME_SETUP_COMP_ON_SAVE_EXISTS";
    
    public static OnSaveExists getOnSaveExists() {
        return OnSaveExists.values()[WizProps.get(keyOnSaveExists, 0)];
    }
    
    public static final String keyOnRecord = "FRAME_SETUP_COMP_ON_RECORD";
    
    public static OnRecord getOnRecord() {
        return OnRecord.values()[WizProps.get(keyOnRecord, 0)];
    }

    public static final String keyRecordPrefix = "FRAME_SETUP_COMP_RECORD_PREFIX";
    
    public static String getRecordPrefix() {
        return WizProps.get(keyRecordPrefix, "");
    }

    public static final String keyRecordSuffix = "FRAME_SETUP_COMP_RECORD_SUFFIX";
    
    public static String getRecordSuffix() {
        return WizProps.get(keyRecordSuffix, "");
    }
    
}
