package com.mobilesoftware.zekaoyunu.domain.util;

import com.mobilesoftware.zekaoyunu.domain.enums.game.settings.GameType;
import java.util.ArrayList;

public class GameGenerator {

    private GameType gameType;

    private Integer showRange;

    private Integer questionEnumIndex;

    private Integer correctButtonIndex;

    private ArrayList<Enum> listGameEnums;

    private ArrayList<Enum> listGameOptionEnums;

    public GameGenerator(GameType gameType, Integer showRange) {

        this.gameType = gameType;

        this.showRange = showRange;

        // Gösterim sayısı kaç ise o kadar enum verisi hazırlandı [Örneğin 4 adet renk, 6 adet eşya, 8 adet sembol vs]
        this.listGameEnums = EnumGenerator.generateRandomEnums(gameType.getTypeClass(), showRange, true);

        // 4 Adet rastgele seçenek hazırlandı
        this.listGameOptionEnums = EnumGenerator.generateRandomEnums(gameType.getTypeClass(), 4, false);

        // Kaçıncı enum değerinin soru olarak seçileceği ayarlandı [Örn 3.enum -> 3. gösterilen eşya, 4.enum -> 4. gösterilen renk vs]
        this.questionEnumIndex = getRandomEnumIndex(listGameEnums.size());

        // Kaçıncı butonun doğru cevap kabul edileceği ayarlandı
        this.correctButtonIndex = getRandomButtonIndex();

        // Soru olarak seçilen enum, seçeneklerin yer aldığı listedeki belirlenen [correctAnswerButton] sıraya yerleştiriliyor
        setCorrectAnswerInOptions(listGameOptionEnums, listGameEnums, correctButtonIndex, questionEnumIndex);

    }

    public Integer getRandomEnumIndex(int listSize) { return (int) (Math.random() * listSize); }

    public Integer getRandomButtonIndex() { return (int) (Math.random() * 4); }

    // Soru olarak seçilen enum, seçeneklerin yer aldığı listedeki sıraya yerleştiriliyor
    public void setCorrectAnswerInOptions(
            ArrayList<Enum> listOption,
            ArrayList<Enum> listGameEnums,
            Integer correctButtonIndex,
            Integer questionEnumIndex
    ) {
        listOption.set(correctButtonIndex, listGameEnums.get(questionEnumIndex));
    }

}
