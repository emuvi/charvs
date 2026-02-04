package br.com.pointel.charvs;

import br.com.pointel.jarch.desk.DEdit;
import br.com.pointel.jarch.desk.DFieldEdit;
import br.com.pointel.jarch.desk.DTitledEdit;
import br.com.pointel.jarch.desk.DLinePane;
import br.com.pointel.jarch.desk.DStringField;
import br.com.pointel.jarch.desk.DBooleanEdit;

public class ReplaceEdit extends DEdit<Replace> {

    private DFieldEdit<String> fieldOf = new DStringField().cols(24);
    private DTitledEdit<String> titledOf = new DTitledEdit<>("Of:", fieldOf);
    private DFieldEdit<String> fieldTo = new DStringField().cols(24);
    private DTitledEdit<String> titledTo = new DTitledEdit<>("To:", fieldTo);
    private DBooleanEdit fieldHolders = new DBooleanEdit();
    private DTitledEdit<Boolean> titledHolders = new DTitledEdit<>("Holders:", fieldHolders);

    public ReplaceEdit() {
        super(new DLinePane());
        comp().add(titledOf);
        comp().add(titledTo);
        comp().add(titledHolders);
    }

    @Override
    public Replace getValue() {
        return new Replace(fieldOf.getValue(), fieldTo.getValue(), fieldHolders.getValue());
    }

    @Override
    public void setValue(Replace value) {
        fieldOf.setValue(value.of);
        fieldTo.setValue(value.to);
        fieldHolders.setValue(value.holders);
    }

}
