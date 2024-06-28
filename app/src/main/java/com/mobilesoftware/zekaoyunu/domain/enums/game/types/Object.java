package com.mobilesoftware.zekaoyunu.domain.enums.game.types;

import com.mobilesoftware.zekaoyunu.R;
import com.mobilesoftware.zekaoyunu.domain.enums.game.option.OptionType;

public enum Object {
    BAG(R.drawable.gametype_goods_bag),
    CAMERA(R.drawable.gametype_goods_camera),
    CLOCK(R.drawable.gametype_goods_clock),
    COMPUTER(R.drawable.gametype_goods_computer),
    GLASSES(R.drawable.gametype_goods_glasses),
    KEY(R.drawable.gametype_goods_key),
    PENCIL(R.drawable.gametype_goods_pencil),
    PHONE(R.drawable.gametype_goods_phone),
    SCISSORS(R.drawable.gametype_goods_scissors),
    UMBRELLA(R.drawable.gametype_goods_umbrella);

    private final OptionType optionType = OptionType.IMAGE;

    private final int typeName = R.string.type_object;

    private final int resourceId;

    Object(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getResourceId() { return resourceId; }

    public OptionType getOptionType() { return optionType; }

    public int getTypeName() { return typeName; }

}
