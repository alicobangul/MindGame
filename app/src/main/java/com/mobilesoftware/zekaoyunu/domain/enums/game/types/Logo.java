package com.mobilesoftware.zekaoyunu.domain.enums.game.types;

import com.mobilesoftware.zekaoyunu.R;
import com.mobilesoftware.zekaoyunu.domain.enums.game.option.OptionType;

public enum Logo {
    BMW(R.drawable.gametype_carlogo_bmw),
    CHEVROLET(R.drawable.gametype_carlogo_chevrolet),
    FERRARI(R.drawable.gametype_carlogo_ferrari),
    LAMBORGHINI(R.drawable.gametype_carlogo_lamborghini),
    MERCEDES(R.drawable.gametype_carlogo_mercedes),
    MITSUBISHI(R.drawable.gametype_carlogo_mitsubishi),
    NISSAN(R.drawable.gametype_carlogo_nissan),
    PORSCHE(R.drawable.gametype_carlogo_porsche),
    ROLLSROYCE(R.drawable.gametype_carlogo_rollsroyce),
    VOLKSWAGEN(R.drawable.gametype_carlogo_volkswagen);

    private final OptionType optionType = OptionType.IMAGE;

    private final int typeName = R.string.type_logo;

    private final int resourceId;

    Logo(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public OptionType getOptionType() { return optionType; }

    public int getTypeName() { return typeName; }

}
