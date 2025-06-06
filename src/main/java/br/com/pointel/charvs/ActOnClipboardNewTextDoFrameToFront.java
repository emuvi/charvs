package br.com.pointel.charvs;

import javax.swing.JFrame;

/**
 *
 * @author emuvi
 */
public class ActOnClipboardNewTextDoFrameToFront extends OnClipboardNewText {

    private final JFrame frame;

    public ActOnClipboardNewTextDoFrameToFront(JFrame frame) {
        this.frame = frame;
    }
    
    @Override
    public Void execute(String text) {
        var isAlwaysOnTop = frame.isAlwaysOnTop();
        frame.requestFocusInWindow();
        frame.requestFocus();
        frame.toFront();
        frame.setAlwaysOnTop(true);
        frame.setAlwaysOnTop(isAlwaysOnTop);
        return null;
    }


    
}
