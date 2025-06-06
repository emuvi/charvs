package br.com.pointel.charvs;

/**
 *
 * @author emuvi
 */
public abstract class OnClipboardNewText extends On<String, Void> {

    @Override
    public abstract Void execute(String param);
    
}
