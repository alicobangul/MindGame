package com.mobilesoftware.zekaoyunu.domain.enums.game.types;

import com.mobilesoftware.zekaoyunu.R;
import com.mobilesoftware.zekaoyunu.domain.enums.game.option.OptionType;

public enum Symbol {

    HEXAGON(R.drawable.gametype_symbol_hexagon),
    L_LETTER(R.drawable.gametype_symbol_lletter),
    PENTAGON(R.drawable.gametype_symbol_pentagon),
    RECTANGLE(R.drawable.gametype_symbol_rectangle),
    ROUND(R.drawable.gametype_symbol_round),
    SPIRAL(R.drawable.gametype_symbol_spiral),
    SQUARE(R.drawable.gametype_symbol_square),
    STAR(R.drawable.gametype_symbol_star),
    TARGET(R.drawable.gametype_symbol_target),
    TRIANGLE(R.drawable.gametype_symbol_triangle);

    private final OptionType optionType = OptionType.IMAGE;

    private final int typeName = R.string.type_symbol;

    private final int resourceId;

    Symbol(int resourceId) { this.resourceId = resourceId; }

    public int getResourceId() { return resourceId; }

    public OptionType getOptionType() { return optionType; }

    public int getTypeName() { return typeName; }

}
