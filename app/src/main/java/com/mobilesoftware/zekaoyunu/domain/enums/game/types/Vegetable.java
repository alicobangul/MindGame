package com.mobilesoftware.zekaoyunu.domain.enums.game.types;

import com.mobilesoftware.zekaoyunu.R;
import com.mobilesoftware.zekaoyunu.domain.enums.game.option.OptionType;

public enum Vegetable {

    CARROT(R.drawable.gametype_vegetables_carrot),
    DILL(R.drawable.gametype_vegetables_dill),
    EGGPLANT(R.drawable.gametype_vegetables_eggplant),
    GARLIC(R.drawable.gametype_vegetables_garlic),
    LEEK(R.drawable.gametype_vegetables_leek),
    MUSHROOMS(R.drawable.gametype_vegetables_mushrooms),
    POTATO(R.drawable.gametype_vegetables_potato),
    PUMPKIN(R.drawable.gametype_vegetables_pumpkin),
    RADISH(R.drawable.gametype_vegetables_radish),
    TOMATO(R.drawable.gametype_vegetables_tomato);

    private final OptionType optionType = OptionType.IMAGE;

    private final int typeName = R.string.type_vegetable;

    private final int resourceId;

    Vegetable(int resourceId) { this.resourceId = resourceId; }

    public int getResourceId() { return resourceId; }

    public OptionType getOptionType() { return optionType; }

    public int getTypeName() { return typeName; }

}
