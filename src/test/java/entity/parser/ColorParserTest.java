package entity.parser;

import entity.enums.Color;
import org.junit.Assert;
import org.junit.Test;

public class ColorParserTest {

    @Test
    public void testReturnRedColor() {
        String myColor = "RED";

        Color color = ColorParser.parseStrToColor(myColor);

        Assert.assertEquals(Color.RED, color);
    }

    @Test
    public void testReturnBlueColor() {
        String myColor = "bLue";

        Color color = ColorParser.parseStrToColor(myColor);

        Assert.assertEquals(Color.BLUE, color);
    }

    @Test
    public void testReturnBlackColor() {
        String myColor = "bLAcK";

        Color color = ColorParser.parseStrToColor(myColor);

        Assert.assertEquals(Color.BLACK, myColor);
    }

    @Test
    public void testReturnYellowColor() {
        String myColor = "pink";

        Color color = ColorParser.parseStrToColor(myColor);

        Assert.assertEquals(Color.YELLOW, myColor);

    }

    @Test
    public void testReturnGreenColor() {
        String myColor = "Green";

        Color color = ColorParser.parseStrToColor(myColor);

        Assert.assertEquals(Color.GREEN, myColor);
    }

    @Test
    public void testReturnWhiteColor() {
        String myColor = "WhiTE";

        Color color = ColorParser.parseStrToColor(myColor);

        Assert.assertEquals(Color.WHITE, myColor);
    }

    @Test
    public void testColorDoesntExist() {
        String colorNoExist = "Pink";

        Color color = ColorParser.parseStrToColor(colorNoExist);

        Assert.assertNotEquals(Color.BLACK, color);
    }
}




