package com.mobilesoftware.zekaoyunu.domain.enums.game.types;

import com.mobilesoftware.zekaoyunu.R;
import com.mobilesoftware.zekaoyunu.domain.enums.game.option.OptionType;

public enum Letter {
    A("A"),
    B("B"),
    C("C"),
    D("D"),
    E("E"),
    F("F"),
    G("G"),
    H("H"),
    I("I"),
    J("J"),
    K("K"),
    L("L"),
    M("M"),
    N("N"),
    O("O"),
    P("P"),
    Q("Q"),
    R("R"),
    S("S"),
    T("T"),
    U("U"),
    V("V"),
    W("W"),
    X("X"),
    Y("Y"),
    Z("Z");

    private final OptionType optionType = OptionType.TEXT;

    private final int typeName = com.mobilesoftware.zekaoyunu.R.string.type_letter;

    private final String text;

    Letter(String text) { this.text = text; }

    public String getText() { return text; }

    public OptionType getOptionType() { return optionType; }

    public int getTypeName() { return typeName; }

}
