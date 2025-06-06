package br.com.pointel.charvs;

/**
 *
 * @author emuvi
 */
public enum Event {
    
    ON_CLIPBOARD_NEW_TEXT(OnClipboardNewText.class,
        ActOnClipboardNewTextDoFrameToFront.class),
    ON_CLIPBOARD_NEW_IMAGE(OnClipboardNewImage.class),
    
    ON_BEFORE_BUFFER_CLEAR(On.class),
    ON_AFTER_BUFFER_CLEAR(On.class),
    ON_BEFORE_BUFFER_APPEND(On.class),
    ON_AFTER_BUFFER_APPEND(On.class),
    
    ON_BEFORE_ORIGIN_SELECT(On.class),
    ON_AFTER_ORIGIN_SELECT(On.class),
    ON_BEFORE_ORIGIN_OPEN(On.class),
    ON_AFTER_ORIGIN_OPEN(On.class),
    ON_BEFORE_ORIGIN_FILES_UPDATE(On.class),
    ON_AFTER_ORIGIN_FILES_UPDATE(On.class),
    ON_BEFORE_ORIGIN_FILE_OPEN(On.class),
    ON_AFTER_ORIGIN_FILE_OPEN(On.class),
    ON_BEFORE_ORIGIN_FILES_FIRST(On.class),
    ON_AFTER_ORIGIN_FILES_FIRST(On.class),
    ON_BEFORE_ORIGIN_FILES_PRIOR(On.class),
    ON_AFTER_ORIGIN_FILES_PRIOR(On.class),
    ON_BEFORE_ORIGIN_FILES_NEXT(On.class),
    ON_AFTER_ORIGIN_FILES_NEXT(On.class),
    ON_BEFORE_ORIGIN_FILES_LAST(On.class),
    ON_AFTER_ORIGIN_FILES_LAST(On.class),
    ON_BEFORE_ORIGIN_FILES_SWITCH(On.class),
    ON_AFTER_ORIGIN_FILES_SWITCH(On.class),
    ON_BEFORE_ORIGIN_FILES_SELECT(On.class),
    ON_AFTER_ORIGIN_FILES_SELECT(On.class),
    ON_BEFORE_ORIGIN_FILE_LOAD(On.class),
    ON_AFTER_ORIGIN_FILE_LOAD(On.class),
    ON_BEFORE_ORIGIN_FILE_INSERT(On.class),
    ON_AFTER_ORIGIN_FILE_INSERT(On.class),
    
    ON_AFTER_DESTINY_SELECT(On.class),
    ON_BEFORE_DESTINY_SELECT(On.class),
    ON_AFTER_DESTINY_OPEN(On.class),
    ON_BEFORE_DESTINY_OPEN(On.class),
    ON_AFTER_DESTINY_FILE_SAVE(OnAfterDestinyFileSave.class),
    ON_BEFORE_DESTINY_FILE_SAVE(OnBeforeDestinyFileSave.class,
            ActOnBeforeDestinyFileSaveDoKeepBoth.class),
    ON_AFTER_DESTINY_FILE_OPEN(On.class),
    ON_BEFORE_DESTINY_FILE_OPEN(On.class);
    
    private final Class<? extends On> onClazz;
    private final Class<? extends On>[] actOnClazzs;

    private Event(Class<? extends On> onClazz, Class<? extends On>... actOnClazzs) {
        this.onClazz = onClazz;
        this.actOnClazzs = actOnClazzs;
    }

    public Class<? extends On> getOnClazz() {
        return onClazz;
    }

    public Class<? extends On>[] getActOnClazzs() {
        return actOnClazzs;
    }
    
    
    
}
