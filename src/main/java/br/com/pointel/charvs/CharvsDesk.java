package br.com.pointel.charvs;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Date;
import java.util.Objects;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.pointel.jarch.desk.DCol;
import br.com.pointel.jarch.desk.DPane;
import br.com.pointel.jarch.desk.DRow;
import br.com.pointel.jarch.mage.WizDesk;
import br.com.pointel.jarch.mage.WizFile;
import br.com.pointel.jarch.mage.WizString;
import br.com.pointel.jarch.mage.WizThread;
import br.com.pointel.jarch.mage.WizUtilDate;

public class CharvsDesk extends JFrame {

    private static final Logger LOG = LoggerFactory.getLogger(CharvsDesk.class);

    private JButton buttonSetup = new JButton("#");
    private JButton buttonBufferAppend = new JButton("Append");
    private JButton buttonBufferClean = new JButton("C");
    private JButton buttonInsert = new JButton("Insert");
    private JTextField fieldInsertTitle = new JTextField();
    private DRow rowMain = new DRow().insets(2)
            .growNone().insetsRight(7).put(buttonSetup)
            .growNone().insetsRight(0).put(buttonBufferAppend)
            .growNone().insetsRight(7).put(buttonBufferClean)
            .growNone().insetsRight(0).put(buttonInsert)
            .growHorizontal().insetsRight(0).put(fieldInsertTitle);

    private JButton buttonInputSelect = new JButton("Input");
    private JButton buttonInputOpen = new JButton("*");
    private JTextField fieldInput = new JTextField();
    private JButton buttonLoad = new JButton("Load");
    private DRow rowInput = new DRow().insets(2)
            .growNone().put(buttonInputSelect)
            .growNone().put(buttonInputOpen)
            .growHorizontal().put(fieldInput)
            .growNone().put(buttonLoad);

    private JButton buttonInputUpdate = new JButton("~");
    private JButton buttonInputFileOpen = new JButton("*");
    private final DefaultComboBoxModel<String> modelInput = new DefaultComboBoxModel<>();
    private JComboBox<String> comboInput = new JComboBox<>(modelInput);
    private JButton buttonInputFirst = new JButton("^");
    private JButton buttonInputPrior = new JButton("<");
    private JButton buttonInputNext = new JButton(">");
    private JButton buttonInputSwitch = new JButton("%");
    private DRow rowInputFile = new DRow().insets(2)
            .growNone().put(buttonInputUpdate)
            .growNone().put(buttonInputFileOpen)
            .growHorizontal().put(comboInput)
            .growNone().put(buttonInputFirst)
            .growNone().put(buttonInputPrior)
            .growNone().put(buttonInputNext)
            .growNone().put(buttonInputSwitch);

    private JButton buttonOutputSelect = new JButton("Output");
    private JButton buttonOutputOpen = new JButton("*");
    private JTextField fieldOutput = new JTextField();
    private JButton buttonSave = new JButton("Save");
    private JButton buttonSaveOpen = new JButton("*");
    private DRow rowOutput = new DRow().insets(2)
            .growNone().put(buttonOutputSelect)
            .growNone().put(buttonOutputOpen)
            .growHorizontal().put(fieldOutput)
            .growNone().put(buttonSave)
            .growNone().put(buttonSaveOpen);

    private JButton buttonArchiveSelect = new JButton("Archive");
    private JButton buttonArchiveOpen = new JButton("*");
    private JTextField fieldArchive = new JTextField();
    private JCheckBox checkArchiveMake = new JCheckBox("Make");
    private DRow rowArchive = new DRow().insets(2)
            .growNone().put(buttonArchiveSelect)
            .growNone().put(buttonArchiveOpen)
            .growHorizontal().put(fieldArchive)
            .growNone().put(checkArchiveMake);

    private JTextField fieldStatus = new JTextField();
    private DRow rowStatus = new DRow().insets(2)
            .growBoth().put(fieldStatus);

    private DPane paneBody = new DCol()
            .growHorizontal().put(rowMain)
            .growHorizontal().put(rowInput)
            .growHorizontal().put(rowInputFile)
            .growHorizontal().put(rowOutput)
            .growHorizontal().put(rowArchive)
            .growBoth().put(rowStatus)
            .borderEmpty(7);

    private String bufferBody = "";
    private Integer bufferSize = 0;
    private String originLast = "";
    private String originActual = "";
    private File savedLast = null;

    private volatile String clipboardText = null;
    private String partialInsert = null;
    private File partialFile = null;

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
    
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Charvs");
        setName("Desk");
        setContentPane(paneBody);
        pack();
        setLocationRelativeTo(null);

        fieldStatus.setEditable(false);

        buttonSetup.setToolTipText("Setup");
        buttonSetup.setName(""); // NOI18N
        buttonSetup.addActionListener(this::buttonSetupActionPerformed);

        buttonBufferAppend.setMnemonic('A');
        buttonBufferAppend.setToolTipText("Append Buffer (ctrl+A)");
        buttonBufferAppend.addActionListener(this::buttonBufferAppendActionPerformed);
        buttonBufferClean.setMnemonic('C');
        buttonBufferClean.setToolTipText("Clear Buffer");
        buttonBufferClean.addActionListener(this::buttonBufferCleanActionPerformed);

        buttonInsert.setMnemonic('I');
        buttonInsert.setToolTipText("Insert on < INSERT > tag in Input chain and puts on clipboard (ctrl+E)");
        buttonInsert.addActionListener(this::buttonInsertActionPerformed);
        fieldInsertTitle.setEditable(false);

        buttonInputSelect.setMnemonic('n');
        buttonInputSelect.setText("Input");
        buttonInputSelect.setToolTipText("Select Input Folder");
        buttonInputSelect.addActionListener(this::buttonInputSelectActionPerformed);
        buttonInputOpen.setToolTipText("Open Origin Folder");
        buttonInputOpen.addActionListener(this::buttonInputOpenActionPerformed);
        fieldInput.setName("InputFolder");
        buttonLoad.setMnemonic('L');
        buttonLoad.setToolTipText("Loads selected Input on clipboard (ctrl+C)");
        buttonLoad.addActionListener(this::buttonLoadActionPerformed);
        
        buttonInputUpdate.setToolTipText("Update Input Files");
        buttonInputUpdate.addActionListener(this::buttonInputUpdateActionPerformed);
        buttonInputFileOpen.setToolTipText("Open Input File");
        buttonInputFileOpen.addActionListener(this::buttonInputFileOpenActionPerformed);
        comboInput.addActionListener(this::comboInputActionPerformed);
        buttonInputFirst.setMnemonic('^');
        buttonInputFirst.setToolTipText("Select First Input File");
        buttonInputFirst.addActionListener(this::buttonInputFirstActionPerformed);
        buttonInputPrior.setMnemonic('<');
        buttonInputPrior.setToolTipText("Select Prior Input File");
        buttonInputPrior.addActionListener(this::buttonInputPriorActionPerformed);
        buttonInputNext.setMnemonic('>');
        buttonInputNext.setToolTipText("Select Next Input File");
        buttonInputNext.addActionListener(this::buttonInputNextActionPerformed);
        buttonInputSwitch.setMnemonic('%');
        buttonInputSwitch.setToolTipText("Switch between Input files (ctrl+S)");
        buttonInputSwitch.addActionListener(this::buttonInputSwitchActionPerformed);

        buttonOutputSelect.setMnemonic('O');
        buttonOutputSelect.setToolTipText("Select Output Folder");
        buttonOutputSelect.addActionListener(this::buttonOutputSelectActionPerformed);
        buttonOutputOpen.setToolTipText("Open Output Folder");
        buttonOutputOpen.addActionListener(this::buttonOutputOpenActionPerformed);
        fieldOutput.setName("OutputFolder");
        buttonSave.setMnemonic('S');
        buttonSave.setToolTipText("Saves clipboard on Output folder (ctrl+V)");
        buttonSave.addActionListener(this::buttonSaveActionPerformed);
        buttonSaveOpen.setToolTipText("Open Last Saved File");
        buttonSaveOpen.addActionListener(this::buttonSaveOpenActionPerformed);

        buttonArchiveSelect.setMnemonic('r');
        buttonArchiveSelect.setToolTipText("Select Archive Folder");
        buttonArchiveSelect.addActionListener(this::buttonArchiveSelectActionPerformed);
        buttonArchiveOpen.setToolTipText("Open Archive Folder");
        buttonArchiveOpen.addActionListener(this::buttonArchiveOpenActionPerformed);
        fieldArchive.setName("ArchiveFolder");
        checkArchiveMake.setName("ArchiveMake");

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
                        LOG.error("Error on watcher.", e);
                    }
                }
            }
        }.start();
    }

    private void watch() throws Exception {
        try {
            watchClipboardText();
        } catch (Exception e) {
            LOG.error("Error on watcher clipboard text.", e);
        }
    }
    
    private void watchClipboardText() throws Exception {
        if (checkClipboardNewText()) {
            if (Setup.getOnNewClipboardText() == OnNewClipboardText.ShowDesk) {
                showDesk();
            } else if (Setup.getOnNewClipboardText() == OnNewClipboardText.AppendOnBuffer) {
                buttonBufferAppendActionPerformed(null);
            } else if (Setup.getOnNewClipboardText() == OnNewClipboardText.InsertOnInput) {
                buttonInsertActionPerformed(null);
            } 
        }
    }

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

    private String cleanFileName(String title) {
        title = WizString.capitalizeWords(title.trim());
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
            builder.append("\nArchive:\n\n");
            builder.append(archive);
            var folder = new File(fieldArchive.getText());
            var file = new File(folder, now + ".txt");
            Files.writeString(file.toPath(), builder.toString(), StandardCharsets.UTF_8);
        }
    }

    private void buttonSetupActionPerformed(ActionEvent evt) {
        new SetupDesk().setVisible(true);
    }

    private void buttonBufferAppendActionPerformed(ActionEvent evt) {
        try {
            var body = WizDesk.getStringFromClipboard();
            bufferBody = (bufferBody.trim() + "\n\n" + body.trim()).trim();
            bufferSize++;
            WizDesk.putStringOnClipboard(bufferBody);
            putStatus("Appended " + bufferSize + " on Buffer", bufferBody);
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }

    private void buttonBufferCleanActionPerformed(ActionEvent evt) {
        try {
            bufferBody = "";
            bufferSize = 0;
            putStatus("Cleaned Buffer", "");
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }

    private void buttonInsertActionPerformed(ActionEvent evt) {
        try {
            var body = WizDesk.getStringFromClipboard();
            var folder = new File(fieldInput.getText());
            var file = new File(folder, comboInput.getSelectedItem().toString());
            var input = partialInsert;
            if (input == null) {    
                input = Files.readString(file.toPath());
            }
            int insertPos = input.indexOf("< INSERT");
            if (insertPos > -1) {
                int insertEnd = input.indexOf(">", insertPos);
                if (insertEnd > -1) {
                    input = input.substring(0, insertPos) + body + input.substring(insertEnd + 1);
                } else {
                    throw new Exception("Malformed < INSERT > tag.");
                }
            } else {
                throw new Exception("Not found < INSERT > tag.");
            }
            var remains = WizString.count(input, "< INSERT");
            WizDesk.putStringOnClipboard(input);
            putStatus("Inserted " + (remains == 0 ? "Done" : "Left " + remains) + " on " + (partialInsert != null ?  "Partial of " + partialFile.getName() : file.getName()), input);
            if (remains == 0) {
                partialInsert = null;
                partialFile = null;
                int warnPos = input.indexOf("< WARN");
                if (warnPos > -1) {
                    int warnEnd = input.indexOf(">", warnPos);
                    if (warnEnd > -1) {
                         var warnText = input.substring(warnPos + 6, warnEnd).trim();
                        if (warnText.startsWith(":")) {
                            warnText = warnText.substring(1).trim();
                        }
                        WizDesk.showInfo(warnText);
                    } else {
                        throw new Exception("Malformed < WARN > tag.");
                    }
                }
            } else {
                partialInsert = input;
                partialFile = file;
            }
            bufferBody = "";
            bufferSize = 0;
            putInsertTitle();
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }

    private void putInsertTitle() {
        try {
            var folder = new File(fieldInput.getText());
            var file = new File(folder, comboInput.getSelectedItem().toString());
            var input = partialInsert;
            if (input == null) {    
                input = Files.readString(file.toPath());
            }
            int insertPos = input.indexOf("< INSERT");
            if (insertPos > -1) {
                int insertEnd = input.indexOf(">", insertPos);
                if (insertEnd > -1) {
                    var insertTitle = input.substring(insertPos + 8, insertEnd).trim();
                    if (insertTitle.startsWith(":")) {
                        insertTitle = insertTitle.substring(1).trim();
                    }
                    fieldInsertTitle.setText(insertTitle.isEmpty() ? "Found <INSERT> tag." : insertTitle);
                    fieldInsertTitle.setSelectionStart(0);
                    fieldInsertTitle.setSelectionEnd(0);
                } else {
                    throw new Exception("Malformed < INSERT > tag.");
                }
            } else {
                throw new Exception("Not found < INSERT > tag.");
            }
        } catch (Exception e) {
            fieldInsertTitle.setText(e.getMessage());
            fieldInsertTitle.setSelectionStart(0);
            fieldInsertTitle.setSelectionEnd(0);
        }
    }

    private void buttonInputSelectActionPerformed(ActionEvent evt) {
        var selected = new File(fieldInput.getText());
        selected = WizDesk.selectFolder(selected);
        if (selected != null) {
            fieldInput.setText(selected.getAbsolutePath());
        }
    }

    private void buttonInputOpenActionPerformed(ActionEvent evt) {
        try {
            var selected = new File(fieldInput.getText());
            WizDesk.open(selected);
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }

    private void buttonLoadActionPerformed(ActionEvent evt) {
        try {
            var folder = new File(fieldInput.getText());
            var file = new File(folder, comboInput.getSelectedItem().toString());
            var input = Files.readString(file.toPath());
            WizDesk.putStringOnClipboard(input);
            putStatus("Loaded from " + file.getName(), input);
            bufferBody = "";
            bufferSize = 0;
            int warnPos = input.indexOf("< WARN");
            if (warnPos > -1) {
                int warnEnd = input.indexOf(">", warnPos);
                if (warnEnd > -1) {
                        var warnText = input.substring(warnPos + 6, warnEnd).trim();
                    if (warnText.startsWith(":")) {
                        warnText = warnText.substring(1).trim();
                    }
                    WizDesk.showInfo(warnText);
                } else {
                    throw new Exception("Malformed < WARN > tag.");
                }
            }
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }

    private void buttonInputUpdateActionPerformed(ActionEvent evt) {
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
    }

    private void buttonInputFileOpenActionPerformed(ActionEvent evt) {
        try {
            var folder = new File(fieldInput.getText());
            var file = new File(folder, comboInput.getSelectedItem().toString());
            WizDesk.open(file);
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }

    private void comboInputActionPerformed(ActionEvent evt) {
        if (comboInput.getSelectedItem() != null) {
            originLast = originActual;
            originActual = comboInput.getSelectedItem().toString();
            partialInsert = null;
            partialFile = null;
            putInsertTitle();
        }
    }

    private void buttonInputFirstActionPerformed(ActionEvent evt) {
        try {
            comboInput.setSelectedIndex(0);
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }

    private void buttonInputPriorActionPerformed(ActionEvent evt) {
        try {
            var toSelect = comboInput.getSelectedIndex() - 1;
            if (toSelect < 0) {
                toSelect = modelInput.getSize() - 1;
            }
            comboInput.setSelectedIndex(toSelect);
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }

    private void buttonInputNextActionPerformed(ActionEvent evt) {
        try {
            var toSelect = comboInput.getSelectedIndex() + 1;
            if (toSelect > modelInput.getSize() -1) {
                toSelect =  0;
            }
            comboInput.setSelectedIndex(toSelect);
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }

    private void buttonInputSwitchActionPerformed(ActionEvent evt) {
        try {
            comboInput.setSelectedItem(originLast);
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }

    private void buttonOutputSelectActionPerformed(ActionEvent evt) {
        var selected = new File(fieldOutput.getText());
        selected = WizDesk.selectFolder(selected);
        if (selected != null) {
            fieldOutput.setText(selected.getAbsolutePath());
        }
    }

    private void buttonOutputOpenActionPerformed(ActionEvent evt) {
        try {
            var selected = new File(fieldOutput.getText());
            WizDesk.open(selected);
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }

    private void buttonSaveActionPerformed(ActionEvent evt) {
        try {
            var text = cleanCitation(WizDesk.getStringFromClipboard()).trim();
            var folder = new File(fieldOutput.getText());
            var fileName = WizUtilDate.formatTimestampFile(new Date());
            var setupNaming = Setup.getOnNaming();
            if (setupNaming == OnNaming.FirstLine) {
                fileName = cleanFileName(WizString.getLines(text)[0]);
            } else if (setupNaming == OnNaming.Numbered) {
                var prefix = Setup.getNameNumberedPrefix();
                var index = 1;
                var size = Setup.getNameNumberedSize();
                var suffix = Setup.getNameNumberedSuffix();
                fileName = prefix + WizString.fillAtStart(index + "", '0', size) + suffix;
                var file = new File(folder, fileName + ".txt");
                while (file.exists()) {
                    index++;
                    fileName = prefix + WizString.fillAtStart(index + "", '0', size) + suffix;
                    file = new File(folder, fileName + ".txt");
                }
            }
            var file = new File(folder, fileName + ".txt");
            if (Setup.getOnSave() == OnSave.KeepAll) {
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
    }

    private void buttonSaveOpenActionPerformed(ActionEvent evt) {
        try {
            WizDesk.open(savedLast);
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }

    private void buttonArchiveSelectActionPerformed(ActionEvent evt) {
        var selected = new File(fieldArchive.getText());
        selected = WizDesk.selectFolder(selected);
        if (selected != null) {
            fieldArchive.setText(selected.getAbsolutePath());
        }
    }

    private void buttonArchiveOpenActionPerformed(ActionEvent evt) {
        try {
            var selected = new File(fieldArchive.getText());
            WizDesk.open(selected);
        } catch (Exception e) {
            WizDesk.showError(e);
        }
    }
    
    public static void start(String args[]) {
        WizDesk.start("Charvs", () -> new CharvsDesk().setVisible(true));
    }

}
