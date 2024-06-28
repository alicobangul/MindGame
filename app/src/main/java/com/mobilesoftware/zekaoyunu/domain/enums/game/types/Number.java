package com.mobilesoftware.zekaoyunu.domain.enums.game.types;

import com.mobilesoftware.zekaoyunu.R;
import com.mobilesoftware.zekaoyunu.domain.enums.game.option.OptionType;

public enum Number {
    ZERO("0"),
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10");

    private final OptionType optionType = OptionType.TEXT;

    private final int typeName = R.string.type_number;

    private final String text;

    Number(String text) { this.text = text; }

    public String getText() { return text; }

    public OptionType getOptionType() { return optionType; }

    public int getTypeName() { return typeName; }

}