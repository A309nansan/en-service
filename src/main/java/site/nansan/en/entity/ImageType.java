package site.nansan.en.entity;

import java.util.List;

public enum ImageType {

    apple_card, banana_card, grape_card,

    apple, carrot, corn, fish, grape, soccerball, turtle,

    hangeul1, hangeul2,

    numeric1, numeric2,

    dot,

    dice,

    zodiac,

    unit,

    ;
    public static final List<ImageType> CONCRETE_TYPE = List.of(apple, carrot, corn, fish, grape, soccerball, turtle);
    public static final List<ImageType> CARD_TYPE = List.of(apple_card, banana_card, grape_card);
    public static final List<ImageType> HANGEUL_TYPE = List.of(hangeul1, hangeul2);
    public static final List<ImageType> NUMERIC_TYPE = List.of(numeric1, numeric2);
    public static final List<ImageType> SEMI_CONCRETE_TYPE = List.of(dot);
    public static final List<ImageType> DICE_TYPE = List.of(dice);
    public static final List<ImageType> ZODIAC_TYPE = List.of(zodiac);
    public static final List<ImageType> UNIT_TYPE = List.of(unit);
}
