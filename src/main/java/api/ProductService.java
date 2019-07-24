package api;

import entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Integer getCountProducts();
    Product getProductByName(String productName);
    boolean isProductOnWareHouse(String productName);
    boolean isProductExistByName(String productName);
    boolean isProductExistById(Long productId);





}
