package br.com.pointel.charvs;

import javax.swing.JFrame;

/**
 *
 * @author emuvi
 */
public class ActionFrameToFront extends Action {

    private final JFrame frame;

    public ActionFrameToFront(JFrame frame) {
        this.frame = frame;
    }
    
    @Override
    public void execute() {
        var isAlwaysOnTop = frame.isAlwaysOnTop();
        frame.requestFocusInWindow();
        frame.requestFocus();
        frame.toFront();
        frame.setAlwaysOnTop(true);
        frame.setAlwaysOnTop(isAlwaysOnTop);
    }


    
}
