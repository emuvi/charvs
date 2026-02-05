package br.com.pointel.charvs;

import java.io.Serializable;

public class Replace implements Serializable {

    public Boolean active;
    public Boolean regex;
    public String of;
    public String to;

    public Replace() {
        this.active = false;
        this.regex = false;
        this.of = "";
        this.to = "";
    }

    public Replace(Boolean active, Boolean regex, String of, String to) {
        this.active = active;
        this.regex = regex;
        this.of = of;
        this.to = to;
    }

    @Override
    public String toString() {
        return (active ? "(X)" : "( )") + " | " + (regex ? "(R)" : "( )") + " | " + of + " -> " + to;
    }

}
