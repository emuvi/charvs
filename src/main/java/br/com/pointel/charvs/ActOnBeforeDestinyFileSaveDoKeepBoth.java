package br.com.pointel.charvs;

import java.io.File;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author emuvi
 */
public class ActOnBeforeDestinyFileSaveDoKeepBoth extends OnBeforeDestinyFileSave {

    @Override
    public File execute(File file) {
        var folder = file.getParentFile();
        var baseName = FilenameUtils.getBaseName(file.getName());
        var index = 1;
        while (file.exists()) {
            index++;
            file = new File(folder, baseName + " (" + index + ").txt");
        }
        return file;
    }
    
}
