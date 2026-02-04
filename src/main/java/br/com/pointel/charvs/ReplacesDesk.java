package br.com.pointel.charvs;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;

import br.com.pointel.jarch.desk.DBordPane;
import br.com.pointel.jarch.desk.DFrame;
import br.com.pointel.jarch.desk.DListEditor;
import br.com.pointel.jarch.desk.DPane;
import br.com.pointel.jarch.mage.WizDesk;
import br.com.pointel.jarch.mage.WizObject;

public class ReplacesDesk extends DFrame {

    private final DListEditor<Replace> listEditor = new DListEditor<>(ReplaceEditFrame.class);
    private final DPane paneBody = new DBordPane().putCenter(listEditor).borderEmpty(7);

    public ReplacesDesk() {
        super("Replaces");
        body(paneBody);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                read();
            }

            @Override
            public void windowClosed(WindowEvent e) {
                write();
            }
        });
    }

    private void read() {
        try {
            var file = new File("replaces.ser");
            if (file.exists()) {
                var replaces = (ArrayList<Replace>) WizObject.read(file);
                listEditor.setValue(replaces);
            }
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }

    private void write() {
        try {
            var replaces = listEditor.getValue();
            WizObject.write(new File("replaces.ser"), replaces);
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }

}
