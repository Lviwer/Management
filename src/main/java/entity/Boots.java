package entity;

import entity.enums.Color;
import entity.enums.ProductSeparators;
import entity.enums.SkinType;

public class Boots extends Product {

    private Integer size;
    private SkinType isNaturalSkin;

    public Boots(Long id, String productName, Float price, Float weight, Color color, Integer productCount, Integer size,
                 SkinType isNaturalSkin) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.isNaturalSkin = isNaturalSkin;
    }

    public Integer getSize() {
        return size;
    }

    public boolean isNaturalSkin() {
        if (isNaturalSkin.equals(SkinType.NATURAL))
        {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return ProductSeparators.BOOTS_ID + ProductSeparators.PRODUCT_SEPARATOR.toString() + getBasicProductString() +
                ProductSeparators.PRODUCT_SEPARATOR.toString() + size + ProductSeparators.PRODUCT_SEPARATOR.toString() + isNaturalSkin;
    }
}
