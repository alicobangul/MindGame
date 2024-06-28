package com.mobilesoftware.zekaoyunu.domain.enums.game.types;

import com.mobilesoftware.zekaoyunu.R;
import com.mobilesoftware.zekaoyunu.domain.enums.game.option.OptionType;

public enum Animal {
    BIRD(R.drawable.gametype_animals_bird),
    CAT(R.drawable.gametype_animals_cat),
    DOG(R.drawable.gametype_animals_dog),
    ELEPHANT(R.drawable.gametype_animals_elephant),
    FOX(R.drawable.gametype_animals_fox),
    GIRAFFE(R.drawable.gametype_animals_giraffe),
    HORSE(R.drawable.gametype_animals_horse),
    LION(R.drawable.gametype_animals_lion),
    PANDA(R.drawable.gametype_animals_panda),
    TIGER(R.drawable.gametype_animals_tiger);

    private final OptionType optionType = OptionType.IMAGE;

    private final int typeName = R.string.type_animal;

    private final int resourceId;

    Animal(int resourceId) { this.resourceId = resourceId; }

    public int getResourceId() { return resourceId; }

    public OptionType getOptionType() { return optionType; }

    public int getTypeName() { return typeName; }

}