package entity.parser;


import entity.Boots;
import entity.Cloth;
import entity.Product;
import entity.enums.ProductSeparators;
import javafx.scene.paint.Color;

public class ProductParser {

    public static Product stringToProduct(String productStr) {

        final ProductSeparators productType = productStr.charAt(0);

        switch (ProductSeparators) {
            case P:
                return convertToProduct(productStr); // Break nie jest tu konieczny
            // return zapewnia wyjście z metody ! ! !
            case C:
                return convertToCloth(productStr);

            case B:
                return convertToBoots(productStr);
        }
        return null;
    }


    private static Product convertToProduct(String productStr) {
        String[] productInformations = productStr.split(ProductSeparators.PRODUCT_SEPARATOR.toString());

        Long id = Long.parseLong(productInformations[1]);
        String productName = productInformations[2];
        Float price = Float.parseFloat(productInformations[3]);
        Float weight = Float.parseFloat(productInformations[4]);
        Color color = toString().productInformations[5];
        Integer productCount = Integer.parseInt(productInformations[6]);

        return new Product(id, productName, price, weight, color, productCount);
    }

    private static Cloth convertToCloth(String productStr) {
        String[] productInformations = productStr.split(Product.PRODUCT_SEPARATOR);


        Long id = Long.parseLong(productInformations[1]);
        String productName = productInformations[2];
        Float price = Float.parseFloat(productInformations[3]);
        Float weight = Float.parseFloat(productInformations[4]);
        String color = productInformations[5];
        Integer productCount = Integer.parseInt(productInformations[6]);
        String size = productInformations[7];
        String material = productInformations[8];

        return new Cloth(id, productName, price, weight,
                color, productCount, size, material);

    }

    private static Boots convertToBoots(String productStr) {

        String[] productInformations = productStr.split(Product.PRODUCT_SEPARATOR);

        Long id = Long.parseLong(productInformations[1]);
        String productName = productInformations[2];
        Float price = Float.parseFloat(productInformations[3]);
        Float weight = Float.parseFloat(productInformations[4]);
        String color = productInformations[5];
        Integer productCount = Integer.parseInt(productInformations[6]);
        Integer size = Integer.parseInt(productInformations[7]);
        Boolean isNaturalSkin = Boolean.parseBoolean(productInformations[8]);

        return new Boots(id, productName, price, weight, color,
                productCount, size, isNaturalSkin);

    }


}
