package br.com.pointel.charvs;

import br.com.pointel.jarch.mage.WizBase;
import br.com.pointel.jarch.mage.WizChars;
import br.com.pointel.jarch.mage.WizDesk;
import java.io.File;
import java.nio.file.Files;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingUtilities;

public class CharvsDesk extends javax.swing.JFrame {

    private final DefaultComboBoxModel<String> modelOrigin = new DefaultComboBoxModel<>();

    private String bufferBody = "";
    private Integer bufferSize = 0;
    private String originLast = "";
    private String originActual = "";
    private File savedLast = null;

    public CharvsDesk() {
        initComponents();
        initUpdater();
        setIconImage(WizDesk.getLogo());
        WizDesk.initFrame(this);
    }

    private void initUpdater() {
        new Thread("Updater") {
            @Override
            public void run() {
                WizBase.sleep(1000);
                SwingUtilities.invokeLater(() -> {
                    buttonOriginUpdateActionPerformed(null);
                });
            }
        }.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGears = new javax.swing.JButton();
        labelStatus = new javax.swing.JLabel();
        buttonAppendClean = new javax.swing.JButton();
        buttonAppend = new javax.swing.JButton();
        buttonInsert = new javax.swing.JButton();
        buttonOriginSelect = new javax.swing.JButton();
        buttonOriginFolder = new javax.swing.JButton();
        fieldOrigin = new javax.swing.JTextField();
        buttonLoad = new javax.swing.JButton();
        buttonOriginUpdate = new javax.swing.JButton();
        buttonOriginFile = new javax.swing.JButton();
        comboOrigin = new javax.swing.JComboBox<>();
        buttonOriginFirst = new javax.swing.JButton();
        buttonOriginPrior = new javax.swing.JButton();
        buttonOriginNext = new javax.swing.JButton();
        buttonOriginSwitch = new javax.swing.JButton();
        buttonDestinySelect = new javax.swing.JButton();
        buttonDestinyOpen = new javax.swing.JButton();
        fieldDestiny = new javax.swing.JTextField();
        buttonSave = new javax.swing.JButton();
        buttonSaveOpen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Charvs");

        buttonGears.setText("Gears");
        buttonGears.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGearsActionPerformed(evt);
            }
        });

        buttonAppendClean.setText("|");
        buttonAppendClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAppendCleanActionPerformed(evt);
            }
        });

        buttonAppend.setText("Append");
        buttonAppend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAppendActionPerformed(evt);
            }
        });

        buttonInsert.setText("Insert");
        buttonInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInsertActionPerformed(evt);
            }
        });

        buttonOriginSelect.setText("Select");
        buttonOriginSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOriginSelectActionPerformed(evt);
            }
        });

        buttonOriginFolder.setText("*");
        buttonOriginFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOriginFolderActionPerformed(evt);
            }
        });

        fieldOrigin.setName("Origin"); // NOI18N

        buttonLoad.setText("Load");
        buttonLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoadActionPerformed(evt);
            }
        });

        buttonOriginUpdate.setText("~");
        buttonOriginUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOriginUpdateActionPerformed(evt);
            }
        });

        buttonOriginFile.setText("*");
        buttonOriginFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOriginFileActionPerformed(evt);
            }
        });

        comboOrigin.setModel(modelOrigin);
        comboOrigin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboOriginActionPerformed(evt);
            }
        });

        buttonOriginFirst.setText("^");
        buttonOriginFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOriginFirstActionPerformed(evt);
            }
        });

        buttonOriginPrior.setText("<");
        buttonOriginPrior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOriginPriorActionPerformed(evt);
            }
        });

        buttonOriginNext.setText(">");
        buttonOriginNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOriginNextActionPerformed(evt);
            }
        });

        buttonOriginSwitch.setText("%");
        buttonOriginSwitch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOriginSwitchActionPerformed(evt);
            }
        });

        buttonDestinySelect.setText("Select");
        buttonDestinySelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDestinySelectActionPerformed(evt);
            }
        });

        buttonDestinyOpen.setText("*");
        buttonDestinyOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDestinyOpenActionPerformed(evt);
            }
        });

        fieldDestiny.setName("Destiny"); // NOI18N

        buttonSave.setText("Save");
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });

        buttonSaveOpen.setText("*");
        buttonSaveOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveOpenActionPerformed(evt);
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
                        .addComponent(buttonGears)
                        .addGap(18, 18, 18)
                        .addComponent(labelStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonAppendClean)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAppend)
                        .addGap(18, 18, 18)
                        .addComponent(buttonInsert))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonOriginSelect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonOriginFolder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldOrigin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonLoad))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonOriginUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonOriginFile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboOrigin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonOriginFirst)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonOriginPrior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonOriginNext)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonOriginSwitch))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonDestinySelect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDestinyOpen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldDestiny)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSaveOpen)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonInsert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonAppend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonAppendClean, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonGears, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonOriginSelect)
                    .addComponent(buttonOriginFolder)
                    .addComponent(buttonLoad)
                    .addComponent(fieldOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonOriginUpdate)
                    .addComponent(buttonOriginSwitch)
                    .addComponent(buttonOriginNext)
                    .addComponent(buttonOriginPrior)
                    .addComponent(buttonOriginFirst)
                    .addComponent(comboOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonOriginFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonDestinySelect)
                    .addComponent(buttonDestinyOpen)
                    .addComponent(buttonSaveOpen)
                    .addComponent(buttonSave)
                    .addComponent(fieldDestiny, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            var exists = file.exists();
            Files.writeString(file.toPath(), text);
            labelStatus.setText(exists ? "Overwritten" : "Saved");
            bufferBody = "";
            bufferSize = 0;
            savedLast = file;
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

    private void buttonOriginFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOriginFolderActionPerformed
        try {
            var selected = new File(fieldOrigin.getText());
            WizDesk.open(selected);
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }//GEN-LAST:event_buttonOriginFolderActionPerformed

    private void buttonLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoadActionPerformed
        try {
            var folder = new File(fieldOrigin.getText());
            var file = new File(folder, comboOrigin.getSelectedItem().toString());
            var origin = Files.readString(file.toPath());
            WizDesk.putStringOnClipboard(origin);
            labelStatus.setText("Loaded");
            bufferBody = "";
            bufferSize = 0;
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }//GEN-LAST:event_buttonLoadActionPerformed

    private void buttonOriginUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOriginUpdateActionPerformed
        modelOrigin.removeAllElements();
        var folder = new File(fieldOrigin.getText());
        if (!folder.exists()) {
            return;
        }
        for (var inside : folder.listFiles()) {
            if (inside.getName().toLowerCase().endsWith(".txt")) {
                modelOrigin.addElement(inside.getName());
            }
        }
    }//GEN-LAST:event_buttonOriginUpdateActionPerformed

    private void buttonInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInsertActionPerformed
        try {
            var body = WizDesk.getStringFromClipboard();
            var folder = new File(fieldOrigin.getText());
            var file = new File(folder, comboOrigin.getSelectedItem().toString());
            var origin = Files.readString(file.toPath());
            if (origin.contains("< INSERT >")) {
                origin = origin.replace("< INSERT >", body);
            } else {
                origin = origin + "\n\n" + body;
            }
            WizDesk.putStringOnClipboard(origin);
            labelStatus.setText("Inserted");
            bufferBody = "";
            bufferSize = 0;
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }//GEN-LAST:event_buttonInsertActionPerformed

    private void buttonAppendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAppendActionPerformed
        try {
            var body = WizDesk.getStringFromClipboard();
            bufferBody = (bufferBody.trim() + "\n\n" + body.trim()).trim();
            bufferSize++;
            WizDesk.putStringOnClipboard(bufferBody);
            labelStatus.setText("Appended " + bufferSize);
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }//GEN-LAST:event_buttonAppendActionPerformed

    private void buttonSaveOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveOpenActionPerformed
        try {
            WizDesk.open(savedLast);
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }//GEN-LAST:event_buttonSaveOpenActionPerformed

    private void comboOriginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboOriginActionPerformed
        if (comboOrigin.getSelectedItem() != null) {
            originLast = originActual;
            originActual = comboOrigin.getSelectedItem().toString();
        }
    }//GEN-LAST:event_comboOriginActionPerformed

    private void buttonOriginSwitchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOriginSwitchActionPerformed
        try {
            comboOrigin.setSelectedItem(originLast);
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }//GEN-LAST:event_buttonOriginSwitchActionPerformed

    private void buttonOriginFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOriginFirstActionPerformed
        try {
            comboOrigin.setSelectedIndex(0);
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }//GEN-LAST:event_buttonOriginFirstActionPerformed

    private void buttonOriginPriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOriginPriorActionPerformed
        try {
            comboOrigin.setSelectedIndex(comboOrigin.getSelectedIndex() - 1);
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }//GEN-LAST:event_buttonOriginPriorActionPerformed

    private void buttonOriginNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOriginNextActionPerformed
        try {
            comboOrigin.setSelectedIndex(comboOrigin.getSelectedIndex() + 1);
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }//GEN-LAST:event_buttonOriginNextActionPerformed

    private void buttonAppendCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAppendCleanActionPerformed
        bufferBody = "";
        bufferSize = 0;
        labelStatus.setText("Appended " + bufferSize);
    }//GEN-LAST:event_buttonAppendCleanActionPerformed

    private void buttonGearsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGearsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonGearsActionPerformed

    private void buttonOriginFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOriginFileActionPerformed
        try {
            var folder = new File(fieldOrigin.getText());
            var file = new File(folder, comboOrigin.getSelectedItem().toString());
            WizDesk.open(file);
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }//GEN-LAST:event_buttonOriginFileActionPerformed

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
    private javax.swing.JButton buttonAppend;
    private javax.swing.JButton buttonAppendClean;
    private javax.swing.JButton buttonDestinyOpen;
    private javax.swing.JButton buttonDestinySelect;
    private javax.swing.JButton buttonGears;
    private javax.swing.JButton buttonInsert;
    private javax.swing.JButton buttonLoad;
    private javax.swing.JButton buttonOriginFile;
    private javax.swing.JButton buttonOriginFirst;
    private javax.swing.JButton buttonOriginFolder;
    private javax.swing.JButton buttonOriginNext;
    private javax.swing.JButton buttonOriginPrior;
    private javax.swing.JButton buttonOriginSelect;
    private javax.swing.JButton buttonOriginSwitch;
    private javax.swing.JButton buttonOriginUpdate;
    private javax.swing.JButton buttonSave;
    private javax.swing.JButton buttonSaveOpen;
    private javax.swing.JComboBox<String> comboOrigin;
    private javax.swing.JTextField fieldDestiny;
    private javax.swing.JTextField fieldOrigin;
    private javax.swing.JLabel labelStatus;
    // End of variables declaration//GEN-END:variables
}
