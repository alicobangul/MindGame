package com.mobilesoftware.zekaoyunu.domain.util;

import com.mobilesoftware.zekaoyunu.domain.enums.game.types.Color;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class EnumGenerator {

    public static <T extends Enum<T>> ArrayList<T> generateRandomEnums(Class<?> enumClass, int count, boolean isForGame) {

        ArrayList<T> result = new ArrayList<>();

        // Enum sabitlerini al
        T[] enumConstants = (T[]) enumClass.getEnumConstants();

        // Eğer count 0'dan küçükse veya enum sabitlerinin sayısından fazlaysa boş liste döndür
        if (count <= 0 || count > Objects.requireNonNull(enumConstants).length) return result;

        Random random = new Random();

        // Enum sabitlerini karıştır
        ArrayList<T> shuffledEnums = new ArrayList<>(List.of(enumConstants));

        Collections.shuffle(shuffledEnums);

        // ArrayList boyutu istenilen sayıya ulaşana kadar devam et
        while (result.size() < count) {

            // Karıştırılmış enum listesinden rastgele bir enum seç
            T randomEnum = shuffledEnums.get(random.nextInt(shuffledEnums.size()));

            /**
             * Oyun gösterimi için hazırlanıyor
             * Benzer öğeler olabilir ama ardışık olamaz ve eğer Color modu seçili ise ilk enum white olamaz.
             */
            if (isForGame) {

                // Daha önce eklenmiş olan son eleman ile aynı değil
                boolean isNotSame = !result.isEmpty() && result.get(result.size() - 1) != randomEnum;

                // Liste boş
                boolean isEmptyList = result.isEmpty();

                // Renk enum'u seçilmedi veya ilk eleman white değil
                boolean isFirstColorNotWhite = !enumClass.equals(Color.class) || randomEnum != Color.WHITE;

                // Son eklenen eleman ile aynı değil
                if (isNotSame) result.add(randomEnum);

                /**
                 * Liste boş & Color enum seçilmedi veya ilk eleman white değil
                 * İlk eleman white değil kontrolünün sebebi:
                 * Ekran ilk açıldığında beyaz oluyor karmaşıklığa sebep olabileceği için farklı renk olmalıdır
                 */
                else if (isEmptyList && isFirstColorNotWhite) result.add(randomEnum);

            }

            // Soru seçenekleri için hazırlanıyor [Benzersiz 4 adet enum gerekli]
            else if (result.isEmpty() || !result.contains(randomEnum)) result.add(randomEnum);


        }

        return result;

    }

}
