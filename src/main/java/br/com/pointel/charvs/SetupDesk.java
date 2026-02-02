package br.com.pointel.charvs;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.awt.GridLayout;

import br.com.pointel.jarch.mage.WizDesk;

public class SetupDesk extends JFrame {

    private JPanel panelBody = new JPanel();
    private JScrollPane scrollBody = new JScrollPane(panelBody);

    private JLabel labelOnClipboardNewText = new JLabel("On Clipboard New Text:");
    private DefaultComboBoxModel<String> modelOnClipboardNewText = new DefaultComboBoxModel<>(new String[] { "Nothing", "ShowDesk", "AppendOnBuffer", "InsertOnInput" });
    private JComboBox<String> comboOnClipboardNewText = new JComboBox<>(modelOnClipboardNewText);
    private JLabel labelOnNaming = new JLabel("On Naming:");
    private DefaultComboBoxModel<String> modelOnNaming = new DefaultComboBoxModel<>(new String[] { "FirstLine", "Timestamp", "Numbered" });
    private JComboBox<String> comboOnNaming = new JComboBox<>(modelOnNaming);
    private JLabel labelNumberedPrefix = new JLabel("  Numbered Prefix:");
    private JTextField fieldNumberedPrefix = new JTextField();
    private JLabel labelNumberedSize = new JLabel("  Numbered Size:");
    private JSpinner spinnerNumberedSize = new JSpinner();
    private JLabel labelNumberedSuffix = new JLabel("  Numbered Suffix:");
    private JTextField fieldNumberedSuffix = new JTextField();
    private JLabel labelNameExtension = new JLabel("Name Extension:");
    private JTextField fieldNameExtension = new JTextField();
    private JLabel labelOnSave = new JLabel("On Save:");
    private DefaultComboBoxModel<String> modelOnSave = new DefaultComboBoxModel<>(new String[] { "Override", "KeepAll" });
    private JComboBox<String> comboOnSave = new JComboBox<>(modelOnSave);
    private JLabel labelOnRecord = new JLabel("On Record:");
    private DefaultComboBoxModel<String> modelOnRecord = new DefaultComboBoxModel<>(new String[] { "Empty", "FileBase", "FileName", "FilePath" });
    private JComboBox<String> comboOnRecord = new JComboBox<>(modelOnRecord);
     private JLabel labelRecordPrefix = new JLabel("  Prefix:");
    private JTextField fieldRecordPrefix = new JTextField();
    private JLabel labelRecordSuffix = new JLabel("  Suffix:");
    private JTextField fieldRecordSuffix = new JTextField();
    
    public SetupDesk() {
        initDesk();
    }
    
    private void initDesk() {
        initComponents();
        setIconImage(WizDesk.getLogo());
        WizDesk.initFrame(this);
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Setup");
        setName("Setup");
        
        comboOnClipboardNewText.setName("OnClipboardNewText");
        comboOnNaming.setName("OnNaming");
        fieldNumberedPrefix.setName("NameNumberedPrefix");
        spinnerNumberedSize.setName("NameNumberedSize");
        fieldNumberedSuffix.setName("NameNumberedSuffix");
        fieldNameExtension.setName("NameExtension");
        comboOnSave.setName("OnSave");
        comboOnRecord.setName("OnRecord");
        fieldRecordPrefix.setName("RecordPrefix");
        fieldRecordSuffix.setName("RecordSuffix");

        panelBody.setBorder(BorderFactory.createEmptyBorder(9, 9, 9, 9));

        panelBody.setLayout(new GridLayout(10, 2, 2, 2));
        panelBody.add(labelOnClipboardNewText);
        panelBody.add(comboOnClipboardNewText);
        panelBody.add(labelOnNaming);
        panelBody.add(comboOnNaming);
        panelBody.add(labelNumberedPrefix);
        panelBody.add(fieldNumberedPrefix);
        panelBody.add(labelNumberedSize);
        panelBody.add(spinnerNumberedSize);
        panelBody.add(labelNumberedSuffix);
        panelBody.add(fieldNumberedSuffix);
        panelBody.add(labelNameExtension);
        panelBody.add(fieldNameExtension);
        panelBody.add(labelOnSave);
        panelBody.add(comboOnSave);
        panelBody.add(labelOnRecord);
        panelBody.add(comboOnRecord);
        panelBody.add(labelRecordPrefix);
        panelBody.add(fieldRecordPrefix);
        panelBody.add(labelRecordSuffix);
        panelBody.add(fieldRecordSuffix);

        setContentPane(scrollBody);
        setLocationRelativeTo(null);
        pack();
    }

}
