package br.com.pointel.charvs;

import com.formdev.flatlaf.FlatDarculaLaf;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;

public class Desk extends javax.swing.JFrame {

    private final DefaultComboBoxModel<String> modelChats = new DefaultComboBoxModel<>();
    
    public Desk() {
        initComponents();
        loadChats();
        WizSwing.initFrame(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollText = new javax.swing.JScrollPane();
        editText = new javax.swing.JTextArea();
        buttonSet = new javax.swing.JButton();
        buttonAppend = new javax.swing.JButton();
        buttonPaste = new javax.swing.JButton();
        comboChats = new javax.swing.JComboBox<>();
        buttonCopy = new javax.swing.JButton();
        buttonSetPasteCopy = new javax.swing.JButton();
        buttonPasteCopy = new javax.swing.JButton();
        buttonOpen = new javax.swing.JButton();
        buttonReload = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Charvs");

        editText.setColumns(20);
        editText.setLineWrap(true);
        editText.setRows(5);
        editText.setWrapStyleWord(true);
        scrollText.setViewportView(editText);

        buttonSet.setText("Set");
        buttonSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSetActionPerformed(evt);
            }
        });

        buttonAppend.setText("Append");
        buttonAppend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAppendActionPerformed(evt);
            }
        });

        buttonPaste.setText("Paste");
        buttonPaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPasteActionPerformed(evt);
            }
        });

        comboChats.setModel(modelChats);

        buttonCopy.setText("Copy");
        buttonCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCopyActionPerformed(evt);
            }
        });

        buttonSetPasteCopy.setText("SPC");
        buttonSetPasteCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSetPasteCopyActionPerformed(evt);
            }
        });

        buttonPasteCopy.setText("PC");
        buttonPasteCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPasteCopyActionPerformed(evt);
            }
        });

        buttonOpen.setText("*");
        buttonOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOpenActionPerformed(evt);
            }
        });

        buttonReload.setText("#");
        buttonReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonReloadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollText, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonOpen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonReload)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboChats, 0, 127, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAppend)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonPaste)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCopy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonPasteCopy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSetPasteCopy)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboChats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSet)
                    .addComponent(buttonAppend)
                    .addComponent(buttonPaste)
                    .addComponent(buttonCopy)
                    .addComponent(buttonSetPasteCopy)
                    .addComponent(buttonPasteCopy)
                    .addComponent(buttonOpen)
                    .addComponent(buttonReload))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollText, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private String readSelectedChat() throws Exception {
        return Files.readString(new File(FOLDER_CHATS, comboChats.getSelectedItem().toString()).toPath(), StandardCharsets.UTF_8);
    }
    
    private void buttonSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSetActionPerformed
        try {
            var chat = readSelectedChat();
            editText.setText(chat);
        } catch (Exception ex) {
            WizSwing.showError(ex);
        }
    }//GEN-LAST:event_buttonSetActionPerformed

    private void buttonAppendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAppendActionPerformed
        try {
            var chat = readSelectedChat();
            editText.append(chat);
        } catch (Exception ex) {
            WizSwing.showError(ex);
        }
    }//GEN-LAST:event_buttonAppendActionPerformed

    private void buttonPasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPasteActionPerformed
        try {
            editText.append("\n\n" + WizSwing.getStringOnClipboard());
        } catch (Exception ex) {
            WizSwing.showError(ex);
        }
    }//GEN-LAST:event_buttonPasteActionPerformed

    private void buttonCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCopyActionPerformed
        try {
            WizSwing.putStringOnClipboard(editText.getText());
        } catch (Exception ex) {
            WizSwing.showError(ex);
        }
    }//GEN-LAST:event_buttonCopyActionPerformed

    private void buttonSetPasteCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSetPasteCopyActionPerformed
        buttonSetActionPerformed(evt);
        buttonPasteActionPerformed(evt);
        buttonCopyActionPerformed(evt);
    }//GEN-LAST:event_buttonSetPasteCopyActionPerformed

    private void buttonPasteCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPasteCopyActionPerformed
        buttonPasteActionPerformed(evt);
        buttonCopyActionPerformed(evt);
    }//GEN-LAST:event_buttonPasteCopyActionPerformed

    private void buttonReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReloadActionPerformed
        loadChats();
    }//GEN-LAST:event_buttonReloadActionPerformed

    private void buttonOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOpenActionPerformed
        try {
            WizSwing.open(FOLDER_CHATS);
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonOpenActionPerformed

    private void loadChats() {
        modelChats.removeAllElements();
        for (var inside : FOLDER_CHATS.listFiles()) {
            if (inside.isFile() && inside.getName().toLowerCase().endsWith(".txt")) {
                modelChats.addElement(inside.getName());
            }
        }
    }

    public static void start(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(() -> {
            new Desk().setVisible(true);
        });
    }
    
    private static final File FOLDER_CHATS = new File("chats");

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAppend;
    private javax.swing.JButton buttonCopy;
    private javax.swing.JButton buttonOpen;
    private javax.swing.JButton buttonPaste;
    private javax.swing.JButton buttonPasteCopy;
    private javax.swing.JButton buttonReload;
    private javax.swing.JButton buttonSet;
    private javax.swing.JButton buttonSetPasteCopy;
    private javax.swing.JComboBox<String> comboChats;
    private javax.swing.JTextArea editText;
    private javax.swing.JScrollPane scrollText;
    // End of variables declaration//GEN-END:variables
}
