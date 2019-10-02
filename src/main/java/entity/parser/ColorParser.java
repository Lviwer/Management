package entity.parser;

import entity.enums.Color;

public class ColorParser {

    public static Color parseStrToColor(String str) {
        String color = str.toUpperCase();

        if (color.equals("RED")) {
            return Color.RED;
        }
        if (color.equals("BLUE")) {
            return Color.BLUE;
        }
        if (color.equals("BLACK")) {
            return Color.BLACK;
        }
        if (color.equals("YELLOW")) {
            return Color.YELLOW;
        }
        if (color.equals("GREEN")) {
            return Color.GREEN;
        }
        if (color.equals("WHITE")) {
            return Color.WHITE;
        }


        return Color.WHITE;

    }

}
