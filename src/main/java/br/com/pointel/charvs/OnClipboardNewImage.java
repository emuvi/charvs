package br.com.pointel.charvs;

import java.awt.image.BufferedImage;

/**
 *
 * @author emuvi
 */
public abstract class OnClipboardNewImage extends On<BufferedImage, Void> {

    @Override
    public abstract Void execute(BufferedImage image);
    
}
