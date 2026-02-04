package br.com.pointel.charvs;

import java.io.Serializable;

public class Replace implements Serializable {

    public String of;
    public String to;
    public Boolean holders;

    public Replace() {
        this("", "", false);
    }

    public Replace(String of, String to) {
        this(of, to, false);
    }

    public Replace(String of, String to, Boolean holders) {
        this.of = of;
        this.to = to;
        this.holders = holders;
    }

    @Override
    public String toString() {
        return of + " -> " + to + " | " + (holders ? "(H)" : "( )");
    }

}
