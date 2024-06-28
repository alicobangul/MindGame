package com.mobilesoftware.zekaoyunu.domain.enums.game.settings;

import com.mobilesoftware.zekaoyunu.domain.enums.game.types.*;
import com.mobilesoftware.zekaoyunu.domain.enums.game.types.Character;
import com.mobilesoftware.zekaoyunu.domain.enums.game.types.Number;
import com.mobilesoftware.zekaoyunu.domain.enums.game.types.Object;
import java.util.Arrays;

public enum GameType {
    COLOR (Color.class),
    SYMBOL (Symbol.class),
    VEGETABLE (Vegetable.class),
    FRUIT (Fruit.class),
    ANIMAL (Animal.class),
    VEHICLE (Vehicle.class),
    LOGO (Logo.class),
    OBJECT (Object.class),
    LETTER (Letter.class),
    NUMBER (Number.class),
    MATHSYMBOL (MathSymbol.class),
    CHARACTER (Character.class),
    RANDOM (null);

    private final Class<?> typeClass;

    GameType(Class<?> typeClass) { this.typeClass = typeClass; }

    public static GameType randomType() {

        /**
         * Son type olan random hariç rastgele bir type döndürür
         * Eğer yeni bir mod eklenecek ise RANDOM verisinin üzerine eklenmeli ve sınıfı bildirilmelidir.
         */

        return Arrays.asList(GameType.values()).get((int) (Math.random() * values().length - 1));

    }

    public Class<?> getTypeClass() { return typeClass; }

}
