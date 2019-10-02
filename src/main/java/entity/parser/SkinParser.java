package entity.parser;

import entity.enums.SkinType;

public class SkinParser {

    public static SkinType parsStrToSkinType(String str) {
        String skinType = str.toUpperCase();

        if (str.equals("NATURAL")) {
            return SkinType.NATURAL;
        }
        if (str.equals("ARTIFICAL")) {
            return SkinType.ARTIFICAL;
        }

        return SkinType.ARTIFICAL;

    }
}
