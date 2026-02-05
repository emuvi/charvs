package br.com.pointel.charvs;

import br.com.pointel.jarch.desk.DEdit;
import br.com.pointel.jarch.desk.DFieldEdit;
import br.com.pointel.jarch.desk.DTitledEdit;
import br.com.pointel.jarch.desk.DLinePane;
import br.com.pointel.jarch.desk.DPane;
import br.com.pointel.jarch.desk.DRowPane;
import br.com.pointel.jarch.desk.DStringField;

import javax.swing.Box;

import br.com.pointel.jarch.desk.DBooleanEdit;
import br.com.pointel.jarch.desk.DColPane;

public class ReplaceEdit extends DEdit<Replace> {

    private DBooleanEdit fieldActive = new DBooleanEdit().text("Active");
    private DBooleanEdit fieldRegex = new DBooleanEdit().text("Regex");
    private DPane paneOptions = new DRowPane().insets(3)
            .put(fieldActive)
            .put(fieldRegex)
            .growHorizontal().put(Box.createHorizontalBox());
    private DFieldEdit<String> fieldOf = new DStringField().cols(24);
    private DTitledEdit<String> titledOf = new DTitledEdit<>("Of:", fieldOf);
    private DFieldEdit<String> fieldTo = new DStringField().cols(24);
    private DTitledEdit<String> titledTo = new DTitledEdit<>("To:", fieldTo);
    private DPane paneReplace = new DRowPane().insets(3)
            .growHorizontal().put(titledOf)
            .put(titledTo);
    private DPane paneBody = new DColPane()
            .growBoth().put(paneOptions)
            .put(paneReplace);

    public ReplaceEdit() {
        comp(paneBody);
    }

    @Override
    public Replace getValue() {
        return new Replace(fieldActive.getValue(), fieldRegex.getValue(), fieldOf.getValue(), fieldTo.getValue());
    }

    @Override
    public void setValue(Replace value) {
        fieldActive.setValue(value.active);
        fieldRegex.setValue(value.regex);
        fieldOf.setValue(value.of);
        fieldTo.setValue(value.to);
    }

}
