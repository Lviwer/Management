package entity;

public class Cloth extends Product {

    private String size;
    private String material;
    public final static char PRODUCT_TYPE = 'C';

    public Cloth(Long id, String productName, Float price, Float weight, String color, Integer productCount, String size,
                 String material) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return PRODUCT_TYPE + PRODUCT_SEPARATOR + getBasicProductString() + PRODUCT_SEPARATOR + size + PRODUCT_SEPARATOR
                + material;
    }
}
