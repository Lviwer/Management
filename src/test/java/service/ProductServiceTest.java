package service;

import entity.Boots;
import entity.Cloth;
import entity.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceTest {

    @Test
    public void testGetAllProducts() {
        //is
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(1L, "Boots", 23.22f, 5.20f, "white", 4, 34, true));
        products.add(new Cloth(2L, "Jacket", 33.99f, 3.00f, "black", 5, "XXL", "Cotton"));

        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        List<Product> productsFromTestClass = productService.getAllProducts();
        //expected
        Assert.assertEquals(products, productsFromTestClass);
    }

    @Test
    public void testGetAllProductsNegative() {
        //is
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1l, "T-SHIRT", 35.0f, 0.3f, "Black", 4, "XL", "COTTON"));
        products.add(new Boots(2L, "Boots", 35.00f, 0.3f, "Black", 4, 38, true));
        //then
        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<Product>(products));
        products.add(new Cloth(3L, "Trousers", 23.49f, 1.00f, "Blue", 5, "XL", "Jeans"));
        List<Product> productsFromTestClass = productService.getAllProducts();
        //expected
        Assert.assertNotEquals(products, productsFromTestClass);
    }

    @Test
    public void testGetCountProductsWithProducts() {
        //is
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1L, "Shirt", 10.99f, 0.5f, "Red", 5, "L", "Cotton"));
        products.add(new Boots(2L, "Boots", 49.99f, 0.5f, "Grey", 4, 45, false));
        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        final int result = productService.getCountProducts();
        //expected
        Assert.assertEquals(2, result);
    }

    @Test
    public void testGetCountProductsWithoutProducts() {
        //is
        List<Product> products = new ArrayList<Product>();
        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        final int result = productService.getCountProducts();
        //expected
        Assert.assertEquals(0, result);
    }

    @Test
    public void testGetProductByNameWhenExist() {
        //is
        List<Product> products = new ArrayList<Product>();
        Product cloth = new Cloth(1L, "Pants", 8.00f, 0.3f, "Gray", 2, "L", "Linen");
        Product boots = new Boots(2L, "Nike", 39.99f, 0.5f, "Black&White", 5, 45, true);
        products.add(cloth);
        products.add(boots);
        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        final Product productFromTestClass = productService.getProductByName("Pants");
        //expected
        Assert.assertEquals(cloth, productFromTestClass);
    }

    @Test
    public void testGetProductByNameWhenNoExist() {
        //is
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1L, "Coat", 39.99f, 0.8f, "White", 5, "XL", "Sink"));
        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        final Product productFromTestClass = productService.getProductByName("No exist");
        //expected
        Assert.assertNull(null, productFromTestClass);
    }

    @Test
    public void testIsProductOnWareHouseWhenExist() {
        //is
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1L, "Skirt", 9.99f, 0.3f, "Red", 2, "M", "Leather"));
        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductOnWareHouse = productService.isProductOnWareHouse("Skirt");
        //expected
        Assert.assertTrue(isProductOnWareHouse);
    }

    @Test
    public void testIsProductOnWareHouseWhenIsNot() {
        //is
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(1L, "Shoes", 4.99f, 0.5f, "Black", 4, 46, false));
        products.add(new Cloth(2L, "Panties", 2.00f, 0.1f, "Black", 6, "L", "Leather"));
        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductOnWareHouse = productService.isProductOnWareHouse("EmptyPlace");
        //expected
        Assert.assertFalse(isProductOnWareHouse);
    }

    @Test
    public void testIsProductExistByNameWhenExist() {
        //is
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1L, "Suit", 49.99f, 2.1f, "Purple", 3, "XL", "Wool"));
        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExistByName = productService.isProductExistByName("Suit");
        //expected
        Assert.assertTrue(isProductExistByName);
    }

    @Test
    public void testIsProductExistByNameWhenNoExist() {
        //is
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1L, "Suit", 49.99f, 2.1f, "Purple", 3, "XL", "Wool"));
        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExistByName = productService.isProductExistByName("Panties");
        //expected
        Assert.assertFalse(isProductExistByName);
    }

    @Test
    public void isProductExistByIdWhenExist() {
        //is
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1L, "Suit", 49.99f, 2.1f, "Purple", 3, "XL", "Wool"));
        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExistById = productService.isProductExistById(1L);
        //expected
        Assert.assertTrue(isProductExistById);
    }

    @Test
    public void isProductExistByIdWhenNoExist() {
        //is
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1L, "Suit", 49.99f, 2.1f, "Purple", 3, "XL", "Wool"));
        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExistById = productService.isProductExistById(2L);
        //expected
        Assert.assertFalse(isProductExistById);
    }


}

