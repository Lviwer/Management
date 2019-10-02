package entity.parser;

import entity.enums.Material;

public class MaterialParser {

    public static Material parseStrToColor(String str) {
        String color = str.toUpperCase();

        if (str.equals("LEATHER")) {
            return Material.LEATHER;
        }
        if (str.equals("FUR")) {
            return Material.FUR;
        }
        if (str.equals("COTTON")) {
            return Material.COTTON;
        }
        if (str.equals("WOOL")) {
            return Material.WOOL;
        }
        if (str.equals("POLYESTERS")) {
            return Material.POLYESTERS;
        }

        return Material.POLYESTERS;


    }

}
