package br.com.pointel.charvs;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.InputEvent;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import org.apache.commons.io.FilenameUtils;

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
        fieldStatus = new javax.swing.JTextField();
        buttonCaptureContent = new javax.swing.JButton();
        buttonRemake = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Charvs");

        editText.setColumns(20);
        editText.setLineWrap(true);
        editText.setRows(5);
        editText.setWrapStyleWord(true);
        scrollText.setViewportView(editText);

        buttonSet.setMnemonic('3');
        buttonSet.setText("3");
        buttonSet.setToolTipText("Set Conntent");
        buttonSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSetActionPerformed(evt);
            }
        });

        buttonAppend.setMnemonic('4');
        buttonAppend.setText("4");
        buttonAppend.setToolTipText("Appennd Content");
        buttonAppend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAppendActionPerformed(evt);
            }
        });

        buttonPaste.setMnemonic('5');
        buttonPaste.setText("5");
        buttonPaste.setToolTipText("Paste Content");
        buttonPaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPasteActionPerformed(evt);
            }
        });

        comboChats.setModel(modelChats);

        buttonCopy.setMnemonic('6');
        buttonCopy.setText("6");
        buttonCopy.setToolTipText("Copy Content");
        buttonCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCopyActionPerformed(evt);
            }
        });

        buttonSetPasteCopy.setMnemonic('8');
        buttonSetPasteCopy.setText("8");
        buttonSetPasteCopy.setToolTipText("Set, Paste and Copy Content");
        buttonSetPasteCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSetPasteCopyActionPerformed(evt);
            }
        });

        buttonPasteCopy.setMnemonic('7');
        buttonPasteCopy.setText("7");
        buttonPasteCopy.setToolTipText("Paste and Copy Content");
        buttonPasteCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPasteCopyActionPerformed(evt);
            }
        });

        buttonOpen.setText("1");
        buttonOpen.setToolTipText("Open Folder");
        buttonOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOpenActionPerformed(evt);
            }
        });

        buttonReload.setMnemonic('2');
        buttonReload.setText("2");
        buttonReload.setToolTipText("Reload Folder");
        buttonReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonReloadActionPerformed(evt);
            }
        });

        fieldStatus.setEditable(false);
        fieldStatus.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fieldStatus.setBorder(null);

        buttonCaptureContent.setMnemonic('9');
        buttonCaptureContent.setText("9");
        buttonCaptureContent.setToolTipText("Capture Heart");
        buttonCaptureContent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCaptureContentActionPerformed(evt);
            }
        });

        buttonRemake.setMnemonic('0');
        buttonRemake.setText("0");
        buttonRemake.setToolTipText("Ramake Heart");
        buttonRemake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemakeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollText, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonOpen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonReload)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboChats, 0, 259, Short.MAX_VALUE)
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
                        .addComponent(buttonSetPasteCopy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCaptureContent)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonRemake))
                    .addComponent(fieldStatus))
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
                    .addComponent(buttonReload)
                    .addComponent(buttonCaptureContent)
                    .addComponent(buttonRemake))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollText, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        try {
            if ((evt.getModifiers() & InputEvent.ALT_DOWN_MASK) != 0) {
                loadChats();
            } else {
                comboChats.setSelectedIndex(1);
            }
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonReloadActionPerformed

    private void buttonOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOpenActionPerformed
        try {
            if ((evt.getModifiers() & InputEvent.ALT_DOWN_MASK) != 0) {
                WizSwing.open(FOLDER_CHATS);
            } else {
                comboChats.setSelectedIndex(0);
            }
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonOpenActionPerformed

    private void buttonCaptureContentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCaptureContentActionPerformed
        try {
            var content = WizSwing.getStringOnClipboard();
            var title = produce(content, null);
            editText.setText(content);
            WizSwing.putStringOnClipboard("[[(H) " + title + "]]");
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonCaptureContentActionPerformed

    private void buttonRemakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemakeActionPerformed
        if (!"yes".equals(WizSwing.showInput("Do you really want to remake the heart?").toLowerCase())) {
            return;
        }
        try {
            for (var file : heartFolder.listFiles()) {
                if (!file.getName().endsWith(".md")) {
                    file.delete();
                }
            }
            for (var file : heartFolder.listFiles()) {
                if (file.getName().endsWith(".md")) {
                    remakeHeart(file);
                }
            }
            WizSwing.showInfo("Finished to remake your heart!");
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonRemakeActionPerformed

    private void remakeHeart(File file) throws Exception {
        var origin = Files.readString(file.toPath(), StandardCharsets.UTF_8);
        var name = FilenameUtils.getBaseName(file.getName());
        produce(origin, name);
    }

    private void loadChats() {
        modelChats.removeAllElements();
        for (var inside : FOLDER_CHATS.listFiles()) {
            if (inside.isFile() && inside.getName().toLowerCase().endsWith(".txt")) {
                modelChats.addElement(inside.getName());
            }
        }
    }

    private String produce(String origin, String name) throws Exception {
        var lines = origin.split("\\r?\\n");
        if (lines.length < 3) {
            throw new Exception("Actual content has too little lines.");
        }
        var title = cleanTitle(lines[0]);
        lines[0] = title;
        if (!lines[0].endsWith(".")) {
            lines[0] = lines[0] + ".";
        }
        for (int i = 1; i < lines.length; i++) {
            lines[i] = cleanLine(lines[i]);
            if (lines[i].startsWith("#") && !lines[i].endsWith(".")) {
                lines[i] = lines[i] + ".";
            }
        }
        var text = "{{Pause=3}}Início.{{Pause=3}}\n\n" 
                + String.join("\n", lines)
                + "\n\n{{Pause=3}}Fim.{{Pause=3}}";
        var fileName = name != null ? name : title;
        save(origin, text, fileName);
        return title;
    }

    private boolean isCharTitleBondaryValid(char c) {
        return Character.isAlphabetic(c) || Character.isDigit(c) || c == '”' || c == '“' || c == '(' || c == ')';
    }

    private String cleanTitle(String title) {
        title = title.trim();
        while (!title.isEmpty() && !isCharTitleBondaryValid(title.charAt(0))) {
            title = title.substring(1);
            title = title.trim();
        }
        while (!title.isEmpty() && !isCharTitleBondaryValid(title.charAt(title.length() - 1))) {
            title = title.substring(0, title.length() - 1);
            title = title.trim();
        }
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

    private String cleanLine(String line) {
        return line
                .replaceAll("\\*+", "*")
                .replaceAll("\\#+", "#")
                .replaceAll("\\_+", "_")
                .replaceAll("\\-+", "-")
                .replaceAll("\\++", "+")
                .trim();
    }

    private final File heartFolder = new File("D:\\emuvi\\OneDrive\\Documentos\\Educação\\AELIN\\ABIN\\Heart");

    private void save(String origin, String text, String fileName) throws Exception {
        var title = fileName;
        if (!fileName.startsWith("(H) ")) {
            fileName = "(H) " + fileName;
        }
        Files.writeString(new File(heartFolder, fileName + ".md").toPath(), origin, StandardCharsets.UTF_8);
        Files.writeString(new File(heartFolder, fileName + ".txt").toPath(), text, StandardCharsets.UTF_8);
        SwingUtilities.invokeLater(() -> fieldStatus.setText("Saved content on: " + title));
    }

    public static void start(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
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
    private javax.swing.JButton buttonCaptureContent;
    private javax.swing.JButton buttonCopy;
    private javax.swing.JButton buttonOpen;
    private javax.swing.JButton buttonPaste;
    private javax.swing.JButton buttonPasteCopy;
    private javax.swing.JButton buttonReload;
    private javax.swing.JButton buttonRemake;
    private javax.swing.JButton buttonSet;
    private javax.swing.JButton buttonSetPasteCopy;
    private javax.swing.JComboBox<String> comboChats;
    private javax.swing.JTextArea editText;
    private javax.swing.JTextField fieldStatus;
    private javax.swing.JScrollPane scrollText;
    // End of variables declaration//GEN-END:variables
}
