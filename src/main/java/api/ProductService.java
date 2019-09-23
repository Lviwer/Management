package api;

import entity.Product;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    List<Product> getAllProducts() throws IOException;
    Integer getCountProducts() throws IOException;
    Product getProductByName(String productName) throws IOException;
    boolean isProductOnWareHouse(String productName);
    boolean isProductExistByName(String productName) throws IOException;
    boolean isProductExistById(Long productId);





}
