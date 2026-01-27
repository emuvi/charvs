package br.com.pointel.charvs;

import br.com.pointel.jarch.mage.WizDesk;
import br.com.pointel.jarch.mage.WizFile;
import br.com.pointel.jarch.mage.WizString;
import br.com.pointel.jarch.mage.WizThread;
import br.com.pointel.jarch.mage.WizUtilDate;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Date;
import java.util.Objects;
import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CharvsDesk extends javax.swing.JFrame {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CharvsDesk.class);
    
    private final DefaultComboBoxModel<String> modelInput = new DefaultComboBoxModel<>();
    
    private String bufferBody = "";
    private Integer bufferSize = 0;
    private String originLast = "";
    private String originActual = "";
    private File savedLast = null;
    
    public CharvsDesk() {
        initDesk();
    }
    
    private void initDesk() {
        initComponents();
        initShortcuts();
        setIconImage(WizDesk.getLogo());
        WizDesk.initFrame(this);
        initWatcher();
    }
    
    private void initShortcuts() {
        var loadActionKey = "LoadActionKey";
        var keyCtrlC = KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK);
        var loadAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonLoadActionPerformed(e);
            }
        };
        var keyCtrlV = KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK);
        var saveActionKey = "SaveActionKey";
        var saveAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSaveActionPerformed(e);
            }
        };
        var keyCtrlA = KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK);
        var appendActionKey = "AppendActionKey";
        var appendAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonBufferAppendActionPerformed(e);
            }
        };
        var keyCtrlE = KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK);
        var insertActionKey = "InsertActionKey";
        var insertAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonInsertActionPerformed(e);
            }
        };
        var keyCtrlW = KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK);
        var switchActionKey = "SwitchActionKey";
        var switchAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonInputSwitchActionPerformed(e);
            }
        };
        var inputMap = getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        var actionMap = getRootPane().getActionMap();
        inputMap.put(keyCtrlC, loadActionKey);
        actionMap.put(loadActionKey, loadAction);
        inputMap.put(keyCtrlV, saveActionKey);
        actionMap.put(saveActionKey, saveAction);
        inputMap.put(keyCtrlA, appendActionKey);
        actionMap.put(appendActionKey, appendAction);
        inputMap.put(keyCtrlE, insertActionKey);
        actionMap.put(insertActionKey, insertAction);
        inputMap.put(keyCtrlW, switchActionKey);
        actionMap.put(switchActionKey, switchAction);
    }
    
    private void initWatcher() {
        new Thread("Watcher") {
            @Override
            public void run() {
                WizThread.sleep(1000);
                SwingUtilities.invokeLater(() -> {
                    buttonInputUpdateActionPerformed(null);
                });
                while (isDisplayable()) {
                    WizThread.sleep(1000);
                    try {
                        watch();
                    } catch (Exception e) {
                        LOGGER.error("Error on watcher.", e);
                    }
                }
            }
        }.start();
    }
    
    private void watch() throws Exception {
        try {
            watchClipboardText();
        } catch (Exception e) {
            LOGGER.error("Error on watcher clipboard text.", e);
        }
    }
    
    private void watchClipboardText() throws Exception {
        if (checkClipboardNewText()) {
            if (Setup.doOnNewClipboardText() == OnNewClipboardText.ShowDesk) {
                showDesk();
            } else if (Setup.doOnNewClipboardText() == OnNewClipboardText.AppendOnBuffer) {
                buttonBufferAppendActionPerformed(null);
            } else if (Setup.doOnNewClipboardText() == OnNewClipboardText.InsertOnInput) {
                buttonInsertActionPerformed(null);
            } 
        }
    }
    
    private volatile String clipboardText = null;
    
    private boolean checkClipboardNewText() throws Exception {
        var actualClipboard = WizDesk.getStringFromClipboard();
        if (!Objects.equals(actualClipboard, clipboardText)) {
            clipboardText = actualClipboard;
            return true;
        }
        return false;
    }
    
    private void showDesk() {
        requestFocus();
        requestFocusInWindow();
        toFront();
        setAlwaysOnTop(true);
        setAlwaysOnTop(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonSetup = new javax.swing.JButton();
        fieldStatus = new javax.swing.JTextField();
        buttonBufferClean = new javax.swing.JButton();
        buttonBufferAppend = new javax.swing.JButton();
        buttonInsert = new javax.swing.JButton();
        buttonInputSelect = new javax.swing.JButton();
        buttonInputOpen = new javax.swing.JButton();
        fieldInput = new javax.swing.JTextField();
        buttonLoad = new javax.swing.JButton();
        buttonInputUpdate = new javax.swing.JButton();
        buttonInputFileOpen = new javax.swing.JButton();
        comboInput = new javax.swing.JComboBox<>();
        buttonInputFirst = new javax.swing.JButton();
        buttonInputPrior = new javax.swing.JButton();
        buttonInputNext = new javax.swing.JButton();
        buttonInputSwitch = new javax.swing.JButton();
        buttonOutputSelect = new javax.swing.JButton();
        buttonOutputOpen = new javax.swing.JButton();
        fieldDestiny = new javax.swing.JTextField();
        buttonSave = new javax.swing.JButton();
        buttonSaveOpen = new javax.swing.JButton();
        buttonArchiveSelect = new javax.swing.JButton();
        buttonArchiveOpen = new javax.swing.JButton();
        fieldArchive = new javax.swing.JTextField();
        checkArchiveMake = new javax.swing.JCheckBox();
        scrollArchive = new javax.swing.JScrollPane();
        textArchive = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Charvs");
        setName("Desk"); // NOI18N

        buttonSetup.setText("#");
        buttonSetup.setToolTipText("Setup");
        buttonSetup.setName(""); // NOI18N
        buttonSetup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSetupActionPerformed(evt);
            }
        });

        fieldStatus.setEditable(false);

        buttonBufferClean.setMnemonic('C');
        buttonBufferClean.setText("C");
        buttonBufferClean.setToolTipText("Clear Buffer");
        buttonBufferClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBufferCleanActionPerformed(evt);
            }
        });

        buttonBufferAppend.setMnemonic('A');
        buttonBufferAppend.setText("Append");
        buttonBufferAppend.setToolTipText("Append Buffer (ctrl+A)");
        buttonBufferAppend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBufferAppendActionPerformed(evt);
            }
        });

        buttonInsert.setMnemonic('I');
        buttonInsert.setText("Insert");
        buttonInsert.setToolTipText("Insert on < INSERT> tag in Input chain and puts on clipboard (ctrl+E)");
        buttonInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInsertActionPerformed(evt);
            }
        });

        buttonInputSelect.setMnemonic('n');
        buttonInputSelect.setText("Input");
        buttonInputSelect.setToolTipText("Select Input Folder");
        buttonInputSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInputSelectActionPerformed(evt);
            }
        });

        buttonInputOpen.setText("*");
        buttonInputOpen.setToolTipText("Open Origin Folder");
        buttonInputOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInputOpenActionPerformed(evt);
            }
        });

        fieldInput.setName("InputFolder"); // NOI18N

        buttonLoad.setMnemonic('L');
        buttonLoad.setText("Load");
        buttonLoad.setToolTipText("Loads selected Input on clipboard (ctrl+C)");
        buttonLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoadActionPerformed(evt);
            }
        });

        buttonInputUpdate.setText("~");
        buttonInputUpdate.setToolTipText("Update Input Files");
        buttonInputUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInputUpdateActionPerformed(evt);
            }
        });

        buttonInputFileOpen.setText("*");
        buttonInputFileOpen.setToolTipText("Open Input File");
        buttonInputFileOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInputFileOpenActionPerformed(evt);
            }
        });

        comboInput.setModel(modelInput);
        comboInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboInputActionPerformed(evt);
            }
        });

        buttonInputFirst.setMnemonic('^');
        buttonInputFirst.setText("^");
        buttonInputFirst.setToolTipText("Select First Input File");
        buttonInputFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInputFirstActionPerformed(evt);
            }
        });

        buttonInputPrior.setMnemonic('<');
        buttonInputPrior.setText("<");
        buttonInputPrior.setToolTipText("Select Prior Input File");
        buttonInputPrior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInputPriorActionPerformed(evt);
            }
        });

        buttonInputNext.setMnemonic('>');
        buttonInputNext.setText(">");
        buttonInputNext.setToolTipText("Select Next Input File");
        buttonInputNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInputNextActionPerformed(evt);
            }
        });

        buttonInputSwitch.setMnemonic('%');
        buttonInputSwitch.setText("%");
        buttonInputSwitch.setToolTipText("Switch between Input files (ctrl+S)");
        buttonInputSwitch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInputSwitchActionPerformed(evt);
            }
        });

        buttonOutputSelect.setMnemonic('O');
        buttonOutputSelect.setText("Output");
        buttonOutputSelect.setToolTipText("Select Output Folder");
        buttonOutputSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOutputSelectActionPerformed(evt);
            }
        });

        buttonOutputOpen.setText("*");
        buttonOutputOpen.setToolTipText("Open Destiny Folder");
        buttonOutputOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOutputOpenActionPerformed(evt);
            }
        });

        fieldDestiny.setName("OutputFolder"); // NOI18N

        buttonSave.setMnemonic('S');
        buttonSave.setText("Save");
        buttonSave.setToolTipText("Saves clipboard on Output folder (ctrl+V)");
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });

        buttonSaveOpen.setText("*");
        buttonSaveOpen.setToolTipText("Open Last Saved File");
        buttonSaveOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveOpenActionPerformed(evt);
            }
        });

        buttonArchiveSelect.setMnemonic('r');
        buttonArchiveSelect.setText("Archive");
        buttonArchiveSelect.setToolTipText("Select Archive Folder");
        buttonArchiveSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonArchiveSelectActionPerformed(evt);
            }
        });

        buttonArchiveOpen.setText("*");
        buttonArchiveOpen.setToolTipText("Open Archive Folder");
        buttonArchiveOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonArchiveOpenActionPerformed(evt);
            }
        });

        fieldArchive.setName("ArchiveFolder"); // NOI18N

        checkArchiveMake.setText("Make");
        checkArchiveMake.setName("ArchiveMake"); // NOI18N

        textArchive.setEditable(false);
        textArchive.setColumns(20);
        textArchive.setRows(5);
        scrollArchive.setViewportView(textArchive);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollArchive)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(buttonInputSelect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonInputOpen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldInput)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonLoad))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(buttonInputUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonInputFileOpen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboInput, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonInputFirst)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonInputPrior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonInputNext)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonInputSwitch))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(buttonOutputSelect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonOutputOpen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldDestiny, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSaveOpen))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(buttonSetup)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonBufferClean)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonBufferAppend)
                        .addGap(18, 18, 18)
                        .addComponent(buttonInsert))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(buttonArchiveSelect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonArchiveOpen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldArchive)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkArchiveMake)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonInsert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonBufferAppend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonBufferClean, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonSetup)
                    .addComponent(fieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonInputSelect)
                    .addComponent(buttonInputOpen)
                    .addComponent(buttonLoad)
                    .addComponent(fieldInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonInputUpdate)
                    .addComponent(buttonInputSwitch)
                    .addComponent(buttonInputNext)
                    .addComponent(buttonInputPrior)
                    .addComponent(buttonInputFirst)
                    .addComponent(comboInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonInputFileOpen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonOutputSelect)
                    .addComponent(buttonOutputOpen)
                    .addComponent(buttonSaveOpen)
                    .addComponent(buttonSave)
                    .addComponent(fieldDestiny, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldArchive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonArchiveSelect)
                    .addComponent(buttonArchiveOpen)
                    .addComponent(checkArchiveMake))
                .addGap(18, 18, 18)
                .addComponent(scrollArchive)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonOutputSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOutputSelectActionPerformed
        var selected = new File(fieldDestiny.getText());
        selected = WizDesk.selectFolder(selected);
        if (selected != null) {
            fieldDestiny.setText(selected.getAbsolutePath());
        }
    }//GEN-LAST:event_buttonOutputSelectActionPerformed

    private void buttonOutputOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOutputOpenActionPerformed
        try {
            var selected = new File(fieldDestiny.getText());
            WizDesk.open(selected);
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }//GEN-LAST:event_buttonOutputOpenActionPerformed

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        try {
            var text = cleanCitation(WizDesk.getStringFromClipboard()).trim();
            var folder = new File(fieldDestiny.getText());
            var name = WizUtilDate.formatTimestampFile(new Date());
            var naming = Setup.doOnNaming();
            if (naming == OnNaming.FirstLine) {
                name = cleanName(WizString.getLines(text)[0]);
            } else if (naming == OnNaming.Numbered) {
                var prefix = Setup.getNameNumberedPrefix();
                var index = 1;
                var size = Setup.getNameNumberedSize();
                var suffix = Setup.getNameNumberedSuffix();
                name = prefix + WizString.fillAtStart(index + "", '0', size) + suffix;
                var file = new File(folder, name + ".txt");
                while (file.exists()) {
                    index++;
                    name = prefix + WizString.fillAtStart(index + "", '0', size) + suffix;
                    file = new File(folder, name + ".txt");
                }
            }
            var file = new File(folder, name + ".txt");
            if (Setup.doOnSave() == OnSave.KeepAll) {
                file = WizFile.notOverride(file);
            }
            var override = file.exists();
            Files.writeString(file.toPath(), text);
            putStatus((override ? "Override on " : "Saved on ") + file.getName(), text);
            bufferBody = "";
            bufferSize = 0;
            savedLast = file;
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }//GEN-LAST:event_buttonSaveActionPerformed

    private void buttonInputSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInputSelectActionPerformed
        var selected = new File(fieldInput.getText());
        selected = WizDesk.selectFolder(selected);
        if (selected != null) {
            fieldInput.setText(selected.getAbsolutePath());
        }
    }//GEN-LAST:event_buttonInputSelectActionPerformed

    private void buttonInputOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInputOpenActionPerformed
        try {
            var selected = new File(fieldInput.getText());
            WizDesk.open(selected);
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }//GEN-LAST:event_buttonInputOpenActionPerformed

    private void buttonLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoadActionPerformed
        try {
            var folder = new File(fieldInput.getText());
            var file = new File(folder, comboInput.getSelectedItem().toString());
            var input = Files.readString(file.toPath());
            WizDesk.putStringOnClipboard(input);
            putStatus("Loaded from " + file.getName(), input);
            bufferBody = "";
            bufferSize = 0;
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }//GEN-LAST:event_buttonLoadActionPerformed

    private void buttonInputUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInputUpdateActionPerformed
        modelInput.removeAllElements();
        var folder = new File(fieldInput.getText());
        if (!folder.exists()) {
            return;
        }
        for (var inside : folder.listFiles()) {
            if (inside.getName().toLowerCase().endsWith(".txt")) {
                modelInput.addElement(inside.getName());
            }
        }
    }//GEN-LAST:event_buttonInputUpdateActionPerformed

    private String partialInsert = null;
    private File partialFile = null;
    
    private void buttonInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInsertActionPerformed
        try {
            var body = WizDesk.getStringFromClipboard();
            var folder = new File(fieldInput.getText());
            var file = new File(folder, comboInput.getSelectedItem().toString());
            var input = partialInsert;
            if (input == null) {    
                input = Files.readString(file.toPath());
            }
            if (input.contains("< INSERT >")) {
                input = input.replaceFirst("< INSERT >", body);
            } else {
                throw new Exception("Did not found the < INSERT > tag.");
            }
            var remains = WizString.count(input, "< INSERT >");
            WizDesk.putStringOnClipboard(input);
            putStatus("Inserted " + (remains == 0 ? "Ok" : "-" + remains) + " on " + (partialInsert != null ?  "Partial of " + partialFile.getName() : file.getName()), input);
            if (remains == 0) {
                partialInsert = null;
                partialFile = null;
            } else {
                partialInsert = input;
                partialFile = file;
            }
            bufferBody = "";
            bufferSize = 0;
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }//GEN-LAST:event_buttonInsertActionPerformed

    private void buttonBufferAppendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBufferAppendActionPerformed
        try {
            var body = WizDesk.getStringFromClipboard();
            bufferBody = (bufferBody.trim() + "\n\n" + body.trim()).trim();
            bufferSize++;
            WizDesk.putStringOnClipboard(bufferBody);
            putStatus("Appended " + bufferSize + " on Buffer", bufferBody);
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }//GEN-LAST:event_buttonBufferAppendActionPerformed

    private void buttonSaveOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveOpenActionPerformed
        try {
            WizDesk.open(savedLast);
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }//GEN-LAST:event_buttonSaveOpenActionPerformed

    private void comboInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboInputActionPerformed
        if (comboInput.getSelectedItem() != null) {
            originLast = originActual;
            originActual = comboInput.getSelectedItem().toString();
        }
    }//GEN-LAST:event_comboInputActionPerformed

    private void buttonInputSwitchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInputSwitchActionPerformed
        try {
            comboInput.setSelectedItem(originLast);
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }//GEN-LAST:event_buttonInputSwitchActionPerformed

    private void buttonInputFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInputFirstActionPerformed
        try {
            comboInput.setSelectedIndex(0);
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }//GEN-LAST:event_buttonInputFirstActionPerformed

    private void buttonInputPriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInputPriorActionPerformed
        try {
            var toSelect = comboInput.getSelectedIndex() - 1;
            if (toSelect < 0) {
                toSelect = modelInput.getSize() - 1;
            }
            comboInput.setSelectedIndex(toSelect);
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }//GEN-LAST:event_buttonInputPriorActionPerformed

    private void buttonInputNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInputNextActionPerformed
        try {
            var toSelect = comboInput.getSelectedIndex() + 1;
            if (toSelect > modelInput.getSize() -1) {
                toSelect =  0;
            }
            comboInput.setSelectedIndex(toSelect);
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }//GEN-LAST:event_buttonInputNextActionPerformed

    private void buttonBufferCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBufferCleanActionPerformed
        try {
            bufferBody = "";
            bufferSize = 0;
            putStatus("Cleaned Buffer", "");
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }//GEN-LAST:event_buttonBufferCleanActionPerformed

    private void buttonSetupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSetupActionPerformed
        new SetupDesk().setVisible(true);
    }//GEN-LAST:event_buttonSetupActionPerformed

    private void buttonInputFileOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInputFileOpenActionPerformed
        try {
            var folder = new File(fieldInput.getText());
            var file = new File(folder, comboInput.getSelectedItem().toString());
            WizDesk.open(file);
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }//GEN-LAST:event_buttonInputFileOpenActionPerformed

    private void buttonArchiveSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonArchiveSelectActionPerformed
        var selected = new File(fieldArchive.getText());
        selected = WizDesk.selectFolder(selected);
        if (selected != null) {
            fieldArchive.setText(selected.getAbsolutePath());
        }
    }//GEN-LAST:event_buttonArchiveSelectActionPerformed

    private void buttonArchiveOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonArchiveOpenActionPerformed
        try {
            var selected = new File(fieldArchive.getText());
            WizDesk.open(selected);
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }//GEN-LAST:event_buttonArchiveOpenActionPerformed
    
    private String cleanName(String title) {
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
                .replace(": ", " - ")
                .replace(":", ",")
                .replace(";", ",")
                .trim();
    }
    
    private String cleanCitation(String text) {
        return text
                .replace("[cite_start]", "")
                .replaceAll("\\[cite\\:(\\s|\\d|\\,)+\\]", "");
    }
    
    private void putStatus(String status, String archive) throws Exception {
        fieldStatus.setText(status);
        fieldStatus.setSelectionStart(0);
        fieldStatus.setSelectionEnd(0);
        if (checkArchiveMake.isSelected()) {
            var now = WizUtilDate.formatTimestampFile(new Date());
            var builder = new StringBuilder();
            builder.append("Time: ");
            builder.append(now);
            builder.append("\nStatus: ");
            builder.append(status);
            builder.append("\nArchive:\n");
            builder.append(archive);
            var folder = new File(fieldArchive.getText());
            var file = new File(folder, now + ".txt");
            Files.writeString(file.toPath(), builder.toString(), StandardCharsets.UTF_8);
        }
        textArchive.setText(archive);
        textArchive.setSelectionStart(0);
        textArchive.setSelectionEnd(0);
    }
    
    public static void start(String args[]) {
        WizDesk.start("Charvs", () -> new CharvsDesk().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonArchiveOpen;
    private javax.swing.JButton buttonArchiveSelect;
    private javax.swing.JButton buttonBufferAppend;
    private javax.swing.JButton buttonBufferClean;
    private javax.swing.JButton buttonInputFileOpen;
    private javax.swing.JButton buttonInputFirst;
    private javax.swing.JButton buttonInputNext;
    private javax.swing.JButton buttonInputOpen;
    private javax.swing.JButton buttonInputPrior;
    private javax.swing.JButton buttonInputSelect;
    private javax.swing.JButton buttonInputSwitch;
    private javax.swing.JButton buttonInputUpdate;
    private javax.swing.JButton buttonInsert;
    private javax.swing.JButton buttonLoad;
    private javax.swing.JButton buttonOutputOpen;
    private javax.swing.JButton buttonOutputSelect;
    private javax.swing.JButton buttonSave;
    private javax.swing.JButton buttonSaveOpen;
    private javax.swing.JButton buttonSetup;
    private javax.swing.JCheckBox checkArchiveMake;
    private javax.swing.JComboBox<String> comboInput;
    private javax.swing.JTextField fieldArchive;
    private javax.swing.JTextField fieldDestiny;
    private javax.swing.JTextField fieldInput;
    private javax.swing.JTextField fieldStatus;
    private javax.swing.JScrollPane scrollArchive;
    private javax.swing.JTextArea textArchive;
    // End of variables declaration//GEN-END:variables
}
