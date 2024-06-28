package com.mobilesoftware.zekaoyunu.domain.enums.game.types;

import com.mobilesoftware.zekaoyunu.R;
import com.mobilesoftware.zekaoyunu.domain.enums.game.option.OptionType;

public enum Color {

    WHITE(R.color.white),
    BLACK(R.color.black),
    RED(R.color.red),
    GREEN(R.color.green),
    BLUE(R.color.blue),
    YELLOW(R.color.yellow),
    PURPLE(R.color.purple),
    ORANGE(R.color.orange),
    GRAY(R.color.gray),
    BROWN(R.color.brown);

    private final OptionType optionType = OptionType.IMAGE;

    private final int typeName = R.string.type_color;

    private final int resourceId;

    Color(int resourceId) { this.resourceId = resourceId; }

    public OptionType getOptionType() { return optionType; }

    public int getTypeName() { return typeName; }

    public int getResourceId() { return resourceId; }

}