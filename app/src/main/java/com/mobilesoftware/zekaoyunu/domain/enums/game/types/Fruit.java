package com.mobilesoftware.zekaoyunu.domain.enums.game.types;

import com.mobilesoftware.zekaoyunu.R;
import com.mobilesoftware.zekaoyunu.domain.enums.game.option.OptionType;

public enum Fruit {

    APPLE(R.drawable.gametype_fruits_apple),
    PEAR(R.drawable.gametype_fruits_pear),
    BANANA(R.drawable.gametype_fruits_banana),
    CANTALOUPE(R.drawable.gametype_fruits_cantaloupe),
    WATERMELON(R.drawable.gametype_fruits_watermelon),
    PEACH(R.drawable.gametype_fruits_peach),
    APRICOT(R.drawable.gametype_fruits_apricot),
    GRAPE(R.drawable.gametype_fruits_grape),
    POMEGRANATE(R.drawable.gametype_fruits_pomegranate),
    PINEAPPLE(R.drawable.gametype_fruits_pineapple);

    private final OptionType optionType = OptionType.IMAGE;

    private final int typeName = R.string.type_fruit;

    private final int resourceId;

    Fruit(int resourceId) { this.resourceId = resourceId; }

    public int getResourceId() { return resourceId; }

    public OptionType getOptionType() { return optionType; }

    public int getTypeName() { return typeName; }

}
