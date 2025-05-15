package br.com.pointel.charvs;

import br.com.pointel.jarch.mage.WizChars;
import br.com.pointel.jarch.mage.WizDesk;
import java.io.File;
import java.nio.file.Files;
import javax.swing.DefaultComboBoxModel;

public class CharvsDesk extends javax.swing.JFrame {

    private final DefaultComboBoxModel<String> modelOrigin = new DefaultComboBoxModel<>();

    public CharvsDesk() {
        initComponents();
        WizDesk.initFrame(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        checkOnTop = new javax.swing.JCheckBox();
        buttonOriginSelect = new javax.swing.JButton();
        fieldOrigin = new javax.swing.JTextField();
        buttonOriginOpen = new javax.swing.JButton();
        buttonLoad = new javax.swing.JButton();
        buttonOriginUpdate = new javax.swing.JButton();
        comboOrigin = new javax.swing.JComboBox<>();
        buttonDestinySelect = new javax.swing.JButton();
        fieldDestiny = new javax.swing.JTextField();
        buttonDestinyOpen = new javax.swing.JButton();
        buttonSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Charvs");

        checkOnTop.setText("On Top");
        checkOnTop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkOnTopActionPerformed(evt);
            }
        });

        buttonOriginSelect.setText("Select");
        buttonOriginSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOriginSelectActionPerformed(evt);
            }
        });

        fieldOrigin.setName("Origin"); // NOI18N

        buttonOriginOpen.setText("Open");
        buttonOriginOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOriginOpenActionPerformed(evt);
            }
        });

        buttonLoad.setText("Load");
        buttonLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoadActionPerformed(evt);
            }
        });

        buttonOriginUpdate.setText("Update");
        buttonOriginUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOriginUpdateActionPerformed(evt);
            }
        });

        comboOrigin.setModel(modelOrigin);

        buttonDestinySelect.setText("Select");
        buttonDestinySelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDestinySelectActionPerformed(evt);
            }
        });

        fieldDestiny.setName("Destiny"); // NOI18N

        buttonDestinyOpen.setText("Open");
        buttonDestinyOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDestinyOpenActionPerformed(evt);
            }
        });

        buttonSave.setText("Save");
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(checkOnTop)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(buttonDestinySelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonOriginUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonOriginSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldDestiny, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                                    .addComponent(fieldOrigin))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(buttonOriginOpen)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonLoad))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(buttonDestinyOpen)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonSave))))
                            .addComponent(comboOrigin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkOnTop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonOriginSelect)
                    .addComponent(fieldOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonLoad)
                    .addComponent(buttonOriginOpen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonOriginUpdate)
                    .addComponent(comboOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonDestinySelect)
                    .addComponent(buttonSave)
                    .addComponent(buttonDestinyOpen)
                    .addComponent(fieldDestiny, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkOnTopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOnTopActionPerformed
        setAlwaysOnTop(checkOnTop.isSelected());
    }//GEN-LAST:event_checkOnTopActionPerformed

    private void buttonDestinySelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDestinySelectActionPerformed
        var selected = new File(fieldDestiny.getText());
        selected = WizDesk.selectFolder(selected);
        if (selected != null) {
            fieldDestiny.setText(selected.getAbsolutePath());
        }
    }//GEN-LAST:event_buttonDestinySelectActionPerformed

    private void buttonDestinyOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDestinyOpenActionPerformed
        try {
            var selected = new File(fieldDestiny.getText());
            WizDesk.open(selected);
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }//GEN-LAST:event_buttonDestinyOpenActionPerformed

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        try {
            var text = cleanCitation(WizDesk.getStringFromClipboard()).trim();
            var lines = WizChars.getLines(text);
            var title = cleanTitle(lines[0]);
            var folder = new File(fieldDestiny.getText());
            var file = new File(folder, title + ".txt");
            Files.writeString(file.toPath(), text);
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }//GEN-LAST:event_buttonSaveActionPerformed

    private void buttonOriginSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOriginSelectActionPerformed
        var selected = new File(fieldOrigin.getText());
        selected = WizDesk.selectFolder(selected);
        if (selected != null) {
            fieldOrigin.setText(selected.getAbsolutePath());
        }
    }//GEN-LAST:event_buttonOriginSelectActionPerformed

    private void buttonOriginOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOriginOpenActionPerformed
        try {
            var selected = new File(fieldOrigin.getText());
            WizDesk.open(selected);
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }//GEN-LAST:event_buttonOriginOpenActionPerformed

    private void buttonLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoadActionPerformed
        try {
            var folder = new File(fieldOrigin.getText());
            var file = new File(folder, comboOrigin.getSelectedItem().toString());
            var origin = Files.readString(file.toPath());
            WizDesk.putStringOnClipboard(origin);
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }//GEN-LAST:event_buttonLoadActionPerformed

    private void buttonOriginUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOriginUpdateActionPerformed
        var folder = new File(fieldOrigin.getText());
        modelOrigin.removeAllElements();
        for (var inside : folder.listFiles()) {
            if (inside.getName().toLowerCase().endsWith(".txt")) {
                modelOrigin.addElement(inside.getName());
            }
        }
    }//GEN-LAST:event_buttonOriginUpdateActionPerformed

    private String cleanTitle(String title) {
        title = title.trim();
        return title
                .replace("{", "(")
                .replace("}", ")")
                .replace("[", "(")
                .replace("]", ")")
                .replace("\"", "”")
                .replace("'", "”")
                .replace("/", "-")
                .replace("|", "-")
                .replace("\\", "-")
                .replace("?", "")
                .replace("!", "")
                .replace("<", "")
                .replace(">", "")
                .replace("*", "")
                .replace("#", "")
                .replace(":", ",")
                .replace(";", ",")
                .trim();
    }
    
    private String cleanCitation(String text) {
        return text.replaceAll("\\[cite\\:(\\s|\\d|\\,)+\\]", "");
    }

    public static void start(String args[]) {
        WizDesk.start("Charvs", () -> new CharvsDesk().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDestinyOpen;
    private javax.swing.JButton buttonDestinySelect;
    private javax.swing.JButton buttonLoad;
    private javax.swing.JButton buttonOriginOpen;
    private javax.swing.JButton buttonOriginSelect;
    private javax.swing.JButton buttonOriginUpdate;
    private javax.swing.JButton buttonSave;
    private javax.swing.JCheckBox checkOnTop;
    private javax.swing.JComboBox<String> comboOrigin;
    private javax.swing.JTextField fieldDestiny;
    private javax.swing.JTextField fieldOrigin;
    // End of variables declaration//GEN-END:variables
}
