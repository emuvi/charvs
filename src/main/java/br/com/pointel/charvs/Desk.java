package br.com.pointel.charvs;

import com.formdev.flatlaf.FlatLightLaf;
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
        buttonStart = new javax.swing.JButton();
        buttonAppend = new javax.swing.JButton();
        buttonCopy = new javax.swing.JButton();
        buttonPaste = new javax.swing.JButton();
        buttonQuery = new javax.swing.JButton();
        comboChats = new javax.swing.JComboBox<>();
        buttonRefresh = new javax.swing.JButton();
        checkOnTop = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Charvs");
        setAlwaysOnTop(true);

        editText.setColumns(20);
        editText.setLineWrap(true);
        editText.setRows(5);
        editText.setWrapStyleWord(true);
        scrollText.setViewportView(editText);

        buttonStart.setText("Start");

        buttonAppend.setText("Set");

        buttonCopy.setText("Append");

        buttonPaste.setText("Paste");

        buttonQuery.setText("Query");

        comboChats.setModel(modelChats);

        buttonRefresh.setText("Refresh");

        checkOnTop.setText("On Top");
        checkOnTop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkOnTopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollText, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonStart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonQuery)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(checkOnTop))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboChats, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAppend)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCopy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonPaste)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonStart)
                    .addComponent(buttonQuery)
                    .addComponent(checkOnTop))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboChats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAppend)
                    .addComponent(buttonCopy)
                    .addComponent(buttonRefresh)
                    .addComponent(buttonPaste))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollText, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkOnTopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOnTopActionPerformed
        setAlwaysOnTop(checkOnTop.isSelected());
    }//GEN-LAST:event_checkOnTopActionPerformed

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
    private javax.swing.JButton buttonCopy;
    private javax.swing.JButton buttonPaste;
    private javax.swing.JButton buttonQuery;
    private javax.swing.JButton buttonRefresh;
    private javax.swing.JButton buttonStart;
    private javax.swing.JCheckBox checkOnTop;
    private javax.swing.JComboBox<String> comboChats;
    private javax.swing.JTextArea editText;
    private javax.swing.JScrollPane scrollText;
    // End of variables declaration//GEN-END:variables
}
