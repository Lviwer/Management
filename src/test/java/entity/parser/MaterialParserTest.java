package entity.parser;

import entity.enums.Material;
import org.junit.Assert;
import org.junit.Test;

public class MaterialParserTest {


    @Test
    public void returnMaterialLeather() {
        String myMaterial = "leatheR";

        Material material = MaterialParser.parseStrToColor(myMaterial);

        Assert.assertEquals(Material.LEATHER, material);
    }

    @Test
    public void returnMaterialFur() {
        String myMaterial = "FUR";

        Material material = MaterialParser.parseStrToColor(myMaterial);

        Assert.assertEquals(Material.FUR, material);
    }

    @Test
    public void returnMaterialCotton() {
        String myMaterial = "coTTon";

        Material material = MaterialParser.parseStrToColor(myMaterial);

        Assert.assertEquals(Material.COTTON, material);
    }

    @Test
    public void returnMaterialWool() {
        String myMaterial = "WoOl";

        Material material = MaterialParser.parseStrToColor(myMaterial);

        Assert.assertEquals(Material.WOOL, material);
    }

    @Test
    public void returnMaterialPolyesters() {
        String myMaterial = "polyesters";

        Material material = MaterialParser.parseStrToColor(myMaterial);

        Assert.assertEquals(Material.POLYESTERS, material);
    }

    @Test
    public void materialNoExist() {
        String myMaterial = "łabadabadu";

        Material material = MaterialParser.parseStrToColor(myMaterial);

        Assert.assertNotEquals(Material.COTTON, material);
    }

}
