package com.mobilesoftware.zekaoyunu.domain.enums.game.types;

import com.mobilesoftware.zekaoyunu.R;
import com.mobilesoftware.zekaoyunu.domain.enums.game.option.OptionType;

public enum MathSymbol {

    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("x"),
    DIVIDE("/"),
    EQUAL("="),
    MODULUS("%"),
    LESS_THAN("<"),
    GREATER_THAN(">"),
    LESS_THAN_OR_EQUAL("=<"),
    GREATER_THAN_OR_EQUAL("=>");

    private final OptionType optionType = OptionType.TEXT;

    private final int typeName = R.string.type_mathsymbol;

    private final String text;

    MathSymbol(String text) { this.text = text; }

    public String getText() { return text; }

    public OptionType getOptionType() { return optionType; }

    public int getTypeName() { return typeName; }

}
