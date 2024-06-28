package com.mobilesoftware.zekaoyunu.domain.enums.game.types;

import com.mobilesoftware.zekaoyunu.R;
import com.mobilesoftware.zekaoyunu.domain.enums.game.option.OptionType;

public enum Character {
    DOT("."),
    COLON(":"),
    COMMA(","),
    SEMICOLON(";"),
    LEFT_PAREN("("),
    RIGHT_PAREN(")"),
    LEFT_BRACKET("["),
    RIGHT_BRACKET("]"),
    LEFT_BRACE("{"),
    RIGHT_BRACE("}");

    private final OptionType optionType = OptionType.TEXT;

    private final int typeName = R.string.type_character;

    private final String text;

    Character(String text) {this.text = text; }

    public String getText() { return text; }

    public OptionType getOptionType() { return optionType; }

    public int getTypeName() { return typeName; }

}