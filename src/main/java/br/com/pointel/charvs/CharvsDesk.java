package br.com.pointel.charvs;

import br.com.pointel.jarch.mage.WizChars;
import br.com.pointel.jarch.mage.WizDesk;
import java.io.File;
import java.nio.file.Files;
import javax.swing.DefaultComboBoxModel;

public class CharvsDesk extends javax.swing.JFrame {

    private final DefaultComboBoxModel<String> modelChats = new DefaultComboBoxModel<>();

    public CharvsDesk() {
        initComponents();
        WizDesk.initFrame(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        checkOnTop = new javax.swing.JCheckBox();
        buttonGet = new javax.swing.JButton();
        buttonOpen = new javax.swing.JButton();
        buttonSelect = new javax.swing.JButton();
        fieldDestiny = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Charvs");

        checkOnTop.setText("On Top");
        checkOnTop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkOnTopActionPerformed(evt);
            }
        });

        buttonGet.setText("Get");
        buttonGet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGetActionPerformed(evt);
            }
        });

        buttonOpen.setText("Open");
        buttonOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOpenActionPerformed(evt);
            }
        });

        buttonSelect.setText("Select");
        buttonSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSelectActionPerformed(evt);
            }
        });

        fieldDestiny.setName("Destiny"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(checkOnTop)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonGet))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonSelect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldDestiny, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonOpen)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkOnTop)
                    .addComponent(buttonGet))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonOpen)
                    .addComponent(buttonSelect)
                    .addComponent(fieldDestiny, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkOnTopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOnTopActionPerformed
        setAlwaysOnTop(checkOnTop.isSelected());
    }//GEN-LAST:event_checkOnTopActionPerformed

    private void buttonSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSelectActionPerformed
        var selected = new File(fieldDestiny.getText());
        selected = WizDesk.selectFolder(selected);
        if (selected != null) {
            fieldDestiny.setText(selected.getAbsolutePath());
        }
    }//GEN-LAST:event_buttonSelectActionPerformed

    private void buttonOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOpenActionPerformed
        try {
            var selected = new File(fieldDestiny.getText());
            WizDesk.open(selected);
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }//GEN-LAST:event_buttonOpenActionPerformed

    private void buttonGetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGetActionPerformed
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
    }//GEN-LAST:event_buttonGetActionPerformed

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
    private javax.swing.JButton buttonGet;
    private javax.swing.JButton buttonOpen;
    private javax.swing.JButton buttonSelect;
    private javax.swing.JCheckBox checkOnTop;
    private javax.swing.JTextField fieldDestiny;
    // End of variables declaration//GEN-END:variables
}
