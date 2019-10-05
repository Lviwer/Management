package entity.parser;

import entity.enums.SkinType;
import org.junit.Assert;
import org.junit.Test;

public class SkinParserTest {

    @Test
    public void testReturnSkinTypeNatural()
    {
        String mySkinType = "NatUraL";

        SkinType skinType = SkinParser.parsStrToSkinType(mySkinType);

        Assert.assertEquals(SkinType.NATURAL, skinType);
    }

    @Test
    public void testReturnSkinTypeArtifical()
    {
        String myskinType = "ARTIFICAL";

        SkinType skinType = SkinParser.parsStrToSkinType(myskinType);

        Assert.assertEquals(SkinType.ARTIFICAL, skinType);
    }


    @Test
    public void testSkinTypeDoesntExist()
    {
        String mySkinType = "StrangeTypeOfSkin";

        SkinType skinType = SkinParser.parsStrToSkinType(mySkinType);

        Assert.assertNotEquals(SkinType.ARTIFICAL, skinType);


    }





}
