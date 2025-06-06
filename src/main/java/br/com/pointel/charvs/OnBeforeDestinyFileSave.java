package br.com.pointel.charvs;

import java.io.File;

/**
 *
 * @author emuvi
 */
public abstract class OnBeforeDestinyFileSave extends On<File, File> {

    @Override
    public abstract File execute(File file);
    
}
