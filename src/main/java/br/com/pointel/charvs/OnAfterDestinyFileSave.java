package br.com.pointel.charvs;

import java.io.File;

/**
 *
 * @author emuvi
 */
public abstract class OnAfterDestinyFileSave extends On<File, Void> {

    @Override
    public abstract Void execute(File file);
    
}
