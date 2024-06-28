package com.mobilesoftware.zekaoyunu.domain.enums.game.types;

import com.mobilesoftware.zekaoyunu.R;
import com.mobilesoftware.zekaoyunu.domain.enums.game.option.OptionType;

public enum Vehicle {
    AIRPLANE(R.drawable.gametype_vehicles_airplane),
    BIKE(R.drawable.gametype_vehicles_bike),
    BUS(R.drawable.gametype_vehicles_bus),
    CAR(R.drawable.gametype_vehicles_car),
    MINI_TRUCK(R.drawable.gametype_vehicles_minitruck),
    MOTORCYCLE(R.drawable.gametype_vehicles_motorcycle),
    SCHOOLVAN(R.drawable.gametype_vehicles_schoolvan),
    TRACTOR(R.drawable.gametype_vehicles_tractor),
    TRAIN(R.drawable.gametype_vehicles_train),
    TRUCK(R.drawable.gametype_vehicles_truck);

    private final OptionType optionType = OptionType.IMAGE;

    private final int typeName = R.string.type_vehicle;

    private final int resourceId;

    Vehicle(int resourceId) { this.resourceId = resourceId; }

    public int getResourceId() { return resourceId; }

    public OptionType getOptionType() { return optionType; }

    public int getTypeName() { return typeName; }

}